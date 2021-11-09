package com.bookApplication2.BookApplication2.requests;

import java.time.LocalDateTime;
import java.util.List;

import com.bookApplication2.BookApplication2.model.Book;

import lombok.Data;

@Data
public class AuthorUpdateRequest {

	
	private int id;
	
	private String authorName;
	
	private String authorAbout;
		
	private LocalDateTime updateDate;
	
	//private List<Book> books;

	
	
}
