package com.jgr.microservicio.commons.alumnos.models.entity;

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
//lo sacamos a un servicio externo para que el resto de servicios puedan acceder a el
//solo vamos a necesitar el jpa para las anotaciones,es un servicio de libreria,no se va a
//ejecutar como hacemos con cursos o con usuarios


@Entity
@Table(name="alumnos")
//equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor 
//@Data
//@Slf4j Creates log = org.slf4j.LoggerFactory.getLogger(LogExample.class);

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
	
	
	
	public Alumno() {
		super();
	}

	//para que guarde la fecha actual
	@PrePersist	
	public void prePersist() {
		this.createAt= new Date();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the createAt
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this==obj) {return true;}
		
		if (!(obj instanceof Alumno)){return false;}
		
		//convertimos de obj a alumno		
		Alumno a =(Alumno) obj;	
		return this.id!=null && this.id.equals(a.getId());
	}

	

	
}
