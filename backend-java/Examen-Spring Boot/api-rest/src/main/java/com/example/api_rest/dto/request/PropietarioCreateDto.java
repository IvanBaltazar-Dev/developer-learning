package com.example.api_rest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropietarioCreateDto {

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato valido")
    private String email;

    @NotBlank(message = "El telefono es obligatorio")
    @Pattern(regexp = "^\\d{7,9}$", message = "El telefono debe tener entre 7 y 9 digitos")
    private String telefono;

    @NotBlank(message = "El dni es obligatorio")
    @Pattern(regexp = "^\\d{8}$", message = "El dni debe tener exactamente 8 digitos")
    private String dni;

    @NotBlank(message = "La direccion es obligatoria")
    private String direccion;
}