package com.auth.spring.controller;

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
import com.auth.spring.interfaces.UserInterface;

@RestController
@RequestMapping("/user")
public class UserController extends BaseEndPoint {

	@Autowired
	private UserInterface userImpl;

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> read(@PathVariable String id) {
		UserDto foundStudent = userImpl.read(id);
		ResponseEntity<UserDto> response = managerResponseBuilderRead(foundStudent, userImpl.getReturnCode(), null);
		return response;
	}

	@PostMapping("/")
	public ResponseEntity<ReturnCode> create(@RequestBody @Validated UserDto student) {
		ReturnCode returnCode = userImpl.create(student);
		ResponseEntity<ReturnCode> response = managerResponseBuilderCreate(returnCode, null);
		return response;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReturnCode> update(@RequestBody @Validated UserDto student, @PathVariable String id) {
		ReturnCode returnCode = userImpl.update(student, id);
		ResponseEntity<ReturnCode> response = managerResponseBuilderUpdate(returnCode, null);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ReturnCode> delete(@PathVariable String id) {
		ReturnCode returnCode = userImpl.delete(id);
		ResponseEntity<ReturnCode> response = managerResponseBuilderDelete(returnCode, null);
		return response;
	}

}
