package com.auth.spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.spring.model.Authority;
import com.auth.spring.model.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);

}