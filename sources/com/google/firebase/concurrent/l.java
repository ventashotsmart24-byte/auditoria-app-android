package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f10195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10196b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f10197c;

    public /* synthetic */ l(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f10195a = delegatingScheduledExecutorService;
        this.f10196b = runnable;
        this.f10197c = completer;
    }

    public final void run() {
        this.f10195a.lambda$schedule$1(this.f10196b, this.f10197c);
    }
}
