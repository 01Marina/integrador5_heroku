package com.estudiantes.dto;

import java.io.Serializable;

//implementa Serializable para que sea un objeto que se envia atravez de a red
public class DTOCareerReport implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreCarrera;
	private Integer anio;
	private Integer inscriptos;
	private Integer inscriptos_graduado;
	
	public DTOCareerReport() {
		super();
	}

	public DTOCareerReport(String nombreCarrera, Integer anio) {
		super();
		this.nombreCarrera = nombreCarrera;
		this.anio = anio;
		this.inscriptos = 0;
		this.inscriptos_graduado = 0;
	}

	public DTOCareerReport(String nombreCarrera, Integer anio, Integer inscriptos, Integer graduados) {
		super();
		this.nombreCarrera = nombreCarrera;
		this.anio = anio;
		this.inscriptos = inscriptos;
		this.inscriptos_graduado = graduados;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(Integer inscriptos) {
		this.inscriptos = inscriptos;
	}

	public Integer getInscriptos_graduado() {
		return inscriptos_graduado;
	}

	public void setInscriptos_graduado(Integer inscriptos_graduado) {
		this.inscriptos_graduado = inscriptos_graduado;
	}

	@Override
	public String toString() {
		return "DTOCareerReport [nombreCarrera=" + nombreCarrera + ", anio=" + anio + ", inscriptos=" + inscriptos
				+ ", graduados=" + inscriptos_graduado + "]";
	}
}
