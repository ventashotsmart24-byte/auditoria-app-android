package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class v1 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MetricsLoggerClient f10328a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InAppMessage f10329b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason f10330c;

    public /* synthetic */ v1(MetricsLoggerClient metricsLoggerClient, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        this.f10328a = metricsLoggerClient;
        this.f10329b = inAppMessage;
        this.f10330c = inAppMessagingErrorReason;
    }

    public final void onSuccess(Object obj) {
        this.f10328a.lambda$logRenderError$2(this.f10329b, this.f10330c, (String) obj);
    }
}
