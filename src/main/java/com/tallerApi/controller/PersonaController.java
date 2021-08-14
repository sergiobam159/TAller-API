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
import org.springframework.web.client.HttpStatusCodeException;

import com.tallerApi.domain.Persona;
import com.tallerApi.repository.IRepositoryPersona;
import com.tallerApi.service.IPersonaService;

import ch.qos.logback.core.status.Status;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired IPersonaService personaService;
	@Autowired IRepositoryPersona  repo;
	
	@PostMapping("/guardar")
	/*
	public Persona metodoGuardarPersona(@RequestBody Persona p) {
		
		return personaService.guardarPersona(p);
	}*/
	
public ResponseEntity<Object> metodoGuardarPersona(@RequestBody Persona p) {
		
		 personaService.guardarPersona(p);
		 log.info("se creó nueva persona "+ p.getNombre());
		 return new ResponseEntity<>(HttpStatus.CREATED);
		 
	}
	
	@PutMapping("/actualizar/{id}")
	/*
	public Persona metodoActualizarPersona(@RequestBody Persona p, @PathVariable Integer id) {
		Optional <Persona> person = repo.findById(id);
		
		if(person.isPresent()) {
			return personaService.actualizarPersona(p);
		}else {
			return p;
		}
		
	}*/
	
	//???????????????????????????????????????????????????? crea ???????????????
	public ResponseEntity<Object>  metodoActualizarPersona(@RequestBody Persona p, @PathVariable Integer id) {
		
		Optional <Persona> persona = repo.findById(id);
			
		if(!persona.isPresent()) {
			log.warn("no existe la persona buscada ");
			return ResponseEntity.notFound().build();
		}else {
			log.info("se actualizó la persona "+p.getNombre());
			 personaService.actualizarPersona(p);
			 return  ResponseEntity.accepted().build();
		}
		
		
	}
	
	@GetMapping("/listar")
	public List<Persona> metodoListarPersona (){
		log.info("se listaron a todas las personas");
		return personaService.listarPersona();
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> metodoDeletePersona(@RequestBody Persona p, @PathVariable Integer id) {
		personaService.borrarPersona(id);
		log.info("se borro a la persona de id "+id);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/buscar")
	public Persona Buscar(@RequestParam Integer id) {
		return personaService.buscarPersona(id);
	}
	
	
	
	
	
	
}
