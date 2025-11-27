package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public interface ValueGraph<N, V> extends BaseGraph<N> {
    Set<N> adjacentNodes(N n10);

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n10);

    @CheckForNull
    V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v10);

    @CheckForNull
    V edgeValueOrDefault(N n10, N n11, @CheckForNull V v10);

    Set<EndpointPair<N>> edges();

    boolean equals(@CheckForNull Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n10, N n11);

    int hashCode();

    int inDegree(N n10);

    ElementOrder<N> incidentEdgeOrder();

    Set<EndpointPair<N>> incidentEdges(N n10);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n10);

    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    Set<N> predecessors(N n10);

    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    Set<N> successors(N n10);
}
