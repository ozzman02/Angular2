package com.restaurantes.repository;

import org.springframework.data.repository.CrudRepository;

import com.restaurantes.model.ImageModel;

public interface ImageRepository extends CrudRepository<ImageModel, Long> {
	
	ImageModel findByName(String imageName);

}
