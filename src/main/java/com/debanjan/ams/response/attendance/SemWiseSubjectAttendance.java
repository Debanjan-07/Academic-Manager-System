package com.pabitra.ams.response.attendance;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Data
public class SemWiseSubjectAttendance implements Serializable {
    private List<SubjectAttendanceResponse> subjectAttendances;
    private HttpStatus statusCode;
}

