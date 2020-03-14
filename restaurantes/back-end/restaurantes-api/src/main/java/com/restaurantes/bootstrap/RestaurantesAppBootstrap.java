package com.restaurantes.bootstrap;

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
		restaurante1.setDescripcion("Comida Industrial");
		restaurante1.setDireccion("Barrio Escalante");
		restaurante1.setPrecio("bajo");
		restaurante1.setImagen("costaRicaBeerFactory.png");
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setId(2);
		restaurante2.setNombre("Agüizotes Gastro Pub");
		restaurante2.setDescripcion("Comida Industrial");
		restaurante2.setDireccion("Barrio Escalante");
		restaurante2.setPrecio("alto");
		restaurante2.setImagen("agastropub.png");
	
		Restaurante restaurante3 = new Restaurante();
		restaurante3.setId(3);
		restaurante3.setNombre("Delirio House");
		restaurante3.setDescripcion("Comida Industrial");
		restaurante3.setDireccion("Barrio Escalante");
		restaurante3.setPrecio("alto");
		restaurante3.setImagen("delirio.png");
		
		Restaurante restaurante4 = new Restaurante();
		restaurante4.setId(4);
		restaurante4.setNombre("Wilk Craft Beer");
		restaurante4.setDescripcion("Comida Industrial");
		restaurante4.setDireccion("Barrio Escalante");
		restaurante4.setPrecio("normal");
		restaurante4.setImagen("wilkcraftbeer.png");
		
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
