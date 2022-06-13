package com.jgr.microservicio.app.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient//declara que es un cliente
@SpringBootApplication
@EntityScan({"com.jgr.microservicio.commons.alumnos.models.entity"})//registramos la entidad alumos que esta en commons-alumos
public class MicroserviciosUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosUsuariosApplication.class, args);
	}

}
