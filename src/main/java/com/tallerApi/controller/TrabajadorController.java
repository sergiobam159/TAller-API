package com.tallerApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
	public ResponseEntity<Object> metodoGuardarTrabajador(@RequestBody Trabajador t) {
		
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
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> metodoBorrarTrabajador(@RequestBody Trabajador t, @PathVariable Long id) {
		traService.borrarTrabajador(id);
		log.info("se borro al trabajador de id "+id);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/buscar")
	public Trabajador metodoBuscarTrabajador(@RequestParam Long id) {
		return traService.buscarTrabajador(id);
	}
	
	@GetMapping("/listar")
	public List<Trabajador> metodoListarTrabajador (){
		log.info("se listaron a todas los trabajadores");
		return traService.listarTrabajador();
	}
	
	@PutMapping("/actualizar/{id}")
public ResponseEntity<Object>  metodoActualizarTrabajador(@RequestBody Trabajador t, @PathVariable Long id) {
		
		Optional <Trabajador> tr= repo.findById(id);
			
		if(!tr.isPresent()) {
			log.warn("no existe este trabajador");
			return ResponseEntity.notFound().build();
		}else {
			log.info("se actualizó este trabajador "+t.getPersona().getNombre());
			traService.actualizarTrabajador(t);
			 return  ResponseEntity.accepted().build();
		}
		
		
	}
	
	
}
