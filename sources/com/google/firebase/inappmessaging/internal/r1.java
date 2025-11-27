package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;

public final /* synthetic */ class r1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10316a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Maybe f10317b;

    public /* synthetic */ r1(InAppMessageStreamManager inAppMessageStreamManager, Maybe maybe) {
        this.f10316a = inAppMessageStreamManager;
        this.f10317b = maybe;
    }

    public final Object apply(Object obj) {
        return this.f10316a.lambda$createFirebaseInAppMessageStream$20(this.f10317b, (CampaignImpressionList) obj);
    }
}
