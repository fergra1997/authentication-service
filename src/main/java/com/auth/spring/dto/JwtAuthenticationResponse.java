package com.auth.spring.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
	
	private String username;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	
}
