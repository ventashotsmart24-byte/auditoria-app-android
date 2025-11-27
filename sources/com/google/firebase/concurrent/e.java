package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f10171a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f10172b;

    public /* synthetic */ e(Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.f10171a = callable;
        this.f10172b = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$schedule$3(this.f10171a, this.f10172b);
    }
}
