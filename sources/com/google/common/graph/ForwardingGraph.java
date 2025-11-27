package com.google.common.graph;

import java.util.Set;

@ElementTypesAreNonnullByDefault
abstract class ForwardingGraph<N> extends AbstractGraph<N> {
    public Set<N> adjacentNodes(N n10) {
        return delegate().adjacentNodes(n10);
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public int degree(N n10) {
        return delegate().degree(n10);
    }

    public abstract BaseGraph<N> delegate();

    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    public boolean hasEdgeConnecting(N n10, N n11) {
        return delegate().hasEdgeConnecting(n10, n11);
    }

    public int inDegree(N n10) {
        return delegate().inDegree(n10);
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return delegate().incidentEdgeOrder();
    }

    public Set<EndpointPair<N>> incidentEdges(N n10) {
        return delegate().incidentEdges(n10);
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    public int outDegree(N n10) {
        return delegate().outDegree(n10);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    public Set<N> predecessors(N n10) {
        return delegate().predecessors((Object) n10);
    }

    public Set<N> successors(N n10) {
        return delegate().successors((Object) n10);
    }
}
