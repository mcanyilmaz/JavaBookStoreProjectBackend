package com.bookApplication2.BookApplication2.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bookApplication2.BookApplication2.exception.ResourceNotFoundException;
import com.bookApplication2.BookApplication2.model.ImageModel;
import com.bookApplication2.BookApplication2.model.User;
import com.bookApplication2.BookApplication2.repository.UserRepository;
import com.bookApplication2.BookApplication2.requests.UserCreateRequest;

@Service

public class UserService {
	
	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	
	public User addUser(UserCreateRequest userCreateRequest){
		
		//Optional<User> newUser = userRepository.findByEmail(userCreateRequest.getEmail());
		
		User user = new User();
		
		/*if(newUser.isEmpty()) {
			throw new ResourceNotFoundException("il already existy with name " + userCreateRequest.getEmail());
		}*/
		
		String encodedPassword = this.passwordEncoder.encode(userCreateRequest.getPassword());
		
	
		user.setUsername(userCreateRequest.getUsername());
		user.setPassword(encodedPassword);
		user.setEmail(userCreateRequest.getEmail());
	
		return userRepository.save(user);
			
	}
	public void deleteUser(int id) {
		 userRepository.deleteById(id);
	}
	
	public User updateUser(int id, UserCreateRequest userCreateRequest) {
		User user = userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("not found id" +id));
		
		user.setUsername(userCreateRequest.getUsername());
		user.setPassword(userCreateRequest.getPassword());
		user.setEmail(userCreateRequest.getEmail());
		
		return userRepository.save(user);
		
	}
	
	public Optional<User> findByEmailAndPassword(String email, String password) {
		User user = userRepository.findByEmail(email).
				orElseThrow(()-> new ResourceNotFoundException("not found id" +email));
		
		/*String encodedPassword = passwordEncoder.encode(password);
		
	//	System.out.println(this.passwordEncoder.matches(password, user.getPassword()));

		if(this.passwordEncoder.matches(encodedPassword, user.getPassword())==false) {
			System.out.println(encodedPassword);
			System.out.println(password);
			System.out.println(this.passwordEncoder.matches(encodedPassword, user.getPassword()));
			System.out.println("eşit degil");
			
			userRepository.findByEmailAndPassword(email,password).
			orElseThrow(()-> new ResourceNotFoundException("not equals email and password" +email+password));
			
		}*/
		return userRepository.findByEmailAndPassword(email, password);
	
	
				
	}
	
	
	
	public Optional<User> findByEmail(String email) {
		
				
		return userRepository.findByEmail(email);
				
	}


}
