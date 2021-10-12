package com.bookApplication2.BookApplication2.requests;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.ImageModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class AuthorCreateRequest {
	
	private int id;
	
	private String authorName;
	
	private String authorAbout;
	
	private LocalDateTime createdDate;
	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateDate;
	
	private String imageName;
	
	
	//private List<Book> books;
	
	//private int image_id;
	

}
