package com.auth.spring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.spring.BaseEndPoint;
import com.auth.spring.dto.ReturnCode;
import com.auth.spring.dto.UserDto;
import com.auth.spring.service.UserImpl;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController extends BaseEndPoint {
	
	
	@Autowired
	private UserImpl userImplementation;
	
	@PostMapping("/createAccount")
	public ResponseEntity<ReturnCode> create(@RequestBody @Validated UserDto user) {
		log.info("create(UserDto user)");
		ReturnCode returnCode = userImplementation.create(user);
		ResponseEntity<ReturnCode> response = managerResponseBuilderCreate(returnCode, null);
		return response;
	}
	
	@PostMapping("/createAdminAccount")
	public ResponseEntity<ReturnCode> createAdmin(@RequestBody @Validated UserDto user) {
		log.info("createAdmin(UserDto user)");
		ReturnCode returnCode = userImplementation.create(user);
		ResponseEntity<ReturnCode> response = managerResponseBuilderCreate(returnCode, null);
		return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> read(@PathVariable Integer id) {
		log.info("createAdmin(UserDto user)");
		UserDto foundStudent = userImplementation.read(id);
		ResponseEntity<UserDto> response = managerResponseBuilderRead(foundStudent, userImplementation.getReturnCode(), null);
		return response;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReturnCode> update(@RequestBody @Validated UserDto user, @PathVariable Integer id) {
		log.info("uodate(user,id)");
		ReturnCode returnCode = userImplementation.update(user, id);
		ResponseEntity<ReturnCode> response = managerResponseBuilderUpdate(returnCode, null);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ReturnCode> delete(@PathVariable Integer id) {
		log.info("delete(user,id)");
		ReturnCode returnCode = userImplementation.delete(id);
		ResponseEntity<ReturnCode> response = managerResponseBuilderDelete(returnCode, null);
		return response;
	}

}
