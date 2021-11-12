package com.bookApplication2.BookApplication2.requests;

import lombok.Data;

@Data
public class LikeRequest {

	private int id;
	
	private int commentId;
	
	private Long userId;
}
