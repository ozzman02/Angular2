package com.restaurantes.response;

import java.util.List;

import com.restaurantes.model.Restaurante;

import lombok.Data;

@Data
public class SuccessfulResponseList {
	
	private String status = "success";
	
	private List<Restaurante> data;
	
	public SuccessfulResponseList(List<Restaurante> data) {
		this.data = data;
	}
	
}
