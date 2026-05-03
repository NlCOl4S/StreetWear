package com.streetwear.backend.service;

import com.streetwear.backend.entity.User;
import com.streetwear.backend.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Service

public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private final UserRepository repositorio;

    @Transactional

    public User addUsuario(User user) {
        User userGuardado = repositorio.save(user);

        return userGuardado;
    }
    public User getUsuario(Long id) {
        User user = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        log.info("\n================================" +
                        "\nUsuario encontrado" +
                        "\nNombre: {} {}" +
                        "\nCedula: {}" +
                        "\n================================",
                user.getNombre(), user.getApellidos(), user.getCedula());

        return user;
    }


}
