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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="examenes")
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)//es un timestamp
	private Date createAt;
	
	//un examen n preguntas,lectura perezosa,las actualizaciones y creacion todas juntas(examen-pregunta)
	//y que borre las preguntas que queden huerfanas.Relacion bidireccional
	//el ignoreproperties es para que no se embucle ya que aqui haria el get de preguntas y en preguntas el de examen
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="examen")
	@JsonIgnoreProperties(value= {"examen"})
	private List<Pregunta> preguntas; 

	public Examen() {
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


		/**
		 * @return the preguntas
		 */
		public List<Pregunta> getPreguntas() {
			return preguntas;
		}


		/**
		 * @param preguntas the preguntas to set
		 */
		public void setPreguntas(List<Pregunta> preguntas) {
			this.preguntas = preguntas;
		}


	

}
