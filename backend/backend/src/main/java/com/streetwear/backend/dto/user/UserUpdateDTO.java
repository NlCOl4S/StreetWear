package com.streetwear.backend.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record UserUpdateDTO (
        @NotBlank String nombre,
        @Positive int edad,
        @NotBlank String apellidos,
        @NotBlank String direccion
){
}
