package com.restaurantes.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.restaurantes.dto.RestauranteDto;
import com.restaurantes.model.Restaurante;

@Component
public class RestauranteToRestauranteDto implements Converter<Restaurante, RestauranteDto>{

	@Override
	public RestauranteDto convert(Restaurante source) {
		
		if (source == null) return null;
		
		RestauranteDto restauranteDto = new RestauranteDto();
		restauranteDto.setId(source.getId());
		restauranteDto.setDescripcion(source.getDescripcion());
		restauranteDto.setDireccion(source.getDireccion());
		restauranteDto.setNombre(source.getNombre());
		restauranteDto.setPrecio(source.getPrecio());
		
		if (source.getImageModel() != null) {
			restauranteDto.setImagenId(source.getImageModel().getId());
		} else {
			restauranteDto.setImagenId(null);
		}
		
		return restauranteDto;
	}
	
	public List<RestauranteDto> convertRestauranteList(List<Restaurante> restaurantes) {
		List<RestauranteDto> restauranteDtoList = new ArrayList<RestauranteDto>();
		for (Restaurante restaurante : restaurantes) {
			restauranteDtoList.add(this.convert(restaurante));
		}
		return restauranteDtoList;
	}

}
