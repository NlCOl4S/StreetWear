package com.streetwear.backend.service;

import com.streetwear.backend.entity.User;
import com.streetwear.backend.exception.UserNotFoundException;
import com.streetwear.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service

public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User addUser(User user) {

        return userRepository.save(user);
    }
    public User getUserByCedula(String cedula) {
        return userRepository.findByCedula(cedula)
                .orElseThrow(() -> new UserNotFoundException(cedula));

    }

}
