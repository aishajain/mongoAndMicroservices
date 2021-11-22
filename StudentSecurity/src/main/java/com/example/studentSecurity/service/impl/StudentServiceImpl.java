package com.example.studentSecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentSecurity.entities.Student;
import com.example.studentSecurity.repository.StudentRepository;
import com.example.studentSecurity.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Integer id) {
		return studentRepository.findByStudentId(id);
	}
}
