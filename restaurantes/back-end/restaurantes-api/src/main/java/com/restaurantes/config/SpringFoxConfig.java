package com.restaurantes.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Restaurantes REST API", 
	      "REST API for the Restaurante project", 
	      "API Restaurantes", 
	      "Terms of service", 
	      new Contact("Oscar Santamaria", "www.osantamaria.com", "osantamaria@gmail.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.restaurantes.controller"))
				.build()
				.apiInfo(apiInfo());
	}
	
}
