package com.example.JcDecorarSite.controllers;

import java.util.Map;

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

       

    @PostMapping
public ResponseEntity<String> upload(
        @RequestParam Map<String, MultipartFile> files) {

    System.out.println("ARQUIVOS RECEBIDOS: " + files.keySet());

    return ResponseEntity.ok(
            "Recebidos: " + files.keySet()
    );
}
}