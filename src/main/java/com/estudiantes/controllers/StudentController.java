package com.estudiantes.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estudiantes.model.Student;
import com.estudiantes.services.StudentService;

@Api(tags = "StudentsAPI")
@RestController
@RequestMapping("/api/students")
public class StudentController {
	 @Autowired
	    private StudentService studentService; //inyecta la dependencia
	    
	    //2a
	    //crea un nuevo estudiante
	    //@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
	    @ApiOperation(value = "Crea un nuevo estudiante y lo inserta en la base de datos.")
	    @PostMapping("/insert")
	    public ResponseEntity<Student> newStudent2(@Valid @RequestBody Student s) {
	       if(studentService.existStudent(s)) {
	    	   return new ResponseEntity<>(HttpStatus.CONFLICT);
	       }
	       return new ResponseEntity<>(studentService.save(s), HttpStatus.CREATED);
	    }
	    
	    /*Estructura de JSON para insertar un estudiante
	     * id autogenerado
	     * 
	     * {
		     	"nombre": "Juan",
		        "edad": 34,
		        "genero": "m",
		        "dni": 3454543,
		        "ciudad_de_residencia": "Balcarce",
		        "libreta_universitaria": 76564,
		        "matriculas": []
	        }
	     * */
	    
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	        
	 //Trae todos los estudiantes
	    @ApiOperation(value = "Obtiene la lista de todos los estudiantes.")
	    //@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
	    @GetMapping("")
	    public Iterable<Student> getStudents() {
	        return studentService.findAll();
	    }    
	//2c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
	    //TESTEADO EN POSTMAN
	//@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")  
	@ApiOperation(value = "Obtiene todos los estudiantes, ordenados alfabéticamente por nombre.")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/sortedbyname")
	    public Iterable<Student> getStudentsByOrder() {
	    	return studentService.getStudentsByOrder();
	    }
	    
	    //2d) recuperar un estudiante, en base a su número de libreta universitaria.
	    //TESTEADO EN POSTMAN
	//@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
	@ApiOperation(value = "Obtiene un estudiante en base a un número de libreta universitaria.")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/bookNumber/{bookNumber}")
	    public Student getStudentByBookNumber(@PathVariable Integer bookNumber) {
	    	return studentService.getStudentByBookNumber(bookNumber);
	    }
	  
	    //2e) recuperar todos los estudiantes, en base a su género.
	    //TESTEADO EN POSTMAN
	//@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
	@ApiOperation(value = "Obtiene una lista de estudiantes que sean del genero especificado, f(femenino), m(masculino).")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/gender/{gender}")
	    public Iterable<Student> getStudentsByGender(@PathVariable String gender) {
	    	return studentService.getStudentsByGender(gender);
	    }
	    

	    //2g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
	    //NO ESTÁ TESTEADA
	//@CrossOrigin(origins= "https://integrdor5frontend.herokuapp.com")
	@ApiOperation(value = "Obtiene una lista de estudiantes inscriptos en una carrera dada y que sean de una localodad dada.")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/{career}/{city}")
	    public Iterable<Student> getStudentsByCareerAndCity(@PathVariable String career, @PathVariable String city) {
	    	return studentService.getStudentsByCareerAndCity(career, city);
	    }
}
