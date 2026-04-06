package com.example.api_rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MascotaResponseDto {
    private UUID id;
    private String nombre;
    private String especie;
    private String raza;
    private Double peso;
    private LocalDate fechaNacimiento;
}
