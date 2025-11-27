package com.google.common.graph;

import com.google.common.graph.GraphConstants;

@ElementTypesAreNonnullByDefault
final class StandardMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    public StandardMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new StandardMutableValueGraph(abstractGraphBuilder);
    }

    public boolean addNode(N n10) {
        return this.backingValueGraph.addNode(n10);
    }

    public BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    public boolean putEdge(N n10, N n11) {
        return this.backingValueGraph.putEdgeValue(n10, n11, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    public boolean removeEdge(N n10, N n11) {
        return this.backingValueGraph.removeEdge(n10, n11) != null;
    }

    public boolean removeNode(N n10) {
        return this.backingValueGraph.removeNode(n10);
    }

    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
