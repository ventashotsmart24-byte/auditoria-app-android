package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f10355a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10356b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10357c;

    public /* synthetic */ b0(Context context, boolean z10, TaskCompletionSource taskCompletionSource) {
        this.f10355a = context;
        this.f10356b = z10;
        this.f10357c = taskCompletionSource;
    }

    public final void run() {
        ProxyNotificationInitializer.lambda$setEnableProxyNotification$0(this.f10355a, this.f10356b, this.f10357c);
    }
}
