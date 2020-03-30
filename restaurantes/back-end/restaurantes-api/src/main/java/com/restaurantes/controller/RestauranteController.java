package com.restaurantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantes.converters.RestauranteDtoToRestaurante;
import com.restaurantes.converters.RestauranteToRestauranteDto;
import com.restaurantes.dto.RestauranteDto;
import com.restaurantes.exception.NotFoundException;
import com.restaurantes.model.Restaurante;
import com.restaurantes.response.ErrorResponse;
import com.restaurantes.response.SuccessfulResponseItem;
import com.restaurantes.response.SuccessfulResponseList;
import com.restaurantes.service.RestauranteService;

@RestController
@RequestMapping("/api/v1/restaurantes")
@CrossOrigin
public class RestauranteController {

	private RestauranteService restauranteService;
	
	@SuppressWarnings("unused")
	private RestauranteDtoToRestaurante restauranteConverter;
	
	private RestauranteToRestauranteDto restauranteDtoConverter;
	
	@Autowired
	public RestauranteController(RestauranteService restauranteService, RestauranteDtoToRestaurante restauranteConverter,
			RestauranteToRestauranteDto restauranteDtoConverter) {
		this.restauranteService = restauranteService;
		this.restauranteConverter = restauranteConverter;
		this.restauranteDtoConverter = restauranteDtoConverter;
	}
	
	@GetMapping
	public ResponseEntity<?> getRestaurantes() {
		return new ResponseEntity<>(new SuccessfulResponseList(
				restauranteDtoConverter.convertRestauranteList(
						restauranteService.getRestaurantes())), HttpStatus.OK);	
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> saveRestaurante(@RequestBody RestauranteDto restauranteDto) {
		return new ResponseEntity<>(
				new SuccessfulResponseItem(restauranteDtoConverter.convert(
						restauranteService.saveRestaurante(restauranteDto))), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateRestaurante(@RequestBody RestauranteDto restauranteDto) {
		return new ResponseEntity<>(
				new SuccessfulResponseItem(restauranteDtoConverter.convert(
								restauranteService.updateRestaurante(restauranteDto))), HttpStatus.OK);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getRestaurante(@PathVariable Integer id) {	
		Restaurante restaurante = restauranteService.getRestaurante(id);
		if (restaurante != null) {
			return new ResponseEntity<>(
					new SuccessfulResponseItem(restauranteDtoConverter.convert(restaurante)), HttpStatus.OK);
		} else {
			String message = String.format("El restaurante con id %s no existe", id);
			return new ResponseEntity<>(new ErrorResponse(new NotFoundException(message)), HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteRestaurante(@PathVariable Integer id) {
		restauranteService.deleteRestaurante(id);
		return new ResponseEntity<>(new SuccessfulResponseItem(null), HttpStatus.OK);
	}
	
}
