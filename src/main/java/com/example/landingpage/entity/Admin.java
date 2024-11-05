package com.example.landingpage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name ="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id; 
	@Column(name="first_name", nullable = false)
	public String firstName; 
	@Column(name="last_name", nullable = false)
	public String lastName;
	@Column(name="email", nullable = false)
	public String email; 
	@Column(name="password", nullable = false)
	public String password;
}
