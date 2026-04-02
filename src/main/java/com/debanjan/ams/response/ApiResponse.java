package com.pabitra.ams.response;


import lombok.*;

@Data
@AllArgsConstructor
public class ApiResponse {
    private   String message;
    private   boolean status;
}

