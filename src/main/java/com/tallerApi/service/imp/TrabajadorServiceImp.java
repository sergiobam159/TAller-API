package com.tallerApi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tallerApi.domain.Trabajador;
import com.tallerApi.repository.IRepositoryTrabajador;
import com.tallerApi.service.ITrabajadorService;
@Service
public class TrabajadorServiceImp implements ITrabajadorService{

	@Autowired
	IRepositoryTrabajador repo;

	@Override
	public Trabajador guardarTrabajador(Trabajador t) {
		
		return 	repo.save(t);
	}

	@Override
	public List<Trabajador> listarTrabajador() {
		// TODO Auto-generated method stub
		return  (List<Trabajador>) repo.findAll();
	}

	@Override
	public Trabajador actualizarTrabajador(Trabajador t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public void borrarTrabajador(Long id) {
		// TODO Auto-generated method stub
		
			repo.deleteById(id);	
		
		
	}

	@Override
	public Trabajador buscarTrabajador(Long id) {
		return repo.findById(id).get();
	}
	
	

}
