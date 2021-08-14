package com.tallerApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tallerApi.domain.Persona;
import com.tallerApi.domain.Trabajador;

import com.tallerApi.repository.IRepositoryTrabajador;

import com.tallerApi.service.ITrabajadorService;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/Trabajador")
@RestController
@Log4j2
public class TrabajadorController {

	@Autowired ITrabajadorService traService;
	@Autowired IRepositoryTrabajador repo;
	@Autowired PersonaController pcontrol;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarTrabajador(@RequestBody Trabajador t) {
		
//DEBE EXISTIR UNA PERSONA CREADA
//LO QUE HACE ES CONECTAR LA PERSONA Y LA "CONVIERTE" a trabajador con este json ↓
		/*{
		    
			  "sueldo": 993.5,
			  "activo" : true,
			  "area" : "sistemas",

			  "persona" : {
			      "idPersona": 1,
			"nombre" : "sergio",
			"apellido": "silva",
			"edad" : 25,
			"dni" : 11122233
			    }
			    
			}*/
		
		 traService.guardarTrabajador(t);
		 log.info("por fin");
		 return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
}
