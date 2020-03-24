package com.restaurantes.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantes.model.ImageModel;
import com.restaurantes.repository.ImageRepository;
import com.restaurantes.service.ImageService;
import com.restaurantes.util.FileUtil;

@Service
public class ImageServiceImpl implements ImageService {

	private ImageRepository imageRepository;
	
	@Autowired
	public ImageServiceImpl(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	@Override
	public ImageModel findByName(String name) {
		return imageRepository.findByName(name);
	}

	@Override
	public ImageModel saveImage(ImageModel imageModel) {
		return imageRepository.save(imageModel);
	}

	@Override
	public ImageModel findById(Long id) {
		
		final Optional<ImageModel> retrievedImage = imageRepository.findById(id); 
		
		ImageModel imageModel = new ImageModel(
				retrievedImage.get().getId(),
				retrievedImage.get().getName(), 
				retrievedImage.get().getType(), 
				FileUtil.decompressBytes(retrievedImage.get().getPicByte())
		);
		
		return imageModel;
	}

}
