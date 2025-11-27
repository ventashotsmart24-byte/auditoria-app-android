package com.google.firebase.concurrent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomThreadFactory f10160a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10161b;

    public /* synthetic */ a(CustomThreadFactory customThreadFactory, Runnable runnable) {
        this.f10160a = customThreadFactory;
        this.f10161b = runnable;
    }

    public final void run() {
        this.f10160a.lambda$newThread$0(this.f10161b);
    }
}
