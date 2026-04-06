package com.example.api_rest.service;

import com.example.api_rest.dto.request.PropietarioCreateDto;
import com.example.api_rest.dto.response.MascotaResponseDto;
import com.example.api_rest.dto.response.PropietarioResponseDto;
import com.example.api_rest.dto.response.ReniecResponse;
import com.example.api_rest.entity.PropietarioEntity;
import com.example.api_rest.exception.DuplicateResourceException;
import com.example.api_rest.exception.ExternalServiceException;
import com.example.api_rest.exception.ResourceNotFoundException;
import com.example.api_rest.feignClient.ReniecClient;
import com.example.api_rest.repository.PropietarioRepository;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;
    private final ModelMapper modelMapper;
    private final ReniecClient reniecClient;

    @Value("${api.token}")
    private String apiToken;

    @Value("${app.reniec.mock-enabled:false}")
    private boolean reniecMockEnabled;

    public PropietarioService(
            PropietarioRepository propietarioRepository,
            ModelMapper modelMapper,
            ReniecClient reniecClient
    ) {
        this.propietarioRepository = propietarioRepository;
        this.modelMapper = modelMapper;
        this.reniecClient = reniecClient;
    }

    private ReniecResponse mockReniec(String dni) {
        ReniecResponse response = new ReniecResponse();
        response.setDocumentNumber(dni);

        switch (dni) {
            case "72224426" -> {
                response.setFirstName("JERICO BALTAZAR");
                response.setFirstLastName("CHICOMA");
                response.setSecondLastName("VARELA");
            }
            case "71224426" -> {
                response.setFirstName("ABEL");
                response.setFirstLastName("CRESPO");
                response.setSecondLastName("CHAVEZ");
            }
            case "71224424" -> {
                response.setFirstName("JUNIOR ZAIR");
                response.setFirstLastName("ESTELA");
                response.setSecondLastName("REYES");
            }
            default -> {
                response.setFirstName("USUARIO");
                response.setFirstLastName("DESCONOCIDO");
                response.setSecondLastName("");
            }
        }

        return response;
    }

    @Transactional
    public PropietarioResponseDto savePropietario(PropietarioCreateDto dto) {
        if (propietarioRepository.findByEmailNative(dto.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Ya existe un propietario registrado con ese email");
        }

        if (propietarioRepository.findByDniNative(dto.getDni()).isPresent()) {
            throw new DuplicateResourceException("Ya existe un propietario registrado con ese dni");
        }

        ReniecResponse reniecResponse = resolveReniecData(dto.getDni());

        PropietarioEntity propietarioEntity = new PropietarioEntity();
        modelMapper.map(dto, propietarioEntity);
        propietarioEntity.setNombres(reniecResponse.getFirstName().trim());

        String apellidos = ((reniecResponse.getFirstLastName() == null ? "" : reniecResponse.getFirstLastName()) + " "
                + (reniecResponse.getSecondLastName() == null ? "" : reniecResponse.getSecondLastName())).trim();
        propietarioEntity.setApellidos(apellidos);

        PropietarioEntity saved = propietarioRepository.save(propietarioEntity);

        PropietarioResponseDto response = new PropietarioResponseDto();
        modelMapper.map(saved, response);
        response.setMascotas(List.of());
        return response;
    }

    @Transactional(readOnly = true)
    public PropietarioResponseDto findById(UUID id) {
        PropietarioEntity propietario = propietarioRepository.findByIdWithMascotas(id)
                .orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado"));

        List<MascotaResponseDto> mascotas = propietario.getMascotas().stream().map(mascota -> {
            MascotaResponseDto dto = new MascotaResponseDto();
            modelMapper.map(mascota, dto);
            return dto;
        }).toList();

        PropietarioResponseDto response = new PropietarioResponseDto();
        modelMapper.map(propietario, response);
        response.setMascotas(mascotas);
        return response;
    }

    @Transactional(readOnly = true)
    public List<PropietarioResponseDto> findByApellido(String apellido) {
        return propietarioRepository.findByApellidoLikeNative(apellido).stream().map(propietario -> {
            PropietarioResponseDto dto = new PropietarioResponseDto();
            modelMapper.map(propietario, dto);
            dto.setMascotas(List.of());
            return dto;
        }).toList();
    }

    @Transactional(readOnly = true)
    public List<PropietarioResponseDto> findByFechaRegistroAfter(LocalDate fecha) {
        return propietarioRepository.findByFechaRegistroAfterNative(fecha).stream().map(propietario -> {
            PropietarioResponseDto dto = new PropietarioResponseDto();
            modelMapper.map(propietario, dto);
            dto.setMascotas(List.of());
            return dto;
        }).toList();
    }

    private ReniecResponse resolveReniecData(String dni) {
        try {
            ReniecResponse response = reniecClient.getPersonaInfo(dni, "Bearer " + apiToken);
            validateReniecResponse(response, dni);
            return response;
        } catch (FeignException ex) {
            if (reniecMockEnabled) {
                return mockReniec(dni);
            }
            throw new ExternalServiceException(buildFeignErrorMessage(ex), ex);
        } catch (ExternalServiceException ex) {
            if (reniecMockEnabled) {
                return mockReniec(dni);
            }
            throw ex;
        } catch (Exception ex) {
            if (reniecMockEnabled) {
                return mockReniec(dni);
            }
            throw new ExternalServiceException("Error inesperado al consultar RENIEC en Decolecta", ex);
        }
    }

    private void validateReniecResponse(ReniecResponse response, String dni) {
        if (response == null) {
            throw new ExternalServiceException("La respuesta de RENIEC llego vacia");
        }

        if (response.getFirstName() == null || response.getFirstName().isBlank()) {
            throw new ExternalServiceException("La respuesta de RENIEC no contiene nombres validos");
        }

        if (response.getDocumentNumber() == null || response.getDocumentNumber().isBlank()) {
            response.setDocumentNumber(dni);
        }
    }

    private String buildFeignErrorMessage(FeignException ex) {
        return switch (ex.status()) {
            case 401, 403 -> "Error al consultar RENIEC: token invalido o sin permisos";
            case 404 -> "Error al consultar RENIEC: endpoint no encontrado";
            case 408, 504 -> "Error al consultar RENIEC: tiempo de espera agotado";
            case 429 -> "Error al consultar RENIEC: cuota o limite excedido";
            default -> "Error al consultar servicio externo de RENIEC";
        };
    }
}
