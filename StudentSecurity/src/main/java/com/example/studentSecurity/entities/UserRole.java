package com.example.studentSecurity.entities;

import static com.example.studentSecurity.entities.Permission.PROJECT_READ;
import static com.example.studentSecurity.entities.Permission.PROJECT_WRITE;
import static com.example.studentSecurity.entities.Permission.STUDENT_READ;
import static com.example.studentSecurity.entities.Permission.STUDENT_WRITE;
import static com.example.studentSecurity.entities.Permission.USER_READ;
import static com.example.studentSecurity.entities.Permission.USER_WRITE;

import java.util.Set;

import com.google.common.collect.Sets;

public enum UserRole {
	STUDENT(Sets.newHashSet(STUDENT_WRITE, PROJECT_READ, USER_READ, USER_WRITE)),
	ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, USER_READ, USER_WRITE, PROJECT_READ, PROJECT_WRITE));

	private final Set<Permission> permissions;

	UserRole(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}
}
