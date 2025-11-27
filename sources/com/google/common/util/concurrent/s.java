package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f10138a;

    public /* synthetic */ s(Callable callable) {
        this.f10138a = callable;
    }

    public final void run() {
        WrappingExecutorService.lambda$wrapTask$0(this.f10138a);
    }
}
