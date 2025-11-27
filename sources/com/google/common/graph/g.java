package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.DirectedGraphConnections;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f10075a;

    public /* synthetic */ g(Object obj) {
        this.f10075a = obj;
    }

    public final Object apply(Object obj) {
        return DirectedGraphConnections.lambda$incidentEdgeIterator$2(this.f10075a, (DirectedGraphConnections.NodeConnection) obj);
    }
}
