package com.example.restaurant_be.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant_be.user.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
