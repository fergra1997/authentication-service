package com.auth.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.spring.dao.RoleRepository;
import com.auth.spring.dao.UserRepository;
import com.auth.spring.dto.ReturnCode;
import com.auth.spring.dto.UserDto;
import com.auth.spring.model.Role;
import com.auth.spring.model.RoleName;
import com.auth.spring.model.User;

@Service
public class UserImpl extends ManagerCRUD {

	private ReturnCode returnCode;

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleDao;

	/**
	 * The method used for read an instance of user.
	 * 
	 * @param id the id used for search.
	 * @return the user dto.
	 */
	public UserDto read(Integer id) {
		returnCode = ReturnCode.ERROR;
		UserDto user = null;
		try {
			User userEntity = read(id, userDao);
			returnCode = getDaoReturnCode();

			if (returnCode.toString().equals(ReturnCode.OK.toString())) {
				user = new UserDto();
				user=converUserEntityToDto(userEntity);
			} else {
				returnCode = ReturnCode.NOT_FOUND;
				System.out.println("User with id : " + id + " not found");
			}
		} catch (Exception e) {
			System.out.println("Exception into read user an exception occurred" + e);
		}
		setReturnCode(returnCode);
		return user;
	}

	/**
	 * The method used for create a new user.
	 * 
	 * @param user the user dto to create.
	 * @return operation returnCode.
	 */
	public ReturnCode create(UserDto user) {
	returnCode = ReturnCode.ERROR;
		try {
			User entity = userDao.findByUsername(user.getUsername());
			if (entity == null) {
				entity = converUserDtoToEntity(user);
				List<Role> roles = new ArrayList<>();
				Role role = roleDao.findByName(RoleName.ROLE_USER);
				roles.add(role);
				entity.setRoles(roles);
				userDao.save(entity);
				returnCode = ReturnCode.OK;
			} else {
				returnCode = ReturnCode.ALREDY_EXIST;
				System.out.println("User with id : " + user.getUsername() + " already exist");
			}
		} catch (Exception e) {
			System.out.println("Exception into create user an exception occurred  " + e);
		}
		setReturnCode(returnCode);
		return returnCode;
	}

	public User converUserDtoToEntity(UserDto dto) {
		User entity = new User();
		entity.setName(dto.getName());
		entity.setUsername(dto.getUsername());
		entity.setSurname(dto.getSurname());
		entity.setEmail(dto.getEmail());
		entity.setEnabled(true);
		entity.setCity(dto.getCity());
		entity.setCountry(dto.getCountry());
		entity.setSex(dto.getSex());
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity.setInscriptionDate(new Date());
		entity.setDateOfBirth(dto.getDateOfBirth());
		return entity;
	}

	public UserDto converUserEntityToDto(User entity) {
		UserDto dto = new UserDto();
		dto.setName(entity.getName());
		dto.setUsername(entity.getUsername());
		dto.setSurname(entity.getSurname());
		dto.setEmail(entity.getEmail());
		dto.setCity(entity.getCity());
		dto.setCountry(entity.getCountry());
		dto.setSex(entity.getSex());
		dto.setDateOfBirth(entity.getDateOfBirth());
		List<RoleName> roles = entity.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());
		dto.setRoles(roles);
		return dto;
	}

	public ReturnCode update(UserDto user, Integer id) {
//		ReturnCode returnCode = ReturnCode.ERROR;
//		UserEntity entity = utility.dtoToEntity(student);
//		update(entity, id, userDao);
//		returnCode = getDaoReturnCode();
//		setReturnCode(returnCode);
		return returnCode;
	}

	public ReturnCode delete(String id) {
//		ReturnCode returnCode = ReturnCode.ERROR;
//		delete(id, userDao);
//		returnCode = getDaoReturnCode();
//		setReturnCode(returnCode);
		return returnCode;
	}
	
	
	

	public ReturnCode getReturnCode() {
		return this.returnCode;
	}

	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;

	}

}
