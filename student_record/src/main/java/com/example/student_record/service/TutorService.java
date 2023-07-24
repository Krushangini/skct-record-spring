package com.example.student_record.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_record.model.StudentDetails;
import com.example.student_record.model.TutorDetails;
import com.example.student_record.repo.TutorDetailsRepo;
import com.example.student_record.repo.WardsRepo;

@Service
public class TutorService {

	@Autowired
	TutorDetailsRepo tuRepo;
	
	@Autowired
	WardsRepo waRepo;
	
	public String Login(String regno,String pass) {
		TutorDetails ts = tuRepo.LoginVerify(regno, pass);
		if(ts!=null) {
			return "successful";
		}
		return "failed";
	}
	
	public String getWards(String regno) {
		List<StudentDetails> st = waRepo.getAllWards(regno);
		if(st!=null) {
			return "retrived";
		}
		return "invalid";
	}
	
}
