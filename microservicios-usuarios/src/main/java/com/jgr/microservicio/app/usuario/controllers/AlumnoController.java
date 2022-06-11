package com.jgr.microservicio.app.usuario.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgr.microservicio.app.usuario.models.entity.Alumno;
import com.jgr.microservicio.app.usuario.models.service.IAlumnoService;

@RestController
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;

	// sin ruta devolvemos un generico con ok y la lista de alumnos y un 200 que es
	// ok
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(alumnoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

		Optional<Alumno> o = alumnoService.findById(id);

		// si no lo encuentra devuelve not found
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(o.get());
	}

	// sin ruta,devuelve un 201 que es que lo ha creado ok
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
		Alumno alumnoDB = alumnoService.save(alumno);

		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDB);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {

		Optional<Alumno> o = alumnoService.findById(id);
			System.out.println("put id->"+id);
		// si no lo encuentra devuelve not found
			
			
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Alumno alumnoDB = o.get();
		alumnoDB.setNombre(alumno.getNombre());
		alumnoDB.setApellido(alumno.getApellido());
		alumnoDB.setEmail(alumno.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoDB));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		Optional<Alumno> o = alumnoService.findById(id);

		// si no lo encuentra devuelve not found
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();//404
		}		
		alumnoService.deleteById(id);
		
		return ResponseEntity.noContent().build();

	}

}
