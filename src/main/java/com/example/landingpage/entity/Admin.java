package com.example.landingpage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="admin")
public class Admin {
	
	@Id
	public Long Id; 
	public String firstName; 
	public String lastName;
	public String email; 
	public String password;
}
