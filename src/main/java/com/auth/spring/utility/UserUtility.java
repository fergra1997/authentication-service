package com.auth.spring.utility;
import com.auth.spring.dto.UserDto;
import com.auth.spring.entity.UserEntity;

public class UserUtility {

	public UserDto entityToDto(UserEntity entity) {
		UserDto dto = new UserDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setStatus(entity.getStatus());
		dto.setSex(entity.getSex());
		dto.setAge(entity.getAge());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setTelephoneNumber(entity.getTelephoneNumber());
		return dto;
	}

	public UserEntity dtoToEntity(UserDto dto) {
		UserEntity entity = new UserEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setStatus(dto.getStatus());
		entity.setSex(dto.getSex());
		entity.setAge(dto.getAge());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setTelephoneNumber(dto.getTelephoneNumber());
		return entity;
	}
}
