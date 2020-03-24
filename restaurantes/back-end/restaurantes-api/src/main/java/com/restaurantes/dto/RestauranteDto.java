package com.restaurantes.dto;

import lombok.Data;

@Data
public class RestauranteDto {
	private Integer id;
	private String nombre;
	private String descripcion;
	private String direccion;
	private String precio;
	private Long imageId;
}
