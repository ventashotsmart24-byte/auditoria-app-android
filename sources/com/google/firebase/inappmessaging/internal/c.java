package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Action;

public final /* synthetic */ class c implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignCacheClient f10252a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FetchEligibleCampaignsResponse f10253b;

    public /* synthetic */ c(CampaignCacheClient campaignCacheClient, FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.f10252a = campaignCacheClient;
        this.f10253b = fetchEligibleCampaignsResponse;
    }

    public final void run() {
        this.f10252a.lambda$put$0(this.f10253b);
    }
}
