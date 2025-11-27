package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignCacheClient f10264a;

    public /* synthetic */ e(CampaignCacheClient campaignCacheClient) {
        this.f10264a = campaignCacheClient;
    }

    public final void accept(Object obj) {
        this.f10264a.lambda$get$2((FetchEligibleCampaignsResponse) obj);
    }
}
