package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class t1 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MetricsLoggerClient f10323a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessage f10324b;

    public /* synthetic */ t1(MetricsLoggerClient metricsLoggerClient, InAppMessage inAppMessage) {
        this.f10323a = metricsLoggerClient;
        this.f10324b = inAppMessage;
    }

    public final void onSuccess(Object obj) {
        this.f10323a.lambda$logMessageClick$1(this.f10324b, (String) obj);
    }
}
