package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import io.reactivex.functions.Action;

public final /* synthetic */ class b0 implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImpressionStorageClient f10248a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignImpressionList f10249b;

    public /* synthetic */ b0(ImpressionStorageClient impressionStorageClient, CampaignImpressionList campaignImpressionList) {
        this.f10248a = impressionStorageClient;
        this.f10249b = campaignImpressionList;
    }

    public final void run() {
        this.f10248a.lambda$storeImpression$0(this.f10249b);
    }
}
