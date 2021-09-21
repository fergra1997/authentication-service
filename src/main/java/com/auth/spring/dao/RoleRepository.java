package com.auth.spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.spring.model.Role;
import com.auth.spring.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {
   
	Role findByName(RoleName name);

}