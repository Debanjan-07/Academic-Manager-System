package com.pabitra.ams.repository.student;


import com.pabitra.ams.entity.student.SemesterMarks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterMarksRepo extends JpaRepository<SemesterMarks, String> {
}

