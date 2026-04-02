package com.pabitra.ams.repository.student;

import com.pabitra.ams.entity.student.CurrentContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentContactRepo extends JpaRepository<CurrentContact, String> {

}

