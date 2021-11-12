package com.bookApplication2.BookApplication2.requests;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentCreateRequest {


	private int id;
	
	private String comment;
	
	private Long userId;
	
	private int totalLike=0;
	
	private LocalDateTime createTime;

	private int bookId;
	
}
