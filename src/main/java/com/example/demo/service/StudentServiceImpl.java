package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentrepository;
	
	
	@Override
	public List<Student> getAllStudents() {
		
		return studentrepository.findAll();
		
	}

	@Override
	public Student saveStudent(Student student) {
		return studentrepository.save(student);
	}

	@Override
	public Student getStudentById(Long sid) {
		
		return studentrepository.findById(sid).get();
	}

	@Override
	public Student updateStudent(Student student) {
	
		return  studentrepository.save(student);
	}

	@Override
	public void deleteStudent(Long sid) {
		
		studentrepository.deleteById(sid);
		
	}
	

}
