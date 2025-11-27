package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f10133a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10134b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f10135c;

    public /* synthetic */ k(Method method, Object obj, Object[] objArr) {
        this.f10133a = method;
        this.f10134b = obj;
        this.f10135c = objArr;
    }

    public final Object call() {
        return SimpleTimeLimiter.AnonymousClass1.lambda$invoke$0(this.f10133a, this.f10134b, this.f10135c);
    }
}
