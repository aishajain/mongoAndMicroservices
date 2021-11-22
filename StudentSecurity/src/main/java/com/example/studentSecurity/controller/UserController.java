package com.example.studentSecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentSecurity.entities.SystemUser;
import com.example.studentSecurity.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	private static final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

	@PostMapping(value = "/user")
	public SystemUser saveuser(@RequestBody @Valid SystemUser user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		return userService.save(user);
	}

	@GetMapping(value = "/user/{username}")
	public SystemUser getUser(@PathVariable String username) {
		return userService.getUserByName(username);
	}
}
