package com.streetwear.backend.service;

import com.streetwear.backend.entity.User;
import com.streetwear.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service

public class UserService {

    private final UserRepository repositorio;

    @Transactional
    public User addUsuario(User user) {
        User userGuardado = repositorio.save(user);

        return userGuardado;
    }
    public User getUsuario(Long id) {
        User user = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return user;
    }



}
