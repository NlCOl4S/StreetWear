package com.streetwear.backend.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record UserRequestDTO (
        @NotNull String cedula,
        @NotBlank String nombre,
        @NotNull LocalDate fechaNacimiento,
        @NotBlank String apellidos,
        @NotBlank String direccion
){
}
