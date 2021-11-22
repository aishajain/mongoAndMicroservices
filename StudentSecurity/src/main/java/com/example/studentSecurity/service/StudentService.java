package com.example.studentSecurity.service;

import java.util.List;

import com.example.studentSecurity.entities.Student;

public interface StudentService {
	Student save(Student student);
	List<Student> getAll();
	Student findById(Integer id);
}
