package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

public final /* synthetic */ class m implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10137a;

    public /* synthetic */ m(int i10) {
        this.f10137a = i10;
    }

    public final Object get() {
        return Striped.lambda$lazyWeakSemaphore$2(this.f10137a);
    }
}
