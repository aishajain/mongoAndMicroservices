package com.example.studentSecurity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentSecurity.entities.Student;
import com.example.studentSecurity.service.StudentService;

@CrossOrigin
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/student/add")
	public Student save(@RequestBody @Valid Student student) {
		return studentService.save(student);
	}

	@GetMapping(value = "/student/getall")
	public List<Student> getAll() {
		return studentService.getAll();
	}

	@GetMapping(value = "/student/{id}")
	public Student findById(@PathVariable Integer id) {
		return studentService.findById(id);
	}
}
