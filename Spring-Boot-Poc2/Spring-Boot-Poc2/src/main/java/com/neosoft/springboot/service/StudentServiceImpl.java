package com.neosoft.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.entities.Student;
import com.neosoft.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
		
	}
	
	public Optional<Student> getStudent(int id) {
		return studentRepository.findById(id);
	}
	
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
