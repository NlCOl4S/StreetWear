package com.streetwear.backend.servicio;

import com.streetwear.backend.entidad.usuario;
import com.streetwear.backend.repositorio.usuariorepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Service

public class usuarioservicio {
    @Autowired
    private final usuariorepositorio repositorio;

    @Transactional
    public usuario addUsuario(usuario usuario) {
        usuario usuarioGuardado = repositorio.save(usuario);

        return usuarioGuardado;
    }
    public usuario getUsuario(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }


}
