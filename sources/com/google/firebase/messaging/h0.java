package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f10376a;

    public /* synthetic */ h0(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f10376a = bindRequest;
    }

    public final void run() {
        this.f10376a.lambda$arrangeTimeout$0();
    }
}
