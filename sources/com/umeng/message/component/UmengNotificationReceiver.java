package com.umeng.message.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.az;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.v;
import com.umeng.message.proguard.x;
import java.util.Locale;
import org.json.JSONObject;

public final class UmengNotificationReceiver extends BroadcastReceiver {
    public final void onReceive(final Context context, final Intent intent) {
        b.c(new Runnable() {
            public final void run() {
                String stringExtra;
                try {
                    Intent intent = intent;
                    if (intent != null && (stringExtra = intent.getStringExtra("MSG")) != null) {
                        int intExtra = intent.getIntExtra("ACTION", -1);
                        UPLog.i("NotificationProxy", String.format(Locale.getDefault(), "onReceive[msg=%s, action=%d]", new Object[]{stringExtra, Integer.valueOf(intExtra)}));
                        UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                        if (intExtra == 11) {
                            UPLog.i("NotificationProxy", "notification ignored!");
                            if (!TextUtils.isEmpty(uMessage.getMsgId())) {
                                UTrack.getInstance().trackMsgDismissed(uMessage);
                            }
                            uMessage.dismiss = true;
                            UPushMessageHandler notificationClickHandler = v.a().getNotificationClickHandler();
                            if (notificationClickHandler != null) {
                                notificationClickHandler.handleMessage(context, uMessage);
                            }
                        }
                        x a10 = x.a();
                        ad a11 = a10.a(uMessage.getMsgId());
                        if (a11 != null) {
                            a10.b(a11);
                            az.a(a11);
                        }
                    }
                } catch (Throwable th) {
                    UPLog.e("NotificationProxy", th);
                }
            }
        });
    }
}
