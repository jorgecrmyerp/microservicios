package com.jgr.microservicio.app.usuario.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgr.microservicio.app.usuario.models.service.IAlumnoService;
import com.jgr.microservicio.commons.alumnos.models.entity.Alumno;
import com.jgr.microservicio.commons.controllers.CommonController;


//hereda de commoncontroller que es generico y como parametros de entrada se le pasa
//la entidad y la capa de servicio. Hereda de commoncontroller que tiene definidos
//los metodos comunes ,todos menos actualizar porque esto tiene propiedades distintas
//segun la entidad. Como parametros le pasamos la entidad,ALUMNO, y la capa de servicio, que
//es IAlumnoService, que a su vez hereda ICommonService

@RestController
public class AlumnoController extends CommonController<Alumno,IAlumnoService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {

		//EL SERVICE VIENE DESDE COMMONCONTROLLER
		Optional<Alumno> o = service.findById(id);
			System.out.println("put id->"+id);
		// si no lo encuentra devuelve not found
			
			
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Alumno alumnoDB = o.get();
		alumnoDB.setNombre(alumno.getNombre());
		alumnoDB.setApellido(alumno.getApellido());
		alumnoDB.setEmail(alumno.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDB));

	}
	
	@GetMapping("/buscar-nombre/{texto}")
	public ResponseEntity<?> buscarNombreOApellido( @PathVariable String texto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByNombreOrApellido(texto));
		
	}
	
	/*
	
	LA LISTA,ALTA Y BORRADO LA VAMOS A HACER EN LA CLASE GENERICA,YA QUE ES INDEPENDIENTE DEL OBJETO
	LA MODIFICACION NO,PORQUE CADA OBJETO TIENE PROPIEDADES UNICAS
	EL SERVICIO LO RECIBIMOS COMO PARAMETRO,PORQUE COMO HEREDA DE COMMONCONTROLLER YA LO RECIBE COMO PARAMETRO
	
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

	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		Optional<Alumno> o = alumnoService.findById(id);

		// si no lo encuentra devuelve not found
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();//404
		}		
		alumnoService.deleteById(id);
		
		return ResponseEntity.noContent().build();

	}*/

}
