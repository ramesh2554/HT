package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Student;


public interface StudentService {

	Integer saveStudent(Student student);
	List<Student> getAllStudents();
	Optional<Student> getStudentInfoById(Integer id);
	
	public void deleteStudent(Integer id);
	
	List<Student> getStudentFirstName(String firstname);
	
}
