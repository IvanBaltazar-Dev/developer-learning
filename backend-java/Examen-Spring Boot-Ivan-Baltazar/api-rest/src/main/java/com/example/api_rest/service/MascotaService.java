package com.example.api_rest.service;

import com.example.api_rest.dto.request.MascotaCreateDto;
import com.example.api_rest.dto.response.MascotaResponseDto;
import com.example.api_rest.entity.MascotaEntity;
import com.example.api_rest.entity.PropietarioEntity;
import com.example.api_rest.exception.ResourceNotFoundException;
import com.example.api_rest.repository.MascotaRepository;
import com.example.api_rest.repository.PropietarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;
    private final ModelMapper modelMapper;

    public MascotaService(
            MascotaRepository mascotaRepository,
            PropietarioRepository propietarioRepository,
            ModelMapper modelMapper
    ) {
        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public MascotaResponseDto saveMascota(MascotaCreateDto dto) {
        PropietarioEntity propietario = propietarioRepository.findById(dto.getPropietarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado"));

        MascotaEntity mascotaEntity = new MascotaEntity();
        modelMapper.map(dto, mascotaEntity);
        mascotaEntity.setPropietario(propietario);

        MascotaEntity saved = mascotaRepository.save(mascotaEntity);

        MascotaResponseDto response = new MascotaResponseDto();
        modelMapper.map(saved, response);
        return response;
    }

    @Transactional(readOnly = true)
    public List<MascotaResponseDto> findByEspecie(String especie) {
        return mascotaRepository.findByEspecieNative(especie).stream().map(mascota -> {
            MascotaResponseDto dto = new MascotaResponseDto();
            modelMapper.map(mascota, dto);
            return dto;
        }).toList();
    }
}
