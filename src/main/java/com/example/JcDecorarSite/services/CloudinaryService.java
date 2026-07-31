package com.example.JcDecorarSite.services;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {


    private final Cloudinary cloudinary;


    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


    public String uploadImage(MultipartFile file) {

        try {

            System.out.println("===== CLOUDINARY UPLOAD =====");
            System.out.println("Arquivo: " + file.getOriginalFilename());
            System.out.println("Tamanho: " + file.getSize());
            System.out.println("Tipo: " + file.getContentType());


            Map uploadResult = cloudinary.uploader()
                    .upload(
                            file.getBytes(),
                            ObjectUtils.emptyMap()
                    );


            System.out.println("UPLOAD OK");
            System.out.println(uploadResult);


            return uploadResult
                    .get("secure_url")
                    .toString();


        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Erro Cloudinary: " + e.getMessage()
            );
        }
    }
}