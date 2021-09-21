package com.auth.spring.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.auth.spring.model.RoleName;
import com.auth.spring.model.SexType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDto implements Serializable {
	
	
	private static final long serialVersionUID = -7077125552140791426L;

	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String name;
	
	@NotNull
	private String surname;
	
	@NotNull
	private String email;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	@NotNull
	private SexType sex;
	
	private String password;
	
	private String country;
	
	private String city;
	
	private List<RoleName> roles;
	
}
