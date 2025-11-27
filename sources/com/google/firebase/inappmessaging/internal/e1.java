package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e1 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10265a;

    public /* synthetic */ e1(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f10265a = inAppMessageStreamManager;
    }

    public final void accept(Object obj) {
        this.f10265a.lambda$createFirebaseInAppMessageStream$6((FetchEligibleCampaignsResponse) obj);
    }
}
