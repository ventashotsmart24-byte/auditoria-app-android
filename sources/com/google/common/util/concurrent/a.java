package com.google.common.util.concurrent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AggregateFuture f10115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f10116b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10117c;

    public /* synthetic */ a(AggregateFuture aggregateFuture, ListenableFuture listenableFuture, int i10) {
        this.f10115a = aggregateFuture;
        this.f10116b = listenableFuture;
        this.f10117c = i10;
    }

    public final void run() {
        this.f10115a.lambda$init$0(this.f10116b, this.f10117c);
    }
}
