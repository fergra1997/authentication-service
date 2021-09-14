package com.auth.spring.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JacksonInject;

import lombok.Data;

@Data
public class UserDto implements Serializable {
	
	
	private static final long serialVersionUID = -7077125552140791426L;

	@NotNull
	private String username;
	
	@NotNull
	private String password;

}
