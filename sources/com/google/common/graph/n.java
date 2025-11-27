package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class n implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f10082a;

    public /* synthetic */ n(Object obj) {
        this.f10082a = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.unordered(this.f10082a, obj);
    }
}
