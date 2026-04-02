package com.pabitra.ams.response.attendance;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresentStatusResponse implements Serializable {

    private String collegeId;
    private String rollNo;
    private String firstName;
    private String lastName;

    private int totalPresentClass;
    private String percentage;
    private Boolean status;


}

