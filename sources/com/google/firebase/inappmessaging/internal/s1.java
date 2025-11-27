package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class s1 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MetricsLoggerClient f10321a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessage f10322b;

    public /* synthetic */ s1(MetricsLoggerClient metricsLoggerClient, InAppMessage inAppMessage) {
        this.f10321a = metricsLoggerClient;
        this.f10322b = inAppMessage;
    }

    public final void onSuccess(Object obj) {
        this.f10321a.lambda$logImpression$0(this.f10322b, (String) obj);
    }
}
