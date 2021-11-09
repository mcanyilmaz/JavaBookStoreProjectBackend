package com.bookApplication2.BookApplication2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.Category;
import com.bookApplication2.BookApplication2.requests.CategoryCreateRequest;

public interface CategoryRepository extends JpaRepository<Category, Integer>{


    Optional<Category> findByCategoryName(String categoryCreateDto);
	//String  findByCategoryName(String categoryName);
    
	Boolean existsByCategoryName(String categoryName);
	
	List<Category> findByCategoryNameContaining(String categoryName);


}
