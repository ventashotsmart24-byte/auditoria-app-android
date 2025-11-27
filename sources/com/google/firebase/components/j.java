package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class j implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRuntime f10150a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f10151b;

    public /* synthetic */ j(ComponentRuntime componentRuntime, Component component) {
        this.f10150a = componentRuntime;
        this.f10151b = component;
    }

    public final Object get() {
        return this.f10150a.lambda$discoverComponents$0(this.f10151b);
    }
}
