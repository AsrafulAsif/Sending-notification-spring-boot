package com.example.sendingnotification.util;


import com.example.sendingnotification.dto.response.SimpleResponse;

public class MakingResponse {
    public static SimpleResponse makingResponse(String statusCode,String message){
        return SimpleResponse.builder().statusCode(statusCode).message(message).build();
    }
}
