package com.auth.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.spring.dao.AuthorityRepository;
import com.auth.spring.dao.UserRepository;
import com.auth.spring.dto.ReturnCode;
import com.auth.spring.dto.UserDto;
import com.auth.spring.model.Authority;
import com.auth.spring.model.AuthorityName;
import com.auth.spring.model.User;

@Service
public class UserImpl extends ManagerCRUD {

	private ReturnCode returnCode;

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityRepository authority;
	
	
	public UserDto read(String id) {
		UserDto user = null;
		ReturnCode returnCode = ReturnCode.ERROR;
		User userEntity = read(id, userDao);
		System.out.println("user entity  + " + userEntity.toString());
		returnCode = getDaoReturnCode();
		if (returnCode.equals(ReturnCode.OK)) {
			user =new UserDto();
			user.setUsername(userEntity.getUsername());
		}else {
			returnCode=ReturnCode.NOT_FOUND;
		}
		setReturnCode(returnCode);
		return user;
	}

	
	public ReturnCode create(UserDto user) {
		ReturnCode returnCode = ReturnCode.ERROR;
		Authority authorityAdmin=read(new Long(1),authority);
		List<Authority> authorities = Arrays.asList(new Authority[] { authorityAdmin });
		User userEntity = new User();
		userEntity = new User();
		userEntity.setAuthorities(authorities);
		userEntity.setEnabled(true);
		userEntity.setUsername(user.getUsername());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity = userDao.save(userEntity);
		ReturnCode code=ReturnCode.OK;
		create(userEntity, userEntity.getUsername(), userDao);
		returnCode = getDaoReturnCode();
		setReturnCode(returnCode);
		return returnCode;
	}

	
	public ReturnCode update(UserDto student, String id) {
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
