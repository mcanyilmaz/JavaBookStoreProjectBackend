package com.bookApplication2.BookApplication2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.bookApplication2.BookApplication2.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{


	Optional<Book> findByBookName(String bookName);
	
	List<Book> findByBookNameContaining(String bookName);

	
	List<Book> getByBookName(String bookName);
	
	
	List<Book> getBycategory_id(int categoryId);
	
	Page<Book> getByCategory_id(int categoryId,Pageable pageable);

	//List<Book> findTop5ByOrderByID(Pageable pageable);
	List<Book> findTop8ByOrderByBookNameDesc();


	List<Book> findTop5ByOrderByBookStock();
	
	List<Book> findTop12ByOrderByRatingDesc();


	//Book findByRatingByOrderByBookId(int id);
	
	//Book findByIdByOrderByRating(int bookId);


	

	
	//List<Book> findAllByBookByIdAsc();

	
	
}
