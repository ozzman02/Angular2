package com.restaurantes.service;

import java.util.List;
import java.util.Optional;

import com.restaurantes.model.Restaurante;

public interface RestauranteService {
	
	List<Restaurante> getRestaurantes();
	
	Optional<Restaurante> getRestaurante(Integer idRestaurante);
	
	Restaurante getAnyRestaurante();
	
	Restaurante saveRestaurante(Restaurante restaurante);
	
	Restaurante updateRestaurante(Integer idRestaurante);
	
	void deleteRestaurante(Integer idRestaurante);
	
}
