package com.google.common.eventbus;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Subscriber f10068a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10069b;

    public /* synthetic */ a(Subscriber subscriber, Object obj) {
        this.f10068a = subscriber;
        this.f10069b = obj;
    }

    public final void run() {
        this.f10068a.lambda$dispatchEvent$0(this.f10069b);
    }
}
