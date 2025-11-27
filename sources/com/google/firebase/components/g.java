package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class g implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10147a;

    public /* synthetic */ g(String str) {
        this.f10147a = str;
    }

    public final Object get() {
        return ComponentDiscovery.instantiate(this.f10147a);
    }
}
