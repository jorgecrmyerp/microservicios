package com.jgr.microservicio.app.usuario.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jgr.microservicio.commons.alumnos.models.entity.Alumno;

public interface IAlumnoRepository extends CrudRepository<Alumno, Long> {
	
	//consulta jpaql
	@Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Alumno> findByNombreOrApellido(String texto);

}
