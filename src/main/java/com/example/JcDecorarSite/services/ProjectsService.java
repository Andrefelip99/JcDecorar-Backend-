package com.example.JcDecorarSite.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JcDecorarSite.dto.request.ProjectsRequestDTO;
import com.example.JcDecorarSite.dto.response.ProjectsResponseDTO;
import com.example.JcDecorarSite.entities.Projects;
import com.example.JcDecorarSite.repository.ProjectsRepository;
import com.example.JcDecorarSite.services.exceptions.BusinessException;
import com.example.JcDecorarSite.services.exceptions.ResourceNotFoundException;

@Service
public class ProjectsService {

    private final ProjectsRepository projectsRepository;

    public ProjectsService(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public List<ProjectsResponseDTO> findAll() {
        List<Projects> list = projectsRepository.findAll();

        return list.stream()
                .map(ProjectsResponseDTO::new)
                .toList();
    }

    public ProjectsResponseDTO findById(Long id) {
        return new ProjectsResponseDTO(findProjectById(id));
    }

    public ProjectsResponseDTO insert(ProjectsRequestDTO dto) {

        validateProject(dto);

        Projects entity = new Projects();

        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setImageUrl(dto.imageUrl());

        entity = projectsRepository.save(entity);

        return new ProjectsResponseDTO(entity);
    }

    public ProjectsResponseDTO update(Long id, ProjectsRequestDTO dto) {

        validateProject(dto);

        Projects entity = findProjectById(id);

        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setImageUrl(dto.imageUrl());

        entity = projectsRepository.save(entity);

        return new ProjectsResponseDTO(entity);
    }

    public void delete(Long id) {
        Projects entity = findProjectById(id);
        projectsRepository.delete(entity);
    }

    private Projects findProjectById(Long id) {
        return projectsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado."));
    }

    private void validateProject(ProjectsRequestDTO dto) {

        if (dto.title() == null || dto.title().isBlank()) {
            throw new BusinessException("O título do projeto é obrigatório.");
        }

        if (dto.description() == null || dto.description().isBlank()) {
            throw new BusinessException("A descrição do projeto é obrigatória.");
        }
    }
}