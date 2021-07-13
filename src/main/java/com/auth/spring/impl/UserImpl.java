package com.auth.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.spring.dao.UserDao;
import com.auth.spring.dto.ReturnCode;
import com.auth.spring.dto.UserDto;
import com.auth.spring.entity.UserEntity;
import com.auth.spring.interfaces.UserInterface;
import com.auth.spring.utility.UserUtility;

@Service
public class UserImpl extends ManagerCRUD implements UserInterface {

	private ReturnCode returnCode;

	@Autowired
	private UserDao userDao;

	private UserUtility utility;

	public UserImpl() {
		utility = new UserUtility();
	}

	/**
	 * 
	 */
	@Override
	public UserDto read(String id) {
		UserDto foundStudent = null;
		ReturnCode returnCode = ReturnCode.ERROR;
		//UserEntity studentEntity = read(id, userDao);
		UserEntity user=new UserEntity();
		user.setId("1");
		user.setAge(13);
		user.setName("Fernando");
		user.setSurname("Granato");
		returnCode = getDaoReturnCode();
		if (returnCode.equals(ReturnCode.OK))
			foundStudent = utility.entityToDto(user);

		setReturnCode(returnCode);
		return foundStudent;
	}

	@Override
	public ReturnCode create(UserDto student) {
		ReturnCode returnCode = ReturnCode.ERROR;
		UserEntity entity = utility.dtoToEntity(student);
		create(entity, entity.getId(), userDao);
		returnCode = getDaoReturnCode();
		setReturnCode(returnCode);
		return returnCode;
	}

	@Override
	public ReturnCode update(UserDto student, String id) {
		ReturnCode returnCode = ReturnCode.ERROR;
		UserEntity entity = utility.dtoToEntity(student);
		update(entity, id, userDao);
		returnCode = getDaoReturnCode();
		setReturnCode(returnCode);
		return returnCode;
	}

	@Override
	public ReturnCode delete(String id) {
		ReturnCode returnCode = ReturnCode.ERROR;
		delete(id, userDao);
		returnCode = getDaoReturnCode();
		setReturnCode(returnCode);
		return returnCode;
	}

	@Override
	public ReturnCode getReturnCode() {
		return this.returnCode;
	}

	@Override
	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;

	}

}
