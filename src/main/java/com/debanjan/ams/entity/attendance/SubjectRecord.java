package com.pabitra.ams.entity.attendance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@IdClass(SubjectRecordKey.class)
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRecord {
    @Id
    private String batch;
    @Id
    private String subCode;
    @Id
    private String section;

    private int totalClass;
}
