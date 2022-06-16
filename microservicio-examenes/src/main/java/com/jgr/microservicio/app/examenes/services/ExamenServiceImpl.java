package com.jgr.microservicio.app.examenes.services;

import org.springframework.stereotype.Service;

import com.jgr.microservicio.app.examenes.models.repository.IExamenRepository;
import com.jgr.microservicio.commons.examenes.models.Examen;
import com.jgr.microservicio.commons.services.CommonServiceImpl;


@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen,IExamenRepository> implements IExamenService {

	

}
