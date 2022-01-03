package com.great.learning.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.great.learning.entity.Roles;
import com.great.learning.entity.Users;


public class UsersDetailsConfig implements UserDetails {

	private Users user;

	public UsersDetailsConfig(Users user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<Roles> roles = user.getRoles();

		System.out.println(user.getUsername() + " Has List<Role>....." + roles);

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
		}

		System.out.println(user.getUsername() + " Has authorities....." + authorities);

		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
