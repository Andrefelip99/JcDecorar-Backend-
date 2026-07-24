package com.example.JcDecorarSite.dto.response;

import com.example.JcDecorarSite.entities.User;

public record UserResponseDTO(
        long id,
        String nome,
        String email) {

    public UserResponseDTO(User entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getEmail());
    }
}