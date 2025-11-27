package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10136a;

    public /* synthetic */ l(int i10) {
        this.f10136a = i10;
    }

    public final Object get() {
        return Striped.lambda$semaphore$1(this.f10136a);
    }
}
