package com.jgr.microservicio.app.usuario.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.jgr.microservicio.commons.alumnos.models.entity.Alumno;

public interface IAlumnoRepository extends CrudRepository<Alumno, Long> {
	

}
