package com.restaurantes.service;

import java.util.List;

import com.restaurantes.dto.RestauranteDto;
import com.restaurantes.model.Restaurante;

public interface RestauranteService {
	
	List<Restaurante> getRestaurantes();
	
	Restaurante getRestaurante(Integer idRestaurante);
	
	Restaurante getAnyRestaurante();
	
	Restaurante saveRestaurante(Restaurante restaurante);
	
	Restaurante updateRestaurante(RestauranteDto restauranteDto);
	
	void deleteRestaurante(Integer idRestaurante);
	
}
