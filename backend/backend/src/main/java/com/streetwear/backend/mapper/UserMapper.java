package com.streetwear.backend.mapper;

import com.streetwear.backend.dto.user.UserRequestDTO;
import com.streetwear.backend.dto.user.UserResponseDTO;
import com.streetwear.backend.entity.User;

public class UserMapper {

    public static UserResponseDTO toResponseDTO(User user){

        return new UserResponseDTO(
                user.getCedula(),
                user.getNombre(),
                user.getEdad(),
                user.getApellidos(),
                user.getDireccion()
        );
    }

    public static User toEntity(UserRequestDTO dto){

        User user = new User();
        user.setCedula(dto.cedula());
        user.setNombre(dto.nombre());
        user.setEdad(dto.edad());
        user.setApellidos(dto.apellidos());
        user.setDireccion(dto.direccion());

        return user;
    }

}
