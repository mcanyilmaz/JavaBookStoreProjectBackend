package com.bookApplication2.BookApplication2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	
	Optional<ImageModel> findByName(String name);

}

