package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.functions.Function;

public final /* synthetic */ class g2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimitProto.RateLimit f10273a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RateLimit f10274b;

    public /* synthetic */ g2(RateLimitProto.RateLimit rateLimit, RateLimit rateLimit2) {
        this.f10273a = rateLimit;
        this.f10274b = rateLimit2;
    }

    public final Object apply(Object obj) {
        return RateLimiterClient.lambda$increment$1(this.f10273a, this.f10274b, (RateLimitProto.Counter) obj);
    }
}
