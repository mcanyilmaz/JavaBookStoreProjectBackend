package com.bookApplication2.BookApplication2.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="author")
@NoArgsConstructor
@AllArgsConstructor

public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

	private LocalDateTime createdDate;
	
	//private LocalDate createdDate = LocalDate.now();

	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateDate;
	
	@Column(name="author_name")
	private String authorName;
	
	@Column(name="author_about", length =300)
	private String authorAbout;
	
	@Column(name="image_name")
	private String imageName;
	
	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	//@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="author_id")
	private List<Book> books;
	
	
	
	
	
	
	
	
	
	/*
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	//@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="image_id")
	private ImageModel image;
*/
}
