package com.efs.sdk.base.core.d;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;

public abstract class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public ControllerCenter f5251a;

    public a() {
        super(com.efs.sdk.base.core.util.concurrent.a.f5313a.getLooper());
        sendEmptyMessageDelayed(0, 60000);
    }

    public abstract void a();

    public void handleMessage(Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000);
    }
}
