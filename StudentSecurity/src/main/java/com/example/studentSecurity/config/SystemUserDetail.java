package com.example.studentSecurity.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.studentSecurity.entities.Role;
import com.example.studentSecurity.entities.SystemUser;

public class SystemUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;

	private SystemUser user;

	public SystemUserDetail(SystemUser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Role> roles = user.getRoles();
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		for (Role role : roles) {
			authorities.addAll(role.getName().getPermissions().stream()
					.map(permission -> new SimpleGrantedAuthority(permission.name())).collect(Collectors.toSet()));
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().name()));
		}

		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}