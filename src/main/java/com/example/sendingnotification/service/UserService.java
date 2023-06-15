package com.example.sendingnotification.service;

import com.example.sendingnotification.dto.request.appside.UserInformationRequest;
import com.example.sendingnotification.entity.AppUser;
import com.example.sendingnotification.repository.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUserDetails(UserInformationRequest request){
        AppUser appUser = AppUser.builder()
                .userPhoneNumber(request.getUserPhoneNumber())
                .userEmail(request.getUserEmail())
                .userAddress(request.getUserAddress())
                .deviceType(request.getDeviceType())
                .createdTime(new Date(System.currentTimeMillis()))
                .build();
        userRepository.save(appUser);
    }
}
