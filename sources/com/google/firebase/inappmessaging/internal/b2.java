package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

public final /* synthetic */ class b2 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f10251a;

    public /* synthetic */ b2(RateLimiterClient rateLimiterClient) {
        this.f10251a = rateLimiterClient;
    }

    public final void accept(Object obj) {
        this.f10251a.lambda$getRateLimits$7((Throwable) obj);
    }
}
