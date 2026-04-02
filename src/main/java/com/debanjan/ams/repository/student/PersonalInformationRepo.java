package com.pabitra.ams.repository.student;


import com.pabitra.ams.entity.student.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInformationRepo extends JpaRepository<PersonalInformation, String> {
}

