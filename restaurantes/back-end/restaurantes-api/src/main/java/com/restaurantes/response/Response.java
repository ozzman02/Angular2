package com.restaurantes.response;

import java.util.ArrayList;
import java.util.List;

import com.restaurantes.model.Restaurante;

import lombok.Data;

@Data
public class Response {
	
	private String status = "success";
	
	private List<Restaurante> data = new ArrayList<Restaurante>();
	
	public Response(List<Restaurante> data) {
		this.data = data;
	}
	
}
