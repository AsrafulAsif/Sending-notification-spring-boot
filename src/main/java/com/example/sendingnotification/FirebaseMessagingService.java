package com.example.sendingnotification;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseMessagingService {
    public void sendNotification(String token, String title, String body,String image) throws FirebaseMessagingException {
        Map<String,String> map = new HashMap<>();
        map.put("asif","asif");
        Message message = Message.builder()
                .setToken(token)
                .setAndroidConfig(AndroidConfig.builder()
                        .setPriority(AndroidConfig.Priority.HIGH)
                        .setNotification(
                                AndroidNotification.builder()
                                        .setTitle(title)
                                        .setBody(body)
                                        .setChannelId("asif")
                                        .setImage(image)
                                        .setColor("#DC143C")
                                        .build()
                        ).build())
                .putAllData(map)
                .build();

        FirebaseMessaging.getInstance().send(message);
    }
}
