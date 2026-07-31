package com.example.JcDecorarSite.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.JcDecorarSite.dto.request.ProductsRequestDTO;
import com.example.JcDecorarSite.dto.response.ProductsResponseDTO;
import com.example.JcDecorarSite.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {


    private final ProductsService projectsService;


    public ProductsController(ProductsService projectsService) {
        this.projectsService = projectsService;
    }


    @GetMapping
    public ResponseEntity<List<ProductsResponseDTO>> findAll() {

        return ResponseEntity.ok(
                projectsService.findAll()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductsResponseDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                projectsService.findById(id)
        );
    }


    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<ProductsResponseDTO> insert(

            @RequestParam("title") String title,

            @RequestParam("description") String description,

            @RequestParam("file") MultipartFile file

    ) {


        ProductsRequestDTO dto = new ProductsRequestDTO(
                title,
                description,
                file
        );


        return ResponseEntity.ok(
                projectsService.insert(dto)
        );
    }


    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<ProductsResponseDTO> update(

            @PathVariable Long id,

            @RequestParam("title") String title,

            @RequestParam("description") String description,

            @RequestParam(value = "file", required = false) MultipartFile file

    ) {


        ProductsRequestDTO dto = new ProductsRequestDTO(
                title,
                description,
                file
        );


        return ResponseEntity.ok(
                projectsService.update(id, dto)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {


        projectsService.delete(id);


        return ResponseEntity.noContent().build();
    }
}