package com.example.restaurant_be.user.dto;

import com.example.restaurant_be.user.entity.Role;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        boolean is_active,
        Role role
) {}