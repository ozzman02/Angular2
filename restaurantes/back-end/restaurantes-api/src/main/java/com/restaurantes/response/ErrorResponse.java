package com.restaurantes.response;

import lombok.Data;

@Data
public class ErrorResponse  {
	
	private String status = "error";
	
	private Exception exception;
	
	public ErrorResponse(Exception exception) {
		this.exception = exception;
	}
}
