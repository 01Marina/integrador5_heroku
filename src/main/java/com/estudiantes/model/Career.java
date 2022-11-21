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

import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.validation.constraints.NotEmpty;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;

@Entity

//Aplico mapeo sobre esta entidad para poder aplicar DTO en respuestas del repository con consultas nativas sql
//para generar la case que guarda el reporte de las carreras

@NamedNativeQuery(
	    name = "Career.getCareerReport",
	    query = "SELECT c.nombre AS nombreCarrera, m.fecha_ingreso AS anio, COUNT(*) AS inscriptos, sum(CASE WHEN  m.fecha_egreso IS NULL THEN 0 ELSE 1 END) AS graduados FROM career c JOIN enrollmentstudent m ON c.id_carrera = m.id_carrera GROUP BY m.fecha_ingreso, c.nombre  ORDER BY c.nombre DESC, m.fecha_ingreso DESC",
	    resultClass = com.estudiantes.dto.DTOCareerReport.class,
	    resultSetMapping = "Mapping.getCareerReport"
	)
@SqlResultSetMapping(
    name = "Mapping.getCareerReport",
    classes = @ConstructorResult(
        targetClass = com.estudiantes.dto.DTOCareerReport.class,
        columns = {
            @ColumnResult(name = "nombreCarrera", type = String.class),
            @ColumnResult(name = "anio", type = Integer.class),
            @ColumnResult(name = "inscriptos", type = Integer.class),
            @ColumnResult(name = "graduados", type = Integer.class)
        }
    )
)

public class Career {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_carrera;
	@Column
	@NotEmpty
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "carrera", cascade=CascadeType.ALL)
	private List<Enrollmentstudent> matriculas;
	
	public Career() {
		super();
		this.matriculas = new ArrayList<>();
	}
	public Career(String nombre) {
		super();
		this.nombre = nombre;
		this.matriculas = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getId_carrera() {
		return id_carrera;
	}
	@Override
	public String toString() {
		return "Carrera [idCarrera=" + id_carrera + ", nombre=" + nombre + "]";
	}
	public List<Enrollmentstudent> getMatriculas() {
		return matriculas;
	}
	
}
