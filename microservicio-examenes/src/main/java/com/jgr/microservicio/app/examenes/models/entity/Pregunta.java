package com.jgr.microservicio.app.examenes.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="preguntas")
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String texto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="examen_id") //esta clase es la dueña de la relacion por el joincolumn
	@JsonIgnoreProperties(value= {"preguntas"})//para que no se embucle buscando propiedades ,ver examen
	private Examen examen;

	public Pregunta() {
		super();
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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the examen
	 */
	public Examen getExamen() {
		return examen;
	}

	/**
	 * @param examen the examen to set
	 */
	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	

}
