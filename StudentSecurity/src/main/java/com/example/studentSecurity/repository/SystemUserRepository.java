package com.example.studentSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentSecurity.entities.SystemUser;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {
	SystemUser findByUsername(String userName);
}
