package com.example.student_record.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.student_record.model.StudentAchievement;
import com.example.student_record.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService stuService;
	
	@PostMapping("/save-ach")
	public void save(@RequestParam("file") MultipartFile file) {
//			try {
//			byte[] certificateData = file.getBytes();
//			Blob certificateBlob = new javax.sql.rowset.serial.SerialBlob(certificateData);
//			achievementDto.setCertificate(certificateBlob);
//			stuService.postAchievement(achievementDto);
//			return "Achievement saved successfully.";
//			} 
//			catch (IOException | SQLException e) {
//			e.printStackTrace();
//			return "Failed to save achievement.";
//			}
	}
	
	@GetMapping("/all-achieve")
	public List<StudentAchievement> getAllAchieve(@RequestParam String regno) {
		return stuService.getAllAchieve(regno);
	}
	
	@PostMapping("/student-login")
	public String Login(@RequestParam String regno,@RequestParam String pass) {
		return stuService.Login(regno, pass);
	}	
	
}