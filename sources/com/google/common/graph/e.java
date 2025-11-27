package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f10073a;

    public /* synthetic */ e(Object obj) {
        this.f10073a = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.ordered(obj, this.f10073a);
    }
}
