package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OptionalProvider f10148a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Provider f10149b;

    public /* synthetic */ i(OptionalProvider optionalProvider, Provider provider) {
        this.f10148a = optionalProvider;
        this.f10149b = provider;
    }

    public final void run() {
        this.f10148a.set(this.f10149b);
    }
}
