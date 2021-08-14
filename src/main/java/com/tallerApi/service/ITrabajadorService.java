package com.tallerApi.service;

import java.util.List;

import com.tallerApi.domain.Trabajador;

public interface ITrabajadorService {
	Trabajador guardarTrabajador(Trabajador t);
	List<Trabajador> listarTrabajador();
	Trabajador actualizarTrabajador(Trabajador t);
	void borrarTrabajador(Long id);
	Trabajador buscarTrabajador(Long id);
	
}
