package com.estudiantes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.CrossOrigin;

import com.estudiantes.dto.DTOEnrollmentstudentBodyInsert;
import com.estudiantes.services.*;
import com.estudiantes.model.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Api(tags = "EnrollmentstudentsAPI")
@RestController
@RequestMapping("/api/enrollmentstudents")
public class EnrollmentstudentController {
	
	@Autowired
    private EnrollmentstudentService enrollmentstudentService; //inyecta la dependencia
	
	@Autowired
    private StudentService studentService; //inyecta la dependencia
	
	@Autowired
    private CareerService careerService; //inyecta la dependencia
    
   
	 //2 b) matricular un estudiante en una carrera
    //@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
    @ApiOperation(value = "Crea una matrícula y la inserta en la base de datos.")
    @PostMapping("/insert")
    public ResponseEntity<Enrollmentstudent> newEnrollmentstudent(@Valid @RequestBody DTOEnrollmentstudentBodyInsert e) {
    	if(enrollmentstudentService.existEnrollmentstudent(e)) {
    		return new ResponseEntity<>(HttpStatus.CONFLICT);
    	}
    	System.out.println(e);
    	//Busco el estudiante al que apunta
    	Student student = studentService.findById(e.getId_estudiante()).get();
    	//Busco la carrera a la que apunta
    	Career career = careerService.findById(e.getId_carrera()).get();
    	//creo la matricula
    	Enrollmentstudent saveE;
    	System.out.println("IMPRIMO YO: "+e.getFecha_egreso());
    	if(e.getFecha_egreso() != null) {
    		saveE = new Enrollmentstudent(student, career, e.getFecha_ingreso(), e.getFecha_egreso());
    	}else {
    		saveE = new Enrollmentstudent(student, career, e.getFecha_ingreso());
    	}
    	System.out.println("IMPRIMO YO: "+saveE);
    	
    	Enrollmentstudent saveEe= enrollmentstudentService.save(saveE);
    	System.out.println("IMPRIMO YO 2 : "+saveEe);
    	return new ResponseEntity<>(saveEe, HttpStatus.CREATED);
    }
    /*/*Estructura de JSON para insertar una matricula
     * id autogenerado
     * {
		    "id_estudiante": 1,
		    "id_carrera": 2,
		    "fecha_ingreso": 2012,
		    "fecha_egreso": 2021
		}*/
    
    
    
   
    
    
  //Trae todas las matrticulas
    //@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
    @ApiOperation(value = "Obtiene una lista con todas las matrículas.")
    @ApiResponses(value = {
	@ApiResponse(code = 200, message = "Success|OK"),
	@ApiResponse(code = 401, message = "not authorized!"),
	@ApiResponse(code = 403, message = "forbidden!!!"),
	@ApiResponse(code = 404, message = "not found!!!"),
	})
    @GetMapping("/")
    public Iterable<Enrollmentstudent> getEnrollmentstudent() {
        return enrollmentstudentService.findAll();
    }
}
