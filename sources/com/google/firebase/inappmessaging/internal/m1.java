package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Function;

public final /* synthetic */ class m1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10299a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10300b;

    public /* synthetic */ m1(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        this.f10299a = inAppMessageStreamManager;
        this.f10300b = str;
    }

    public final Object apply(Object obj) {
        return this.f10299a.lambda$createFirebaseInAppMessageStream$12(this.f10300b, (CampaignProto.ThickContent) obj);
    }
}
