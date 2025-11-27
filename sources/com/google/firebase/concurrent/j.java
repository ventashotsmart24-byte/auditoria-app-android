package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f10187a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10188b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f10189c;

    public /* synthetic */ j(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f10187a = delegatingScheduledExecutorService;
        this.f10188b = runnable;
        this.f10189c = completer;
    }

    public final void run() {
        this.f10187a.lambda$scheduleWithFixedDelay$10(this.f10188b, this.f10189c);
    }
}
