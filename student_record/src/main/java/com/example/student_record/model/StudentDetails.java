package com.example.student_record.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studentdetails")
public class StudentDetails {

	
	@Id
	@Column(name="regno")
	String regno; 
	@Column(name="email")
	String email; 
	@Column(name="name")
	String name; 
	@Column(name="dept")
	String dept; 
	@Column(name="year")
	String year;
	@Column(name="password")
	String password;
	@OneToOne(mappedBy = "regno",cascade = CascadeType.ALL)
	Wards tutor;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Wards getTutor() {
		return tutor;
	}
	public void setTutor(Wards tutor) {
		this.tutor = tutor;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	} 
	
	
}
