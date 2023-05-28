package com.example.sendingnotification.service;

import com.example.sendingnotification.dto.request.NotificationRequest;
import com.example.sendingnotification.dto.response.SimpleResponse;
import com.example.sendingnotification.util.MakingResponse;
import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseMessagingService {
    public SimpleResponse sendNotificationByToken(NotificationRequest request) {
        Message message = Message.builder()
                .setToken(request.getFcmToken())
                .setNotification(
                        makingNotification(
                                request.getNotificationTitle(),
                                request.getNotificationBody(),
                                request.getNotificationImageUrl()).build()
                )
                .setAndroidConfig(
                        makingAndroidConfig(request.getAndroidNotificationChannelId()).build()
                )
                .build();
        try {
            FirebaseMessaging.getInstance().send(message);
            return MakingResponse.makingResponse("200","Successful");
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return MakingResponse.makingResponse("500","Error");

        }

    }

    private Notification.Builder makingNotification(String title, String body, String image) {
        return Notification.builder().setTitle(title).setBody(body).setImage(image);

    }

    private AndroidConfig.Builder makingAndroidConfig(String channelId) {
        return AndroidConfig.builder().setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(
                        AndroidNotification.builder()
                                .setChannelId(channelId).build());
    }
}
