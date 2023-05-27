package com.example.sendingnotification.controller;

import com.example.sendingnotification.service.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sending-notification")
public class NotificationController {
    private final FirebaseMessagingService firebaseMessagingService;

    @Autowired
    public NotificationController(FirebaseMessagingService firebaseMessagingService) {
        this.firebaseMessagingService = firebaseMessagingService;
    }

    @PostMapping
    ResponseEntity<?> sendingNotification(
            @RequestParam("token") String token,
            @RequestParam("title") String title,
            @RequestParam("body") String body,
            @RequestParam("image") String image
    ) {
        firebaseMessagingService.sendNotification(token,title,body,image);
        return new ResponseEntity<>("Notification send....", HttpStatus.OK);
    }

}
