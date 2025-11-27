package com.umeng.message;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.component.UmengNotificationClickActivity;
import com.umeng.message.component.UmengNotificationReceiver;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.a;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.ak;
import com.umeng.message.proguard.az;
import com.umeng.message.proguard.bj;
import com.umeng.message.proguard.bo;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.x;
import com.umeng.message.proguard.z;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class UmengMessageHandler implements UPushMessageHandler {

    /* renamed from: a  reason: collision with root package name */
    private static Date f15214a;

    /* renamed from: b  reason: collision with root package name */
    private int f15215b;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.app.Notification a(android.content.Context r20, com.umeng.message.entity.UMessage r21) {
        /*
            r19 = this;
            android.app.Notification$Builder r0 = new android.app.Notification$Builder
            r1 = r20
            r0.<init>(r1)
            java.lang.String r2 = r21.getCategory()
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x001a
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x001a
            android.app.Notification.Builder unused = r0.setCategory(r2)
        L_0x001a:
            java.lang.String r2 = "MsgHandler"
            r4 = 0
            r5 = 26
            r6 = 1
            r7 = 0
            if (r3 < r5) goto L_0x005c
            android.app.NotificationChannel r3 = r19.getNotificationChannel(r20, r21)
            if (r3 != 0) goto L_0x0049
            int r3 = r21.getImportance()
            if (r3 != r6) goto L_0x003a
            boolean r3 = com.umeng.message.proguard.d.g()
            if (r3 == 0) goto L_0x003a
            android.app.NotificationChannel r3 = com.umeng.message.common.UPushNotificationChannel.getSilenceMode(r20)
            goto L_0x0049
        L_0x003a:
            boolean r3 = r19.isInNoDisturbTime(r20)
            if (r3 == 0) goto L_0x0045
            android.app.NotificationChannel r3 = com.umeng.message.common.UPushNotificationChannel.getSilenceMode(r20)
            goto L_0x0049
        L_0x0045:
            android.app.NotificationChannel r3 = com.umeng.message.common.UPushNotificationChannel.getDefaultMode(r20)
        L_0x0049:
            if (r3 != 0) goto L_0x0055
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r1 = "notification channel null!"
            r0[r7] = r1
            com.umeng.message.common.UPLog.e((java.lang.String) r2, (java.lang.Object[]) r0)
            return r4
        L_0x0055:
            java.lang.String r3 = r3.getId()
            android.app.Notification.Builder unused = r0.setChannelId(r3)
        L_0x005c:
            int r3 = r19.getSmallIconId(r20, r21)
            if (r3 >= 0) goto L_0x006c
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r1 = "notification small icon error!"
            r0[r7] = r1
            com.umeng.message.common.UPLog.e((java.lang.String) r2, (java.lang.Object[]) r0)
            return r4
        L_0x006c:
            android.graphics.Bitmap r2 = r19.getLargeIcon(r20, r21)
            android.graphics.Bitmap r8 = r19.getExpandImage(r20, r21)
            java.lang.String r9 = r21.getTitle()
            java.lang.String r10 = r21.getContent()
            java.lang.String r11 = r21.getTitleColor()
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            r13 = 34
            if (r12 != 0) goto L_0x00a6
            boolean r12 = android.text.TextUtils.isEmpty(r9)
            if (r12 != 0) goto L_0x00a6
            int r12 = android.graphics.Color.parseColor(r11)     // Catch:{ Exception -> 0x00a5 }
            android.text.SpannableString r14 = new android.text.SpannableString     // Catch:{ Exception -> 0x00a5 }
            r14.<init>(r9)     // Catch:{ Exception -> 0x00a5 }
            android.text.style.ForegroundColorSpan r15 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x00a5 }
            r15.<init>(r12)     // Catch:{ Exception -> 0x00a5 }
            int r12 = r9.length()     // Catch:{ Exception -> 0x00a5 }
            r14.setSpan(r15, r7, r12, r13)     // Catch:{ Exception -> 0x00a5 }
            r9 = r14
            goto L_0x00a6
        L_0x00a5:
        L_0x00a6:
            java.lang.String r12 = r21.getTextColor()
            boolean r14 = android.text.TextUtils.isEmpty(r12)
            if (r14 != 0) goto L_0x00ce
            boolean r14 = android.text.TextUtils.isEmpty(r10)
            if (r14 != 0) goto L_0x00ce
            int r14 = android.graphics.Color.parseColor(r12)     // Catch:{ Exception -> 0x00cd }
            android.text.SpannableString r15 = new android.text.SpannableString     // Catch:{ Exception -> 0x00cd }
            r15.<init>(r10)     // Catch:{ Exception -> 0x00cd }
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x00cd }
            r4.<init>(r14)     // Catch:{ Exception -> 0x00cd }
            int r14 = r10.length()     // Catch:{ Exception -> 0x00cd }
            r15.setSpan(r4, r7, r14, r13)     // Catch:{ Exception -> 0x00cd }
            r10 = r15
            goto L_0x00ce
        L_0x00cd:
        L_0x00ce:
            java.lang.String r4 = r21.getTicker()
            r0.setTicker(r4)
            r0.setSmallIcon(r3)
            r0.setContentTitle(r9)
            r0.setContentText(r10)
            r0.setAutoCancel(r6)
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L_0x00f0
            boolean r6 = r21.hasBackgroundImage()
            if (r6 == 0) goto L_0x00f0
            android.graphics.Bitmap r6 = r19.getBackgroundImage(r20, r21)
            goto L_0x00f1
        L_0x00f0:
            r6 = 0
        L_0x00f1:
            if (r4 < r5) goto L_0x019a
            if (r6 == 0) goto L_0x019a
            boolean r4 = com.umeng.message.proguard.d.h()
            android.app.Notification.Builder unused = r0.setGroupSummary(r4)
            r5 = r21
            java.lang.String r4 = r5.msg_id
            android.app.Notification.Builder unused = r0.setGroup(r4)
            int r4 = com.umeng.message.push.R.layout.upush_notification_shade_layout
            int r15 = com.umeng.message.push.R.id.upush_notification_small_icon
            int r13 = com.umeng.message.push.R.id.upush_notification_app_name
            int r14 = com.umeng.message.push.R.id.upush_notification_date
            int r7 = com.umeng.message.push.R.id.upush_notification_title
            int r1 = com.umeng.message.push.R.id.upush_notification_content
            int r5 = com.umeng.message.push.R.id.upush_notification_shade_iv
            r16 = r12
            int r12 = com.umeng.message.push.R.id.upush_notification_large_iv
            r17 = r11
            android.widget.RemoteViews r11 = new android.widget.RemoteViews
            r18 = r8
            java.lang.String r8 = r20.getPackageName()
            r11.<init>(r8, r4)
            r11.setImageViewResource(r15, r3)
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getAppName(r20)
            r11.setTextViewText(r13, r3)
            long r3 = r21.getMsgTime()
            boolean r8 = com.umeng.message.proguard.f.a((long) r3)
            if (r8 == 0) goto L_0x0142
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat
            java.lang.String r13 = "HH:mm"
            java.util.Locale r15 = java.util.Locale.getDefault()
            r8.<init>(r13, r15)
            goto L_0x014d
        L_0x0142:
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat
            java.lang.String r13 = "yyyy/MM/dd"
            java.util.Locale r15 = java.util.Locale.getDefault()
            r8.<init>(r13, r15)
        L_0x014d:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r8.format(r3)
            r11.setTextViewText(r14, r3)
            r11.setTextViewText(r7, r9)
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            r4 = 8
            if (r3 == 0) goto L_0x0168
            r11.setViewVisibility(r1, r4)
            r3 = 0
            goto L_0x016f
        L_0x0168:
            r3 = 0
            r11.setViewVisibility(r1, r3)
            r11.setTextViewText(r1, r10)
        L_0x016f:
            if (r2 == 0) goto L_0x0178
            r11.setViewVisibility(r12, r3)
            r11.setImageViewBitmap(r12, r2)
            goto L_0x017b
        L_0x0178:
            r11.setViewVisibility(r12, r4)
        L_0x017b:
            r11.setViewVisibility(r5, r3)
            r11.setImageViewBitmap(r5, r6)
            android.app.Notification.Builder unused = r0.setCustomContentView(r11)
            android.content.pm.ApplicationInfo r1 = r20.getApplicationInfo()
            int r1 = r1.targetSdkVersion
            r3 = 31
            if (r1 < r3) goto L_0x0191
            android.app.Notification.Builder unused = r0.setCustomBigContentView(r11)
        L_0x0191:
            android.app.Notification$DecoratedCustomViewStyle r1 = new android.app.Notification$DecoratedCustomViewStyle
            r1.<init>()
            r0.setStyle(r1)
            goto L_0x01dc
        L_0x019a:
            r18 = r8
            r17 = r11
            r16 = r12
            java.lang.String r1 = r21.getBarImageUrl()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x01d7
            android.widget.RemoteViews r1 = new android.widget.RemoteViews
            java.lang.String r3 = r20.getPackageName()
            int r5 = com.umeng.message.push.R.layout.upush_notification_banner_layout
            r1.<init>(r3, r5)
            int r3 = com.umeng.message.push.R.id.upush_notification_banner
            android.graphics.Bitmap r5 = r19.getBarImage(r20, r21)
            r1.setImageViewBitmap(r3, r5)
            r3 = 24
            if (r4 < r3) goto L_0x01d3
            android.app.Notification.Builder unused = r0.setCustomContentView(r1)
            android.content.pm.ApplicationInfo r3 = r20.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            r4 = 31
            if (r3 < r4) goto L_0x01dc
            android.app.Notification.Builder unused = r0.setCustomBigContentView(r1)
            goto L_0x01dc
        L_0x01d3:
            r0.setContent(r1)
            goto L_0x01dc
        L_0x01d7:
            if (r2 == 0) goto L_0x01dc
            r0.setLargeIcon(r2)
        L_0x01dc:
            if (r18 == 0) goto L_0x01f0
            android.app.Notification$BigPictureStyle r1 = new android.app.Notification$BigPictureStyle
            r1.<init>()
            r3 = r18
            r1.bigPicture(r3)
            r1.bigLargeIcon(r2)
            r0.setStyle(r1)
            goto L_0x0266
        L_0x01f0:
            java.lang.String r1 = r21.getBigBody()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0266
            java.lang.String r1 = r21.getBigTitle()
            if (r1 == 0) goto L_0x0208
            int r2 = r1.length()
            if (r2 != 0) goto L_0x0207
            goto L_0x0208
        L_0x0207:
            r9 = r1
        L_0x0208:
            java.lang.String r1 = r21.getBigBody()
            boolean r2 = android.text.TextUtils.isEmpty(r17)
            if (r2 != 0) goto L_0x0233
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 != 0) goto L_0x0233
            int r2 = android.graphics.Color.parseColor(r17)     // Catch:{ Exception -> 0x0232 }
            android.text.SpannableString r3 = new android.text.SpannableString     // Catch:{ Exception -> 0x0232 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x0232 }
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x0232 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0232 }
            int r2 = r9.length()     // Catch:{ Exception -> 0x0232 }
            r5 = 34
            r6 = 0
            r3.setSpan(r4, r6, r2, r5)     // Catch:{ Exception -> 0x0232 }
            r9 = r3
            goto L_0x0233
        L_0x0232:
        L_0x0233:
            boolean r2 = android.text.TextUtils.isEmpty(r16)
            if (r2 != 0) goto L_0x0258
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0258
            int r2 = android.graphics.Color.parseColor(r16)     // Catch:{ Exception -> 0x0258 }
            android.text.SpannableString r3 = new android.text.SpannableString     // Catch:{ Exception -> 0x0258 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0258 }
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x0258 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0258 }
            int r2 = r1.length()     // Catch:{ Exception -> 0x0258 }
            r5 = 34
            r6 = 0
            r3.setSpan(r4, r6, r2, r5)     // Catch:{ Exception -> 0x0258 }
            r1 = r3
        L_0x0258:
            android.app.Notification$BigTextStyle r2 = new android.app.Notification$BigTextStyle
            r2.<init>()
            r2.setBigContentTitle(r9)
            r2.bigText(r1)
            r0.setStyle(r2)
        L_0x0266:
            android.app.Notification r0 = r0.getNotification()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.a(android.content.Context, com.umeng.message.entity.UMessage):android.app.Notification");
    }

    public void dealWithCustomMessage(Context context, UMessage uMessage) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0126 A[Catch:{ Exception -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012f A[Catch:{ Exception -> 0x01db }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dealWithNotificationMessage(android.content.Context r14, com.umeng.message.entity.UMessage r15) {
        /*
            r13 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "notification:"
            r3 = 0
            r1[r3] = r2
            org.json.JSONObject r2 = r15.getRaw()
            r4 = 1
            r1[r4] = r2
            java.lang.String r2 = "MsgHandler"
            com.umeng.message.common.UPLog.i(r2, r1)
            com.umeng.message.MessageSharedPrefs r1 = com.umeng.message.MessageSharedPrefs.getInstance(r14)
            long r5 = r15.getMsgTime()
            com.umeng.message.proguard.bd r7 = r1.f15211b
            r8 = 0
            java.lang.String r10 = "last_msg_time"
            long r7 = r7.b((java.lang.String) r10, (long) r8)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x002c
            r5 = 1
            goto L_0x002d
        L_0x002c:
            r5 = 0
        L_0x002d:
            long r6 = r15.getMsgTime()
            com.umeng.message.proguard.bd r1 = r1.f15211b
            r1.a((java.lang.String) r10, (long) r6)
            android.app.Notification r1 = r13.getNotification(r14, r15)
            int r6 = r13.getNotificationDefaults(r14, r15)
            if (r1 != 0) goto L_0x0044
            android.app.Notification r1 = r13.a(r14, r15)
        L_0x0044:
            if (r1 != 0) goto L_0x0050
            java.lang.Object[] r14 = new java.lang.Object[r4]
            java.lang.String r15 = "notification null"
            r14[r3] = r15
            com.umeng.message.common.UPLog.e((java.lang.String) r2, (java.lang.Object[]) r14)
            return
        L_0x0050:
            int r7 = r13.f15215b
            if (r7 != 0) goto L_0x005c
            long r7 = android.os.SystemClock.elapsedRealtime()
            int r8 = (int) r7
            r13.f15215b = r8
            goto L_0x005f
        L_0x005c:
            int r7 = r7 + r4
            r13.f15215b = r7
        L_0x005f:
            android.app.PendingIntent r7 = r13.getDismissPendingIntent(r14, r15)
            r1.deleteIntent = r7
            android.app.PendingIntent r7 = r13.getClickPendingIntent(r14, r15)
            r1.contentIntent = r7
            r7 = r6 & 1
            if (r7 == 0) goto L_0x007f
            android.net.Uri r7 = r13.getSound(r14, r15)
            if (r7 == 0) goto L_0x007b
            android.net.Uri r8 = r13.getSound(r14, r15)
            r1.sound = r8
        L_0x007b:
            if (r7 == 0) goto L_0x007f
            r6 = r6 ^ 1
        L_0x007f:
            r1.defaults = r6
            int r6 = r13.f15215b
            java.lang.String r7 = "notification"
            java.lang.Object r7 = r14.getSystemService(r7)     // Catch:{ Exception -> 0x01db }
            android.app.NotificationManager r7 = (android.app.NotificationManager) r7     // Catch:{ Exception -> 0x01db }
            com.umeng.message.proguard.ap r8 = new com.umeng.message.proguard.ap     // Catch:{ Exception -> 0x01db }
            r8.<init>(r15)     // Catch:{ Exception -> 0x01db }
            int r9 = com.umeng.message.proguard.d.q(r14)     // Catch:{ Exception -> 0x01db }
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01db }
            r11 = 26
            r12 = 3
            if (r10 < r11) goto L_0x00c6
            if (r9 <= 0) goto L_0x00c6
            if (r7 == 0) goto L_0x00c6
            java.lang.String r9 = r1.getChannelId()     // Catch:{ Exception -> 0x01db }
            android.app.NotificationChannel r9 = r7.getNotificationChannel(r9)     // Catch:{ Exception -> 0x01db }
            int r9 = r9.getImportance()     // Catch:{ Exception -> 0x01db }
            r10 = 4
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x01db }
            java.lang.String r11 = "notification channelId:"
            r10[r3] = r11     // Catch:{ Exception -> 0x01db }
            java.lang.String r11 = r1.getChannelId()     // Catch:{ Exception -> 0x01db }
            r10[r4] = r11     // Catch:{ Exception -> 0x01db }
            java.lang.String r11 = "importance:"
            r10[r0] = r11     // Catch:{ Exception -> 0x01db }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x01db }
            r10[r12] = r11     // Catch:{ Exception -> 0x01db }
            com.umeng.message.common.UPLog.i(r2, r10)     // Catch:{ Exception -> 0x01db }
            goto L_0x00da
        L_0x00c6:
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01db }
            java.lang.String r11 = "notification switch:"
            r10[r3] = r11     // Catch:{ Exception -> 0x01db }
            if (r9 != r4) goto L_0x00d0
            r11 = 1
            goto L_0x00d1
        L_0x00d0:
            r11 = 0
        L_0x00d1:
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ Exception -> 0x01db }
            r10[r4] = r11     // Catch:{ Exception -> 0x01db }
            com.umeng.message.common.UPLog.w((java.lang.String) r2, (java.lang.Object[]) r10)     // Catch:{ Exception -> 0x01db }
        L_0x00da:
            com.umeng.message.proguard.al r10 = com.umeng.message.proguard.ak.a()     // Catch:{ Exception -> 0x01db }
            com.umeng.message.proguard.an r10 = r10.c()     // Catch:{ Exception -> 0x01db }
            boolean r10 = r10.a()     // Catch:{ Exception -> 0x01db }
            java.lang.String r11 = "Pop"
            if (r10 == 0) goto L_0x00f4
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01db }
            java.lang.String r10 = "config null"
            r9[r3] = r10     // Catch:{ Exception -> 0x01db }
            com.umeng.message.common.UPLog.i(r11, r9)     // Catch:{ Exception -> 0x01db }
            goto L_0x0123
        L_0x00f4:
            int r10 = r8.f15403c     // Catch:{ Exception -> 0x01db }
            if (r10 != r0) goto L_0x0105
            if (r9 > 0) goto L_0x0105
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01db }
            java.lang.String r10 = "importance matched"
            r9[r3] = r10     // Catch:{ Exception -> 0x01db }
            com.umeng.message.common.UPLog.i(r11, r9)     // Catch:{ Exception -> 0x01db }
        L_0x0103:
            r9 = 1
            goto L_0x0124
        L_0x0105:
            if (r10 != r4) goto L_0x0111
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01db }
            java.lang.String r10 = "force matched"
            r9[r3] = r10     // Catch:{ Exception -> 0x01db }
            com.umeng.message.common.UPLog.i(r11, r9)     // Catch:{ Exception -> 0x01db }
            goto L_0x0103
        L_0x0111:
            if (r10 != r12) goto L_0x0123
            boolean r9 = com.umeng.message.proguard.u.c()     // Catch:{ Exception -> 0x01db }
            if (r9 == 0) goto L_0x0123
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01db }
            java.lang.String r10 = "foreground matched"
            r9[r3] = r10     // Catch:{ Exception -> 0x01db }
            com.umeng.message.common.UPLog.i(r11, r9)     // Catch:{ Exception -> 0x01db }
            goto L_0x0103
        L_0x0123:
            r9 = 0
        L_0x0124:
            if (r9 == 0) goto L_0x012f
            com.umeng.message.proguard.al r0 = com.umeng.message.proguard.ak.a()     // Catch:{ Exception -> 0x01db }
            r0.a((com.umeng.message.proguard.ap) r8)     // Catch:{ Exception -> 0x01db }
            goto L_0x01df
        L_0x012f:
            com.umeng.message.PushAgent r8 = com.umeng.message.PushAgent.getInstance(r14)     // Catch:{ Exception -> 0x01db }
            boolean r8 = r8.getNotificationOnForeground()     // Catch:{ Exception -> 0x01db }
            if (r8 != 0) goto L_0x0157
            boolean r8 = com.umeng.message.proguard.u.c()     // Catch:{ Exception -> 0x01db }
            if (r8 == 0) goto L_0x0157
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01db }
            java.lang.String r1 = "foreground notification dismiss. msgId:"
            r0[r3] = r1     // Catch:{ Exception -> 0x01db }
            java.lang.String r1 = r15.getMsgId()     // Catch:{ Exception -> 0x01db }
            r0[r4] = r1     // Catch:{ Exception -> 0x01db }
            com.umeng.message.common.UPLog.i(r2, r0)     // Catch:{ Exception -> 0x01db }
            com.umeng.message.UTrack r0 = com.umeng.message.UTrack.getInstance()     // Catch:{ Exception -> 0x01db }
            r0.trackMsgDismissed(r15)     // Catch:{ Exception -> 0x01db }
            goto L_0x01df
        L_0x0157:
            com.umeng.message.MessageSharedPrefs r0 = com.umeng.message.MessageSharedPrefs.getInstance(r14)     // Catch:{ Exception -> 0x01db }
            int r0 = r0.b()     // Catch:{ Exception -> 0x01db }
            if (r0 != r4) goto L_0x016c
            if (r5 != 0) goto L_0x016c
            com.umeng.message.UTrack r0 = com.umeng.message.UTrack.getInstance()     // Catch:{ Exception -> 0x01db }
            r0.trackMsgDismissed(r15)     // Catch:{ Exception -> 0x01db }
            goto L_0x01df
        L_0x016c:
            com.umeng.message.proguard.x r3 = com.umeng.message.proguard.x.a()     // Catch:{ Exception -> 0x01db }
            java.lang.String r4 = "um"
            if (r0 <= 0) goto L_0x0194
        L_0x0174:
            int r5 = r3.c()     // Catch:{ Exception -> 0x01db }
            if (r5 < r0) goto L_0x0194
            com.umeng.message.proguard.ad r5 = r3.b()     // Catch:{ Exception -> 0x01db }
            if (r5 == 0) goto L_0x0174
            if (r7 == 0) goto L_0x0187
            int r8 = r5.f15319a     // Catch:{ Exception -> 0x01db }
            r7.cancel(r4, r8)     // Catch:{ Exception -> 0x01db }
        L_0x0187:
            com.umeng.message.UTrack r8 = com.umeng.message.UTrack.getInstance()     // Catch:{ Exception -> 0x01db }
            com.umeng.message.entity.UMessage r9 = r5.f15320b     // Catch:{ Exception -> 0x01db }
            r8.trackMsgDismissed(r9)     // Catch:{ Exception -> 0x01db }
            com.umeng.message.proguard.az.a(r5)     // Catch:{ Exception -> 0x01db }
            goto L_0x0174
        L_0x0194:
            com.umeng.message.proguard.ad r0 = new com.umeng.message.proguard.ad     // Catch:{ Exception -> 0x01db }
            r0.<init>(r6, r15)     // Catch:{ Exception -> 0x01db }
            r3.a((com.umeng.message.proguard.ad) r0)     // Catch:{ Exception -> 0x01db }
            if (r7 == 0) goto L_0x01df
            r7.notify(r4, r6, r1)     // Catch:{ Exception -> 0x01db }
            com.umeng.message.UTrack r3 = com.umeng.message.UTrack.getInstance()     // Catch:{ Exception -> 0x01db }
            r3.trackMsgShow(r15, r1)     // Catch:{ Exception -> 0x01db }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01db }
            r3 = 23
            if (r1 < r3) goto L_0x01df
            com.umeng.message.entity.UMessage r1 = r0.f15320b     // Catch:{ Exception -> 0x01db }
            if (r1 == 0) goto L_0x01df
            java.lang.Object r3 = r0.f15321c     // Catch:{ Exception -> 0x01db }
            if (r3 != 0) goto L_0x01df
            boolean r3 = r1.isRepost()     // Catch:{ Exception -> 0x01db }
            if (r3 == 0) goto L_0x01df
            android.app.Application r3 = com.umeng.message.proguard.y.a()     // Catch:{ Exception -> 0x01db }
            com.umeng.message.MessageSharedPrefs r3 = com.umeng.message.MessageSharedPrefs.getInstance(r3)     // Catch:{ Exception -> 0x01db }
            int r1 = r1.getRepostCount()     // Catch:{ Exception -> 0x01db }
            com.umeng.message.proguard.bd r3 = r3.f15211b     // Catch:{ Exception -> 0x01db }
            java.lang.String r4 = "re_pop_cfg"
            r3.a((java.lang.String) r4, (int) r1)     // Catch:{ Exception -> 0x01db }
            com.umeng.message.proguard.ba r1 = new com.umeng.message.proguard.ba     // Catch:{ Exception -> 0x01db }
            r1.<init>(r0)     // Catch:{ Exception -> 0x01db }
            com.umeng.message.proguard.c r1 = r1.a()     // Catch:{ Exception -> 0x01db }
            r0.f15321c = r1     // Catch:{ Exception -> 0x01db }
            goto L_0x01df
        L_0x01db:
            r0 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r2, (java.lang.Throwable) r0)
        L_0x01df:
            r13.setBadgeNum(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.dealWithNotificationMessage(android.content.Context, com.umeng.message.entity.UMessage):void");
    }

    public Bitmap getBackgroundImage(Context context, UMessage uMessage) {
        try {
            String backgroundImageUrl = uMessage.getBackgroundImageUrl();
            if (TextUtils.isEmpty(backgroundImageUrl)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(backgroundImageUrl)), bo.a(), bo.a(64.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public Bitmap getBarImage(Context context, UMessage uMessage) {
        try {
            String barImageUrl = uMessage.getBarImageUrl();
            if (TextUtils.isEmpty(barImageUrl)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(barImageUrl)), bo.a(), bo.a(64.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        int i10 = 335544320;
        intent.setFlags(335544320);
        intent.setClass(context, UmengNotificationClickActivity.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("NOTIFICATION_ID", this.f15215b);
        if (Build.VERSION.SDK_INT < 23) {
            i10 = 268435456;
        }
        return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, i10);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage uMessage) {
        int i10;
        Intent intent = new Intent();
        intent.setClass(context, UmengNotificationReceiver.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("ACTION", 11);
        intent.putExtra("NOTIFICATION_ID", this.f15215b);
        if (Build.VERSION.SDK_INT >= 23) {
            i10 = 335544320;
        } else {
            i10 = 268435456;
        }
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, i10);
    }

    public Bitmap getExpandImage(Context context, UMessage uMessage) {
        try {
            String bigImage = uMessage.getBigImage();
            if (TextUtils.isEmpty(bigImage)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(bigImage)), bo.a(), bo.a(256.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A[Catch:{ Exception -> 0x0042, all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap getLargeIcon(android.content.Context r6, com.umeng.message.entity.UMessage r7) {
        /*
            r5 = this;
            java.lang.String r0 = "MsgHandler"
            r1 = 0
            boolean r2 = r7.isLargeIconFromInternet()     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0030
            java.lang.String r2 = r7.getLargeIconUrl()     // Catch:{ all -> 0x005e }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0014
            return r1
        L_0x0014:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x005e }
            java.io.File r4 = com.umeng.message.proguard.f.g(r6)     // Catch:{ all -> 0x005e }
            java.lang.String r2 = com.umeng.commonsdk.utils.UMUtils.MD5(r2)     // Catch:{ all -> 0x005e }
            r3.<init>(r4, r2)     // Catch:{ all -> 0x005e }
            r2 = 1111490560(0x42400000, float:48.0)
            int r4 = com.umeng.message.proguard.bo.a(r2)     // Catch:{ all -> 0x005e }
            int r2 = com.umeng.message.proguard.bo.a(r2)     // Catch:{ all -> 0x005e }
            android.graphics.Bitmap r2 = com.umeng.message.proguard.f.a((java.io.File) r3, (int) r4, (int) r2)     // Catch:{ all -> 0x005e }
            goto L_0x0031
        L_0x0030:
            r2 = r1
        L_0x0031:
            if (r2 != 0) goto L_0x005d
            java.lang.String r7 = r7.getLargeIconDrawableName()     // Catch:{ all -> 0x005e }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x005e }
            if (r3 != 0) goto L_0x0047
            int r7 = com.umeng.message.proguard.a.c(r7)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0053
        L_0x0042:
            r7 = move-exception
            com.umeng.message.common.UPLog.w((java.lang.String) r0, (java.lang.Throwable) r7)     // Catch:{ all -> 0x005e }
            goto L_0x0052
        L_0x0047:
            java.lang.String r7 = "umeng_push_notification_default_large_icon"
            int r7 = com.umeng.message.proguard.a.c(r7)     // Catch:{ Exception -> 0x004e }
            goto L_0x0053
        L_0x004e:
            r7 = move-exception
            com.umeng.message.common.UPLog.w((java.lang.String) r0, (java.lang.Throwable) r7)     // Catch:{ all -> 0x005e }
        L_0x0052:
            r7 = -1
        L_0x0053:
            if (r7 <= 0) goto L_0x005d
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ all -> 0x005e }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r6, r7)     // Catch:{ all -> 0x005e }
        L_0x005d:
            return r2
        L_0x005e:
            r6 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r0, (java.lang.Throwable) r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getLargeIcon(android.content.Context, com.umeng.message.entity.UMessage):android.graphics.Bitmap");
    }

    public Notification getNotification(Context context, UMessage uMessage) {
        return null;
    }

    public NotificationChannel getNotificationChannel() {
        return null;
    }

    public int getNotificationDefaults(Context context, UMessage uMessage) {
        int i10;
        Calendar instance = Calendar.getInstance();
        if (isInNoDisturbTime(context)) {
            return 0;
        }
        MessageSharedPrefs instance2 = MessageSharedPrefs.getInstance(context);
        long g10 = ((long) instance2.g()) * 1000;
        if (f15214a != null && instance.getTimeInMillis() - f15214a.getTime() < g10) {
            return 0;
        }
        int i11 = instance2.i();
        UPLog.i("MsgHandler", "vibrate:", Integer.valueOf(i11));
        if (i11 != 1 && (i11 == 2 || !uMessage.isVibrate())) {
            i10 = 0;
        } else {
            i10 = 2;
        }
        int j10 = instance2.j();
        UPLog.i("MsgHandler", "lights:", Integer.valueOf(j10));
        if (j10 == 1 || (j10 != 2 && uMessage.isLights())) {
            i10 |= 4;
        }
        int k10 = instance2.k();
        UPLog.i("MsgHandler", "sound:", Integer.valueOf(k10));
        if (k10 == 1 || (k10 != 2 && uMessage.isSound())) {
            i10 |= 1;
        }
        f15214a = instance.getTime();
        return i10;
    }

    public int getSmallIconId(Context context, UMessage uMessage) {
        int i10 = -1;
        try {
            String smallIconDrawableName = uMessage.getSmallIconDrawableName();
            if (!TextUtils.isEmpty(smallIconDrawableName)) {
                i10 = a.c(smallIconDrawableName);
            } else {
                try {
                    i10 = a.c("umeng_push_notification_default_small_icon");
                } catch (Exception e10) {
                    UPLog.w("MsgHandler", (Throwable) e10);
                }
            }
        } catch (Exception e11) {
            UPLog.w("MsgHandler", (Throwable) e11);
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
        }
        if (i10 < 0) {
            UPLog.i("MsgHandler", "no custom notification small icon! change to use app icon");
            i10 = context.getApplicationInfo().icon;
        }
        if (i10 < 0) {
            UPLog.e("MsgHandler", "can't find notification small icon");
        }
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (r1.exists() == false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri getSound(android.content.Context r5, com.umeng.message.entity.UMessage r6) {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r6.isSoundFromInternet()     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0022
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0064 }
            java.io.File r2 = com.umeng.message.proguard.f.g(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r6.getSoundUri()     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.MD5(r3)     // Catch:{ all -> 0x0064 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = r1.getPath()     // Catch:{ all -> 0x0064 }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0023
        L_0x0022:
            r2 = r0
        L_0x0023:
            if (r2 != 0) goto L_0x005d
            java.lang.String r1 = r6.getSoundUri()     // Catch:{ all -> 0x0064 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0038
            java.lang.String r6 = r6.getSoundUri()     // Catch:{ all -> 0x0064 }
            int r6 = com.umeng.message.proguard.a.d(r6)     // Catch:{ all -> 0x0064 }
            goto L_0x0039
        L_0x0038:
            r6 = -1
        L_0x0039:
            if (r6 >= 0) goto L_0x0041
            java.lang.String r6 = "umeng_push_notification_default_sound"
            int r6 = com.umeng.message.proguard.a.d(r6)     // Catch:{ all -> 0x0064 }
        L_0x0041:
            if (r6 <= 0) goto L_0x005d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "android.resource://"
            r1.<init>(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0064 }
            r1.append(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = "/"
            r1.append(r5)     // Catch:{ all -> 0x0064 }
            r1.append(r6)     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0064 }
        L_0x005d:
            if (r2 == 0) goto L_0x006a
            android.net.Uri r5 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x0064 }
            return r5
        L_0x0064:
            r5 = move-exception
            java.lang.String r6 = "MsgHandler"
            com.umeng.message.common.UPLog.w((java.lang.String) r6, (java.lang.Throwable) r5)
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getSound(android.content.Context, com.umeng.message.entity.UMessage):android.net.Uri");
    }

    public void handleMessage(Context context, UMessage uMessage) {
        if ("notification".equals(uMessage.getDisplayType())) {
            dealWithNotificationMessage(context, uMessage);
        } else if (!"custom".equals(uMessage.getDisplayType())) {
        } else {
            if (!TextUtils.isEmpty(uMessage.getRecallMsgId())) {
                try {
                    x a10 = x.a();
                    ad a11 = a10.a(uMessage.getRecallMsgId());
                    if (a11 != null) {
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                        if (notificationManager != null) {
                            notificationManager.cancel("um", a11.f15319a);
                        }
                        a10.b(a11);
                        az.a(a11);
                        z.a().a(uMessage.getRecallMsgId(), 4);
                    } else {
                        z.a().a(uMessage.getRecallMsgId(), 5);
                    }
                    ak.a().a(uMessage.getRecallMsgId());
                } catch (Throwable th) {
                    UPLog.e("MsgHandler", th);
                }
            } else {
                dealWithCustomMessage(context, uMessage);
            }
        }
    }

    public boolean isInNoDisturbTime(Context context) {
        boolean z10;
        boolean z11;
        boolean z12;
        Calendar instance = Calendar.getInstance();
        int i10 = (instance.get(11) * 60) + instance.get(12);
        if (i10 >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i10 <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            if (!z10 || !z11) {
                return false;
            }
            return true;
        } else if (z10 || z11) {
            return true;
        } else {
            return false;
        }
    }

    public void setBadgeNum(Context context, UMessage uMessage) {
        if (uMessage.getBadgeSet() >= 0) {
            bj.a(context, uMessage.getBadgeSet());
            UPLog.i("MsgHandler", "setBadgeNum:", Integer.valueOf(uMessage.getBadgeSet()));
        } else if (uMessage.getBadgeAdd() != 0) {
            bj.b(context, uMessage.getBadgeAdd());
            UPLog.i("MsgHandler", "changeBadgeNum:", Integer.valueOf(uMessage.getBadgeAdd()));
        }
    }

    public NotificationChannel getNotificationChannel(Context context, UMessage uMessage) {
        return getNotificationChannel();
    }
}
