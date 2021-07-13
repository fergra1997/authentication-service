package com.auth.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.spring.model.User;


public interface UserRepository extends JpaRepository<User, String> {
    
	User findByUsername(String username);
	
}