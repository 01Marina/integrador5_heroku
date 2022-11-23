package com.estudiantes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.CrossOrigin;

import com.estudiantes.dto.DTOCareerReport;
import com.estudiantes.services.CareerService;
import com.estudiantes.model.Career;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "CareersAPI")
@RestController
@RequestMapping("/api/careers")
public class CareerController {
	
	@Autowired
    private CareerService careerService; //inyecta la dependencia
	//@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
	@ApiOperation(value = "Crea una carrera y la inserta en la base de dadtos.")
	@PostMapping("/insert")
	public ResponseEntity<Career> newStudent2(@Valid @RequestBody Career c) {
       if(careerService.existStudent(c)) {
    	   return new ResponseEntity<>(HttpStatus.CONFLICT);
       }
       return new ResponseEntity<>(careerService.save(c), HttpStatus.CREATED);
    }
	
	 /*/*Estructura de JSON para insertar una carrera
     * id autogenerado
     * {
		    "nombre": "historia"
	    }
     * */
	
    
    
    
  //Trae todas las carreras
    //@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
    @ApiOperation(value = "Obtiene la lista de todas las carreras.")
    @ApiResponses(value = {
	@ApiResponse(code = 200, message = "Success|OK"),
	@ApiResponse(code = 401, message = "not authorized!"),
	@ApiResponse(code = 403, message = "forbidden!!!"),
	@ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/")
    public Iterable<Career> getCareers() {
        return careerService.findAll();
    }
    
    //2 f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    //@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
    @ApiOperation(value = "Obtiene las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.")
    @GetMapping("/orderbysubscribers")
    public Iterable<Career> getCarrerasOrdenCantAlumnos(){
    	return careerService.getCarrerasOrdenCantAlumnos();
    }
    
    //2 h) generar un reporte de las carreras, que para cada carrera incluya información de los
//    		inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
//    		presentar los años de manera cronológica.
    
    //para su realización agregó en la case Career el mapeo a otro clase de esta misma
    //y se agregó query sql nativo que consume este mapeo
    // ver lines 23 a 43 de la clase Career.
    //@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
    @ApiOperation(value = "Genera un reporte de las carreras, incluye información de los inscriptos y egresados por año, ordenadas afabéticamente y presenta los años cronologicamente.")
    @GetMapping("/report")
    public Iterable<DTOCareerReport> getCareerReport(){
    	return careerService.getCareerReport();
    }
}
