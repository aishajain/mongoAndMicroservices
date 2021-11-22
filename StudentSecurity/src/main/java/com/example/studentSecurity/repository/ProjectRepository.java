package com.example.studentSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentSecurity.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
