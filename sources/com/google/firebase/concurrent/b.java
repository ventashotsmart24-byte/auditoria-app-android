package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f10162a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f10163b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10164c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f10165d;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, long j10, TimeUnit timeUnit) {
        this.f10162a = delegatingScheduledExecutorService;
        this.f10163b = callable;
        this.f10164c = j10;
        this.f10165d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f10162a.lambda$schedule$5(this.f10163b, this.f10164c, this.f10165d, completer);
    }
}
