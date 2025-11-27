package com.google.firebase.inappmessaging.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class z1 implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle f10342a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10343b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AnalyticsConnector.AnalyticsConnectorListener f10344c;

    public /* synthetic */ z1(ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle proxyAnalyticsConnectorHandle, String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f10342a = proxyAnalyticsConnectorHandle;
        this.f10343b = str;
        this.f10344c = analyticsConnectorListener;
    }

    public final void handle(Provider provider) {
        this.f10342a.lambda$new$0(this.f10343b, this.f10344c, provider);
    }
}
