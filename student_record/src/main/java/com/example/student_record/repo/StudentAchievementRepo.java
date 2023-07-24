package com.example.student_record.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.student_record.model.StudentAchievement;

@Repository
public interface StudentAchievementRepo extends JpaRepository<StudentAchievement, Integer>{
	
	@Query("select achieve from StudentAchievement achieve where achieve.regno.regno=?1")
	List<StudentAchievement> findAllAchievementsByRegno(String regno);
	
}