package com.pabitra.ams.repository.student;

import com.pabitra.ams.entity.student.AddressInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressInformationRepo extends JpaRepository<AddressInformation, String> {
}

