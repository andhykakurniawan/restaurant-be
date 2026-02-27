package com.example.restaurant_be.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.restaurant_be.auth.dto.LoginRequest;
import com.example.restaurant_be.auth.dto.LoginResponse;
import com.example.restaurant_be.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        String token = authService.login(request.getEmail(), request.getPassword());

        return new LoginResponse(token);
    }
}