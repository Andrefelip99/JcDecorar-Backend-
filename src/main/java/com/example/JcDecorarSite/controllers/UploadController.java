package com.example.JcDecorarSite.controllers;

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


    public UploadController(
            CloudinaryService cloudinaryService) {

        this.cloudinaryService = cloudinaryService;
    }


/* 
    @PostMapping
    public ResponseEntity<Map<String, String>> upload(
            @RequestParam("file") MultipartFile file) {


        String imageUrl =
                cloudinaryService.uploadImage(file);


        return ResponseEntity.ok(
                Map.of(
                    "url",
                    imageUrl
                )
        );/* */

       

   
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> upload(
            @RequestParam("file") MultipartFile file) {


        System.out.println("========== UPLOAD ==========");
        System.out.println("NOME: " + file.getOriginalFilename());
        System.out.println("TAMANHO: " + file.getSize());
        System.out.println("TIPO: " + file.getContentType());


        if (file.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Arquivo vazio");
        }


        String url = cloudinaryService.uploadImage(file);


        return ResponseEntity.ok(url);
    }
}