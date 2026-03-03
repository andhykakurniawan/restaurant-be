package com.example.restaurant_be.menu.controller;

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
import com.example.restaurant_be.menu.dto.MenuRequest;
import com.example.restaurant_be.menu.dto.MenuResponse;
import com.example.restaurant_be.menu.service.MenuService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<MenuResponse>>> findAll() {
        return ResponseEntity.ok(
                ApiResponse.success(
                        "Menus retrieved successfully",
                        menuService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MenuResponse>> create(
            @RequestBody MenuRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(
                        "Menu created successfully",
                        menuService.create(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MenuResponse>> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                ApiResponse.success(
                        "Menu retrieved successfully",
                        menuService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable UUID id) {
        menuService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Menu deleted successfully", null));
    }
}
