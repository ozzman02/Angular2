package com.restaurantes.service;

import java.util.List;

import com.restaurantes.dto.UpdateRestauranteDto;
import com.restaurantes.model.Restaurante;

public interface RestauranteService {
	
	List<Restaurante> getRestaurantes();
	
	Restaurante getRestaurante(Integer idRestaurante);
	
	Restaurante getAnyRestaurante();
	
	Restaurante saveRestaurante(Restaurante restaurante);
	
	Restaurante updateRestaurante(UpdateRestauranteDto updateRestauranteDto);
	
	void deleteRestaurante(Integer idRestaurante);
	
}
