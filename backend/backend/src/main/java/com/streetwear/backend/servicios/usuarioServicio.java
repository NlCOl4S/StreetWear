package com.streetwear.backend.servicios;

import com.streetwear.backend.entidades.usuarios;
import com.streetwear.backend.repositorios.usuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Service

public class usuarioServicio {
    @Autowired
    private final usuarioRepositorio repositorio;

    @Transactional
    public usuarios addUsuario(usuarios usuario) {
        usuarios usuarioGuardado = repositorio.save(usuario);

        return usuarioGuardado;
    }
    public usuarios getUsuario(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }


}
