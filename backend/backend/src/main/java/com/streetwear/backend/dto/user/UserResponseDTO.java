package com.streetwear.backend.dto.user;

public record UserResponseDTO (
        Long cedula,
        String nombre,
        int edad,
        String apellidos,
        String direccion
){
}
