package com.bookApplication2.BookApplication2.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name=BookAppConstant.TABLE_COMMENTTABLENAME)
public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5345309821895861521L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name=BookAppConstant.COL_COMMENTCOMMENTNAME)
	private String comment;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name=BookAppConstant.COL_COMMENTCREATETIME)
	private LocalDateTime createTime;
	
	
	@Column(name="totalLike")
	private int totalLike=0;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = BookAppConstant.COL_COMMENTBOOKID)
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = BookAppConstant.COL_COMMENTUSERID)
	private User user;
	
	

}
