package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentRepo studentrepo ;

	public Integer saveStudent(Student student) {
		Student saveStudentInfo = studentrepo.save(student);
		return saveStudentInfo.getId();
	}

	public List<Student> getAllStudents() {
		return studentrepo.findAll();
	}
	
	public Optional<Student> getStudentInfoById(Integer id) {
		
		return studentrepo.findById(id);
	}
	
	public void deleteStudent(Integer id) {
		
		studentrepo.deleteById(id);
	}
	
	public List<Student> getStudentFirstName(String first_name){
		return studentrepo.findByFirstname(first_name);
	}
}
