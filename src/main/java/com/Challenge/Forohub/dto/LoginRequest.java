package com.Challenge.Forohub.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public Object getUsername() {
    }

    public Object getPassword() {
        return null;
    }

    // Getters and Setters
}
