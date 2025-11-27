package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Function;

public final /* synthetic */ class k1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignProto.ThickContent f10291a;

    public /* synthetic */ k1(CampaignProto.ThickContent thickContent) {
        this.f10291a = thickContent;
    }

    public final Object apply(Object obj) {
        return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$10(this.f10291a, (Boolean) obj);
    }
}
