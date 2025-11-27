package com.hpplay.sdk.source.protocol;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkReceiver;
import com.hpplay.sdk.source.utils.Feature;

public class MirrorNotification {
    private static final int PENDING_INTENT_FLAG_MUTABLE = 33554432;
    private static final String TAG = "MirrorNotification";
    public static final String ZTE_ACTION_CASTING_SERVICE_CLICK_FILTER = "casting.service.notification.click.filter";
    public static final String ZTE_CHANNEL_ID = "smart_cast_channel";
    public static final int ZTE_NOTIFICATION_ID = 110;

    private static Notification createZTENotification(Context context, String str) {
        int i10;
        int i11 = Build.VERSION.SDK_INT;
        Icon icon = null;
        if (i11 < 26) {
            return null;
        }
        Notification.Builder builder = new Notification.Builder(context);
        Bitmap icon2 = getIcon(context);
        if (icon2 != null) {
            icon = Icon.createWithBitmap(icon2);
        }
        if (icon != null) {
            Notification.Builder unused = builder.setSmallIcon(icon);
        } else {
            builder.setSmallIcon(17301651);
        }
        if (i11 >= 31) {
            i10 = PENDING_INTENT_FLAG_MUTABLE;
        } else {
            i10 = 268435456;
        }
        try {
            builder.setContentIntent(PendingIntent.getBroadcast(context, 1, new Intent(ZTE_ACTION_CASTING_SERVICE_CLICK_FILTER), i10));
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        builder.setAutoCancel(false);
        builder.setContentTitle(str);
        Notification.Builder unused2 = builder.setChannelId(ZTE_CHANNEL_ID);
        builder.setAutoCancel(false);
        builder.setOngoing(true);
        return builder.build();
    }

    private static NotificationChannel createZTENotificationChannel(Context context) {
        String appName = HapplayUtils.getAppName(context);
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(ZTE_CHANNEL_ID, appName, 1);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound((Uri) null, (AudioAttributes) null);
        notificationChannel.setShowBadge(false);
        return notificationChannel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.graphics.Bitmap getIcon(android.content.Context r3) {
        /*
            java.lang.Class<com.hpplay.sdk.source.protocol.MirrorNotification> r0 = com.hpplay.sdk.source.protocol.MirrorNotification.class
            monitor-enter(r0)
            android.content.Context r1 = r3.getApplicationContext()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r2 = 0
            android.content.pm.ApplicationInfo r3 = r1.getApplicationInfo(r3, r2)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            android.graphics.drawable.Drawable r3 = r1.getApplicationIcon(r3)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            android.graphics.drawable.BitmapDrawable r3 = (android.graphics.drawable.BitmapDrawable) r3     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            android.graphics.Bitmap r3 = r3.getBitmap()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            monitor-exit(r0)
            return r3
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x0023:
            monitor-exit(r0)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.protocol.MirrorNotification.getIcon(android.content.Context):android.graphics.Bitmap");
    }

    public Notification createNotification(Context context, String str, int i10) {
        Icon icon;
        int i11;
        String str2;
        Class<LelinkReceiver> cls = LelinkReceiver.class;
        if (Feature.isZTEChannel()) {
            return createZTENotification(context, str);
        }
        SourceLog.i(TAG, "createNotification");
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 26) {
            StringBuilder sb = new StringBuilder();
            sb.append("已连接到 ");
            if (TextUtils.isEmpty(str)) {
                str = "接收端";
            }
            sb.append(str);
            String sb2 = sb.toString();
            Notification.Builder builder = new Notification.Builder(context);
            builder.setAutoCancel(false);
            builder.setShowWhen(false);
            Bitmap icon2 = getIcon(context);
            if (icon2 != null) {
                icon = Icon.createWithBitmap(icon2);
            } else {
                icon = null;
            }
            if (icon != null) {
                Notification.Builder unused = builder.setSmallIcon(icon);
            } else {
                builder.setSmallIcon(17301651);
            }
            builder.setContentTitle(sb2);
            Notification.Builder unused2 = builder.setChannelId("DlnaService");
            if (i10 != 2) {
                Intent intent = new Intent(context, cls);
                intent.setAction("com.hpplay.source.service.close");
                intent.setPackage(context.getPackageName());
                intent.setClass(context, cls);
                if (i12 >= 31) {
                    i11 = PENDING_INTENT_FLAG_MUTABLE;
                } else {
                    i11 = 268435456;
                }
                PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i11);
                try {
                    str2 = context.getResources().getString(context.getResources().getIdentifier("dlna_disconnect", "string", context.getPackageName()));
                } catch (Exception unused3) {
                    str2 = null;
                }
                try {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "停止镜像";
                    }
                    Notification.Builder unused4 = builder.addAction(new Notification.Action.Builder((Icon) null, str2, broadcast).build());
                    builder.setContentIntent(broadcast);
                } catch (Exception e10) {
                    SourceLog.w(TAG, (Throwable) e10);
                }
            }
            return builder.build();
        }
        Notification build = new Notification.Builder(context).build();
        build.flags = 64;
        build.defaults = 1;
        return build;
    }

    public NotificationChannel createNotificationChannel(Context context) {
        if (Feature.isZTEChannel()) {
            return createZTENotificationChannel(context);
        }
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel("DlnaService", "乐播截屏", 3);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound((Uri) null, (AudioAttributes) null);
        notificationChannel.setShowBadge(false);
        return notificationChannel;
    }
}
