package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a1 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10244a;

    public /* synthetic */ a1(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f10244a = inAppMessageStreamManager;
    }

    public final void accept(Object obj) {
        this.f10244a.lambda$createFirebaseInAppMessageStream$18((FetchEligibleCampaignsResponse) obj);
    }
}
