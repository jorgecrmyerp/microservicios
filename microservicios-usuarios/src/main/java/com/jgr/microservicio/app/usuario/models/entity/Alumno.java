package com.jgr.microservicio.app.usuario.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name="alumnos")
//equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor 
@Data
//@Slf4j Creates log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
@Slf4j
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)//es un timestamp
	private Date createAt;
	
	//para que guarde la fecha actual
	@PrePersist	
	public void prePersist() {
		this.createAt= new Date();
	}
		

	
}
