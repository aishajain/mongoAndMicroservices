package com.example.studentSecurity.service;

import com.example.studentSecurity.entities.SystemUser;

public interface UserService {
	SystemUser save(SystemUser user);

	SystemUser getUserByName(String name);

}
