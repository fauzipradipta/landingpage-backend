package com.example.landingpage.exception;

public class EmailNotFoundException extends Exception{

	private String message;
	
	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	
	
}
