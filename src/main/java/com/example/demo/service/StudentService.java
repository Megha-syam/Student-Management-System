package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long sid);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long sid);
}
