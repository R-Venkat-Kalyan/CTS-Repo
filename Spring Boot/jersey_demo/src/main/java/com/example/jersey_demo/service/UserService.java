package com.example.jersey_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jersey_demo.entity.UserEntity;
import com.example.jersey_demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(UserEntity user) {
		userRepository.save(user);
	}

}
