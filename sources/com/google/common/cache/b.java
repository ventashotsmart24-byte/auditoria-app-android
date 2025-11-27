package com.google.common.cache;

import java.util.concurrent.Executor;

public final /* synthetic */ class b implements RemovalListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f10055a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemovalListener f10056b;

    public /* synthetic */ b(Executor executor, RemovalListener removalListener) {
        this.f10055a = executor;
        this.f10056b = removalListener;
    }

    public final void onRemoval(RemovalNotification removalNotification) {
        this.f10055a.execute(new a(this.f10056b, removalNotification));
    }
}
