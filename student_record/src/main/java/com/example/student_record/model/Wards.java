package com.example.student_record.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="wards")
public class Wards {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sno;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tregno")
	TutorDetails tregno;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="regno")
	StudentDetails regno;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public TutorDetails getTregno() {
		return tregno;
	}
	public void setTregno(TutorDetails tregno) {
		this.tregno = tregno;
	}
	public StudentDetails getRegno() {
		return regno;
	}
	public void setRegno(StudentDetails regno) {
		this.regno = regno;
	}
	
	
}
