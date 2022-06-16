package com.jgr.microservicio.app.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.jgr.microservicio.commons.examenes.models.Examen;

public interface IExamenRepository extends CrudRepository<Examen,Long>{

}
