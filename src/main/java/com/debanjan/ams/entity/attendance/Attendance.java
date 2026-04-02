package com.pabitra.ams.entity.attendance;

import com.pabitra.ams.config.attendance.AttendanceKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AttendanceKey.class)
public class Attendance {
    @Id
    @Column(length = 64)
    private String collegeId;
    @Id
    @Column(length = 64)
    private String date;
    @Id
    @Column(length = 64)
    private String subCode;

    @Id
    @Column(length = 32)
    private String classType;

    private  Boolean status;
}
