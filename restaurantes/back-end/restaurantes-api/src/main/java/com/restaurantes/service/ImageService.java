package com.restaurantes.service;

import com.restaurantes.model.ImageModel;

public interface ImageService {
	
	ImageModel findByName(String name);
	
	ImageModel findById(Long id);
	
	ImageModel saveImage(ImageModel imageModel);

}
