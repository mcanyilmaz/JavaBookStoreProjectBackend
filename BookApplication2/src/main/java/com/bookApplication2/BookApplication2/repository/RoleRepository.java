package com.bookApplication2.BookApplication2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.ERole;
import com.bookApplication2.BookApplication2.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}