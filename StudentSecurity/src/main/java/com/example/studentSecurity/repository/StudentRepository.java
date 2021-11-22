package com.example.studentSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentSecurity.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findByStudentId(Integer id);
}
