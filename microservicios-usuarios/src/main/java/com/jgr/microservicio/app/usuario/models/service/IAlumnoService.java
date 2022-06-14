package com.jgr.microservicio.app.usuario.models.service;


import com.jgr.microservicio.commons.alumnos.models.entity.Alumno;
import com.jgr.microservicio.commons.services.ICommonService;


//le paso el tipo de dato que voy a usar,el service de microserviciocursos que
//he hecho generico para poder reutilizarlo luego con el resto de clases
public interface IAlumnoService extends ICommonService<Alumno>{}

//ESTO ES NECESARIO ANTES DE INCLUIR EN EL POM EL COMMONS, AHORA NO ES NECESARIO
/*
public interface IAlumnoService {
	
	public Iterable<Alumno> findAll();
	
	public Optional<Alumno> findById(Long id);
	
	public Alumno save(Alumno alumno);
	
	public void deleteById(Long id);
	

}
*/