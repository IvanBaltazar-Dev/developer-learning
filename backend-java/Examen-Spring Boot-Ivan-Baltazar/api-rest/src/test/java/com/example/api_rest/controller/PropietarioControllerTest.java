package com.example.api_rest.controller;

import com.example.api_rest.dto.request.PropietarioCreateDto;
import com.example.api_rest.dto.response.MascotaResponseDto;
import com.example.api_rest.dto.response.PropietarioResponseDto;
import com.example.api_rest.exception.DuplicateResourceException;
import com.example.api_rest.exception.ExternalServiceException;
import com.example.api_rest.exception.GlobalExceptionHandler;
import com.example.api_rest.exception.ResourceNotFoundException;
import com.example.api_rest.service.PropietarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PropietarioController.class)
@Import(GlobalExceptionHandler.class)
class PropietarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PropietarioService propietarioService;

    @Test
    void savePropietarioReturnsCreated() throws Exception {
        PropietarioCreateDto request = new PropietarioCreateDto(
                "jerico.chicoma@email.com",
                "987654321",
                "72224426",
                "Av. Lima 123"
        );

        PropietarioResponseDto response = new PropietarioResponseDto(
                UUID.fromString("11111111-1111-1111-1111-111111111111"),
                "JERICO BALTAZAR",
                "CHICOMA VARELA",
                request.getEmail(),
                request.getTelefono(),
                request.getDireccion(),
                LocalDate.of(2026, 4, 2),
                List.of()
        );

        when(propietarioService.savePropietario(any(PropietarioCreateDto.class))).thenReturn(response);

        mockMvc.perform(post("/api/v1/propietario/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Propietario registrado correctamente"))
                .andExpect(jsonPath("$.data.email").value("jerico.chicoma@email.com"));
    }

    @Test
    void savePropietarioReturnsValidationError() throws Exception {
        PropietarioCreateDto request = new PropietarioCreateDto(
                "",
                "123",
                "ABC",
                ""
        );

        mockMvc.perform(post("/api/v1/propietario/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.data.email").isArray())
                .andExpect(jsonPath("$.data.telefono").isArray())
                .andExpect(jsonPath("$.data.dni").isArray())
                .andExpect(jsonPath("$.data.direccion").isArray());
    }

    @Test
    void savePropietarioReturnsConflictWhenDuplicated() throws Exception {
        PropietarioCreateDto request = new PropietarioCreateDto(
                "jerico.chicoma@email.com",
                "987654321",
                "72224426",
                "Av. Lima 123"
        );

        doThrow(new DuplicateResourceException("Ya existe un propietario registrado con ese email"))
                .when(propietarioService).savePropietario(any(PropietarioCreateDto.class));

        mockMvc.perform(post("/api/v1/propietario/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Ya existe un propietario registrado con ese email"));
    }

    @Test
    void savePropietarioReturnsBadGatewayWhenReniecFails() throws Exception {
        PropietarioCreateDto request = new PropietarioCreateDto(
                "jerico.chicoma@email.com",
                "987654321",
                "72224426",
                "Av. Lima 123"
        );

        doThrow(new ExternalServiceException("Error al consultar servicio externo de RENIEC"))
                .when(propietarioService).savePropietario(any(PropietarioCreateDto.class));

        mockMvc.perform(post("/api/v1/propietario/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadGateway())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Error al consultar servicio externo de RENIEC"));
    }

    @Test
    void findByIdReturnsPropietarioWithMascotas() throws Exception {
        UUID propietarioId = UUID.fromString("11111111-1111-1111-1111-111111111111");

        PropietarioResponseDto response = new PropietarioResponseDto(
                propietarioId,
                "JERICO BALTAZAR",
                "CHICOMA VARELA",
                "jerico.chicoma@email.com",
                "987654321",
                "Av. Lima 123",
                LocalDate.of(2026, 4, 2),
                List.of(new MascotaResponseDto(
                        UUID.fromString("22222222-2222-2222-2222-222222222222"),
                        "Firulais",
                        "Perro",
                        "Mestizo",
                        12.5,
                        LocalDate.of(2020, 1, 10)
                ))
        );

        when(propietarioService.findById(propietarioId)).thenReturn(response);

        mockMvc.perform(get("/api/v1/propietario/find/{id}", propietarioId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(propietarioId.toString()))
                .andExpect(jsonPath("$.data.mascotas[0].nombre").value("Firulais"));
    }

    @Test
    void findByIdReturnsNotFound() throws Exception {
        UUID propietarioId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        when(propietarioService.findById(propietarioId))
                .thenThrow(new ResourceNotFoundException("Propietario no encontrado"));

        mockMvc.perform(get("/api/v1/propietario/find/{id}", propietarioId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Propietario no encontrado"));
    }

    @Test
    void findByApellidoReturnsCaseInsensitiveMatches() throws Exception {
        when(propietarioService.findByApellido("chi")).thenReturn(List.of(
                new PropietarioResponseDto(
                        UUID.fromString("11111111-1111-1111-1111-111111111111"),
                        "JERICO BALTAZAR",
                        "CHICOMA VARELA",
                        "jerico.chicoma@email.com",
                        "987654321",
                        "Av. Lima 123",
                        LocalDate.of(2026, 4, 2),
                        List.of()
                )
        ));

        mockMvc.perform(get("/api/v1/propietario/find/apellido/{apellido}", "chi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data[0].apellidos").value("CHICOMA VARELA"));
    }
}
