package com.bookApplication2.BookApplication2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.Author;
import com.bookApplication2.BookApplication2.model.Book;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	Author findByAuthorName(String authorName);
	

}
