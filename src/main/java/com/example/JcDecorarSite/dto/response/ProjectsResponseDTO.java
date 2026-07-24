package com.example.JcDecorarSite.dto.response;

import com.example.JcDecorarSite.entities.Projects;

public record ProjectsResponseDTO(
        long id,
        String title,
        String description,
        String imagUrl

) {

    public ProjectsResponseDTO(Projects entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getImageUrl());
    }

}