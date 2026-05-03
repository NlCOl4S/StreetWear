package com.streetwear.backend.controller;

import com.streetwear.backend.entity.User;
import com.streetwear.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor

public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/{id}")
    public User getUsuario(@PathVariable Long id) {
        return userService.getUsuario(id);

    }
    @PostMapping("/add")
    public User addUsuario(@RequestBody User user) {
        return userService.addUsuario(user);
    }
}
