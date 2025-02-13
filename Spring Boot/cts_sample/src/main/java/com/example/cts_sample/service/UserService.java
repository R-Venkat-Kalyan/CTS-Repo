package com.example.cts_sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cts_sample.entity.UserEntity;
import com.example.cts_sample.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public void saveUser(UserEntity user) {
		userRepository.save(user);
	}
	
	public List<UserEntity> findUsers() {
		return userRepository.findAll();
	}
	
	public Optional<UserEntity> findUserById(String id) {
		return userRepository.findById(id);
	}
	
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}
	
	
	
}
