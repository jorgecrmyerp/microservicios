package com.jgr.microservicio.app.cursos.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jgr.microservicio.commons.alumnos.models.entity.Alumno;

@Entity
@Table(name="cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)//es un timestamp
	private Date createAt;
	
	//un curso->muchos alumnos. No crea la relacion con curso porque
	//lo puede conseguir realizando peticiones¿?,para intentar desacoplar
	@OneToMany(fetch=FetchType.LAZY)
	private List<Alumno> alumnos;
	
	public Curso() {
		this.alumnos= new ArrayList<>();
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
	
	
	@PrePersist
	public void prePersist() {
		this.createAt= new Date();
	}

	/**
	 * @return the alumnos
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	/**
	 * @param alumnos the alumnos to set
	 */
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	
	/**
	 * @param alumno the alumno to set
	 */
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	
	/**
	 * @param alumno the alumno to remove
	 * para hacerlo bien tenemos que sobreescribir el equals en alumno,que compare por id
	 */
	public void removeAlumno(Alumno alumno) {
		this.alumnos.remove(alumno);
	}

}
