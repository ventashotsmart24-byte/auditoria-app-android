package com.umeng.message;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.agoo.BaseNotifyClick;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.bj;
import com.umeng.message.proguard.y;

public abstract class UmengNotifyClick extends BaseNotifyClick {
    private static final String TAG = "NotifyClickActivity";

    public void onChangeBadgeNumber(UMessage uMessage) {
        Application a10 = y.a();
        MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a10);
        if (!TextUtils.equals(uMessage.getMsgId(), instance.f())) {
            instance.c(uMessage.getMsgId());
            bj.b(a10, -1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A[SYNTHETIC, Splitter:B:28:0x0087] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMessage(android.content.Intent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "NotifyClickActivity"
            r1 = 0
            java.lang.String r2 = "body"
            java.lang.String r2 = r8.getStringExtra(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = "message_source"
            java.lang.String r3 = r8.getStringExtra(r3)     // Catch:{ all -> 0x0081 }
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = "msg:"
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0081 }
            r5 = 1
            r4[r5] = r2     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = "source:"
            r6 = 2
            r4[r6] = r5     // Catch:{ all -> 0x0081 }
            r5 = 3
            r4[r5] = r3     // Catch:{ all -> 0x0081 }
            com.umeng.message.common.UPLog.i(r0, r4)     // Catch:{ all -> 0x0081 }
            r7.onMessageReceived(r8)     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x006e
            int r3 = r2.length()     // Catch:{ all -> 0x0081 }
            if (r3 != 0) goto L_0x0031
            goto L_0x006e
        L_0x0031:
            java.lang.String r3 = "id"
            java.lang.String r3 = r8.getStringExtra(r3)     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = "task_id"
            java.lang.String r4 = r8.getStringExtra(r4)     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = "channel"
            r6 = -1
            int r8 = r8.getIntExtra(r5, r6)     // Catch:{ all -> 0x0081 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0081 }
            r5.<init>(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "agoo_msg_id"
            r5.put(r2, r3)     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "agoo_task_id"
            r5.put(r2, r4)     // Catch:{ all -> 0x0081 }
            com.umeng.message.entity.UMessage r2 = new com.umeng.message.entity.UMessage     // Catch:{ all -> 0x0081 }
            r2.<init>(r5)     // Catch:{ all -> 0x0081 }
            com.umeng.message.UTrack r1 = com.umeng.message.UTrack.getInstance()     // Catch:{ all -> 0x006b }
            r1.trackMfrPushMsgClick(r2, r8)     // Catch:{ all -> 0x006b }
            r7.onChangeBadgeNumber(r2)     // Catch:{ all -> 0x006b }
            r7.onMessage((com.umeng.message.entity.UMessage) r2)     // Catch:{ all -> 0x0066 }
            return
        L_0x0066:
            r8 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r0, (java.lang.Throwable) r8)
            return
        L_0x006b:
            r8 = move-exception
            r1 = r2
            goto L_0x0082
        L_0x006e:
            com.umeng.message.entity.UMessage r8 = new com.umeng.message.entity.UMessage     // Catch:{ all -> 0x007c }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x007c }
            r1.<init>()     // Catch:{ all -> 0x007c }
            r8.<init>(r1)     // Catch:{ all -> 0x007c }
            r7.onMessage((com.umeng.message.entity.UMessage) r8)     // Catch:{ all -> 0x007c }
            return
        L_0x007c:
            r8 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r0, (java.lang.Throwable) r8)
            return
        L_0x0081:
            r8 = move-exception
        L_0x0082:
            com.umeng.message.common.UPLog.e((java.lang.String) r0, (java.lang.Throwable) r8)     // Catch:{ all -> 0x009a }
            if (r1 != 0) goto L_0x0091
            com.umeng.message.entity.UMessage r1 = new com.umeng.message.entity.UMessage     // Catch:{ all -> 0x0095 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0095 }
            r8.<init>()     // Catch:{ all -> 0x0095 }
            r1.<init>(r8)     // Catch:{ all -> 0x0095 }
        L_0x0091:
            r7.onMessage((com.umeng.message.entity.UMessage) r1)     // Catch:{ all -> 0x0095 }
            return
        L_0x0095:
            r8 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r0, (java.lang.Throwable) r8)
            return
        L_0x009a:
            r8 = move-exception
            if (r1 != 0) goto L_0x00a7
            com.umeng.message.entity.UMessage r1 = new com.umeng.message.entity.UMessage     // Catch:{ all -> 0x00ab }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00ab }
            r2.<init>()     // Catch:{ all -> 0x00ab }
            r1.<init>(r2)     // Catch:{ all -> 0x00ab }
        L_0x00a7:
            r7.onMessage((com.umeng.message.entity.UMessage) r1)     // Catch:{ all -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r1 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x00af:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengNotifyClick.onMessage(android.content.Intent):void");
    }

    public abstract void onMessage(UMessage uMessage);

    public void onMessageReceived(Intent intent) {
    }
}
