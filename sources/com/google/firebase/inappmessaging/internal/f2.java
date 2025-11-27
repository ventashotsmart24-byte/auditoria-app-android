package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class f2 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f10269a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RateLimit f10270b;

    public /* synthetic */ f2(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.f10269a = rateLimiterClient;
        this.f10270b = rateLimit;
    }

    public final boolean test(Object obj) {
        return this.f10269a.lambda$increment$0(this.f10270b, (RateLimitProto.Counter) obj);
    }
}
