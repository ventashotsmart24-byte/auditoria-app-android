package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class f implements AsyncCallable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListeningExecutorService f10125a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f10126b;

    public /* synthetic */ f(ListeningExecutorService listeningExecutorService, Callable callable) {
        this.f10125a = listeningExecutorService;
        this.f10126b = callable;
    }

    public final ListenableFuture call() {
        return this.f10125a.submit(this.f10126b);
    }
}
