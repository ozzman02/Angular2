package com.restaurantes.response;

import com.restaurantes.dto.RestauranteDto;
import lombok.Data;

@Data
public class SuccessfulResponseItem {
	
	private String status = "success";
	
	private RestauranteDto data;
	
	public SuccessfulResponseItem(RestauranteDto data) {
		this.data = data;
	}
	
}
