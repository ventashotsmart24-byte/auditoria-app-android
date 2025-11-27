package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.functions.Function;

public final /* synthetic */ class e2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f10266a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RateLimit f10267b;

    public /* synthetic */ e2(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.f10266a = rateLimiterClient;
        this.f10267b = rateLimit;
    }

    public final Object apply(Object obj) {
        return this.f10266a.lambda$increment$4(this.f10267b, (RateLimitProto.RateLimit) obj);
    }
}
