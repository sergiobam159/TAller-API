package com.tallerApi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tallerApi.domain.Persona;
import com.tallerApi.repository.IRepositoryPersona;
import com.tallerApi.service.IPersonaService;

@Service
public class PersonaServiceImp implements IPersonaService {

	@Autowired
	IRepositoryPersona repo;

	@Override
	public Persona guardarPersona(Persona p) {
		repo.save(p);
		return p;
	}

	@Override
	public List<Persona> listarPersona() {
		return (List<Persona>) repo.findAll();
		
	}

	@Override
	public Persona actualizarPersona(Persona p) {
		
		return repo.save(p);
	}

	@Override
	public void borrarPersona(Integer id) {
		
		repo.deleteById(id);
		
	}

	@Override
	public Persona buscarPersona(Integer id) {
		return repo.findById(id).get();
	}
	
}
