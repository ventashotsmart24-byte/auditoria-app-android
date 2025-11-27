package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Function;

public final /* synthetic */ class y0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10338a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignImpressionList f10339b;

    public /* synthetic */ y0(InAppMessageStreamManager inAppMessageStreamManager, CampaignImpressionList campaignImpressionList) {
        this.f10338a = inAppMessageStreamManager;
        this.f10339b = campaignImpressionList;
    }

    public final Object apply(Object obj) {
        return this.f10338a.lambda$createFirebaseInAppMessageStream$16(this.f10339b, (InstallationIdResult) obj);
    }
}
