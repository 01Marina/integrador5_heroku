package com.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudiantes.dto.DTOCareerReport;
import com.estudiantes.model.Career;
@Repository
public interface CareerRepository extends JpaRepository<Career, Integer>{
//	c.nombre, m.fecha_ingreso, COUNT(*), COUNT(m.fecha_egreso IS NOT NULL)  FROM career c JOIN enrollmentstudent m ON c.id_carrera = m.id_carrera GROUP BY m.fecha_ingreso, c.nombre  ORDER BY c.nombre DESC, m.fecha_ingreso DESC

	@Query("SELECT c FROM Career c JOIN c.matriculas GROUP BY c.id_carrera ORDER BY count(c.id_carrera) DESC")
	public Iterable<Career> getCarrerasOrdenCantAlumnos();
	
	// La siguiente query comentada rompe en el count() y el sum()
//	@Query("SELECT new com.estudiantes.dto.DTOCareerReport(c.nombre, m.fecha_ingreso, COUN(c), sum(CASE WHEN  m.fecha_egreso IS NULL THEN 0 ELSE 1 END)) FROM Career c JOIN c.matriculas m GROUP BY m.fecha_ingreso, c.nombre  ORDER BY c.nombre DESC, m.fecha_ingreso DESC")
	
	@Query(name = "Career.getCareerReport", nativeQuery = true)
	public Iterable<DTOCareerReport> getCareerReport();
	
	@Query("SELECT c FROM Career c WHERE c.nombre=:nombre")
	public Career existCareer(String nombre);
}
