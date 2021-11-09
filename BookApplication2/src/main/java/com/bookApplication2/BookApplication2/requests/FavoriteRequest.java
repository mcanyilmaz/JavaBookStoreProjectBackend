package com.bookApplication2.BookApplication2.requests;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.User;

import lombok.Data;

@Data
public class FavoriteRequest {

	private int id;
	private Boolean status;
	private int bookId;
	private Long userId;
	
	
}
