package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class y1 implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProxyAnalyticsConnector f10340a;

    public /* synthetic */ y1(ProxyAnalyticsConnector proxyAnalyticsConnector) {
        this.f10340a = proxyAnalyticsConnector;
    }

    public final void handle(Provider provider) {
        this.f10340a.lambda$new$0(provider);
    }
}
