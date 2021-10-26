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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bookApplication2.BookApplication2.util.BookAppConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name=BookAppConstant.TABLE_BOOKORDERTABLENAME)

public class BookOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8225871973790290734L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name=BookAppConstant.COL_ORDERBOOKNAME)
	private String bookName;
	
	@Column(name=BookAppConstant.COL_ORDERBOOKPRICE)
	private Double bookPrice;
	
	@Column(name=BookAppConstant.COL_ORDERBOOKPIECE)
	private int bookPiece;
	
	@Column(name=BookAppConstant.COL_ORDERTOTALPIECE)
	private Double totalPrice;
	
	@Column(name=BookAppConstant.COL_ORDERORDERNUMBER)
	private int orderNumber;
	

	@Column(name=BookAppConstant.COL_ORDERADDRESS)
	private String address;
	
	@Column(name=BookAppConstant.COL_ORDERUSERNAME)
	private String username;

	@Column(name=BookAppConstant.COL_ORDERCRATETIME)
	private LocalDateTime createTime;
	
	
	@Column(name="state")
	private String state = "Hazırlanıyor";

	@ManyToMany(targetEntity=Book.class, fetch=FetchType.EAGER)
	@JoinColumn(name="bookList")

	private List<Book> bookList;
	
}
