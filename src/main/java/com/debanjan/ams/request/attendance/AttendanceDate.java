package com.pabitra.ams.request.attendance;


import lombok.Data;

@Data
public class AttendanceDate {
    private String date;
    private boolean status;
    private String classType;
}

