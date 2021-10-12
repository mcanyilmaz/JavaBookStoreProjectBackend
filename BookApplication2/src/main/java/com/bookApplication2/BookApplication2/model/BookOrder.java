package com.bookApplication2.BookApplication2.model;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name="book_orders")

public class BookOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	
	
	
	
	private String bookName;
	
	private Double bookPrice;
	
	private int bookPiece;
	
	private Double totalPrice;
	
	private int orderNumber;
	

	
	private String address;
	
	private String username;

	private LocalDateTime createTime;
	
	
}
