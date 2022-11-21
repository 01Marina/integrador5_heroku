package com.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudiantes.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    @Query("SELECT e FROM Student e WHERE e.libreta_universitaria = :bookNumber")
	public Student getStudentByBookNumber(Integer bookNumber);
    
    @Query("SELECT s FROM Student s ORDER BY s.nombre ASC")
	public Iterable<Student> getStudentsByOrder();
    
    @Query("SELECT s FROM Student s WHERE s.genero = :gender")
	public Iterable<Student> getStudentsByGender(String gender);
    
    @Query("SELECT s FROM Student s JOIN s.matriculas m JOIN m.carrera c WHERE c.nombre = :career AND s.ciudad_de_residencia = :city ")
    public Iterable<Student> getStudentsByCareerAndCity(String career, String city);

    @Query("SELECT s FROM Student s WHERE s.dni = :dni OR s.libreta_universitaria=:libreta_universitaria")
	public Student existStudent(Integer dni, Integer libreta_universitaria);
}
