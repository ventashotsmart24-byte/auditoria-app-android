package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class u1 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MetricsLoggerClient f10325a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessage f10326b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType f10327c;

    public /* synthetic */ u1(MetricsLoggerClient metricsLoggerClient, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        this.f10325a = metricsLoggerClient;
        this.f10326b = inAppMessage;
        this.f10327c = inAppMessagingDismissType;
    }

    public final void onSuccess(Object obj) {
        this.f10325a.lambda$logDismiss$3(this.f10326b, this.f10327c, (String) obj);
    }
}
