package com.auth.spring.dto;

import lombok.Data;

@Data
public class JwtAuthenticationRequest {
	
	private String username;
	
	private String password;
	
}
