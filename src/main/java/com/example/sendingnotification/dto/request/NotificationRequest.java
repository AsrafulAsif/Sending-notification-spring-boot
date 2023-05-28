package com.example.sendingnotification.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private String fcmToken;
    private String notificationTitle;
    private String notificationBody;
    private String notificationImageUrl;
    private String androidNotificationChannelId;
}
