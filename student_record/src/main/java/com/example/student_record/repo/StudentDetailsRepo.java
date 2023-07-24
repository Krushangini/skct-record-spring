package com.example.student_record.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.student_record.model.StudentDetails;

@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentDetails, String>{

	@Query("select s from StudentDetails s where s.regno=?1 and s.password=?2")
	StudentDetails LoginVerify(String regno,String pass);
	
}
