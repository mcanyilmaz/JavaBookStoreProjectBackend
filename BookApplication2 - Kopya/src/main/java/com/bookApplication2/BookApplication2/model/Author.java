package com.bookApplication2.BookApplication2.model;

import java.io.Serializable;
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

import com.bookApplication2.BookApplication2.util.BookAppConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name=BookAppConstant.TABLE_AUTHORTABLENAME)
@NoArgsConstructor
@AllArgsConstructor

public class Author implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9111465956991049780L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name=BookAppConstant.COL_AUTHORCREATEDATE)
	private LocalDateTime createdDate;
	
	//private LocalDate createdDate = LocalDate.now();

	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name=BookAppConstant.COL_AUTHORUPDATEDATE)
	private LocalDateTime updateDate;
	
	@Column(name=BookAppConstant.COL_AUTHORNAME)
	private String authorName;
	
	@Column(name=BookAppConstant.COL_AUTHORABOUT, length =300)
	private String authorAbout;
	
	@Column(name="author_images_name")
	private String imageName;
	
	@Column(name=BookAppConstant.COL_AUTHORIMAGENAME)
	private String name;
	
	@Column(name=BookAppConstant.COL_AUTHORIMAGETYPE)
	private String type;
	
	@Column(name =BookAppConstant.COL_AUTHORIMAGEPICBYTE , length = 10000)
	private byte[] picByte;
	
	
	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	//@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name=BookAppConstant.COL_LISTAUTHORID)
	private List<Book> books;
	
	
	
	
	
	
	
	
	
	/*
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	//@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="image_id")
	private ImageModel image;
*/
}
