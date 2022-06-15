package com.jgr.microservicio.app.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;


//indica que es el servidor EUREKA
@EnableEurekaServer
@SpringBootApplication
public class MicroserviciosEurekaApplication {
	
    
	public static void main(String[] args) {
		
		
		
		//String portValue = env.getProperty("server.port");
		
		SpringApplication.run(MicroserviciosEurekaApplication.class, args);
	}

}
