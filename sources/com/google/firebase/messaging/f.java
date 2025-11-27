package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f10370a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f10371b;

    public /* synthetic */ f(Context context, Intent intent) {
        this.f10370a = context;
        this.f10371b = intent;
    }

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2(this.f10370a, this.f10371b, task);
    }
}
