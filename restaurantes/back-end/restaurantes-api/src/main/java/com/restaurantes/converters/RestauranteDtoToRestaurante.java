package com.restaurantes.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.restaurantes.dto.RestauranteDto;
import com.restaurantes.model.Restaurante;
import com.restaurantes.service.ImageService;

@Component
public class RestauranteDtoToRestaurante implements Converter<RestauranteDto, Restaurante> {
	
	private ImageService imageService;
	
	@Autowired
	public RestauranteDtoToRestaurante(ImageService imageService) {
		this.imageService = imageService;
	}

	@Override
	public Restaurante convert(RestauranteDto source) {
		 if (source == null) return null;
		 Restaurante restaurante = new Restaurante();
		 restaurante.setId(source.getId());
		 restaurante.setDescripcion(source.getDescripcion());
		 restaurante.setDireccion(source.getDireccion());
		 restaurante.setNombre(source.getNombre());
		 restaurante.setPrecio(source.getPrecio());
		 restaurante.setImageModel(imageService.findById(source.getImagenId()));
		 return restaurante;
	}
	
}
