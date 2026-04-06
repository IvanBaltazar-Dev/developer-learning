package com.example.api_rest.controller;

import com.example.api_rest.dto.response.ApiResponse;
import com.example.api_rest.dto.request.MascotaCreateDto;
import com.example.api_rest.dto.response.MascotaResponseDto;
import com.example.api_rest.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mascota")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<MascotaResponseDto>> saveMascota(@Valid @RequestBody MascotaCreateDto dto) {
        MascotaResponseDto response = mascotaService.saveMascota(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Mascota registrada correctamente", response));
    }

    @GetMapping("/find/especie/{especie}")
    public ResponseEntity<ApiResponse<List<MascotaResponseDto>>> findByEspecie(@PathVariable String especie) {
        List<MascotaResponseDto> response = mascotaService.findByEspecie(especie);
        return ResponseEntity.ok(new ApiResponse<>(true, "Mascotas encontradas", response));
    }
}
