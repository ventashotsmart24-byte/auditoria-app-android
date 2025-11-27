package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class d implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f10360a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f10361b;

    public /* synthetic */ d(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f10360a = enhancedIntentService;
        this.f10361b = intent;
    }

    public final void onComplete(Task task) {
        this.f10360a.lambda$onStartCommand$1(this.f10361b, task);
    }
}
