package com.google.firebase.inappmessaging.internal;

import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignCacheClient f10259a;

    public /* synthetic */ d(CampaignCacheClient campaignCacheClient) {
        this.f10259a = campaignCacheClient;
    }

    public final Object call() {
        return this.f10259a.lambda$get$1();
    }
}
