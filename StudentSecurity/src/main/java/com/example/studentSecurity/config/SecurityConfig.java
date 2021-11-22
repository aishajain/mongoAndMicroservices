package com.example.studentSecurity.config;

import static com.example.studentSecurity.entities.Permission.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.studentSecurity.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	//Basic Auth
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .csrf().disable() .authorizeRequests() .antMatchers("/", "index", "/css/*",
	 * "/js/*").permitAll() .antMatchers(HttpMethod.POST, "/user").permitAll()
	 * .antMatchers(HttpMethod.POST,
	 * "/student/**").hasAuthority(STUDENT_WRITE.name())
	 * .antMatchers(HttpMethod.POST, "/project/all").hasAuthority(USER_WRITE.name())
	 * .antMatchers("/student/getall",
	 * "/student/**").hasAuthority(STUDENT_READ.name())
	 * .antMatchers("/user/**").hasAuthority(USER_READ.name())
	 * .antMatchers("/project").hasAuthority(PROJECT_READ.name())
	 * .anyRequest().authenticated().and() .formLogin().permitAll() .and()
	 * .logout().permitAll() .and() .exceptionHandling().accessDeniedPage("/403")
	 * .and() .httpBasic(); }
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilter(new JWTUsernameAndPasswordAuthicationFilter(authenticationManager()))
		.addFilterAfter(new JWTokenVerifier(), JWTUsernameAndPasswordAuthicationFilter.class)
		.authorizeRequests()
		.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
		.antMatchers(HttpMethod.POST, "/user").permitAll()
		.antMatchers(HttpMethod.POST, "/student/**").hasAuthority(STUDENT_WRITE.name())
		.antMatchers(HttpMethod.POST, "/project/all").hasAuthority(USER_WRITE.name())
		.antMatchers("/student/getall", "/student/**").hasAuthority(STUDENT_READ.name())
		.antMatchers("/user/**").hasAuthority(USER_READ.name())
		.antMatchers("/project").hasAuthority(PROJECT_READ.name())
		.anyRequest().authenticated().and()
		.exceptionHandling().accessDeniedPage("/403");
	}
}
