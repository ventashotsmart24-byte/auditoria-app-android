package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Function;

public final /* synthetic */ class m0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10297a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10298b;

    public /* synthetic */ m0(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        this.f10297a = inAppMessageStreamManager;
        this.f10298b = str;
    }

    public final Object apply(Object obj) {
        return this.f10297a.lambda$getTriggeredInAppMessageMaybe$27(this.f10298b, (CampaignProto.ThickContent) obj);
    }
}
