package com.great.learning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.great.learning.dao.UsersRepository;
import com.great.learning.entity.Users;
import com.great.learning.security.UsersDetailsConfig;


@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = usersRepository.getUserByUsername(username);

		if (user == null) {
			System.out.println("Could not find user....." + username);
			throw new UsernameNotFoundException("Could not find user");
		}

		return new UsersDetailsConfig(user);
	}

}
