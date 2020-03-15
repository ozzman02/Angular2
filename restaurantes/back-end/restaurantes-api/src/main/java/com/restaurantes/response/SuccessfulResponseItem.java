package com.restaurantes.response;

import com.restaurantes.model.Restaurante;

import lombok.Data;

@Data
public class SuccessfulResponseItem {
	
	private String status = "success";
	
	private Restaurante data;
	
	public SuccessfulResponseItem(Restaurante data) {
		this.data = data;
	}
	
}
