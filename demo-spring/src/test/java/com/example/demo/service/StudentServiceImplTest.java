package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

	@InjectMocks
	StudentServiceImpl studentServiceImpl;
	
	@Mock
	StudentRepo repo;
	
	@Test
	void testsaveStudent() {
		Student student = new Student();
		student.setId(1);
		when(repo.save(student)).thenReturn(student);
		Integer saveStudent = studentServiceImpl.saveStudent(student);
		assertEquals(1, saveStudent);
	}

}
