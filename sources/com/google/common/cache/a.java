package com.google.common.cache;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RemovalListener f10053a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemovalNotification f10054b;

    public /* synthetic */ a(RemovalListener removalListener, RemovalNotification removalNotification) {
        this.f10053a = removalListener;
        this.f10054b = removalNotification;
    }

    public final void run() {
        this.f10053a.onRemoval(this.f10054b);
    }
}
