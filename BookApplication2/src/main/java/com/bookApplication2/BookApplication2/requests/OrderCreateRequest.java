package com.bookApplication2.BookApplication2.requests;

import java.time.LocalDateTime;

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
	
	
	
}
