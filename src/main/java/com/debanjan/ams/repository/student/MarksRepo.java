package com.pabitra.ams.repository.student;


import com.pabitra.ams.entity.student.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepo extends JpaRepository<Marks, String> {
}

