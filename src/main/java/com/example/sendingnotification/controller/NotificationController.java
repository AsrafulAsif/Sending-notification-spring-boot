package com.example.sendingnotification.controller;

import com.example.sendingnotification.dto.request.NotificationRequest;
import com.example.sendingnotification.dto.response.SimpleResponse;
import com.example.sendingnotification.service.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sending-notification")
public class NotificationController {
    private final FirebaseMessagingService firebaseMessagingService;

    @Autowired
    public NotificationController(FirebaseMessagingService firebaseMessagingService) {
        this.firebaseMessagingService = firebaseMessagingService;
    }

    @PostMapping("/token")
    ResponseEntity<?> sendingNotificationByToken(
            @RequestBody NotificationRequest request
            ) {
        SimpleResponse simpleResponse = firebaseMessagingService.sendNotificationByToken(request);
        return new ResponseEntity<>(simpleResponse, HttpStatus.OK);
    }

}
