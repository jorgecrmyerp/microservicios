package com.jgr.microservicio.app.cursos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgr.microservicio.app.cursos.models.entity.Curso;
import com.jgr.microservicio.app.cursos.services.ICursoService;
import com.jgr.microservicio.commons.alumnos.models.entity.Alumno;
import com.jgr.microservicio.commons.controllers.CommonController;

//IGUAL QUE USUARIOS,REVISAR COMENTARIOS

@RestController
public class CursoController extends CommonController<Curso, ICursoService> {

	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {

		// EL SERVICE VIENE DESDE COMMONCONTROLLER
		Optional<Curso> o = this.service.findById(id);

		System.out.println("put id->" + id);
		// si no lo encuentra devuelve not found

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Curso cursoDB = o.get();
		cursoDB.setNombre(curso.getNombre());// el created es un 201
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));

	}

	
		//localhost:8090/api/cursos/3/asignar-alumnos
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos,@PathVariable Long id) {
		Optional<Curso> o = this.service.findById(id);

		System.out.println("put id->" + id);
		// si no lo encuentra devuelve not found

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDB = o.get();
		//como es curso el que tiene un array de alumnos, vamos guardandolos ahi
		alumnos.forEach(a->{
			cursoDB.addAlumno(a);
			});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
		}
	
	//localhost:8090/api/cursos/1/eliminar-alumno
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno,@PathVariable Long id) {
		Optional<Curso> o = this.service.findById(id);

		System.out.println("put id->" + id);
		// si no lo encuentra devuelve not found

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDB = o.get();
		cursoDB.removeAlumno(alumno);
		
		return ResponseEntity.status(HttpStatus.OK).body(service.save(cursoDB));
		}
	
	
	//localhost:8090/api/cursos/busca-curso-alumno/1
	@GetMapping("busca-curso-alumno/{id}")
	public ResponseEntity<?> buscarCursoDeAlumnoporId(@PathVariable Long id) {
		
		Curso curso = service.findCursoByAlumnoId(id);
		
		return ResponseEntity.ok(curso);
	}

	
	
}
