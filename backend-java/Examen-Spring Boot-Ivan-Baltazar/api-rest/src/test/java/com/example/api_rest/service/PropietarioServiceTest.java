package com.example.api_rest.service;

import com.example.api_rest.dto.request.PropietarioCreateDto;
import com.example.api_rest.dto.response.PropietarioResponseDto;
import com.example.api_rest.dto.response.ReniecResponse;
import com.example.api_rest.entity.PropietarioEntity;
import com.example.api_rest.exception.DuplicateResourceException;
import com.example.api_rest.exception.ExternalServiceException;
import com.example.api_rest.feignClient.ReniecClient;
import com.example.api_rest.mapper.ModelMapperConfig;
import com.example.api_rest.repository.PropietarioRepository;
import feign.FeignException;
import feign.Request;
import feign.RequestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PropietarioServiceTest {

    @Mock
    private PropietarioRepository propietarioRepository;

    @Mock
    private ReniecClient reniecClient;

    private PropietarioService propietarioService;

    @BeforeEach
    void setUp() {
        propietarioService = new PropietarioService(
                propietarioRepository,
                new ModelMapperConfig().modelMapper(),
                reniecClient
        );
        ReflectionTestUtils.setField(propietarioService, "apiToken", "token-test");
        ReflectionTestUtils.setField(propietarioService, "reniecMockEnabled", false);
    }

    @Test
    void savePropietarioThrowsConflictWhenEmailAlreadyExists() {
        PropietarioCreateDto request = new PropietarioCreateDto(
                "jerico.chicoma@email.com",
                "987654321",
                "72224426",
                "Av. Lima 123"
        );

        when(propietarioRepository.findByEmailNative(request.getEmail()))
                .thenReturn(Optional.of(new PropietarioEntity()));

        assertThrows(DuplicateResourceException.class, () -> propietarioService.savePropietario(request));
        verify(reniecClient, never()).getPersonaInfo(any(), any());
    }

    @Test
    void savePropietarioThrowsBadGatewayWhenReniecReturnsUnauthorized() {
        PropietarioCreateDto request = new PropietarioCreateDto(
                "jerico.chicoma@email.com",
                "987654321",
                "72224426",
                "Av. Lima 123"
        );

        when(propietarioRepository.findByEmailNative(request.getEmail())).thenReturn(Optional.empty());
        when(propietarioRepository.findByDniNative(request.getDni())).thenReturn(Optional.empty());
        when(reniecClient.getPersonaInfo(eq(request.getDni()), eq("Bearer token-test")))
                .thenThrow(FeignException.errorStatus(
                        "getPersonaInfo",
                        feign.Response.builder()
                                .status(401)
                                .reason("Unauthorized")
                                .request(Request.create(
                                        Request.HttpMethod.GET,
                                        "/v1/reniec/dni",
                                        Collections.emptyMap(),
                                        null,
                                        new RequestTemplate()
                                ))
                                .build()
                ));

        ExternalServiceException ex = assertThrows(
                ExternalServiceException.class,
                () -> propietarioService.savePropietario(request)
        );

        assertEquals("Error al consultar RENIEC: token invalido o sin permisos", ex.getMessage());
    }

    @Test
    void savePropietarioPersistsMappedDataWhenReniecResponds() {
        PropietarioCreateDto request = new PropietarioCreateDto(
                "jerico.chicoma@email.com",
                "987654321",
                "72224426",
                "Av. Lima 123"
        );

        ReniecResponse reniecResponse = new ReniecResponse(
                "JERICO BALTAZAR",
                "CHICOMA",
                "VARELA",
                "CHICOMA VARELA JERICO BALTAZAR",
                "72224426"
        );

        PropietarioEntity savedEntity = new PropietarioEntity();
        savedEntity.setId(UUID.fromString("11111111-1111-1111-1111-111111111111"));
        savedEntity.setNombres("JERICO BALTAZAR");
        savedEntity.setApellidos("CHICOMA VARELA");
        savedEntity.setEmail(request.getEmail());
        savedEntity.setTelefono(request.getTelefono());
        savedEntity.setDni(request.getDni());
        savedEntity.setDireccion(request.getDireccion());

        when(propietarioRepository.findByEmailNative(request.getEmail())).thenReturn(Optional.empty());
        when(propietarioRepository.findByDniNative(request.getDni())).thenReturn(Optional.empty());
        when(reniecClient.getPersonaInfo(eq(request.getDni()), eq("Bearer token-test"))).thenReturn(reniecResponse);
        when(propietarioRepository.save(any(PropietarioEntity.class))).thenReturn(savedEntity);

        PropietarioResponseDto response = propietarioService.savePropietario(request);

        assertEquals("JERICO BALTAZAR", response.getNombres());
        assertEquals("CHICOMA VARELA", response.getApellidos());
        assertEquals("jerico.chicoma@email.com", response.getEmail());
    }
}
