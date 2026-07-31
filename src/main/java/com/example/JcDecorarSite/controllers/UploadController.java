package com.example.JcDecorarSite.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.JcDecorarSite.services.CloudinaryService;


@RestController
@RequestMapping("/upload")
public class UploadController {


    private final CloudinaryService cloudinaryService;


    public UploadController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> upload(
            @RequestParam("file") MultipartFile file
    ){

        System.out.println("========= ENTROU CONTROLLER =========");

        System.out.println("Arquivo: " + file.getOriginalFilename());
        System.out.println("Tamanho: " + file.getSize());
        System.out.println("Tipo: " + file.getContentType());


        String url = cloudinaryService.uploadImage(file);


        System.out.println("URL CLOUDINARY: " + url);


        return ResponseEntity.ok(url);
    }
}