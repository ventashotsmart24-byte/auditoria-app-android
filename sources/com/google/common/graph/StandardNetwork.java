package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

@ElementTypesAreNonnullByDefault
class StandardNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<E> edgeOrder;
    final MapIteratorCache<E, N> edgeToReferenceNode;
    private final boolean isDirected;
    final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.nodeOrder.createMap(networkBuilder.expectedNodeCount.or(10).intValue()), networkBuilder.edgeOrder.createMap(networkBuilder.expectedEdgeCount.or(20).intValue()));
    }

    public Set<N> adjacentNodes(N n10) {
        return checkedConnections(n10).adjacentNodes();
    }

    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final NetworkConnections<N, E> checkedConnections(N n10) {
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n10);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.checkNotNull(n10);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[]{n10}));
    }

    public final N checkedReferenceNode(E e10) {
        N n10 = this.edgeToReferenceNode.get(e10);
        if (n10 != null) {
            return n10;
        }
        Preconditions.checkNotNull(e10);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", new Object[]{e10}));
    }

    public final boolean containsEdge(E e10) {
        return this.edgeToReferenceNode.containsKey(e10);
    }

    public final boolean containsNode(N n10) {
        return this.nodeConnections.containsKey(n10);
    }

    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    public Set<E> edgesConnecting(N n10, N n11) {
        NetworkConnections checkedConnections = checkedConnections(n10);
        if (!this.allowsSelfLoops && n10 == n11) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(n11), "Node %s is not an element of this graph.", (Object) n11);
        return checkedConnections.edgesConnecting(n11);
    }

    public Set<E> inEdges(N n10) {
        return checkedConnections(n10).inEdges();
    }

    public Set<E> incidentEdges(N n10) {
        return checkedConnections(n10).incidentEdges();
    }

    public EndpointPair<N> incidentNodes(E e10) {
        Object checkedReferenceNode = checkedReferenceNode(e10);
        NetworkConnections networkConnections = this.nodeConnections.get(checkedReferenceNode);
        Objects.requireNonNull(networkConnections);
        return EndpointPair.of((Network<?, ?>) this, checkedReferenceNode, networkConnections.adjacentNode(e10));
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

    public Set<E> outEdges(N n10) {
        return checkedConnections(n10).outEdges();
    }

    public Set<N> predecessors(N n10) {
        return checkedConnections(n10).predecessors();
    }

    public Set<N> successors(N n10) {
        return checkedConnections(n10).successors();
    }

    public StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        MapIteratorCache<N, NetworkConnections<N, E>> mapIteratorCache;
        this.isDirected = networkBuilder.directed;
        this.allowsParallelEdges = networkBuilder.allowsParallelEdges;
        this.allowsSelfLoops = networkBuilder.allowsSelfLoops;
        this.nodeOrder = networkBuilder.nodeOrder.cast();
        this.edgeOrder = networkBuilder.edgeOrder.cast();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(map);
        } else {
            mapIteratorCache = new MapIteratorCache<>(map);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeToReferenceNode = new MapIteratorCache<>(map2);
    }
}
