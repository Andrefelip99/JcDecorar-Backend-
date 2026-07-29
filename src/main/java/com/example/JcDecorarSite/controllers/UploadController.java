package com.example.JcDecorarSite.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        );
    }
}