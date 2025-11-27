package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Network f10076a;

    public /* synthetic */ i(Network network) {
        this.f10076a = network;
    }

    public final Object apply(Object obj) {
        return this.f10076a.incidentNodes(obj).source();
    }
}
