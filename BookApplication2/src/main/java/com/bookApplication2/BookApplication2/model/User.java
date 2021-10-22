package com.bookApplication2.BookApplication2.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.bookApplication2.BookApplication2.util.BookAppConstant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
	

@Entity
@Table(	name = BookAppConstant.TABLE_USERTABLENAME, 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = BookAppConstant.COL_USERUSERNAME),
			@UniqueConstraint(columnNames = BookAppConstant.COL_USERUSEREMAIL) 
		})

@Data
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -594215680151416582L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String username;


	private String email;

	@Column(name=BookAppConstant.COL_USERUSERPASSWORD)
	private String password;
	
	@Column(name=BookAppConstant.COL_USERPERSONNAME)
	private String name;
	@Column(name=BookAppConstant.COL_USERPERSONSURNAME)
	private String surname;
	
	@Column(name=BookAppConstant.COL_USERPERSONPHONENUMBER)
	private String userPhoneNumber;
	
	

	@Column(name=BookAppConstant.COL_USERADDRESS)
	private String userAddress;
	
	@Column(name=BookAppConstant.COL_USERCREATETIME)
	private LocalDateTime createTime;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = BookAppConstant.COL_USERUSERROLES, 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	
	@Column(name = BookAppConstant.COL_USERIMAGENAME)
	private String imageName;
	
	@Column(name = BookAppConstant.COL_USERIMAGETYPE)
	private String type;
	
	@Column(name = BookAppConstant.COL_USERIMAGEPICBYTE, length = 10000)
	private byte[] picByte;
	
	
	public User() {
	}
	
	
	public User(String username, String email, String password,
			String name, String surname,
			String userPhoneNumber, String userAddress,LocalDateTime createTime) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.userPhoneNumber = userPhoneNumber;
		this.userAddress = userAddress;
		this.createTime = createTime;
	}
	/*
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	*/
	
	
	
}