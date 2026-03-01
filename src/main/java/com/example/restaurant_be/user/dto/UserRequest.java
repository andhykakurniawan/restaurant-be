package com.example.restaurant_be.user.dto;

import com.example.restaurant_be.user.entity.Role;
import jakarta.validation.constraints.*;

public record UserRequest(

        @NotBlank
        String username,

        @Email
        @NotBlank
        String email,

        @NotBlank
        @Size(min = 6)
        String password,

        @NotNull
        Role role
) {}