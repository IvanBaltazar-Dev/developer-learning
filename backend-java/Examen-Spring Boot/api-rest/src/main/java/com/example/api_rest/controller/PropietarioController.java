package com.example.api_rest.controller;

import com.example.api_rest.dto.response.ApiResponse;
import com.example.api_rest.dto.request.PropietarioCreateDto;
import com.example.api_rest.dto.response.PropietarioResponseDto;
import com.example.api_rest.service.PropietarioService;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/propietario")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<PropietarioResponseDto>> savePropietario(@Valid @RequestBody PropietarioCreateDto dto) {
        PropietarioResponseDto response = propietarioService.savePropietario(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Propietario registrado correctamente", response));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ApiResponse<PropietarioResponseDto>> findById(@PathVariable UUID id) {
        PropietarioResponseDto response = propietarioService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Propietario encontrado", response));
    }

    @GetMapping("/find/apellido/{apellido}")
    public ResponseEntity<ApiResponse<List<PropietarioResponseDto>>> findByApellido(@PathVariable String apellido) {
        List<PropietarioResponseDto> response = propietarioService.findByApellido(apellido);
        return ResponseEntity.ok(new ApiResponse<>(true, "Propietarios encontrados", response));
    }
}
