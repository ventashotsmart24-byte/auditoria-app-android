package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class d2 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f10262a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RateLimit f10263b;

    public /* synthetic */ d2(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.f10262a = rateLimiterClient;
        this.f10263b = rateLimit;
    }

    public final boolean test(Object obj) {
        return this.f10262a.lambda$isRateLimited$6(this.f10263b, (RateLimitProto.Counter) obj);
    }
}
