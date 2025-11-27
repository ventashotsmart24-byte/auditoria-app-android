package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class h implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f10178a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10180c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f10181d;

    public /* synthetic */ h(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j10, TimeUnit timeUnit) {
        this.f10178a = delegatingScheduledExecutorService;
        this.f10179b = runnable;
        this.f10180c = j10;
        this.f10181d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f10178a.lambda$schedule$2(this.f10179b, this.f10180c, this.f10181d, completer);
    }
}
