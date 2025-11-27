package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class i implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f10182a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10183b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10184c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f10185d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f10186e;

    public /* synthetic */ i(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        this.f10182a = delegatingScheduledExecutorService;
        this.f10183b = runnable;
        this.f10184c = j10;
        this.f10185d = j11;
        this.f10186e = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f10182a.lambda$scheduleWithFixedDelay$11(this.f10183b, this.f10184c, this.f10185d, this.f10186e, completer);
    }
}
