package com.example.JcDecorarSite.dto.request;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;

public record ProductsRequestDTO(

        @NotBlank(message = "O campo title não pode estar em branco")
        String title,

        @NotBlank(message = "O campo description não pode estar em branco")
        String description,

        MultipartFile file

) {

}