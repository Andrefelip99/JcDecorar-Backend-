package com.example.JcDecorarSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JcDecorarSite.entities.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

}