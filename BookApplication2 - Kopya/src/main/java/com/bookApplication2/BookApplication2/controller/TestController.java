package com.bookApplication2.BookApplication2.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookApplication2.BookApplication2.exception.ResourceNotFoundException;
import com.bookApplication2.BookApplication2.model.Comment;
import com.bookApplication2.BookApplication2.model.User;
import com.bookApplication2.BookApplication2.repository.UserRepository;
import com.bookApplication2.BookApplication2.requests.CommentCreateRequest;
import com.bookApplication2.BookApplication2.requests.UserCreateDataDetails;
import com.bookApplication2.BookApplication2.service.CommentService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}
	

	@PutMapping("/setUserData/")
	
	public User addUserData2(@RequestBody UserCreateDataDetails userCreateDataDetails ) {
	
		User user = userRepository.findByUsername(userCreateDataDetails.getUsername())
				.orElseThrow(()->new ResourceNotFoundException("not found" + userCreateDataDetails.getUsername()));
		
		System.out.println(userCreateDataDetails.getUserAddress());
		System.out.println(userCreateDataDetails.getUserPhoneNumber());
		
		user.setUserPhoneNumber(userCreateDataDetails.getUserPhoneNumber());		
		user.setUserAddress(userCreateDataDetails.getUserAddress());
		
		return userRepository.save(user);
	}
	
	@GetMapping("/getUserData")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public User addUserData(@RequestBody UserCreateDataDetails userCreateDataDetails ) {
		
		User user = userRepository.findByUsername("admin").orElseThrow(null); 
		
		
		return user;
	}
	
	
	

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
