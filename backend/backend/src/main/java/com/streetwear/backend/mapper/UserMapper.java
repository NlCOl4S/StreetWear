package com.streetwear.backend.mapper;

import com.streetwear.backend.dto.user.UserRequestDTO;
import com.streetwear.backend.dto.user.UserResponseDTO;
import com.streetwear.backend.entity.User;

public class UserMapper {

    public static UserResponseDTO toResponseDTO(User user){

        return new UserResponseDTO(
                user.getCedula(),
                user.getNombre(),
                user.getFechaNacimiento(),
                user.getApellidos(),
                user.getDireccion()
        );
    }

    public static User toEntity(UserRequestDTO dto){

        User user = new User();
        user.setCedula(dto.cedula());
        user.setNombre(dto.nombre());
        user.setFechaNacimiento(dto.fechaNacimiento());
        user.setApellidos(dto.apellidos());
        user.setDireccion(dto.direccion());

        return user;
    }

}
