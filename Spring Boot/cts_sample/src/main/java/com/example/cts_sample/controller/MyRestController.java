package com.example.cts_sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cts_sample.entity.UserEntity;
import com.example.cts_sample.service.UserService;

@RestController
@RequestMapping("/rest")
public class MyRestController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("register")
	public String register() {
		return "register";
	}

	@GetMapping("users")
	public List<UserEntity> allUsers() {
		return userService.findUsers();
	}

	@PostMapping("saveUser")
	public String saveUser(@RequestBody UserEntity user) {
		userService.saveUser(user);
		// System.out.println(user.getEmail());
		return "saved successfully";
	}

	@DeleteMapping("deleteUser/{mail}")
	public String deleteUser(@PathVariable("mail") String email) {
		userService.deleteById(email);
		return "deleted successfully";
	}

	@GetMapping("getUser/{mail}")
	public Optional<UserEntity> getUser(@PathVariable("mail") String email) {
		return userService.findUserById(email);
	}

//	@GetMapping("update")
//	public String updateUser() {
//		UserEntity user = new UserEntity();
//		user.setEmail("2100030959cseh@gmail.com");
//		user.setConfirm_password("1234");
//		user.setPassword("1234");
//		user.setName("kalyan");
//		userService.saveUser(user);
//		return "redirect:/login";
//	}

}
