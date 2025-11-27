package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f10363a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f10364b;

    public /* synthetic */ e(Context context, Intent intent) {
        this.f10363a = context;
        this.f10364b = intent;
    }

    public final Object call() {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(this.f10363a, this.f10364b));
    }
}
