package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import io.reactivex.functions.Function;

public final /* synthetic */ class h2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f10278a;

    public /* synthetic */ h2(RateLimiterClient rateLimiterClient) {
        this.f10278a = rateLimiterClient;
    }

    public final Object apply(Object obj) {
        return this.f10278a.lambda$increment$3((RateLimitProto.RateLimit) obj);
    }
}
