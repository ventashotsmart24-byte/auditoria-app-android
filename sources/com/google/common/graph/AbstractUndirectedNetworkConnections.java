package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    public void addInEdge(E e10, N n10, boolean z10) {
        if (!z10) {
            addOutEdge(e10, n10);
        }
    }

    public void addOutEdge(E e10, N n10) {
        boolean z10;
        if (this.incidentEdgeMap.put(e10, n10) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
    }

    public N adjacentNode(E e10) {
        N n10 = this.incidentEdgeMap.get(e10);
        Objects.requireNonNull(n10);
        return n10;
    }

    public Set<E> inEdges() {
        return incidentEdges();
    }

    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    public Set<E> outEdges() {
        return incidentEdges();
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @CheckForNull
    public N removeInEdge(E e10, boolean z10) {
        if (!z10) {
            return removeOutEdge(e10);
        }
        return null;
    }

    public N removeOutEdge(E e10) {
        N remove = this.incidentEdgeMap.remove(e10);
        Objects.requireNonNull(remove);
        return remove;
    }

    public Set<N> successors() {
        return adjacentNodes();
    }
}
