package com.tallerApi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//aqui estan los getters and setters ↓
@Data
//aqui se definen los constructores 
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="tbl_trabajador")
public class Trabajador {

	@OneToOne
	@JoinColumn(name="idPersona", nullable=false)
private Persona persona;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTrabajador", length = 4, nullable = false)
private Long idTrabajador;
	@Column(name="sueldo", length = 6, nullable = false)
private Double sueldo;
	@Column(name="activo", nullable = false)
private boolean activo;
	@Column(name="area", length = 13, nullable = false)
private String area;
}
