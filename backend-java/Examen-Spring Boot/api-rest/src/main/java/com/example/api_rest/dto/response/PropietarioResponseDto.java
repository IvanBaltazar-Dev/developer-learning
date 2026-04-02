package com.example.api_rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropietarioResponseDto {
    private UUID id;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
    private LocalDate fechaRegistro;
    private List<MascotaResponseDto> mascotas = new ArrayList<>();
}
