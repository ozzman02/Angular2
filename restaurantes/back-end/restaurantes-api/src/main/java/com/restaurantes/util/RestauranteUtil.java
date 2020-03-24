package com.restaurantes.util;

import java.util.ArrayList;
import java.util.List;

import com.restaurantes.dto.RestauranteDto;
import com.restaurantes.model.Restaurante;

public class RestauranteUtil {
	
	public static RestauranteDto convertRestauranteToRestauranteDto(Restaurante restaurante) {
		RestauranteDto restauranteDto = new RestauranteDto();
		restauranteDto.setId(restaurante.getId());
		restauranteDto.setDescripcion(restaurante.getDescripcion());
		restauranteDto.setDireccion(restaurante.getDireccion());
		restauranteDto.setNombre(restaurante.getNombre());
		restauranteDto.setPrecio(restaurante.getPrecio());
		restauranteDto.setImageId(restaurante.getImageModel().getId());
		return restauranteDto;
	}
	
	public static List<RestauranteDto> convertRestauranteList(List<Restaurante> restaurantes) {
		List<RestauranteDto> restauranteDtoList = new ArrayList<RestauranteDto>();
		for (Restaurante restaurante : restaurantes) {
			restauranteDtoList.add(convertRestauranteToRestauranteDto(restaurante));
		}
		return restauranteDtoList;
	}
	
}
