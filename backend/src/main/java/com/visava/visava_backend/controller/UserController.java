package com.visava.visava_backend.controller;

import com.visava.visava_backend.dto.UserRegistrationRequest;
import com.visava.visava_backend.dto.UserRegistrationResponse;
import com.visava.visava_backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(
            @Valid @RequestBody UserRegistrationRequest request
    ) {
        UserRegistrationResponse response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }
}
