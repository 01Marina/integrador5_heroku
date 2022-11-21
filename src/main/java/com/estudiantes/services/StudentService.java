package com.estudiantes.services;

import java.util.Optional;

import javax.validation.Valid;

import com.estudiantes.model.Student;

public interface StudentService {
	
	Student save(Student s);
	
	Iterable<Student> findAll();

	Student getStudentByBookNumber(Integer bookNumber);

	Iterable<Student> getStudentsByOrder();

	Iterable<Student> getStudentsByGender(String gender);

	Iterable<Student> getStudentsByCareerAndCity(String career, String city);

	Optional<Student> findById(Integer id_estudiante);

	boolean existStudent(@Valid Student s);

}
