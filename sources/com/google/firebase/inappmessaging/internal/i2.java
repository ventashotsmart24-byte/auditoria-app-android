package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import io.reactivex.functions.Action;

public final /* synthetic */ class i2 implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f10283a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RateLimitProto.RateLimit f10284b;

    public /* synthetic */ i2(RateLimiterClient rateLimiterClient, RateLimitProto.RateLimit rateLimit) {
        this.f10283a = rateLimiterClient;
        this.f10284b = rateLimit;
    }

    public final void run() {
        this.f10283a.lambda$increment$2(this.f10284b);
    }
}
