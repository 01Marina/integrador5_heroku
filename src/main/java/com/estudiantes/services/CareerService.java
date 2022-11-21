package com.estudiantes.services;

import java.util.Optional;

import com.estudiantes.dto.DTOCareerReport;
import com.estudiantes.model.Career;

public interface CareerService {
	
	Career save(Career c);
	
	Iterable<Career> findAll();

	Optional<Career> findById(Integer id);

	Iterable<Career> getCarrerasOrdenCantAlumnos();

	Iterable<DTOCareerReport> getCareerReport();

	boolean existStudent(Career c);

}
