package com.landingpage.landingpagebackend.Entity;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="image")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="name")
	private String name; 
	
	@Column(name="itemDesc")
	private String itemDesc; 
	
	@Column(name="itemPrice")
	private String itemprice; 
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "image", length = 1000)
	private byte[] image;

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public byte[] getImageByte() {
//		return imageByte;
//	}
//
//	public void setImageByte(byte[] imageByte) {
//		this.imageByte = imageByte;
//	}
//
//	public Items(String name, String type, byte[] imageByte) {
//		
//		this.name = name;
//		this.type = type;
//		this.imageByte = imageByte;
//	}
//	
//	public Items() {
//		super();
//	}
	
}
