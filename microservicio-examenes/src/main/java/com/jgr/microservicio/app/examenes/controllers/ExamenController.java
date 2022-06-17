package com.jgr.microservicio.app.examenes.controllers;

import java.util.Optional;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgr.microservicio.app.examenes.services.IExamenService;
import com.jgr.microservicio.commons.controllers.CommonController;
import com.jgr.microservicio.commons.examenes.models.entity.Examen;

@EnableEurekaClient
@RestController
public class ExamenController extends CommonController<Examen, IExamenService> {

	
	//localhost:8090/api/examenes/1
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarExamen(@RequestBody Examen examen, @PathVariable Long id) {

		// el acceso al servicio lo obtenemos de commoncontroller,definido como
		// protected
		Optional<Examen> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Examen examenDB = o.get();
		examenDB.setNombre(examen.getNombre());

		/*
		 * GUARDAMOS EN UNA LISTA LAS QUE HAN ELIMINADO Y LUEGO LAS BORRAMOS
		 * List<Pregunta> eliminar = new ArrayList<>();
		 * 
		 * 
		 * examenDB.getPreguntas().forEach(preg->{
		 * if(!examen.getPreguntas().contains(preg)) {eliminar.add(preg);} });
		 * 
		 * //recorremos las preguntas del examen y las borramos
		 * //eliminar.forEach(preg->{examenDB.removePregunta(preg);}); //otra manera de
		 * hacerlo eliminar.forEach(examenDB::removePregunta);
		 */

		// OTRA MANERA DE HACERLO
		examenDB.getPreguntas()// obtengo las preguntas
				.stream()// lo convierto en un stream para usar prog. funcional
				.filter(preg -> !examen.getPreguntas().contains(preg))// filtro las preguntas que no estan en el examen
				.forEach(examenDB::removePregunta);// y las borro

		// añadimos las que nos entran,las que sean iguales las dejara y las nuevas las
		// insertara
		examenDB.setPreguntas(examen.getPreguntas());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDB));

	}

	
	
	//localhost:8090/api/examenes/filtrar/examen
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombre(term));
	}
}
