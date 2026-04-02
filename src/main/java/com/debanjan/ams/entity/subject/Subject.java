package com.pabitra.ams.entity.subject;

import com.pabitra.ams.config.subject.SubjectKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@IdClass(SubjectKey.class)
@Table(name = "Subject_data")
public class Subject {

    @Id
    private String subCode;

    @Id
    private  String batch;

    private String subName;

    private String sem;

}
