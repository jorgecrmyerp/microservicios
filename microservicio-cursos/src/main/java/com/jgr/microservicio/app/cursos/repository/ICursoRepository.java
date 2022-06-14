package com.jgr.microservicio.app.cursos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jgr.microservicio.app.cursos.models.entity.Curso;

public interface ICursoRepository extends CrudRepository<Curso, Long> {

	//cruza cursos y alumnos, buscando por el id de alumnos
	@Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
	public Curso findCursoByAlumnoId(Long id);
	
	
}
