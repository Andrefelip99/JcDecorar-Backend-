package com.example.JcDecorarSite.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JcDecorarSite.dto.request.ProductsRequestDTO;
import com.example.JcDecorarSite.dto.response.ProductsResponseDTO;
import com.example.JcDecorarSite.entities.Products;
import com.example.JcDecorarSite.repository.ProductsRepository;
import com.example.JcDecorarSite.services.exceptions.BusinessException;
import com.example.JcDecorarSite.services.exceptions.ResourceNotFoundException;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<ProductsResponseDTO> findAll() {

        List<Products> list = productsRepository.findAll();

        return list.stream()
                .map(ProductsResponseDTO::new)
                .toList();
    }

    public ProductsResponseDTO findById(Long id) {
        return new ProductsResponseDTO(findProjectById(id));
    }

    public ProductsResponseDTO insert(ProductsRequestDTO dto) {

        validateProducts(dto);

        Products entity = new Products();

        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setImageUrl(dto.imageUrl());

        entity = productsRepository.save(entity);

        return new ProductsResponseDTO(entity);
    }

    public ProductsResponseDTO update(Long id, ProductsRequestDTO dto) {

        validateProducts(dto);

        Products entity = findProjectById(id);

        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setImageUrl(dto.imageUrl());

        entity = productsRepository.save(entity);

        return new ProductsResponseDTO(entity);
    }

    public void delete(Long id) {

        Products entity = findProjectById(id);

        productsRepository.delete(entity);
    }

    private Products findProjectById(Long id) {

        return productsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Projeto não encontrado."));
    }

    private void validateProducts(ProductsRequestDTO dto) {

        if (dto.title() == null || dto.title().isBlank()) {
            throw new BusinessException("O título do projeto é obrigatório.");
        }

        if (dto.description() == null || dto.description().isBlank()) {
            throw new BusinessException("A descrição do projeto é obrigatória.");
        }

        if (dto.imageUrl() == null || dto.imageUrl().isBlank()) {
            throw new BusinessException("A URL da imagem é obrigatória.");
        }
    }
}