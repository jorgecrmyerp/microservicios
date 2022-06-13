package com.jgr.microservicio.app.cursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.jgr.microservicio.app.cursos.models.entity.Curso;

public interface ICursoRepository extends CrudRepository<Curso, Long> {

}
