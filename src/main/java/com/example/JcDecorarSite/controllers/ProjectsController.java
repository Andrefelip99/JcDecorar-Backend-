package com.example.JcDecorarSite.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JcDecorarSite.dto.request.ProjectsRequestDTO;
import com.example.JcDecorarSite.dto.response.ProjectsResponseDTO;
import com.example.JcDecorarSite.services.ProjectsService;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    private final ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectsResponseDTO>> findAll() {

        return ResponseEntity.ok(
                projectsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectsResponseDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                projectsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectsResponseDTO> insert(
            @RequestBody ProjectsRequestDTO dto) {

        return ResponseEntity.ok(
                projectsService.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectsResponseDTO> update(
            @PathVariable Long id,
            @RequestBody ProjectsRequestDTO dto) {

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