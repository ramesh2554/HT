package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

	@InjectMocks
	StudentController studentController ; //dependent
	
	@Mock
	StudentService service;  //dependency
	
	@Test
	void testaddStudent() {
		Student student = new Student();
		student.setId(1);
		when(service.saveStudent(student)).thenReturn(1);
		int id = studentController.addStudent(student);
		assertEquals(1, id);
	}
	
	@Test
	void getStudentInfoById() {
		Student student = new Student();
		student.setId(1);
		Optional<Student> studentInfoById = service.getStudentInfoById(student.getId());
		when(service.getStudentInfoById(student.getId())).thenReturn(studentInfoById);
		Optional<Student> studentInfoById2 = studentController.getStudentInfoById(student.getId());
		assertEquals(studentInfoById, studentInfoById2);
	}
}
