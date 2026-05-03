package com.streetwear.backend.service;

import com.streetwear.backend.entity.User;
import com.streetwear.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Service

public class UserService {
    @Autowired
    private final UserRepository repositorio;

    @Transactional
    public User addUsuario(User user) {
        User userGuardado = repositorio.save(user);

        return userGuardado;
    }
    public User getUsuario(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }


}
