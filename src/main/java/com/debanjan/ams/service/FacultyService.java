package com.pabitra.ams.service;

import com.pabitra.ams.entity.Faculty;
import com.pabitra.ams.response.FacultyResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface FacultyService {

    ResponseEntity<String> updateFaculty(FacultyResponse facultyResponse, String id);

    ResponseEntity<String> deleteFaculty(String id);
    ResponseEntity<String> addFaculty(Faculty faculty);

    ResponseEntity<FacultyResponse> getFaculty(String  id);

    ResponseEntity<List<FacultyResponse>> getAllFaculty();
}

