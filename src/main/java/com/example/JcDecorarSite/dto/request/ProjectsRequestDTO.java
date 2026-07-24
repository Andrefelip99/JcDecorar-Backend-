package com.example.JcDecorarSite.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProjectsRequestDTO(
                @NotBlank(message = "O campo title não pode estar em branco") String title,
                String description,
                @NotBlank(message = "a foto é obrigatoria") String imageUrl

) {

}