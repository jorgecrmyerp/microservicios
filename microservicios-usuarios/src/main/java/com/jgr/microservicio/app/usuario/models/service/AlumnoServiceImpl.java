package com.jgr.microservicio.app.usuario.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jgr.microservicio.app.usuario.models.entity.Alumno;
import com.jgr.microservicio.app.usuario.models.repository.IAlumnoRepository;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

	@Autowired
	private IAlumnoRepository repositoryAlumno;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Alumno> findAll() {
		return repositoryAlumno.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Alumno> findById(Long id) {
		return repositoryAlumno.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		return repositoryAlumno.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repositoryAlumno.deleteById(id);
	}

}
