package com.auth.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.spring.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    
	User findByUsername(String username);
	
}