package com.example.studentSecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentSecurity.entities.Project;
import com.example.studentSecurity.repository.ProjectRepository;
import com.example.studentSecurity.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getAll() {
		return projectRepository.findAll();
	}

}
