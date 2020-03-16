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

import com.restaurantes.dto.UpdateRestauranteDto;
import com.restaurantes.exception.NotFoundException;
import com.restaurantes.model.Restaurante;
import com.restaurantes.response.ErrorResponse;
import com.restaurantes.response.SuccessfulResponseItem;
import com.restaurantes.response.SuccessfulResponseList;
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
		return new ResponseEntity<>(new SuccessfulResponseList(restauranteService.getRestaurantes()), HttpStatus.OK);
	}
	
	@PostMapping(value = "/restaurantes", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> saveRestaurante(@RequestBody Restaurante restaurante) {
		return new ResponseEntity<>(new SuccessfulResponseItem(
				restauranteService.saveRestaurante(restaurante)), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/restaurantes", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateRestaurante(@RequestBody UpdateRestauranteDto updateRestauranteDto) {
		return new ResponseEntity<>(new SuccessfulResponseItem(
				restauranteService.updateRestaurante(updateRestauranteDto)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/restaurante/{id}")
	public ResponseEntity<?> getRestaurante(@PathVariable Integer id) {
		Restaurante restaurante = restauranteService.getRestaurante(id);
		if (restaurante != null) {
			return new ResponseEntity<>(new SuccessfulResponseItem(restaurante), HttpStatus.OK);
		} else {
			String message = String.format("El restaurante con id %s no existe", id);
			return new ResponseEntity<>(new ErrorResponse(new NotFoundException(message)), HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value = "/restaurante/{id}")
	public ResponseEntity<?> deleteRestaurante(@PathVariable Integer id) {
		restauranteService.deleteRestaurante(id);
		return new ResponseEntity<>(new SuccessfulResponseItem(null), HttpStatus.OK);
	}
	
}
