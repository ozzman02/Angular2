package com.restaurantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantes.exception.NotFoundException;
import com.restaurantes.model.Restaurante;
import com.restaurantes.response.ErrorResponse;
import com.restaurantes.response.Response;
import com.restaurantes.response.SingleResponse;
import com.restaurantes.service.RestauranteService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class RestauranteController {

	private RestauranteService restauranteService;
	
	@Autowired
	public RestauranteController(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}
	
	@GetMapping(value = "/restaurantes")
	public ResponseEntity<?> getRestaurantes() {
		return new ResponseEntity<>(new Response(restauranteService.getRestaurantes()), HttpStatus.OK);
	}
	
	@GetMapping(value = "/restaurante/{id}")
	public ResponseEntity<?> getRestaurante(@PathVariable Integer id) {
		Restaurante restaurante = restauranteService.getRestaurante(id);
		if (restaurante != null) {
			return new ResponseEntity<>(new SingleResponse(restaurante), HttpStatus.OK);
		} else {
			String message = String.format("El restaurante con id %s no existe", id);
			return new ResponseEntity<>(new ErrorResponse(new NotFoundException(message)), HttpStatus.OK);
		}
	}
	
}
