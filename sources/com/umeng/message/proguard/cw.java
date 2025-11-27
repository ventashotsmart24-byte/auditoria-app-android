package com.umeng.message.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.atomic.AtomicBoolean;

public final class cw extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f15714a;

    public cw(AtomicBoolean atomicBoolean) {
        this.f15714a = atomicBoolean;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                this.f15714a.set(true);
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.f15714a.set(false);
            }
        }
    }
}
