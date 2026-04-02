package com.pabitra.ams.service.subjectteacher;


import com.pabitra.ams.request.subjectteacher.SubjectTeacherRequest;
import com.pabitra.ams.request.subjectteacher.SubjectTeacherUpdateRequest;
import com.pabitra.ams.response.subjectteacher.SubjectTeacherResponse;
import org.springframework.http.ResponseEntity;

public interface SubjectTeacherService {

    ResponseEntity<String> addSubjectTeacher(SubjectTeacherRequest subjectTeacherRequest);

    ResponseEntity<SubjectTeacherResponse> getSubjectTeacher(String batch, String subjectCode, String section);

    ResponseEntity<String> updatePrimarySubjectTeacher(String batch, String subjectCode, String section
            , SubjectTeacherUpdateRequest curSubjectTeacher);

    ResponseEntity<String> deleteSubjectTeacher(String batch, String subjectCode,String section);

    ResponseEntity<String> updateSubstituteSubjectTeacher(String batch, String subjectCode,String section,
                                                          SubjectTeacherUpdateRequest curSubjectTeacher);
}

