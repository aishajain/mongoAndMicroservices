package com.example.studentSecurity.service;

import java.util.List;

import com.example.studentSecurity.entities.Project;

public interface ProjectService {
	Project save(Project project);

	List<Project> getAll();
}
