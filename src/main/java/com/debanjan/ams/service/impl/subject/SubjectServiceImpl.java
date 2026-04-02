package com.pabitra.ams.service.impl.subject;


import com.pabitra.ams.entity.subject.Subject;
import com.pabitra.ams.exception.ResourceNotFoundException;
import com.pabitra.ams.repository.subject.SubjectRepo;
import com.pabitra.ams.request.subject.SubjectRequest;
import com.pabitra.ams.request.subject.SubjectUpdateRequest;
import com.pabitra.ams.response.subject.SubjectResponse;
import com.pabitra.ams.service.subject.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override

    public ResponseEntity<String> addSubject(SubjectRequest subjectRequest) {

        Optional<Subject> existingSubject = subjectRepo.findByBatchAndSubCode(subjectRequest.getBatch(), subjectRequest.getSubCode());

        if (existingSubject.isPresent()) {
            // If subject exists, return a response indicating it exists
            return new ResponseEntity<>("Already Exists",HttpStatus.NOT_ACCEPTABLE);

        }
        else {
            //save subject
            Subject subject = modelMapper.map(subjectRequest, Subject.class);

            subjectRepo.save(subject);
            return new ResponseEntity<>("Succesfully updated", HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<SubjectResponse> getSubject(String batch, String id) {

        Subject subject = subjectRepo.findByBatchAndSubCode(batch,id)
                .orElseThrow( ()-> new ResourceNotFoundException("Subject", "Batch: "+batch+" Code",id));

        SubjectResponse subjectResponse =modelMapper.map(subject, SubjectResponse.class);

        return new ResponseEntity<>(subjectResponse,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> updateSubject(String batch, String id, SubjectUpdateRequest subjectRes) {
        Subject subject = subjectRepo.findByBatchAndSubCode(batch,id)
                .orElseThrow( ()-> new ResourceNotFoundException("Subject", "Batch: "+batch+" Code",id));


        subject.setSem(subjectRes.getSem());
        subject.setSubName(subjectRes.getSubName());

        subjectRepo.save(subject);

        return new ResponseEntity<>("Updated Succesfully",HttpStatus.OK);


    }

    @Override
    public ResponseEntity<String> deleteSubject(String batch,String id) {
        Subject subject = subjectRepo.findByBatchAndSubCode(batch,id)
                .orElseThrow( ()-> new ResourceNotFoundException("Subject", "Batch: "+batch+" Code",id));

        subjectRepo.delete(subject);

        return new ResponseEntity<>("Subject Deleted!!",HttpStatus.OK);
    }



    @Override
    public ResponseEntity<List<SubjectResponse>> getAllSubjectByBatchAndSem(String batch, String sem) {

        List<Subject>subjects = subjectRepo.findAllByBatchAndSem(batch, sem);

        List<SubjectResponse>subjectResponses=
                subjects.stream()
                        .map(subject -> modelMapper.map(subject,SubjectResponse.class))
                        .toList();

        return new ResponseEntity<>(subjectResponses,HttpStatus.OK);

    }

}

