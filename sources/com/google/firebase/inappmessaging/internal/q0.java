package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Function;

public final /* synthetic */ class q0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignProto.ThickContent f10312a;

    public /* synthetic */ q0(CampaignProto.ThickContent thickContent) {
        this.f10312a = thickContent;
    }

    public final Object apply(Object obj) {
        return InAppMessageStreamManager.lambda$getContentIfNotRateLimited$24(this.f10312a, (Boolean) obj);
    }
}
