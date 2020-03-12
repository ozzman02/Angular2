package com.restaurantes.bootstrap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.restaurantes.model.Restaurante;
import com.restaurantes.repository.RestauranteRepository;

@Component
public class RestaurantesAppBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private RestauranteRepository restauranteRepository;
	
	private void loadRestaurantes() {
		
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setId(1);
		restaurante1.setNombre("Costa Rica Beer Factory");
		restaurante1.setDireccion("Barrio Escalante");
		restaurante1.setVersion(1L);
		restaurante1.setPrecio("10 millones");
		restaurante1.setImagen("costaRicaBeerFactory.png");
		restaurante1.setFechaDeCreacion(LocalDateTime.now());
		restaurante1.setFechaDeActualizacion(LocalDateTime.now());
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setId(2);
		restaurante2.setNombre("Agüizotes Gastro Pub");
		restaurante2.setDireccion("Barrio Escalante");
		restaurante2.setVersion(1L);
		restaurante2.setPrecio("11 millones");
		restaurante2.setImagen("agastropub.png");
		restaurante2.setFechaDeCreacion(LocalDateTime.now());
		restaurante2.setFechaDeActualizacion(LocalDateTime.now());
		
		Restaurante restaurante3 = new Restaurante();
		restaurante3.setId(3);
		restaurante3.setNombre("Delirio House");
		restaurante3.setDireccion("Barrio Escalante");
		restaurante3.setVersion(1L);
		restaurante3.setPrecio("5 millones");
		restaurante3.setImagen("delirio.png");
		restaurante3.setFechaDeCreacion(LocalDateTime.now());
		restaurante3.setFechaDeActualizacion(LocalDateTime.now());
		
		Restaurante restaurante4 = new Restaurante();
		restaurante4.setId(4);
		restaurante4.setNombre("Wilk Craft Beer");
		restaurante4.setDireccion("Barrio Escalante");
		restaurante4.setVersion(1L);
		restaurante4.setPrecio("6 millones");
		restaurante4.setImagen("wilkcraftbeer.png");
		restaurante4.setFechaDeCreacion(LocalDateTime.now());
		restaurante4.setFechaDeActualizacion(LocalDateTime.now());
		
		restaurantes.add(restaurante1);
		restaurantes.add(restaurante2);
		restaurantes.add(restaurante3);
		restaurantes.add(restaurante4);
		
		restauranteRepository.saveAll(restaurantes);
		
	}
	
	@Autowired
	public RestaurantesAppBootstrap(RestauranteRepository restauranteRepository) {
		this.restauranteRepository = restauranteRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadRestaurantes();
	}
		
}
