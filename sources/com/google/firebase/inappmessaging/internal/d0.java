package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Action;

public final /* synthetic */ class d0 implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImpressionStorageClient f10260a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignImpressionList f10261b;

    public /* synthetic */ d0(ImpressionStorageClient impressionStorageClient, CampaignImpressionList campaignImpressionList) {
        this.f10260a = impressionStorageClient;
        this.f10261b = campaignImpressionList;
    }

    public final void run() {
        this.f10260a.lambda$clearImpressions$3(this.f10261b);
    }
}
