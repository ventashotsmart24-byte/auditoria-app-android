package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignCacheClient f10268a;

    public /* synthetic */ f(CampaignCacheClient campaignCacheClient) {
        this.f10268a = campaignCacheClient;
    }

    public final boolean test(Object obj) {
        return this.f10268a.isResponseValid((FetchEligibleCampaignsResponse) obj);
    }
}
