package com.bookApplication2.BookApplication2.requests;


import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BookCreateRequest {
	
	private int id;
	
	private String bookName;
	
	private int bookPrice;
	
	private int bookStock;
	
	private String bookDetails;
	
	private LocalDateTime createDate;

	private int authorId;
	
	private int categoryId;
	
	private String bookImageName;
	
	//private MultipartFile file;
	

}
