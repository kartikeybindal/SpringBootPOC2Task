package com.neosoft.springboot.service;

import java.util.List;
import java.util.Optional;

import com.neosoft.springboot.entities.Student;


public interface StudentService {
   
	public Student addUser(Student student);
	
	public List<Student> getAllStudents();
	
	public Optional<Student> getStudentById(int stdId);
	
	public void deleteStudentById(int stdId);

}
