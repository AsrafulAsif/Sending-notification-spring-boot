package com.example.sendingnotification.dto.request.appside;
import com.example.sendingnotification.dto.enums.DeviceType;
import lombok.Data;

@Data
public class UserInformationRequest {
    private String userName;
    private String userPhoneNumber;
    private String userEmail;
    private String userAddress;
    private DeviceType deviceType;
}

