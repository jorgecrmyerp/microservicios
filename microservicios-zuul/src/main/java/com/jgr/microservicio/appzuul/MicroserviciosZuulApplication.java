package com.jgr.microservicio.appzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
 * Zuul es una librería generada por Netflix para tener un solo punto de acceso (gateway)
 *  a todo los componentes que hacen parte de nuestro sistema. Por medio de este podemos 
 *  gestionar el acceso a diferentes microservicios en vez de que cada uno tenga un punto
 *   de acceso único.

Zuul proporciona un completo control del punto de acceso para poder gestionar de una 
manera dinámica el enrutamiento y filtrado de las peticiones que se hacen a través de 
la misma.
 * 
 * */

@EnableZuulProxy //activa el proxy zuul
@EnableEurekaClient // que es un cliente de eureka
@SpringBootApplication
public class MicroserviciosZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosZuulApplication.class, args);
	}

}
