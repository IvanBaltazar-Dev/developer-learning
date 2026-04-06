package com.example.api_rest.mapper;

import com.example.api_rest.dto.request.MascotaCreateDto;
import com.example.api_rest.dto.request.PropietarioCreateDto;
import com.example.api_rest.dto.response.MascotaResponseDto;
import com.example.api_rest.dto.response.PropietarioResponseDto;
import com.example.api_rest.entity.MascotaEntity;
import com.example.api_rest.entity.PropietarioEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(PropietarioCreateDto.class, PropietarioEntity.class);
        modelMapper.createTypeMap(PropietarioEntity.class, PropietarioResponseDto.class);

        modelMapper.createTypeMap(MascotaCreateDto.class, MascotaEntity.class);
        modelMapper.createTypeMap(MascotaEntity.class, MascotaResponseDto.class);

        return modelMapper;
    }
}