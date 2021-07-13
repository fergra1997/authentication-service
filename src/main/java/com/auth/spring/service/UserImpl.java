package com.auth.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.spring.dao.UserRepository;
import com.auth.spring.dto.ReturnCode;
import com.auth.spring.dto.UserDto;
import com.auth.spring.interfaces.UserInterface;
import com.auth.spring.model.Authority;
import com.auth.spring.model.AuthorityName;
import com.auth.spring.model.User;

@Service
public class UserImpl extends ManagerCRUD implements UserInterface {

	private ReturnCode returnCode;

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	//private UserUtility utility;

	public UserImpl() {
	//	utility = new UserUtility();
	}

	
	@Override
	public UserDto read(String id) {
		UserDto foundStudent = null;
		ReturnCode returnCode = ReturnCode.ERROR;
		User userEntity = read(id, userDao);
		returnCode = getDaoReturnCode();
		if (returnCode.equals(ReturnCode.OK)) {
			UserDto dto =new UserDto();
			dto.setUsername(userEntity.getUsername());
		}
		setReturnCode(returnCode);
		return foundStudent;
	}

	@Override
	public ReturnCode create(UserDto user) {
		ReturnCode returnCode = ReturnCode.ERROR;
		Authority authorityAdmin = new Authority();
		authorityAdmin.setName(AuthorityName.ROLE_ADMIN);
		Authority authorityUser = new Authority();
		authorityUser.setName(AuthorityName.ROLE_USER);
		List<Authority> authorities = Arrays.asList(new Authority[] { authorityAdmin, authorityUser });
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

	@Override
	public ReturnCode update(UserDto student, String id) {
//		ReturnCode returnCode = ReturnCode.ERROR;
//		UserEntity entity = utility.dtoToEntity(student);
//		update(entity, id, userDao);
//		returnCode = getDaoReturnCode();
//		setReturnCode(returnCode);
		return returnCode;
	}

	@Override
	public ReturnCode delete(String id) {
//		ReturnCode returnCode = ReturnCode.ERROR;
//		delete(id, userDao);
//		returnCode = getDaoReturnCode();
//		setReturnCode(returnCode);
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
