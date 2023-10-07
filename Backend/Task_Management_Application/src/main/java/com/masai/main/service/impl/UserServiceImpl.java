package com.masai.main.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.main.entity.UserEntity;
import com.masai.main.exception.UserException;
import com.masai.main.repository.UserRepository;
import com.masai.main.request.RegistrationRequest;
import com.masai.main.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity registerUser(RegistrationRequest request) throws UserException {
		
		Optional<UserEntity> opt = userRepository.findByEmail(request.getEmail());
		
		if(opt.isPresent()) throw new UserException("User with this email already exist.");
		
		UserEntity user = new UserEntity();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		return userRepository.save(user);
		
	}

}
