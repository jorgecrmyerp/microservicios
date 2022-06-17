package com.jgr.microservicio.app.examenes.services;

import java.util.List;

import com.jgr.microservicio.commons.examenes.models.entity.Examen;
import com.jgr.microservicio.commons.services.ICommonService;

public interface IExamenService extends ICommonService<Examen>{
	public List<Examen> findByNombre(String term);

}
