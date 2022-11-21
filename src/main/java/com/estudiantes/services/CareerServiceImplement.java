package com.estudiantes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudiantes.dto.DTOCareerReport;
import com.estudiantes.model.Career;
import com.estudiantes.repository.CareerRepository;

@Service
public class CareerServiceImplement implements CareerService{
	
	@Autowired
	private CareerRepository careerRepository;//inyecta la dependencia

	@Override
	public Career save(Career c) {
		return careerRepository.save(c);
	}

	@Override
	public Iterable<Career> findAll() {
		return careerRepository.findAll();
	}

	@Override
	public Optional<Career> findById(Integer id) {
		return careerRepository.findById(id);
	}

	@Override
	public Iterable<Career> getCarrerasOrdenCantAlumnos() {
		return careerRepository.getCarrerasOrdenCantAlumnos();
	}

	@Override
	public Iterable<DTOCareerReport> getCareerReport() {
		return careerRepository.getCareerReport();
	}

	@Override
	public boolean existStudent(Career c) {
		Career exist = careerRepository.existCareer(c.getNombre());
		if(exist != null) {
			return true;
		}
		return false;
	}

}
