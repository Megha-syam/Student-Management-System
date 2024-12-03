package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}

	@GetMapping("/")
	public String listStudents(Model model) {
		model.addAttribute("students", studentservice.getAllStudents());
		return "students";			
	}
	
	@GetMapping("/newstudent")
	public String createStudentForm(Model model) {
		
		Student student=new Student();
		
		model.addAttribute("student", student);
		return "createStudent";
	}

	@PostMapping("/")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{sid}")
	public String editStudent(@PathVariable Long sid ,Model model) {
		model.addAttribute("student", studentservice.getStudentById(sid));
		return "editStudent";
	}
	
	@PostMapping("/{sid}")
	public String updateStudent(@PathVariable Long sid,@ModelAttribute("student") Student student, Model model) {
		
		Student updstd=studentservice.getStudentById(sid);
		updstd.setSid(sid);
		updstd.setSfname(student.getSfname());
		updstd.setSlname(student.getSlname());
		updstd.setSemail(student.getSemail());
		
		studentservice.updateStudent(updstd);
		return "redirect:/";
	}
	
	@GetMapping("/{sid}")
	public String DeleteStudent(@PathVariable Long sid) {
		
		 studentservice.deleteStudent(sid);
		 return "redirect:/";
		
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		return "signup";
	}
}
