package com.masai.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.main.entity.UserEntity;
import com.masai.main.exception.UserException;
import com.masai.main.request.RegistrationRequest;
import com.masai.main.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> registerUser(@RequestBody RegistrationRequest request) throws UserException{
		
		return new ResponseEntity<>(userService.registerUser(request), HttpStatus.CREATED);
	}

}
