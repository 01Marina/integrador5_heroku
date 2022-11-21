package com.estudiantes.services;

import com.estudiantes.dto.DTOEnrollmentstudentBodyInsert;
import com.estudiantes.model.Enrollmentstudent;

public interface EnrollmentstudentService {
	
	public Enrollmentstudent save(Enrollmentstudent e);
	
	public Iterable<Enrollmentstudent> findAll();

	public boolean existEnrollmentstudent(DTOEnrollmentstudentBodyInsert e);
}
