package com.mobile.brasiltv.service;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.p0;
import java.util.Map;
import mobile.com.requestframe.utils.response.BaseResult;
import t9.i;
import w5.m;
import w6.i;

public final class MyFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: a  reason: collision with root package name */
    public final String f12481a = MyFirebaseMessagingService.class.getSimpleName();

    public static final class a extends ha.a {
        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
        }
    }

    public final void c(Map map) {
        boolean z10;
        if (map == null || map.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            b0.U(this, "receive in app message.");
            m.f19701a.Q(map);
        }
    }

    public final void d() {
        boolean z10;
        i.c cVar = w6.i.f9510g;
        String H = cVar.H();
        boolean z11 = false;
        if (H == null || H.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            String e10 = na.a.e();
            t9.i.f(e10, "getDeviceToken()");
            if (e10.length() == 0) {
                z11 = true;
            }
            if (!z11) {
                cVar.b().o2().compose(p0.b()).subscribe(new a());
            }
        }
    }

    public void onDeletedMessages() {
        super.onDeletedMessages();
        b0.U(this, this.f12481a + ", onDeletedMessages");
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        t9.i.g(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        b0.U(this, this.f12481a + ", From: " + remoteMessage.getFrom());
        if (remoteMessage.getNotification() == null) {
            Map<String, String> data = remoteMessage.getData();
            t9.i.f(data, "remoteMessage.data");
            c(data);
        }
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification != null) {
            b0.U(this, this.f12481a + ", Message Notification title: " + notification.getTitle());
            b0.U(this, this.f12481a + ", Message Notification Body: " + notification.getBody());
            b0.U(this, this.f12481a + ", Message Notification data: " + remoteMessage.getData());
        }
    }

    public void onNewToken(String str) {
        t9.i.g(str, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        super.onNewToken(str);
        b0.U(this, this.f12481a + ", Refreshed token: " + str);
        na.a.i(str);
        d();
    }
}
