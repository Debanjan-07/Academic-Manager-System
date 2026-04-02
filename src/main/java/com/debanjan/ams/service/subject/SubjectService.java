package com.pabitra.ams.service.subject;


import com.pabitra.ams.request.subject.SubjectRequest;
import com.pabitra.ams.request.subject.SubjectUpdateRequest;
import com.pabitra.ams.response.subject.SubjectResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectService {


    ResponseEntity<String> addSubject(SubjectRequest subjectRequest);
    ResponseEntity<SubjectResponse> getSubject(String batch, String id);
    ResponseEntity<String> updateSubject(String batch,String id, SubjectUpdateRequest subjectRes);
    ResponseEntity<String> deleteSubject(String batch,String id);
    ResponseEntity<List<SubjectResponse>> getAllSubjectByBatchAndSem(String batch, String sem);

}

