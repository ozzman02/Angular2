package com.restaurantes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "precio")
	private String precio;
	
	@CreationTimestamp
	@Column(name = "fechaDeCreacion")
	private LocalDateTime fechaDeCreacion;
	
	@UpdateTimestamp
	@Column(name = "fechaDeActualizacion")
	private LocalDateTime fechaDeActualizacion;
	
	@Version
    private Long version;
	
}
