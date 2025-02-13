package com.example.cts_sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cts_sample.entity.UserEntity;
import com.example.cts_sample.service.UserService;


@Controller
public class SampleController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String home() {
		return "home";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("register")
	public String register() {
		return "register";
	}
	

	@GetMapping(path = "users", produces = {"application/json"})
	public List<UserEntity> getAllUsers(){
		return userService.findUsers();
	}
	
	@PostMapping("saveUser")
	public String saveUser(@ModelAttribute UserEntity user) {
		userService.saveUser(user);
		//System.out.println(user.getEmail());
		return "redirect:/login";
	}
	
	@GetMapping("update")
	public String updateUser() {
		UserEntity user = new UserEntity();
		user.setEmail("2100030959cseh@gmail.com");
		user.setConfirm_password("1234");
		user.setPassword("1234");
		user.setName("kalyan");
		userService.saveUser(user);
		return "redirect:/login";
	}
	
	

}
