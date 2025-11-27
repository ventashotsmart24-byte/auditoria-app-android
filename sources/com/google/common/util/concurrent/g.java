package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionSequencer;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrustedListenableFutureTask f10127a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f10128b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f10129c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f10130d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExecutionSequencer.TaskNonReentrantExecutor f10131e;

    public /* synthetic */ g(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor) {
        this.f10127a = trustedListenableFutureTask;
        this.f10128b = settableFuture;
        this.f10129c = listenableFuture;
        this.f10130d = listenableFuture2;
        this.f10131e = taskNonReentrantExecutor;
    }

    public final void run() {
        ExecutionSequencer.lambda$submitAsync$0(this.f10127a, this.f10128b, this.f10129c, this.f10130d, this.f10131e);
    }
}
