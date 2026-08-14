package com.example.JcDecorarSite.dto.request;


import jakarta.validation.constraints.NotBlank;



public record ProductsRequestDTO(

    @NotBlank(message = "O campo title não pode estar em branco")
    String title,

    @NotBlank(message = "O campo description não pode estar em branco")
    String description,

    @NotBlank(message = "O campo beforeImageUrl não pode estar em branco")
    String beforeImageUrl,

    @NotBlank(message = "O campo afterImageUrl não pode estar em branco")
    String afterImageUrl

) {}
