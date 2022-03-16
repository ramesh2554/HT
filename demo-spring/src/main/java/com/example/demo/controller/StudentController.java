package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("allStudents")
	public List<Student> getAllStudents() {

		return service.getAllStudents();
	}

	@PostMapping("add")
	public Integer addStudent(@RequestBody Student student) {

		Integer id = service.saveStudent(student);
		System.out.println(id);
		return id;
	}

	@GetMapping("allStudents/{id}")
	public Optional<Student> getStudentInfoById(@PathVariable Integer id) {
			Optional<Student> studentInfoById = service.getStudentInfoById(id);
			
			return studentInfoById;
	}
	@GetMapping("allStudents/name/{firstname}")
	public List<Student> getStudentFirstName(@PathVariable String firstname){
		
		return service.getStudentFirstName(firstname);
	}
	
	@DeleteMapping("allStudents/{id}")
	public ResponseEntity<Student> deleteOrder(@PathVariable Integer id) {
		
		ResponseEntity<Student> responseEntity = new ResponseEntity<Student>(HttpStatus.OK);
		try {
			System.out.println(id);
			service.deleteStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
