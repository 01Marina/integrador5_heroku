package com.estudiantes.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

//implementa Serializable para que sea un objeto que se envia atravez de a red
public class DTOEnrollmentstudentBodyInsert implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private Integer id_estudiante;
	@NotNull
	private Integer id_carrera;
	@NotNull
	private Integer fecha_ingreso;
	
	private Integer fecha_egreso;

	public DTOEnrollmentstudentBodyInsert() {
		super();
	}

	public DTOEnrollmentstudentBodyInsert(Integer id_estudiante, Integer id_carrera, Integer fecha_ingreso,
			Integer fecha_egreso) {
		super();
		this.id_estudiante = id_estudiante;
		this.id_carrera = id_carrera;
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_egreso = fecha_egreso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public Integer getId_carrera() {
		return id_carrera;
	}

	public Integer getFecha_ingreso() {
		return fecha_ingreso;
	}

	public Integer getFecha_egreso() {
		return fecha_egreso;
	}

	@Override
	public String toString() {
		return "DTOEnrollmentstudentBodyInsert [id_estudiante=" + id_estudiante + ", id_carrera=" + id_carrera
				+ ", fecha_ingreso=" + fecha_ingreso + ", fecha_egreso=" + fecha_egreso + "]";
	}
}
