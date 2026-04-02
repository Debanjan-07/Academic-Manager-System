package com.pabitra.ams.entity.routine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(RoutineKey.class)
public class Routine {

    @Id
    @Column(length = 64)
    private String batch;
    @Id
    @Column(length = 64)
    private String sem;
    @Id
    @Column(length = 64)
    private String section;

    @Id
    @Column(length = 64)
    private String day;

    @Id
    @Column(length = 64)
    private String startTime;

    private String endTime;

    private String classType;

    private String roomNo;

    private String subCode;

    private String teacherId;

    private String subTeacherId;

    private String lastUpdateTime;

}
