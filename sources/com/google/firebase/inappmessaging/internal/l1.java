package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Function;

public final /* synthetic */ class l1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10295a;

    public /* synthetic */ l1(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f10295a = inAppMessageStreamManager;
    }

    public final Object apply(Object obj) {
        return this.f10295a.lambda$createFirebaseInAppMessageStream$11((CampaignProto.ThickContent) obj);
    }
}
