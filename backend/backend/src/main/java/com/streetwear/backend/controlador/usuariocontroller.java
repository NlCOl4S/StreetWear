package com.streetwear.backend.controlador;

import com.streetwear.backend.entidad.usuario;
import com.streetwear.backend.servicio.usuarioservicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor

public class usuariocontroller {
    @Autowired
    private final usuarioservicio usuarioServicio;

    @GetMapping("/{id}")
    public usuario getUsuario(@PathVariable Long id) {
        return usuarioServicio.getUsuario(id);

    }
    @PostMapping("/add")
    public usuario addUsuario(@RequestBody usuario usuario) {
        return usuarioServicio.addUsuario(usuario);
    }
}
