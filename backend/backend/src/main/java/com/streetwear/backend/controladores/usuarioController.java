package com.streetwear.backend.controladores;

import com.streetwear.backend.entidades.usuarios;
import com.streetwear.backend.servicios.usuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor

public class usuarioController {
    @Autowired
    private final usuarioServicio usuarioServicio;

    @GetMapping("/{id}")
    public usuarios getUsuario(@PathVariable Long id) {
        return usuarioServicio.getUsuario(id);

    }
    @PostMapping("/add")
    public usuarios addUsuario(@RequestBody usuarios usuario) {
        return usuarioServicio.addUsuario(usuario);
    }
}
