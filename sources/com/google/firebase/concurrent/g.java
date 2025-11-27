package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f10175a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f10177c;

    public /* synthetic */ g(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f10175a = delegatingScheduledExecutorService;
        this.f10176b = runnable;
        this.f10177c = completer;
    }

    public final void run() {
        this.f10175a.lambda$scheduleAtFixedRate$7(this.f10176b, this.f10177c);
    }
}
