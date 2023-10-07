package com.masai.main.service;

import com.masai.main.entity.UserEntity;
import com.masai.main.exception.UserException;
import com.masai.main.request.RegistrationRequest;

public interface UserService {
	
	
	public UserEntity registerUser(RegistrationRequest request) throws UserException;

}
