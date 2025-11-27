package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a2 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f10245a;

    public /* synthetic */ a2(RateLimiterClient rateLimiterClient) {
        this.f10245a = rateLimiterClient;
    }

    public final void accept(Object obj) {
        this.f10245a.lambda$increment$2((RateLimitProto.RateLimit) obj);
    }
}
