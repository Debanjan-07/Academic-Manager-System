package com.pabitra.ams.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Faculty_Data")
public class Faculty {

    @Id
    private String mailId;
    private String name;
    private String shortName;
    private String password;
}
