package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JdkFutureAdapters.ListenableFutureAdapter f10132a;

    public /* synthetic */ h(JdkFutureAdapters.ListenableFutureAdapter listenableFutureAdapter) {
        this.f10132a = listenableFutureAdapter;
    }

    public final void run() {
        this.f10132a.lambda$addListener$0();
    }
}
