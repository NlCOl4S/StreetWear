package com.streetwear.backend.controller;

import com.streetwear.backend.dto.user.UserRequestDTO;
import com.streetwear.backend.dto.user.UserResponseDTO;
import com.streetwear.backend.entity.User;
import com.streetwear.backend.mapper.UserMapper;
import com.streetwear.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{cedula}")
    public ResponseEntity<UserResponseDTO> getUserByCedula(@PathVariable Long cedula) {

        User user = userService.getUserByCedula(cedula);

        return ResponseEntity.ok(UserMapper.toResponseDTO(user));

    }
    @PostMapping
    public ResponseEntity<UserResponseDTO> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
       User user = UserMapper.toEntity(userRequestDTO);
       User savedUser = userService.addUser(user);

       return ResponseEntity.ok(UserMapper.toResponseDTO(savedUser));

    }
}
