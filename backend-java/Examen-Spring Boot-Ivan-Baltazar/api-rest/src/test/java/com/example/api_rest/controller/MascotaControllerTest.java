package com.example.api_rest.controller;

import com.example.api_rest.dto.request.MascotaCreateDto;
import com.example.api_rest.dto.response.MascotaResponseDto;
import com.example.api_rest.exception.GlobalExceptionHandler;
import com.example.api_rest.exception.ResourceNotFoundException;
import com.example.api_rest.service.MascotaService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MascotaController.class)
@Import(GlobalExceptionHandler.class)
class MascotaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MascotaService mascotaService;

    @Test
    void saveMascotaReturnsCreated() throws Exception {
        UUID propietarioId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        MascotaCreateDto request = new MascotaCreateDto(
                "Firulais",
                "Perro",
                "Mestizo",
                LocalDate.of(2020, 1, 10),
                12.5,
                propietarioId
        );

        MascotaResponseDto response = new MascotaResponseDto(
                UUID.fromString("22222222-2222-2222-2222-222222222222"),
                "Firulais",
                "Perro",
                "Mestizo",
                12.5,
                LocalDate.of(2020, 1, 10)
        );

        when(mascotaService.saveMascota(any(MascotaCreateDto.class))).thenReturn(response);

        mockMvc.perform(post("/api/v1/mascota/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.nombre").value("Firulais"));
    }

    @Test
    void saveMascotaReturnsValidationError() throws Exception {
        MascotaCreateDto request = new MascotaCreateDto(
                "",
                "",
                "Mestizo",
                LocalDate.now().plusDays(1),
                -1.0,
                null
        );

        mockMvc.perform(post("/api/v1/mascota/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.data.nombre").isArray())
                .andExpect(jsonPath("$.data.especie").isArray())
                .andExpect(jsonPath("$.data.fechaNacimiento").isArray())
                .andExpect(jsonPath("$.data.peso").isArray())
                .andExpect(jsonPath("$.data.propietarioId").isArray());
    }

    @Test
    void saveMascotaReturnsNotFoundWhenOwnerDoesNotExist() throws Exception {
        UUID propietarioId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        MascotaCreateDto request = new MascotaCreateDto(
                "Firulais",
                "Perro",
                "Mestizo",
                LocalDate.of(2020, 1, 10),
                12.5,
                propietarioId
        );

        when(mascotaService.saveMascota(any(MascotaCreateDto.class)))
                .thenThrow(new ResourceNotFoundException("Propietario no encontrado"));

        mockMvc.perform(post("/api/v1/mascota/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Propietario no encontrado"));
    }

    @Test
    void findByEspecieReturnsCaseInsensitiveMatches() throws Exception {
        when(mascotaService.findByEspecie("per")).thenReturn(List.of(
                new MascotaResponseDto(
                        UUID.fromString("22222222-2222-2222-2222-222222222222"),
                        "Firulais",
                        "Perro",
                        "Mestizo",
                        12.5,
                        LocalDate.of(2020, 1, 10)
                )
        ));

        mockMvc.perform(get("/api/v1/mascota/find/especie/{especie}", "per"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data[0].especie").value("Perro"));
    }
}
