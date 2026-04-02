package com.pabitra.ams.entity.attendance;

import com.pabitra.ams.config.attendance.AttendanceStatusOnDateKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AttendanceStatusOnDateKey.class)
public class AttendanceStatusOnDate {
    @Id
    @Column(length = 64)
    private String batch;
    @Id
    @Column(length = 64)
    private String section;
    @Id
    @Column(length = 64)
    private String subCode;
    @Id
    @Column(length = 64)
    private String date;
    @Id
    @Column(length = 64)
    private String classType;
}
