package com.great.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.great.learning.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {

	@Query("SELECT u FROM Users u WHERE u.username = ?1")
	public Users getUserByUsername(String username);
}
