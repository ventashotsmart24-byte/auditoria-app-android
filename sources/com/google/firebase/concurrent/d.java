package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f10168a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f10169b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f10170c;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.f10168a = delegatingScheduledExecutorService;
        this.f10169b = callable;
        this.f10170c = completer;
    }

    public final Object call() {
        return this.f10168a.lambda$schedule$4(this.f10169b, this.f10170c);
    }
}
