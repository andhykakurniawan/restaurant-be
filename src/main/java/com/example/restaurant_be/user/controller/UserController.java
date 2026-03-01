package com.example.restaurant_be.user.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant_be.common.response.ApiResponse;
import com.example.restaurant_be.user.dto.UserRequest;
import com.example.restaurant_be.user.dto.UserResponse;
import com.example.restaurant_be.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> findAll() {
        return ResponseEntity.ok(
                ApiResponse.success(
                        "Users retrieved successfully",
                        userService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> create(
            @RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(
                        "User created successfully",
                        userService.create(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                ApiResponse.success(
                        "User retrieved successfully",
                        userService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        userService.delete(id);

        return ResponseEntity.ok(
                ApiResponse.success("User deleted successfully", null));
    }
}