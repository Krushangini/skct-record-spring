package com.example.student_record.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.student_record.model.StudentDetails;
import com.example.student_record.model.Wards;

@Repository
public interface WardsRepo extends JpaRepository<Wards, Integer>{

	@Query("select wa.tregno.email from Wards wa join wa.tregno tu join wa.regno st where st.regno = ?1")
    String getTutorEmail(String regno);

    @Query("select wa.regno.email from Wards wa join wa.tregno tu join wa.regno st where st.regno = ?1")
    String getStudentEmail(String regno);
    
    @Query("select wa.regno from Wards wa where wa.tregno.regno=?1 group by wa.tregno.regno")
    List<StudentDetails> getAllWards(String regno);
}
