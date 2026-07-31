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


    public UploadController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }


    @PostMapping
public ResponseEntity<?> upload(
        @RequestParam("file") MultipartFile file
){
    System.out.println("ENTROU");
    System.out.println(file.getOriginalFilename());

    return ResponseEntity.ok("ok");
}}