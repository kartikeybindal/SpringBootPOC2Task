package com.neosoft.springboot.entities;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {


	@Id
	@Column(name = "stid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stdId;
	
	@NonNull
	@Column(name="firstname")
	private String firstname;
	
	@NonNull
	@Column(name="lastname")
	private String lastname;
	
	@NonNull
	@Column(name="mobileno")
	private long mobileno;
	
	@NonNull
	@Column(name="email")
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Project> project = new HashSet<>();

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Project> getProject() {
		return project;
	}

	
	//@JoinColumn(name = "proid" , nullable = false)

	
	
	
}