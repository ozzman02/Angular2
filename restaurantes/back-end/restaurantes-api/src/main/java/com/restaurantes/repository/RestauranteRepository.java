package com.restaurantes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurantes.model.Restaurante;

@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Integer> {
	
}
