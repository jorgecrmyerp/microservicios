package com.jgr.microservicio.app.examenes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jgr.microservicio.app.examenes.models.repository.IExamenRepository;
import com.jgr.microservicio.commons.examenes.models.entity.Examen;
import com.jgr.microservicio.commons.services.CommonServiceImpl;


@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen,IExamenRepository> implements IExamenService {
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}

	

}
