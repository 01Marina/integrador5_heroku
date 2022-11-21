package com.estudiantes.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Enrollmentstudent{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_matricula;
	@Column
	private Integer fecha_ingreso;
	
	@Column (nullable = true)
	private Integer fecha_egreso;
	
	@Column (nullable = true)
	private Integer antiguedad;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinColumn(name ="id_estudiante", referencedColumnName = "id_estudiante")
	@JsonProperty(access = Access.WRITE_ONLY)//para que en la api ignore la propiedad para serilizar la cadena
	private Student estudiante;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinColumn(name="id_carrera", referencedColumnName = "id_carrera")
	@JsonProperty(access = Access.WRITE_ONLY)//para que en la api ignore la propiedad para serilizar la cadena
	private Career carrera;
	
	public Enrollmentstudent() {
		super();
	}

	public Enrollmentstudent(Student estudiante, Career carrera, Integer fechaIngreso) {
		super();
		this.carrera = carrera;
		this.fecha_ingreso = fechaIngreso;
		this.estudiante = estudiante;
		this.antiguedad = null;
	}
	
	public Enrollmentstudent(Student estudiante, Career carrera, Integer fechaIngreso, Integer fechaEgreso) {
		super();
		this.carrera = carrera;
		this.fecha_ingreso = fechaIngreso;
		this.fecha_egreso = fechaEgreso;
		this.estudiante = estudiante;
		this.antiguedad = this.calcularAntiguedad();
	}


	@Override
	public String toString() {
		return "Enrollmentstudent [id_matricula=" + id_matricula + ", fecha_ingreso=" + fecha_ingreso
				+ ", fecha_egreso=" + fecha_egreso + ", antiguedad=" + antiguedad + ", estudiante=" + estudiante
				+ ", carrera=" + carrera + "]";
	}

	public Integer getFechaIngreso() {
		return fecha_ingreso;
	}

	public void setFechaIngreso(int fechaIngreso) {
		this.fecha_ingreso = fechaIngreso;
	}

	public Student getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Student estudiante) {
		this.estudiante = estudiante;
	}

	public Career getCarrera() {
		return carrera;
	}

	public void setCarrera(Career carrera) {
		this.carrera = carrera;
	}

	public Integer getIdMatricula() {
		return id_matricula;
	}

	public Integer getFechaEgreso() {
		return fecha_egreso;
	}

	public void setFechaEgreso(Integer fechaEgreso) {
		this.fecha_egreso = fechaEgreso;
	}

	public Integer getAntiguedad() {
		if(this.fecha_egreso == null) {
			LocalDateTime fechaActual = LocalDateTime.now();
			Integer anioActual = fechaActual.getYear();
			return anioActual-fecha_ingreso;
		}
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	

	private Integer calcularAntiguedad() {
		return fecha_egreso - fecha_ingreso;
	}
	
}
