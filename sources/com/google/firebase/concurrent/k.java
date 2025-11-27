package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class k implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f10190a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10191b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10192c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f10193d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f10194e;

    public /* synthetic */ k(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        this.f10190a = delegatingScheduledExecutorService;
        this.f10191b = runnable;
        this.f10192c = j10;
        this.f10193d = j11;
        this.f10194e = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f10190a.lambda$scheduleAtFixedRate$8(this.f10191b, this.f10192c, this.f10193d, this.f10194e, completer);
    }
}
