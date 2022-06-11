package com.jgr.microservicio.app.usuario.models.service;

import com.jgr.microservicio.app.usuario.models.entity.Alumno;
import com.jgr.microservicio.commons.services.ICommonService;


//le paso el tipo de dato que voy a usar
public interface IAlumnoService extends ICommonService<Alumno>{}

//TODO ESTO ES NECESARIO ANTES DE INCLUIR EN EL POM EL COMMONS, AHORA NO ES NECESARIO
/*
public interface IAlumnoService {
	
	public Iterable<Alumno> findAll();
	
	public Optional<Alumno> findById(Long id);
	
	public Alumno save(Alumno alumno);
	
	public void deleteById(Long id);
	

}
*/