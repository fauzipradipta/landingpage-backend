package com.landingpagebackend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="User")

public class User {
	
	@Id
	@Column(name="user_id", length=45 )
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id; 
	@Column(name="user_username", length=255 )
	private String username;
	@Column(name="user_email", length=255 )
	private String email;
	@Column(name="user_password", length=255 )
	private String password;
	
	public User(Long id, String username, String email, String password) {
		super();
		Id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
