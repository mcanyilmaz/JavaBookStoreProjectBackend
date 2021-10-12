package com.bookApplication2.BookApplication2.requests;

import lombok.Data;

@Data
public class UserCreateRequest {
	
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String email;

	

}
