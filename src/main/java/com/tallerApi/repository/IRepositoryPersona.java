package com.tallerApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tallerApi.domain.Persona;

@Repository
public interface IRepositoryPersona extends CrudRepository<Persona,Integer>  {

	
	
}
