package com.bookApplication2.BookApplication2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookApplication2.BookApplication2.model.User;
import com.bookApplication2.BookApplication2.requests.UserCreateRequest;
import com.bookApplication2.BookApplication2.service.UserService;


@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("v1/")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody UserCreateRequest userCreateRequest) {
		return userService.addUser(userCreateRequest);
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable int id, @RequestBody UserCreateRequest userCreateRequest ) {
		return userService.updateUser(id, userCreateRequest);
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		 userService.deleteUser(id); 
	}
	
	@PostMapping("/findByEmailAndPassword/")
	public Optional<User> getUserAndPassword(@RequestBody User user) {
		return userService.findByEmailAndPassword(user.getEmail(),user.getPassword());
	}
	
	/*
	@PostMapping("/findByEmailAndPassword/")
	public Optional<User> getUserAndPassword(@RequestParam String email, @RequestParam String password) {
		return userService.findByEmailAndPassword(email, password);
	}*/
	
	@GetMapping("/findByEmail/{email}")
	public Optional<User> findByEmail(@PathVariable String email) {
		
		
		return userService.findByEmail(email);
				
	}

	
}
