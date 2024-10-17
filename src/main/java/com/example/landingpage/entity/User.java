package com.example.landingpage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	public Long id;
	public String username; 
	public String email; 
	public String password; 
	public String address;
}
