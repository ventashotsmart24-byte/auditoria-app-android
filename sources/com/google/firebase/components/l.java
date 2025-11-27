package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class l implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f10154a;

    public /* synthetic */ l(ComponentRegistrar componentRegistrar) {
        this.f10154a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.lambda$toProviders$1(this.f10154a);
    }
}
