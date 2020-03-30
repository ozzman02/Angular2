package com.restaurantes.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantes.converters.RestauranteDtoToRestaurante;
import com.restaurantes.converters.RestauranteToRestauranteDto;
import com.restaurantes.dto.RestauranteDto;
import com.restaurantes.model.Restaurante;
import com.restaurantes.repository.RestauranteRepository;
import com.restaurantes.service.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService {

	private RestauranteRepository restauranteRepository;
	
	private RestauranteDtoToRestaurante restauranteDtoConverter;
	
	private RestauranteToRestauranteDto restauranteConverter;
	
	@Autowired
	public RestauranteServiceImpl(RestauranteRepository restauranteRepository,
			RestauranteDtoToRestaurante restauranteDtoConverter, RestauranteToRestauranteDto restauranteConverter) {
		this.restauranteRepository = restauranteRepository;
		this.restauranteDtoConverter = restauranteDtoConverter;
		this.restauranteConverter = restauranteConverter;
	}
	
	@Override
	public List<Restaurante> getRestaurantes() {
		return (List<Restaurante>) restauranteRepository.findAll();
	}

	@Override
	public Restaurante getRestaurante(Integer idRestaurante)  {
		Optional<Restaurante> optionalRestaurante = restauranteRepository.findById(idRestaurante); 
		if(optionalRestaurante.isPresent()) {
			return optionalRestaurante.get();
		} else {
			return null;
		}
	}

	@Override
	public RestauranteDto getAnyRestaurante() {
		List<Restaurante> restauranteList = (List<Restaurante>) restauranteRepository.findAll();
		Random rand = new Random();
		Restaurante restaurante = restauranteList.get(rand.nextInt(restauranteList.size()));
		return restauranteConverter.convert(restaurante);
	}

	@Override
	public Restaurante saveRestaurante(RestauranteDto restauranteDto) {
		return restauranteRepository.save(restauranteDtoConverter.convert(restauranteDto));
	}

	@Override
	public Restaurante updateRestaurante(RestauranteDto restauranteDto) {
		Restaurante restauranteModificado = restauranteDtoConverter.convert(restauranteDto);
		Restaurante nuevoRestaurante = restauranteRepository.findById(restauranteDto.getId()).get();
		nuevoRestaurante = restauranteModificado;
		return restauranteRepository.save(nuevoRestaurante);
	}

	@Override
	public void deleteRestaurante(Integer idRestaurante) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(idRestaurante);
		restauranteRepository.delete(restaurante.get());
	}
	
}
