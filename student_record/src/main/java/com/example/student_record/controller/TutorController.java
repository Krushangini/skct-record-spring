package com.example.student_record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_record.service.TutorService;

@RestController
@CrossOrigin
public class TutorController {
	
	@Autowired
	TutorService tuService;

	@PostMapping("/tutor-login")
	public String Login(@RequestParam String regno,@RequestParam String pass) {
		return tuService.Login(regno, pass);
	}
	
	@GetMapping("/get-all-wards")
	public String getAllWards(@RequestParam String regno) {
		return tuService.getWards(regno);
	}
	
}
