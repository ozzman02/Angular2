package com.restaurantes.response;

import java.util.List;

import com.restaurantes.dto.RestauranteDto;
import lombok.Data;

@Data
public class SuccessfulResponseList {
	
	private String status = "success";
	
	private List<RestauranteDto> data;
	
	public SuccessfulResponseList(List<RestauranteDto> data) {
		this.data = data;
	}
	
}
