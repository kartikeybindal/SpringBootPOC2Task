package com.neosoft.springboot.controller;

import java.util.List;
import java.util.function.Function;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.entities.Student;
import com.neosoft.springboot.exception.ResourceNotFoundException;
import com.neosoft.springboot.repository.StudentRepository;
import com.neosoft.springboot.service.StudentService;

@RestController
public class StudentController {
	
	 @Autowired
	    private StudentRepository studentRepository;
	 @Autowired
	 private StudentService studentService;

	    @GetMapping("/students")
	  
		public List<Student> getAllStudents(){
			return studentRepository.findAll();
		}
	    
  
	    @PostMapping("/students")
	    public Student createStudent(@RequestBody Student student) {
	        return studentRepository.save(student);
	    }
		
		@DeleteMapping("/students/{studentsId}")
		public void deleteStudent(@PathVariable Integer studentId) {
	     studentRepository.findById(studentId).map(student -> {
				studentRepository.delete(student);
				return student;
			}).orElseThrow(() -> new ResourceNotFoundException("Student", "Project", studentId));
		}
}