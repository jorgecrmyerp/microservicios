package com.jgr.microservicio.app.examenes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgr.microservicio.app.examenes.models.entity.Examen;
import com.jgr.microservicio.app.examenes.services.IExamenService;
import com.jgr.microservicio.commons.controllers.CommonController;




@RestController
public class ExamenController extends CommonController<Examen,IExamenService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody Examen examen,@PathVariable Long id){
		return null;
		
	}

}
