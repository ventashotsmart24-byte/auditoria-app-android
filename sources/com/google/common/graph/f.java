package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f10074a;

    public /* synthetic */ f(Object obj) {
        this.f10074a = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.ordered(this.f10074a, obj);
    }
}
