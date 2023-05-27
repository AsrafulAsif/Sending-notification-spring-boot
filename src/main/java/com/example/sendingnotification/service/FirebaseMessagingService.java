package com.example.sendingnotification.service;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseMessagingService {
    public void sendNotification(String token, String title, String body,String image) {
        Message message = Message.builder()
                .setToken(token)
                .setNotification(
                        Notification.builder()
                                .setTitle(title)
                                .setBody(body)
                                .setImage(image)
                                .build()
                )
                .setAndroidConfig(
                        makingAndroidConfig().build()
                )
                .putData("asif","asif")
                .build();
        try {
            FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }

    }

    private AndroidConfig.Builder makingAndroidConfig(){
        return AndroidConfig.builder().setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(makingAndroidNotification().build());
    }

    private AndroidNotification.Builder makingAndroidNotification(){
        return AndroidNotification.builder()
                .setChannelId("asif")
                .setSound("wow.mp3")
                .setPriority(AndroidNotification.Priority.HIGH);
    }

}
