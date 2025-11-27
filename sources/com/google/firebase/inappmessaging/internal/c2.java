package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.functions.Function;

public final /* synthetic */ class c2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f10257a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RateLimit f10258b;

    public /* synthetic */ c2(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.f10257a = rateLimiterClient;
        this.f10258b = rateLimit;
    }

    public final Object apply(Object obj) {
        return this.f10257a.lambda$isRateLimited$5(this.f10258b, (RateLimitProto.RateLimit) obj);
    }
}
