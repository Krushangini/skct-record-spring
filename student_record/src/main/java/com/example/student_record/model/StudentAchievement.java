package com.example.student_record.model;

import java.sql.Blob;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studentachievement")
public class StudentAchievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sno")
	int sno;
	@Column(name="event")
	String event;
	@Column(name="prize")
	 String prize;
	@Column(name="institute")
	 String institute;
	@Column(name="heldplace")
	 String heldplace;
	@Lob
	Blob certificate; 
	@ManyToOne
	@JoinColumn(name="regno", referencedColumnName = "regno")
    StudentDetails regno;
	@Column(name="date")
	LocalDate date;
	
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getHeldplace() {
		return heldplace;
	}
	public void setHeldplace(String heldplace) {
		this.heldplace = heldplace;
	}
	public Blob getCertificate() {
		return certificate;
	}
	public void setCertificate(Blob certificate) {
		this.certificate = certificate;
	}
	public StudentDetails getRegno() {
		return regno;
	}
	public void setRegno(StudentDetails regno) {
		this.regno = regno;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
