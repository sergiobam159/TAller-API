package com.tallerApi.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tblPersona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPersona", length = 4, nullable = false)
	private Integer idPersona;
	@Column(name="nombrePersona", length = 10, nullable = false)
private String nombre;
	@Column(name="apellidoPersona", length = 10, nullable = false)
private String apellido;
	@Column(name="edadPersona", length = 2, nullable = false)
private Integer edad;
	@Column(name="dniPersona", length = 8, nullable = false, unique = true)
private String dni;
	
}
