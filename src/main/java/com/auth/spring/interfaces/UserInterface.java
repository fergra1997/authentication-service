package com.auth.spring.interfaces;

import com.auth.spring.dto.ReturnCode;
import com.auth.spring.dto.UserDto;

public interface UserInterface {

	public UserDto read(String id);

	public ReturnCode create(UserDto student);

	public ReturnCode update(UserDto student, String id);

	public ReturnCode delete(String id);
	
	public ReturnCode getReturnCode();

	public void setReturnCode(ReturnCode returnCode);
}
