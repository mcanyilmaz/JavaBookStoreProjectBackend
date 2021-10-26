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
@Table(name=BookAppConstant.TABLE_BOOKTABLENAME)
@NoArgsConstructor
@AllArgsConstructor

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1676783239408325865L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name=BookAppConstant.COL_BOOKNAME)
	private String bookName;
	
	@Column(name=BookAppConstant.COL_BOOKPRICE)
	private Double bookPrice;
		
	@Column(name=BookAppConstant.COL_BOOKDETAILS,length =400)
	private String bookDetails;
	
	@Column(name=BookAppConstant.COL_BOOKSTOCK)
	private int bookStock;
	
	@Column(name=BookAppConstant.COL_BOOKCREATEDATE)
	private LocalDateTime createDate;
	
	@Column(name="book_images_name")
	private String bookImageName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	//@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = BookAppConstant.COL_BOOKAUTHORID)
	private Author author;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = BookAppConstant.COL_CATEGORYID)
	private Category category;
	
	
	@Column(name="rating")
	private int rating;
	
	//@OneToOne
	//@JoinColumn(name="image_id")
	//private ImageModel imageModel;

	
	@Column(name=BookAppConstant.COL_BOOKIMAGENAME)
	private String name;
	
	@Column(name=BookAppConstant.COL_BOOKIMAGETYPE)
	private String type;
	
	@Column(name = BookAppConstant.COL_BOOKIMAGEPICBYTE, length = 10000)
	private byte[] picByte;
	
	/*
	//LAZY user objesini db den hemen çekme post objesini çektiğimde ilgili useri getirme
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="user_id",nullable = false)
		//bir user silindiğinde bütün postları sil.
		@OnDelete(action = OnDeleteAction.CASCADE)
		@JsonIgnore
		User user;*/
	
}

