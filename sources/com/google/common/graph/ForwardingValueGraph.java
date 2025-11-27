package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    public Set<N> adjacentNodes(N n10) {
        return delegate().adjacentNodes(n10);
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public int degree(N n10) {
        return delegate().degree(n10);
    }

    public abstract ValueGraph<N, V> delegate();

    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    @CheckForNull
    public V edgeValueOrDefault(N n10, N n11, @CheckForNull V v10) {
        return delegate().edgeValueOrDefault(n10, n11, v10);
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

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v10) {
        return delegate().edgeValueOrDefault(endpointPair, v10);
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
