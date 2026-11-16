package com.streetwear.backend.dto.user;

import java.time.LocalDate;

public record UserResponseDTO (
        String cedula,
        String nombre,
        LocalDate fechaNacimiento,
        String apellidos,
        String direccion
){
}

