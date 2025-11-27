package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class StandardMutableValueGraph<N, V> extends StandardValueGraph<N, V> implements MutableValueGraph<N, V> {
    private final ElementOrder<N> incidentEdgeOrder;

    public StandardMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
        this.incidentEdgeOrder = abstractGraphBuilder.incidentEdgeOrder.cast();
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> addNodeInternal(N n10) {
        boolean z10;
        GraphConnections<N, V> newConnections = newConnections();
        if (this.nodeConnections.put(n10, newConnections) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        return newConnections;
    }

    private GraphConnections<N, V> newConnections() {
        if (isDirected()) {
            return DirectedGraphConnections.of(this.incidentEdgeOrder);
        }
        return UndirectedGraphConnections.of(this.incidentEdgeOrder);
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

    public ElementOrder<N> incidentEdgeOrder() {
        return this.incidentEdgeOrder;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V putEdgeValue(N n10, N n11, V v10) {
        Preconditions.checkNotNull(n10, "nodeU");
        Preconditions.checkNotNull(n11, "nodeV");
        Preconditions.checkNotNull(v10, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n10.equals(n11), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", (Object) n10);
        }
        GraphConnections graphConnections = this.nodeConnections.get(n10);
        if (graphConnections == null) {
            graphConnections = addNodeInternal(n10);
        }
        V addSuccessor = graphConnections.addSuccessor(n11, v10);
        GraphConnections graphConnections2 = this.nodeConnections.get(n11);
        if (graphConnections2 == null) {
            graphConnections2 = addNodeInternal(n11);
        }
        graphConnections2.addPredecessor(n10, v10);
        if (addSuccessor == null) {
            long j10 = this.edgeCount + 1;
            this.edgeCount = j10;
            Graphs.checkPositive(j10);
        }
        return addSuccessor;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V removeEdge(N n10, N n11) {
        Preconditions.checkNotNull(n10, "nodeU");
        Preconditions.checkNotNull(n11, "nodeV");
        GraphConnections graphConnections = this.nodeConnections.get(n10);
        GraphConnections graphConnections2 = this.nodeConnections.get(n11);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        V removeSuccessor = graphConnections.removeSuccessor(n11);
        if (removeSuccessor != null) {
            graphConnections2.removePredecessor(n10);
            long j10 = this.edgeCount - 1;
            this.edgeCount = j10;
            Graphs.checkNonNegative(j10);
        }
        return removeSuccessor;
    }

    @CanIgnoreReturnValue
    public boolean removeNode(N n10) {
        boolean z10;
        Preconditions.checkNotNull(n10, "node");
        GraphConnections graphConnections = this.nodeConnections.get(n10);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(n10) != null) {
            graphConnections.removePredecessor(n10);
            this.edgeCount--;
        }
        for (Object withoutCaching : graphConnections.successors()) {
            GraphConnections withoutCaching2 = this.nodeConnections.getWithoutCaching(withoutCaching);
            Objects.requireNonNull(withoutCaching2);
            withoutCaching2.removePredecessor(n10);
            this.edgeCount--;
        }
        if (isDirected()) {
            for (Object withoutCaching3 : graphConnections.predecessors()) {
                GraphConnections withoutCaching4 = this.nodeConnections.getWithoutCaching(withoutCaching3);
                Objects.requireNonNull(withoutCaching4);
                if (withoutCaching4.removeSuccessor(n10) != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkState(z10);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(n10);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V putEdgeValue(EndpointPair<N> endpointPair, V v10) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v10);
    }
}
