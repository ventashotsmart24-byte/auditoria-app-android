package com.google.firebase.messaging;

import android.content.Intent;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FcmLifecycleCallbacks f10374a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f10375b;

    public /* synthetic */ h(FcmLifecycleCallbacks fcmLifecycleCallbacks, Intent intent) {
        this.f10374a = fcmLifecycleCallbacks;
        this.f10375b = intent;
    }

    public final void run() {
        this.f10374a.lambda$onActivityCreated$0(this.f10375b);
    }
}
