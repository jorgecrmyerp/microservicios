package com.jgr.microservicio.app.usuario.models.service;

import java.util.Optional;

import com.jgr.microservicio.app.usuario.models.entity.Alumno;

public interface IAlumnoService {
	
	public Iterable<Alumno> findAll();
	
	public Optional<Alumno> findById(Long id);
	
	public Alumno save(Alumno alumno);
	
	public void deleteById(Long id);
	

}
