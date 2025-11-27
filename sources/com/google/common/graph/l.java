package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class l implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ValueGraph f10080a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10081b;

    public /* synthetic */ l(ValueGraph valueGraph, Object obj) {
        this.f10080a = valueGraph;
        this.f10081b = obj;
    }

    public final Object apply(Object obj) {
        return ImmutableValueGraph.lambda$connectionsOf$0(this.f10080a, this.f10081b, obj);
    }
}
