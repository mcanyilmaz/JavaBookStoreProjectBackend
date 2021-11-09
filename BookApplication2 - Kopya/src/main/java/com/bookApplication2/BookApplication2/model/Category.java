package com.bookApplication2.BookApplication2.model;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.bookApplication2.BookApplication2.util.BookAppConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name=BookAppConstant.TABLE_CATEGORYTABLENAME)
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3796636759027367581L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "category_id")
	
	@Column(name=BookAppConstant.COL_CATEGORYCATEGORYNAME)
	private String categoryName;

	//@JsonIgnore
	//@OneToMany(fetch = FetchType.EAGER)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	//@JoinColumn(name="category_id")
	//private List<Book> books;
	
	@Column(name =BookAppConstant.COL_CATEGORYIMAGENAME )
	private String name;
	
	@Column(name =BookAppConstant.COL_CATEGORYIMAGETYPE )
	private String type;
	
	@Column(name = BookAppConstant.COL_CATEGORYIMAGEPICBYTE, length = 10000)
	private byte[] picByte;
	
	

}
