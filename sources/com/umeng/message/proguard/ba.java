package com.umeng.message.proguard;

import android.app.Application;
import android.app.NotificationManager;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ba extends c {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f15486b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ad f15487c;

    /* renamed from: d  reason: collision with root package name */
    private long f15488d;

    public ba(ad adVar) {
        this.f15487c = adVar;
    }

    private StatusBarNotification a(NotificationManager notificationManager) {
        UMessage uMessage;
        StatusBarNotification statusBarNotification;
        boolean z10;
        ad adVar = this.f15487c;
        if (adVar == null || (uMessage = adVar.f15320b) == null || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            StatusBarNotification[] a10 = notificationManager.getActiveNotifications();
            if (a10 != null) {
                if (a10.length != 0) {
                    int length = a10.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            statusBarNotification = null;
                            z10 = false;
                            break;
                        }
                        statusBarNotification = a10[i10];
                        if (TextUtils.equals(statusBarNotification.getTag(), "um") && statusBarNotification.getId() == this.f15487c.f15319a) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                    UPLog.i("Repost", "showing:", Boolean.valueOf(z10), "msgId:", uMessage.getMsgId());
                    return statusBarNotification;
                }
            }
            UPLog.i("Repost", "notification list null");
            return null;
        } catch (Throwable th) {
            UPLog.e("Repost", th);
            return null;
        }
    }

    public final Future<?> b() {
        boolean z10;
        int i10;
        if (d()) {
            return this.f15561a;
        }
        ad adVar = this.f15487c;
        if (adVar == null) {
            return this.f15561a;
        }
        UMessage uMessage = adVar.f15320b;
        if (uMessage == null) {
            return this.f15561a;
        }
        long j10 = this.f15488d;
        if (j10 == 0) {
            this.f15488d = System.currentTimeMillis();
            z10 = true;
        } else {
            boolean a10 = f.a(j10);
            UPLog.i("Repost", "is today:", Boolean.valueOf(a10));
            if (!a10) {
                return this.f15561a;
            }
            z10 = false;
        }
        Application a11 = y.a();
        int p10 = MessageSharedPrefs.getInstance(a11).p();
        int o10 = MessageSharedPrefs.getInstance(a11).o();
        UPLog.i("Repost", "total times:", Integer.valueOf(p10), "config:", Integer.valueOf(o10));
        if (p10 >= o10) {
            return this.f15561a;
        }
        if (z10) {
            i10 = uMessage.getRepostStart();
        } else {
            i10 = uMessage.getRepostInterval();
        }
        long j11 = (long) i10;
        this.f15561a = b.a(this, j11, TimeUnit.MINUTES);
        UPLog.i("Repost", "delay:", Long.valueOf(j11), "msgId:", uMessage.getMsgId());
        return this.f15561a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0129, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r15 = this;
            java.lang.Object r0 = f15486b     // Catch:{ all -> 0x012e }
            monitor-enter(r0)     // Catch:{ all -> 0x012e }
            com.umeng.message.proguard.ad r1 = r15.f15487c     // Catch:{ all -> 0x012c }
            r2 = 0
            if (r1 != 0) goto L_0x000c
            r15.f15561a = r2     // Catch:{ all -> 0x012c }
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return
        L_0x000c:
            long r3 = r15.f15488d     // Catch:{ all -> 0x012c }
            boolean r1 = com.umeng.message.proguard.f.a((long) r3)     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "Repost"
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x012c }
            java.lang.String r6 = "is today:"
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x012c }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x012c }
            r8 = 1
            r5[r8] = r6     // Catch:{ all -> 0x012c }
            com.umeng.message.common.UPLog.i(r3, r5)     // Catch:{ all -> 0x012c }
            if (r1 != 0) goto L_0x002c
            r15.f15561a = r2     // Catch:{ all -> 0x012c }
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return
        L_0x002c:
            android.app.Application r1 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "notification"
            java.lang.Object r3 = r1.getSystemService(r3)     // Catch:{ all -> 0x012c }
            android.app.NotificationManager r3 = (android.app.NotificationManager) r3     // Catch:{ all -> 0x012c }
            if (r3 != 0) goto L_0x0049
            r15.f15561a = r2     // Catch:{ all -> 0x012c }
            java.lang.String r1 = "Repost"
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "mgr null!"
            r2[r7] = r3     // Catch:{ all -> 0x012c }
            com.umeng.message.common.UPLog.i(r1, r2)     // Catch:{ all -> 0x012c }
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return
        L_0x0049:
            android.service.notification.StatusBarNotification r5 = r15.a(r3)     // Catch:{ all -> 0x012c }
            if (r5 != 0) goto L_0x0068
            r15.f15561a = r2     // Catch:{ all -> 0x012c }
            java.lang.String r1 = "Repost"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "sbn null! msgId:"
            r2[r7] = r3     // Catch:{ all -> 0x012c }
            com.umeng.message.proguard.ad r3 = r15.f15487c     // Catch:{ all -> 0x012c }
            com.umeng.message.entity.UMessage r3 = r3.f15320b     // Catch:{ all -> 0x012c }
            java.lang.String r3 = r3.getMsgId()     // Catch:{ all -> 0x012c }
            r2[r8] = r3     // Catch:{ all -> 0x012c }
            com.umeng.message.common.UPLog.i(r1, r2)     // Catch:{ all -> 0x012c }
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return
        L_0x0068:
            com.umeng.message.MessageSharedPrefs r6 = com.umeng.message.MessageSharedPrefs.getInstance(r1)     // Catch:{ all -> 0x012c }
            int r6 = r6.o()     // Catch:{ all -> 0x012c }
            com.umeng.message.MessageSharedPrefs r9 = com.umeng.message.MessageSharedPrefs.getInstance(r1)     // Catch:{ all -> 0x012c }
            int r9 = r9.p()     // Catch:{ all -> 0x012c }
            java.lang.String r10 = "Repost"
            r11 = 4
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ all -> 0x012c }
            java.lang.String r13 = "task total times:"
            r12[r7] = r13     // Catch:{ all -> 0x012c }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x012c }
            r12[r8] = r13     // Catch:{ all -> 0x012c }
            java.lang.String r13 = "config:"
            r12[r4] = r13     // Catch:{ all -> 0x012c }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x012c }
            r14 = 3
            r12[r14] = r13     // Catch:{ all -> 0x012c }
            com.umeng.message.common.UPLog.i(r10, r12)     // Catch:{ all -> 0x012c }
            if (r9 < r6) goto L_0x0099
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return
        L_0x0099:
            android.app.Notification r5 = r5.getNotification()     // Catch:{ all -> 0x012c }
            if (r5 == 0) goto L_0x0128
            java.lang.String r6 = "um"
            com.umeng.message.proguard.ad r10 = r15.f15487c     // Catch:{ all -> 0x012c }
            int r10 = r10.f15319a     // Catch:{ all -> 0x012c }
            r3.cancel(r6, r10)     // Catch:{ all -> 0x012c }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012c }
            r5.when = r12     // Catch:{ all -> 0x012c }
            java.lang.String r6 = "um"
            com.umeng.message.proguard.ad r10 = r15.f15487c     // Catch:{ all -> 0x012c }
            int r10 = r10.f15319a     // Catch:{ all -> 0x012c }
            r3.notify(r6, r10, r5)     // Catch:{ all -> 0x012c }
            r15.f15561a = r2     // Catch:{ all -> 0x012c }
            com.umeng.message.proguard.ad r2 = r15.f15487c     // Catch:{ all -> 0x012c }
            int r3 = r2.f15322d     // Catch:{ all -> 0x012c }
            int r3 = r3 + r8
            r2.f15322d = r3     // Catch:{ all -> 0x012c }
            com.umeng.message.MessageSharedPrefs r1 = com.umeng.message.MessageSharedPrefs.getInstance(r1)     // Catch:{ all -> 0x012c }
            int r9 = r9 + r8
            java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x012c }
            int r3 = r2.get(r8)     // Catch:{ all -> 0x012c }
            r6 = 6
            int r2 = r2.get(r6)     // Catch:{ all -> 0x012c }
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ all -> 0x012c }
            java.lang.String r10 = "%d.%d.%d"
            java.lang.Object[] r12 = new java.lang.Object[r14]     // Catch:{ all -> 0x012c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x012c }
            r12[r7] = r3     // Catch:{ all -> 0x012c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x012c }
            r12[r8] = r2     // Catch:{ all -> 0x012c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x012c }
            r12[r4] = r2     // Catch:{ all -> 0x012c }
            java.lang.String r2 = java.lang.String.format(r6, r10, r12)     // Catch:{ all -> 0x012c }
            com.umeng.message.proguard.bd r1 = r1.f15211b     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "re_pop_times"
            r1.a((java.lang.String) r3, (java.lang.String) r2)     // Catch:{ all -> 0x012c }
            com.umeng.message.UTrack r1 = com.umeng.message.UTrack.getInstance()     // Catch:{ all -> 0x012c }
            com.umeng.message.proguard.ad r2 = r15.f15487c     // Catch:{ all -> 0x012c }
            com.umeng.message.entity.UMessage r2 = r2.f15320b     // Catch:{ all -> 0x012c }
            r1.trackMsgRepost(r2, r5)     // Catch:{ all -> 0x012c }
            java.lang.String r1 = "Repost"
            java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "show msgId:"
            r2[r7] = r3     // Catch:{ all -> 0x012c }
            com.umeng.message.proguard.ad r3 = r15.f15487c     // Catch:{ all -> 0x012c }
            com.umeng.message.entity.UMessage r3 = r3.f15320b     // Catch:{ all -> 0x012c }
            java.lang.String r3 = r3.getMsgId()     // Catch:{ all -> 0x012c }
            r2[r8] = r3     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "count:"
            r2[r4] = r3     // Catch:{ all -> 0x012c }
            com.umeng.message.proguard.ad r3 = r15.f15487c     // Catch:{ all -> 0x012c }
            int r3 = r3.f15322d     // Catch:{ all -> 0x012c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x012c }
            r2[r14] = r3     // Catch:{ all -> 0x012c }
            com.umeng.message.common.UPLog.i(r1, r2)     // Catch:{ all -> 0x012c }
            r15.a()     // Catch:{ all -> 0x012c }
        L_0x0128:
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return
        L_0x012a:
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            throw r1     // Catch:{ all -> 0x012e }
        L_0x012c:
            r1 = move-exception
            goto L_0x012a
        L_0x012e:
            r0 = move-exception
            java.lang.String r1 = "Repost"
            com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Throwable) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ba.run():void");
    }
}
