package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LazySet f10152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Provider f10153b;

    public /* synthetic */ k(LazySet lazySet, Provider provider) {
        this.f10152a = lazySet;
        this.f10153b = provider;
    }

    public final void run() {
        this.f10152a.add(this.f10153b);
    }
}
