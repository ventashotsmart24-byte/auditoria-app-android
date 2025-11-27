package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AggregateFuture f10118a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImmutableCollection f10119b;

    public /* synthetic */ b(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        this.f10118a = aggregateFuture;
        this.f10119b = immutableCollection;
    }

    public final void run() {
        this.f10118a.lambda$init$1(this.f10119b);
    }
}
