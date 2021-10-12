package com.bookApplication2.BookApplication2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);

	
	Optional<User> findByEmailAndPassword(String email, String password);
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	Optional<User> findById(Long id);
	
	
	
}
