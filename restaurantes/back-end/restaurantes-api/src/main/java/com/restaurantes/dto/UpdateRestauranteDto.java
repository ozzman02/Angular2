package com.restaurantes.dto;

import com.restaurantes.model.Restaurante;

import lombok.Data;

@Data
public class UpdateRestauranteDto {
	
	private Integer id;
	
	private Restaurante restaurante;

	public UpdateRestauranteDto(Integer id, Restaurante restaurante) {
		this.id = id;
		this.restaurante = restaurante;
	}
	
}
