package com.example.studentSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentSecurity.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
