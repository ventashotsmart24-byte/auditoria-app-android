package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Supplier f10121a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10122b;

    public /* synthetic */ d(Supplier supplier, Runnable runnable) {
        this.f10121a = supplier;
        this.f10122b = runnable;
    }

    public final void run() {
        Callables.lambda$threadRenaming$3(this.f10121a, this.f10122b);
    }
}
