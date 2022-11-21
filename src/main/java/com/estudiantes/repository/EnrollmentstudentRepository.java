package com.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudiantes.model.Enrollmentstudent;
@Repository
public interface EnrollmentstudentRepository extends JpaRepository<Enrollmentstudent, Integer>{
	@Query("SELECT e FROM Enrollmentstudent e WHERE e.estudiante.id_estudiante=:id_estudiante AND e.carrera.id_carrera=:id_carrera AND e.fecha_ingreso=:fecha_ingreso")
	Enrollmentstudent existEnrollmentstudent(Integer id_estudiante, Integer id_carrera, Integer fecha_ingreso);

}
