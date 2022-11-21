package com.estudiantes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_estudiante;
	
	@Column //(nullable=false)
	@NotEmpty
	private String nombre;
	
	@Column(name="anios")
	@NotNull
	private Integer edad;
	
	@Column
	private String genero;
	
	@Column
	@NotNull
	private Integer dni;
	
	@Column
	private String ciudad_de_residencia;
	
	@Column
	@NotNull
	private Integer libreta_universitaria;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "estudiante")
	private List<Enrollmentstudent> matriculas;
	
	public Student() {
		super();
		this.matriculas = new ArrayList<Enrollmentstudent>();
	}

	public Student(String nombre, Integer edad, String genero, Integer dni, String ciudadDeResidencia,
			Integer libretaUniversitaria) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.ciudad_de_residencia = ciudadDeResidencia;
		this.libreta_universitaria = libretaUniversitaria;
		this.matriculas = new ArrayList<Enrollmentstudent>();
	}

	public void addMatricula(Enrollmentstudent m) {
		this.matriculas.add(m);
	}

	@Override
	public String toString() {
		return "Estudiante [idEstuduante=" + id_estudiante + ", nombre=" + nombre + ", edad=" + edad + ", genero="
				+ genero + ", dni=" + dni + ", ciudadDeResidencia=" + ciudad_de_residencia + ", libretaUniversitaria="
				+ libreta_universitaria +"]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getCiudad_de_residencia() {
		return ciudad_de_residencia;
	}

	public void setCiudad_de_residencia(String ciudad_de_residencia) {
		this.ciudad_de_residencia = ciudad_de_residencia;
	}

	public Integer getLibreta_universitaria() {
		return libreta_universitaria;
	}

	public void setLibreta_universitaria(Integer libreta_universitaria) {
		this.libreta_universitaria = libreta_universitaria;
	}

	public List<Enrollmentstudent> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Enrollmentstudent> matriculas) {
		this.matriculas = matriculas;
	}

	public Integer getId_estudiante() {
		return id_estudiante;
	}
	
	
}