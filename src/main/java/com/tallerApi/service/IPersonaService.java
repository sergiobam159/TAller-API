package com.tallerApi.service;

import java.util.List;

import com.tallerApi.domain.Persona;



public interface IPersonaService {
	
	Persona guardarPersona(Persona p);
	List<Persona> listarPersona();
	Persona actualizarPersona(Persona p);
	void borrarPersona(Integer id);
	Persona buscarPersona(Integer id);
	

}
