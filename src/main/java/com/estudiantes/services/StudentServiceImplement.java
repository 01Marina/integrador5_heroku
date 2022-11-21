package com.estudiantes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudiantes.model.Student;
import com.estudiantes.repository.StudentRepository;

@Service
public class StudentServiceImplement implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;//inyecta la dependencia
	
	@Override
	@Transactional //modificaciones
	public Student save(Student s) {
		return studentRepository.save(s);
	}

	@Override
	@Transactional (readOnly = true) //solo lectura
	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentByBookNumber(Integer bookNumber) {
		return studentRepository.getStudentByBookNumber(bookNumber);
	}

	@Override
	//@Transactional (readOnly = true) solo lectura
	public Iterable<Student> getStudentsByOrder() {
		return studentRepository.getStudentsByOrder();
	}

	@Override
	public Iterable<Student> getStudentsByGender(String gender) {
		return studentRepository.getStudentsByGender(gender);
	}

	@Override
	public Iterable<Student> getStudentsByCareerAndCity(String career, String city) {
		return studentRepository.getStudentsByCareerAndCity(career, city);
	}

	@Override
	public Optional<Student> findById(Integer id_estudiante) {
		return studentRepository.findById(id_estudiante);
	}

	@Override
	public boolean existStudent(Student s) {
		Student exist = studentRepository.existStudent(s.getDni(), s.getLibreta_universitaria());
		if(exist != null){
			return true;
		}
		return false;
	}


}
