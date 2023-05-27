package com.example.sendingnotification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage {
    private String fmToken;
    private String title;
    private String body;
    private String image;
    private Map<String,String> data;
}
