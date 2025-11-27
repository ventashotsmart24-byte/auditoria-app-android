package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f10352a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f10353b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10354c;

    public /* synthetic */ b(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f10352a = enhancedIntentService;
        this.f10353b = intent;
        this.f10354c = taskCompletionSource;
    }

    public final void run() {
        this.f10352a.lambda$processIntent$0(this.f10353b, this.f10354c);
    }
}
