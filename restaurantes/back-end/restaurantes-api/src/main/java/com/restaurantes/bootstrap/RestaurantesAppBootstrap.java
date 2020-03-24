package com.restaurantes.bootstrap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.restaurantes.model.ImageModel;
import com.restaurantes.model.Restaurante;
import com.restaurantes.repository.ImageRepository;
import com.restaurantes.repository.RestauranteRepository;
import com.restaurantes.util.FileUtil;

@Component
public class RestaurantesAppBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private RestauranteRepository restauranteRepository;
	
	private ImageRepository imageRepository;
	
	private static String IMAGE_FOLDER = "C:\\Users\\USUARIO\\git\\Angular2\\restaurantes\\back-end\\restaurantes-api\\src\\main\\resources\\static\\images";
	
	private void loadRestaurantes() {
		
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setId(1);
		restaurante1.setNombre("Costa Rica Beer Factory");
		restaurante1.setDescripcion("Comida Industrial");
		restaurante1.setDireccion("Barrio Escalante");
		restaurante1.setPrecio("bajo");
		restaurante1.setImageModel(imageRepository.findByName("beerFactory.png"));
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setId(2);
		restaurante2.setNombre("Agüizotes Gastro Pub");
		restaurante2.setDescripcion("Comida Industrial");
		restaurante2.setDireccion("Barrio Escalante");
		restaurante2.setPrecio("alto");
		restaurante2.setImageModel(imageRepository.findByName("aguizotes.png"));
	
		Restaurante restaurante3 = new Restaurante();
		restaurante3.setId(3);
		restaurante3.setNombre("Delirio House");
		restaurante3.setDescripcion("Comida Industrial");
		restaurante3.setDireccion("Barrio Escalante");
		restaurante3.setPrecio("alto");
		restaurante3.setImageModel(imageRepository.findByName("delirio.png"));
		
		Restaurante restaurante4 = new Restaurante();
		restaurante4.setId(4);
		restaurante4.setNombre("Wilk Craft Beer");
		restaurante4.setDescripcion("Comida Industrial");
		restaurante4.setDireccion("Barrio Escalante");
		restaurante4.setPrecio("normal");
		restaurante4.setImageModel(imageRepository.findByName("wilk.png"));
		
		restaurantes.add(restaurante1);
		restaurantes.add(restaurante2);
		restaurantes.add(restaurante3);
		restaurantes.add(restaurante4);
		
		restauranteRepository.saveAll(restaurantes);
		
	}
	
	private void saveImagesInDB() {
		List<ImageModel> imageList = new ArrayList<ImageModel>();
		File[] files = new File(IMAGE_FOLDER).listFiles();
		for (File file : files) {
			MultipartFile multipartFile =  convertToMultipartFile(file);
			try {
				ImageModel imageModel = new ImageModel(multipartFile.getOriginalFilename(), 
						multipartFile.getContentType(),FileUtil.compressBytes(multipartFile.getBytes()));
				imageList.add(imageModel);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		imageRepository.saveAll(imageList);
	}
	
	private MultipartFile convertToMultipartFile(File file) {
		DiskFileItem fileItem = null;
		try {
			fileItem = new DiskFileItem("imageFile", Files.probeContentType(file.toPath()), 
					false, file.getName(), (int) file.length(), file.getParentFile());
			IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
		return multipartFile;
	}
	
	@Autowired
	public RestaurantesAppBootstrap(RestauranteRepository restauranteRepository, 
			ImageRepository imageRepository) {
		this.restauranteRepository = restauranteRepository;
		this.imageRepository = imageRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		saveImagesInDB();
		loadRestaurantes();
	}
		
}
