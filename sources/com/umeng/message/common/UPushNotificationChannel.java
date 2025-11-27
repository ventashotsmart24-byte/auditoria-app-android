package com.umeng.message.common;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.umeng.message.PushAgent;

public class UPushNotificationChannel {
    public static final String DEFAULT_NOTIFICATION_CHANNEL_NAME = "Default";
    public static final String DEFAULT_NOTIFICATION_SILENCE_CHANNEL_NAME = "Silence";
    public static final String PRIMARY_CHANNEL = "upush_default";
    public static final String PRIMARY_SILENCE_CHANNEL = "upush_silence";

    public static NotificationChannel getDefaultMode(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel a10 = notificationManager.getNotificationChannel(PRIMARY_CHANNEL);
            if (a10 != null) {
                return a10;
            }
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL, PushAgent.getInstance(context).getNotificationChannelName(), 3);
            notificationManager.createNotificationChannel(notificationChannel);
            return notificationChannel;
        } catch (Throwable th) {
            UPLog.e("NotificationChannel", th);
            return null;
        }
    }

    public static NotificationChannel getSilenceMode(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel a10 = notificationManager.getNotificationChannel(PRIMARY_SILENCE_CHANNEL);
            if (a10 != null) {
                return a10;
            }
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_SILENCE_CHANNEL, PushAgent.getInstance(context).getNotificationSilenceChannelName(), 1);
            notificationManager.createNotificationChannel(notificationChannel);
            return notificationChannel;
        } catch (Throwable th) {
            UPLog.e("NotificationChannel", th);
            return null;
        }
    }
}
