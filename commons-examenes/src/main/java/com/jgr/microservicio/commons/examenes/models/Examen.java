package com.jgr.microservicio.commons.examenes.models;

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
@Table(name = "examenes")
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP) // es un timestamp
	private Date createAt;

	// un examen n preguntas,lectura perezosa,las actualizaciones y creacion todas
	// juntas(examen-pregunta)
	// y que borre las preguntas que queden huerfanas.Relacion bidireccional
	// el ignoreproperties es para que no se embucle ya que aqui haria el get de
	// preguntas y en preguntas el de examen
	// el allowsetters es para que oculte la relacion,pero si permita la relacion
	// inversa
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "examen")
	@JsonIgnoreProperties(value = { "examen" }, allowSetters = true)
	private List<Pregunta> preguntas;

	public Examen() {

		this.preguntas = new ArrayList<>();
	}

	// para que guarde la fecha actual
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
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
		// reiniciamos preguntas
		this.preguntas.clear();
		// agregamos examen a cada pregunta
		// preguntas.forEach(p->{this.addPregunta(p);});
		// tb lo podemos poner asi
		preguntas.forEach(this::addPregunta);
	}

	public void addPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
		pregunta.setExamen(this); // relacionamos la pregunta con este examen para que no quede huerfano
	}

	public void removePregunta(Pregunta pregunta) {
		this.preguntas.remove(pregunta);
		pregunta.setExamen(null); // damos de baja la relacion,el orphan removal lo borraria
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Examen))
			return false;

		Examen other = (Examen) obj;
		return this.id != null && this.id.equals(other.getId());
	}

}
