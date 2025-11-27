package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CampaignCacheClient f10271a;

    public /* synthetic */ g(CampaignCacheClient campaignCacheClient) {
        this.f10271a = campaignCacheClient;
    }

    public final void accept(Object obj) {
        this.f10271a.lambda$get$3((Throwable) obj);
    }
}
