package com.auth.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.auth.spring.entity.UserEntity;

public interface UserDao extends CrudRepository<UserEntity, String> {

}
