package com.example.JcDecorarSite.dto.response;

import com.example.JcDecorarSite.entities.Products;

public record ProductsResponseDTO(
        long id,
        String title,
        String description,
        String beforeImageUrl,
        String afterImageUrl

) {

    public ProductsResponseDTO(Products entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getBeforeImageUrl(),
                entity.getAfterImageUrl());
    }

} 
