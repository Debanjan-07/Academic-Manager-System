package com.pabitra.ams.service.impl.subjectteacher;


import com.pabitra.ams.entity.subjectteacher.SubjectTeacher;
import com.pabitra.ams.exception.ResourceNotFoundException;
import com.pabitra.ams.repository.subjectteacher.SubjectTeacherRepo;
import com.pabitra.ams.request.subjectteacher.SubjectTeacherRequest;
import com.pabitra.ams.request.subjectteacher.SubjectTeacherUpdateRequest;
import com.pabitra.ams.response.subjectteacher.SubjectTeacherResponse;
import com.pabitra.ams.service.subjectteacher.SubjectTeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubjectTeacherServiceImpl implements SubjectTeacherService {
    @Autowired
    SubjectTeacherRepo subjectTeacherRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> addSubjectTeacher(SubjectTeacherRequest subjectTeacherRequest) {

        SubjectTeacher subjectTeacher=modelMapper.map(subjectTeacherRequest,SubjectTeacher.class);

        subjectTeacherRepo.save(subjectTeacher);

        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SubjectTeacherResponse> getSubjectTeacher(String batch, String subjectCode, String section) {

        SubjectTeacher subjectTeacher = subjectTeacherRepo
                .findByBatchAndSubCodeAndSection(batch,subjectCode,section)
                .orElseThrow( ()-> new ResourceNotFoundException("SubjectTeacher", "Batch: "+batch+" Section:"+section+ " Code",subjectCode));


        SubjectTeacherResponse subjectTeacherResponse=modelMapper.map(subjectTeacher,
                SubjectTeacherResponse.class);

        return new ResponseEntity<>(subjectTeacherResponse,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> updatePrimarySubjectTeacher(String batch, String subjectCode, String section
            , SubjectTeacherUpdateRequest curSubjectTeacher) {

        SubjectTeacher subjectTeacher = subjectTeacherRepo
                .findByBatchAndSubCodeAndSection(batch,subjectCode,section)
                .orElseThrow( ()-> new ResourceNotFoundException("SubjectTeacher", "Batch: "+batch+" Section:"+section+ " Code",subjectCode));

        subjectTeacher.setPrimaryTeacherId(curSubjectTeacher.getPrimaryTeacherId());

        subjectTeacherRepo.save(subjectTeacher);

        return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> deleteSubjectTeacher(String batch, String subjectCode,String section) {
        SubjectTeacher subjectTeacher = subjectTeacherRepo
                .findByBatchAndSubCodeAndSection(batch,subjectCode,section)
                .orElseThrow( ()-> new ResourceNotFoundException("SubjectTeacher", "Batch: "+batch+" Section:"+section+ " Code",subjectCode));

        subjectTeacherRepo.delete(subjectTeacher);

        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateSubstituteSubjectTeacher(String batch, String subjectCode, String section,
                                                                 SubjectTeacherUpdateRequest curSubjectTeacher) {
        SubjectTeacher subjectTeacher = subjectTeacherRepo
                .findByBatchAndSubCodeAndSection(batch,subjectCode,section)
                .orElseThrow( ()-> new ResourceNotFoundException("SubjectTeacher", "Batch: "+batch+" Section:"+section+ " Code",subjectCode));

        subjectTeacher.setSubstituteTeacherId(curSubjectTeacher.getSubstituteTeacherId());

        subjectTeacher.setLastUpdateTime(curSubjectTeacher.getLastUpdateTime());
        subjectTeacherRepo.save(subjectTeacher);

        return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);

    }

}

