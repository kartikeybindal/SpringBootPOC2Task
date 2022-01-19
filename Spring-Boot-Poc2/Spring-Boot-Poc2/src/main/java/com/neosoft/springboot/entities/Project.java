package com.neosoft.springboot.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	@Id
	@Column(name = "proid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projId;
	
	@NonNull
	@Column(name="projname")
	private String projname;
	
	@NonNull
	@Column(name="duration")
	private String duration;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="project")
	private Set<Student> student = new HashSet<>();

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	
	   }