package com.bookApplication2.BookApplication2.requests;

import java.time.LocalDateTime;
import java.util.List;

import com.bookApplication2.BookApplication2.model.Book;

import lombok.Data;

@Data
public class OrderCreateRequest {

	
	private int id;

	private int bookId;

	
	private String bookName;
	
	private Double bookPrice;
	
	private int bookPiece;
	
	private Double totalPrice;
	
	private String username;
	
	private String address;
	
	private String state;
	
	private List<Book> bookList;
	
	
}
