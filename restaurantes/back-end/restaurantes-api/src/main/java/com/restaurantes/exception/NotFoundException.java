package com.restaurantes.exception;

import lombok.Getter;


public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private String status = "error";
	
	public NotFoundException(String message) {
		super(message);
	}
	
	
	
}
