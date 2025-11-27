package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Supplier f10123a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f10124b;

    public /* synthetic */ e(Supplier supplier, Callable callable) {
        this.f10123a = supplier;
        this.f10124b = callable;
    }

    public final Object call() {
        return Callables.lambda$threadRenaming$2(this.f10123a, this.f10124b);
    }
}
