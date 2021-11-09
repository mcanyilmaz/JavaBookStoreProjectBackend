package com.bookApplication2.BookApplication2.requests;

import java.util.List;

import com.bookApplication2.BookApplication2.model.Book;

import lombok.Data;

@Data
public class CategoryViewRequest {

	
	private int id;
	
	private String categoryName;
	
	private List<Book> books;
	
}
