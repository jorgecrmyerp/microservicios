package com.jgr.microservicio.app.cursos.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgr.microservicio.app.cursos.models.entity.Curso;
import com.jgr.microservicio.app.cursos.services.ICursoService;

import com.jgr.microservicio.commons.controllers.CommonController;

@RestController
public class CursoController extends CommonController<Curso,ICursoService>{
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {

		
		//EL SERVICE VIENE DESDE COMMONCONTROLLER
		Optional<Curso> o = this.service.findById(id); 

			System.out.println("put id->"+id);
		// si no lo encuentra devuelve not found
			
			
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Curso cursoDB = o.get();
		cursoDB.setNombre(curso.getNombre());//el created es un 201
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));

	}
	
	

}
