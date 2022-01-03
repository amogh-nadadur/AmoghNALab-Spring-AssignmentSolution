package com.great.learning.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.great.learning.service.impl.UserServiceImpl;


@Configuration
@EnableWebSecurity

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
@Autowired
UserServiceImpl userServiceImpl;
	
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
		authProvider.setUserDetailsService(userServiceImpl);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	/*Admin has authority to access all APIs
	 * User can only access list & Add Student API*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/students/save", "/students/addStudent", "/students/403")
				.hasAnyAuthority("user", "admin")
				.antMatchers("/students/updateStudent", "/students/delete")
				.hasAuthority("admin").anyRequest()
				.authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/students/list").permitAll()
				.and()
				.logout().logoutSuccessUrl("/login").permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/students/403")
				.and()
				.cors().and().csrf().disable();
	}

}