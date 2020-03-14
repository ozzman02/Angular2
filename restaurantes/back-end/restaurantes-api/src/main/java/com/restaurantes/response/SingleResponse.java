package com.restaurantes.response;

import com.restaurantes.model.Restaurante;

import lombok.Data;

@Data
public class SingleResponse {
	
	private String status = "success";
	
	private Restaurante data;
	
	public SingleResponse(Restaurante data) {
		this.data = data;
	}
	
}
