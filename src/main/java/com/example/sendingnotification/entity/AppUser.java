package com.example.sendingnotification.entity;

import com.example.sendingnotification.dto.enums.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "app-user")
public class AppUser {
    @Id
    private String id;
    private String userName;
    private String userPhoneNumber;
    private String userEmail;
    private String userAddress;
    private DeviceType deviceType;
    private Date createdTime;
}

