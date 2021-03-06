package com.bookApplication2.BookApplication2.model;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6823159422573683725L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}