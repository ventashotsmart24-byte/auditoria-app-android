package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b1 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsEventsManager f10250a;

    public /* synthetic */ b1(AnalyticsEventsManager analyticsEventsManager) {
        this.f10250a = analyticsEventsManager;
    }

    public final void accept(Object obj) {
        this.f10250a.updateContextualTriggers((FetchEligibleCampaignsResponse) obj);
    }
}
