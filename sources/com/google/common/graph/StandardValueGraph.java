package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    long edgeCount;
    private final boolean isDirected;
    final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(abstractGraphBuilder.expectedNodeCount.or(10).intValue()), 0);
    }

    private final GraphConnections<N, V> checkedConnections(N n10) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n10);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n10);
        String valueOf = String.valueOf(n10);
        StringBuilder sb = new StringBuilder(valueOf.length() + 38);
        sb.append("Node ");
        sb.append(valueOf);
        sb.append(" is not an element of this graph.");
        throw new IllegalArgumentException(sb.toString());
    }

    @CheckForNull
    private final V edgeValueOrDefaultInternal(N n10, N n11, @CheckForNull V v10) {
        V v11;
        GraphConnections graphConnections = this.nodeConnections.get(n10);
        if (graphConnections == null) {
            v11 = null;
        } else {
            v11 = graphConnections.value(n11);
        }
        if (v11 == null) {
            return v10;
        }
        return v11;
    }

    private final boolean hasEdgeConnectingInternal(N n10, N n11) {
        GraphConnections graphConnections = this.nodeConnections.get(n10);
        if (graphConnections == null || !graphConnections.successors().contains(n11)) {
            return false;
        }
        return true;
    }

    public Set<N> adjacentNodes(N n10) {
        return checkedConnections(n10).adjacentNodes();
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final boolean containsNode(@CheckForNull N n10) {
        return this.nodeConnections.containsKey(n10);
    }

    public long edgeCount() {
        return this.edgeCount;
    }

    @CheckForNull
    public V edgeValueOrDefault(N n10, N n11, @CheckForNull V v10) {
        return edgeValueOrDefaultInternal(Preconditions.checkNotNull(n10), Preconditions.checkNotNull(n11), v10);
    }

    public boolean hasEdgeConnecting(N n10, N n11) {
        return hasEdgeConnectingInternal(Preconditions.checkNotNull(n10), Preconditions.checkNotNull(n11));
    }

    public Set<EndpointPair<N>> incidentEdges(N n10) {
        final GraphConnections checkedConnections = checkedConnections(n10);
        return new IncidentEdgeSet<N>(this, this, n10) {
            public Iterator<EndpointPair<N>> iterator() {
                return checkedConnections.incidentEdgeIterator(this.node);
            }
        };
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v10) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefaultInternal(endpointPair.nodeU(), endpointPair.nodeV(), v10);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnectingInternal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public Set<N> predecessors(N n10) {
        return checkedConnections(n10).predecessors();
    }

    public Set<N> successors(N n10) {
        return checkedConnections(n10).successors();
    }

    public StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j10) {
        MapIteratorCache<N, GraphConnections<N, V>> mapIteratorCache;
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = abstractGraphBuilder.nodeOrder.cast();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(map);
        } else {
            mapIteratorCache = new MapIteratorCache<>(map);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeCount = Graphs.checkNonNegative(j10);
    }
}
