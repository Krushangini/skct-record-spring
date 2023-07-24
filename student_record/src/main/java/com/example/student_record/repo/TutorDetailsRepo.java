package com.example.student_record.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.student_record.model.TutorDetails;

@Repository
public interface TutorDetailsRepo extends JpaRepository<TutorDetails, String>{

	@Query("select s from TutorDetails s where s.regno=?1 and s.password=?2")
	TutorDetails LoginVerify(String regno,String pass);
	
}
