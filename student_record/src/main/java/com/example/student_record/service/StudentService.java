package com.example.student_record.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.student_record.model.StudentAchievement;
import com.example.student_record.model.StudentDetails;
import com.example.student_record.repo.StudentAchievementRepo;
import com.example.student_record.repo.StudentDetailsRepo;
import com.example.student_record.repo.WardsRepo;

@Service
public class StudentService {

	@Autowired
	WardsRepo wardRepo;
	
	@Autowired
	StudentAchievementRepo stAchRepo;
	
	@Autowired
	StudentDetailsRepo stuDeRepo;
	
	@Autowired
	private JavaMailSender emailSender;
	
	public String postAchievement(StudentAchievement ach) {
		
		stAchRepo.save(ach);
		StudentDetails st= ach.getRegno();
		st=stuDeRepo.findById(st.getRegno()).get();
		String wardEmail = wardRepo.getStudentEmail(st.getRegno());
		String tutorEmail = wardRepo.getTutorEmail(st.getRegno());
	    String subject = "New Achievement Uploaded by "+st.getRegno();
	    String body = "Dear Tutor,\n\nA new achievement has been uploaded by " + st.getRegno() +
	                  ". Please login to the website and add your remarks.\n\nThank you.";
	    String body1="Dear "+st.getName()+"\n\nYour Achievement has been added successfully and send to you respective tutor";
	    sendEmail(wardEmail,tutorEmail, subject, body,body1);
		return "passed";
	}
	
	  private void sendEmail(String from,String to, String subject, String body,String body1) {
		    SimpleMailMessage message = new SimpleMailMessage();
		    message.setFrom(from);
		    message.setTo(to);
		    message.setSubject(subject);
		    message.setText(body);
		    emailSender.send(message);
		    message.setTo(from);
		    message.setSubject("new achievement Added Successfully");
		    message.setText(body1);
		    emailSender.send(message);
		  }
	  
	  public List<StudentAchievement> getAllAchieve(String regno) {
		  return stAchRepo.findAllAchievementsByRegno(regno);
	  }
	  
	  public String Login(String regno,String pass) {
			StudentDetails ts = stuDeRepo.LoginVerify(regno, pass);
			if(ts!=null) {
				return "successful";
			}
			return "failed";
		}
}
