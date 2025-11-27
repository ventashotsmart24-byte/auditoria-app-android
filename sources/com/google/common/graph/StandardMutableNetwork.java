package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
final class StandardMutableNetwork<N, E> extends StandardNetwork<N, E> implements MutableNetwork<N, E> {
    public StandardMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    @CanIgnoreReturnValue
    private NetworkConnections<N, E> addNodeInternal(N n10) {
        boolean z10;
        NetworkConnections<N, E> newConnections = newConnections();
        if (this.nodeConnections.put(n10, newConnections) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        return newConnections;
    }

    private NetworkConnections<N, E> newConnections() {
        if (isDirected()) {
            if (allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.of();
            }
            return DirectedNetworkConnections.of();
        } else if (allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.of();
        } else {
            return UndirectedNetworkConnections.of();
        }
    }

    @CanIgnoreReturnValue
    public boolean addEdge(N n10, N n11, E e10) {
        Preconditions.checkNotNull(n10, "nodeU");
        Preconditions.checkNotNull(n11, "nodeV");
        Preconditions.checkNotNull(e10, "edge");
        boolean z10 = false;
        if (containsEdge(e10)) {
            EndpointPair incidentNodes = incidentNodes(e10);
            EndpointPair of = EndpointPair.of((Network<?, ?>) this, n10, n11);
            Preconditions.checkArgument(incidentNodes.equals(of), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e10, incidentNodes, of);
            return false;
        }
        NetworkConnections networkConnections = this.nodeConnections.get(n10);
        if (!allowsParallelEdges()) {
            if (networkConnections == null || !networkConnections.successors().contains(n11)) {
                z10 = true;
            }
            Preconditions.checkArgument(z10, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", (Object) n10, (Object) n11);
        }
        boolean equals = n10.equals(n11);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", (Object) n10);
        }
        if (networkConnections == null) {
            networkConnections = addNodeInternal(n10);
        }
        networkConnections.addOutEdge(e10, n11);
        NetworkConnections networkConnections2 = this.nodeConnections.get(n11);
        if (networkConnections2 == null) {
            networkConnections2 = addNodeInternal(n11);
        }
        networkConnections2.addInEdge(e10, n10, equals);
        this.edgeToReferenceNode.put(e10, n10);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addNode(N n10) {
        Preconditions.checkNotNull(n10, "node");
        if (containsNode(n10)) {
            return false;
        }
        addNodeInternal(n10);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean removeEdge(E e10) {
        Preconditions.checkNotNull(e10, "edge");
        N n10 = this.edgeToReferenceNode.get(e10);
        boolean z10 = false;
        if (n10 == null) {
            return false;
        }
        NetworkConnections networkConnections = this.nodeConnections.get(n10);
        Objects.requireNonNull(networkConnections);
        NetworkConnections networkConnections2 = networkConnections;
        Object adjacentNode = networkConnections2.adjacentNode(e10);
        NetworkConnections networkConnections3 = this.nodeConnections.get(adjacentNode);
        Objects.requireNonNull(networkConnections3);
        NetworkConnections networkConnections4 = networkConnections3;
        networkConnections2.removeOutEdge(e10);
        if (allowsSelfLoops() && n10.equals(adjacentNode)) {
            z10 = true;
        }
        networkConnections4.removeInEdge(e10, z10);
        this.edgeToReferenceNode.remove(e10);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean removeNode(N n10) {
        Preconditions.checkNotNull(n10, "node");
        NetworkConnections networkConnections = this.nodeConnections.get(n10);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator it = ImmutableList.copyOf(networkConnections.incidentEdges()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.remove(n10);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addEdge(EndpointPair<N> endpointPair, E e10) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e10);
    }
}
