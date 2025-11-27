package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class k implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Network f10078a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10079b;

    public /* synthetic */ k(Network network, Object obj) {
        this.f10078a = network;
        this.f10079b = obj;
    }

    public final Object apply(Object obj) {
        return this.f10078a.incidentNodes(obj).adjacentNode(this.f10079b);
    }
}
