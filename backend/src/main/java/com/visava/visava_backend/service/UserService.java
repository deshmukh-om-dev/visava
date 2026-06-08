package com.visava.visava_backend.service;

import com.visava.visava_backend.dto.UserRegistrationRequest;
import com.visava.visava_backend.dto.UserRegistrationResponse;
import com.visava.visava_backend.entity.User;
import com.visava.visava_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return UserRegistrationResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .message("User registered successfully")
                .build();
    }
}
