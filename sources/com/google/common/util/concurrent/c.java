package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f10120a;

    public /* synthetic */ c(Object obj) {
        this.f10120a = obj;
    }

    public final Object call() {
        return Callables.lambda$returning$0(this.f10120a);
    }
}
