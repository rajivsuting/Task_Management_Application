package com.masai.main.service;

import com.masai.main.entity.UserEntity;
import com.masai.main.exception.UserException;

public interface UserService {
	
	public UserEntity registerUser(UserEntity user) throws UserException;

}
