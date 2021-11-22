package com.example.studentSecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.studentSecurity.config.SystemUserDetail;
import com.example.studentSecurity.entities.SystemUser;
import com.example.studentSecurity.repository.SystemUserRepository;
import com.example.studentSecurity.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private SystemUserRepository systemUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SystemUser user = systemUserRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new SystemUserDetail(user);
	}

	@Override
	public SystemUser save(SystemUser user) {
		return systemUserRepository.save(user);
	}

	@Override
	public SystemUser getUserByName(String name) {
		return systemUserRepository.findByUsername(name);
	}
}