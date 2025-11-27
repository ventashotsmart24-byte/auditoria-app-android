package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    public Set<E> adjacentEdges(E e10) {
        return delegate().adjacentEdges(e10);
    }

    public Set<N> adjacentNodes(N n10) {
        return delegate().adjacentNodes(n10);
    }

    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public int degree(N n10) {
        return delegate().degree(n10);
    }

    public abstract Network<N, E> delegate();

    @CheckForNull
    public E edgeConnectingOrNull(N n10, N n11) {
        return delegate().edgeConnectingOrNull(n10, n11);
    }

    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
    }

    public Set<E> edges() {
        return delegate().edges();
    }

    public Set<E> edgesConnecting(N n10, N n11) {
        return delegate().edgesConnecting(n10, n11);
    }

    public boolean hasEdgeConnecting(N n10, N n11) {
        return delegate().hasEdgeConnecting(n10, n11);
    }

    public int inDegree(N n10) {
        return delegate().inDegree(n10);
    }

    public Set<E> inEdges(N n10) {
        return delegate().inEdges(n10);
    }

    public Set<E> incidentEdges(N n10) {
        return delegate().incidentEdges(n10);
    }

    public EndpointPair<N> incidentNodes(E e10) {
        return delegate().incidentNodes(e10);
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

    public Set<E> outEdges(N n10) {
        return delegate().outEdges(n10);
    }

    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        return delegate().edgeConnectingOrNull(endpointPair);
    }

    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        return delegate().edgesConnecting(endpointPair);
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
