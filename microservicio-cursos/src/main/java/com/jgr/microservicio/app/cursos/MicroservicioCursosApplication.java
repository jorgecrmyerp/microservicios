package com.jgr.microservicio.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication

//registramos la entidad alumos que esta en commons-alumnos y a la misma entidad cursos
@EntityScan({"com.jgr.microservicio.commons.alumnos.models.entity",
			"com.jgr.microservicio.app.cursos.models.entity",
			"com.jgr.microservicio.commons.examenes.models.entity"})
public class MicroservicioCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCursosApplication.class, args);
	}

}
