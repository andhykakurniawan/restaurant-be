package com.example.restaurant_be.config;

import com.example.restaurant_be.user.entity.Role;
import com.example.restaurant_be.user.entity.User;
import com.example.restaurant_be.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        String email = "admin@restaurant.com";


        if (userRepository.findByEmail(email).isEmpty()) {

            User user = new User();
            user.setUsername("Super Admin");
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode("admin123"));
            user.setRole(Role.SUPER_ADMIN);

            userRepository.save(user);

            System.out.println("SUPER_ADMIN created.");
        } else {
            System.out.println("SUPER_ADMIN already exists.");
        }
    }
}