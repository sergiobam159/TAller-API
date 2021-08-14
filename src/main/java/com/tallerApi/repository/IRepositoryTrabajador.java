package com.tallerApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.tallerApi.domain.Trabajador;

@Repository
public interface IRepositoryTrabajador extends CrudRepository<Trabajador,Long>{

}
