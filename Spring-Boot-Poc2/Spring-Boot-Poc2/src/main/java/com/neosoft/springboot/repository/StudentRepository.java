package com.neosoft.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	 List<Student> findByProjectId(int projectId);
		
		Student findByIdAndProjectId(int id, int projectId);
	
	
}



