package com.bookApplication2.BookApplication2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bookApplication2.BookApplication2.util.BookAppConstant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name=BookAppConstant.TABLE_SLIDERTABLENAME)
@Entity
@Data
@NoArgsConstructor

public class Slider implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8509684061293279320L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = BookAppConstant.COL_SLİDERSLIDERSTATE)
	private Boolean state = true;
	
	@Column(name = BookAppConstant.COL_SLIDERSLIDERIMAGENAME)
	private String name;
	
	@Column(name = BookAppConstant.COL_SLIDERSLIDERIMAGETYPE)
	private String type;
	
	@Column(name = BookAppConstant.COL_SLIDERSLIDERIMAGEPICBYTE, length = 10000)
	private byte[] picByte;

	public Slider(Boolean state, String name, String type, byte[] picByte) {
		super();
		this.state = state;
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	} 
	
	
	
	
	
}
