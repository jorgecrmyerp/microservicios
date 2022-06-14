package com.jgr.microservicio.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jgr.microservicio.commons.services.ICommonService;


/*
 * CAPA DE SERVICIO Y CONTROLADOR GENERICO REST
 * 
 * 
 * */

//ESTE MICROSERVICIOS NO HAY QUE LEVANTARLO,ES INVOCADO DESDE EL QUE LO USA,COMO PUEDE SER USUARIOS.
//SE QUITA DEL POM EL SPRING-BOOT-MAVEN-PLUGIN


//le entra una entidad E y un servicio S, este ultimo hereda de ICommonService,que como es generico tambien recibe una
//entidad como parametro de entrada.
//como parametros le va a entrar una entidad E,un servicio S que hereda de CommonService
//que a su vez tiene el tipo generico E.
public class CommonController<E,S extends ICommonService<E>> {

	
	//IMPORTANTE QUE SEA PROTECTED,NO PRIVATE PARA QUE PODAMOS USARLO EN LOS QUE HEREDAN ESTA CLASE GENERICA
	
	@Autowired
	protected S service;

	// sin ruta devolvemos un generico con ok y la lista de alumnos y un 200 que es
	// ok
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

		Optional<E> o = service.findById(id);

		// si no lo encuentra devuelve not found
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(o.get());
	}

	// sin ruta,devuelve un 201 que es que lo ha creado ok
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity) {
		E entityDB = service.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);

	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		Optional<E> o = service.findById(id);

		// si no lo encuentra devuelve not found
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();//404
		}		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();

	}

}
