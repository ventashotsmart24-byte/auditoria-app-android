package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class j implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Network f10077a;

    public /* synthetic */ j(Network network) {
        this.f10077a = network;
    }

    public final Object apply(Object obj) {
        return this.f10077a.incidentNodes(obj).target();
    }
}
