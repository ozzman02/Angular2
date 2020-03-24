package com.restaurantes.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restaurantes.model.ImageModel;
import com.restaurantes.service.ImageService;
import com.restaurantes.util.FileUtil;

@RestController
@RequestMapping("/api/v1/images")
@CrossOrigin
public class ImageController {
	
	private ImageService imageService;
	
	@Autowired
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<InputStreamResource> getImage(@PathVariable("id") Long id) throws IOException {
		
		String imageName = imageService.findById(id).getName();
		
		ClassPathResource imgFile = new ClassPathResource("/static/images/" + imageName);
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
				.body(new InputStreamResource(imgFile.getInputStream()));
	}
	
	@PostMapping(value = "/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		ImageModel imageModel = new ImageModel(file.getOriginalFilename(),
				file.getContentType(), FileUtil.compressBytes(file.getBytes()));
		return new ResponseEntity<>(imageService.saveImage(imageModel).getId(), HttpStatus.OK); 
	}
	
}
