package com.example.JcDecorarSite.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JcDecorarSite.dto.request.ProductsRequestDTO;
import com.example.JcDecorarSite.dto.response.ProductsResponseDTO;
import com.example.JcDecorarSite.services.ProductsService;

@RestController
@RequestMapping("/projects")
public class ProductsController {

    private final ProductsService projectsService;

    public ProductsController(ProductsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping
    public ResponseEntity<List<ProductsResponseDTO>> findAll() {

        return ResponseEntity.ok(
                projectsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsResponseDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                projectsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductsResponseDTO> insert(
            @RequestBody ProductsRequestDTO dto) {

        return ResponseEntity.ok(
                projectsService.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsResponseDTO> update(
            @PathVariable Long id,
            @RequestBody ProductsRequestDTO dto) {

        return ResponseEntity.ok(
                projectsService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        projectsService.delete(id);

        return ResponseEntity.noContent().build();
    }
}