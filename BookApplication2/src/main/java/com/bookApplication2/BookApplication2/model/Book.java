package com.bookApplication2.BookApplication2.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.bookApplication2.BookApplication2.util.BookAppConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1676783239408325865L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name=BookAppConstant.COL_BOOKNAME)
	private String bookName;
	
	@Column(name="book_price")
	private int bookPrice;
	
	@Column(name="book_details",length =400)
	private String bookDetails;
	
	@Column(name="book_stock")
	private int bookStock;
	
	@Column(name="book_create_date")
	private LocalDateTime createDate;
	
	@Column(name="book_image_name")
	private String bookImageName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	
	//@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "author_id")
	private Author author;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	@OneToOne
	@JoinColumn(name="image_id")
	private ImageModel imageModel;

	
	
	// buradan sonrası ımage için
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Column(name = "picByte", length = 10000)
	private byte[] picByte;
	
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id")
	private ImageModel imageModel;
	*/
	
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="author_id",nullable = false)
	private Author author;
	*/
	
	
	/*
	//LAZY user objesini db den hemen çekme post objesini çektiğimde ilgili useri getirme
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="user_id",nullable = false)
		//bir user silindiğinde bütün postları sil.
		@OnDelete(action = OnDeleteAction.CASCADE)
		@JsonIgnore
		User user;*/
	
}

