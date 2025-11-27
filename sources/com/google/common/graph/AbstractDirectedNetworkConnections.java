package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> inEdgeMap;
    final Map<E, N> outEdgeMap;
    /* access modifiers changed from: private */
    public int selfLoopCount;

    public AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i10) {
        boolean z10;
        this.inEdgeMap = (Map) Preconditions.checkNotNull(map);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(map2);
        this.selfLoopCount = Graphs.checkNonNegative(i10);
        if (i10 > map.size() || i10 > map2.size()) {
            z10 = false;
        } else {
            z10 = true;
        }
        Preconditions.checkState(z10);
    }

    public void addInEdge(E e10, N n10, boolean z10) {
        Preconditions.checkNotNull(e10);
        Preconditions.checkNotNull(n10);
        boolean z11 = true;
        if (z10) {
            int i10 = this.selfLoopCount + 1;
            this.selfLoopCount = i10;
            Graphs.checkPositive(i10);
        }
        if (this.inEdgeMap.put(e10, n10) != null) {
            z11 = false;
        }
        Preconditions.checkState(z11);
    }

    public void addOutEdge(E e10, N n10) {
        boolean z10;
        Preconditions.checkNotNull(e10);
        Preconditions.checkNotNull(n10);
        if (this.outEdgeMap.put(e10, n10) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
    }

    public N adjacentNode(E e10) {
        N n10 = this.outEdgeMap.get(e10);
        Objects.requireNonNull(n10);
        return n10;
    }

    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    public Set<E> incidentEdges() {
        return new AbstractSet<E>() {
            public boolean contains(@CheckForNull Object obj) {
                if (AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj)) {
                    return true;
                }
                return false;
            }

            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }

            public UnmodifiableIterator<E> iterator() {
                Iterable<T> iterable;
                if (AbstractDirectedNetworkConnections.this.selfLoopCount == 0) {
                    iterable = Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                } else {
                    iterable = Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                }
                return Iterators.unmodifiableIterator(iterable.iterator());
            }
        };
    }

    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    public N removeInEdge(E e10, boolean z10) {
        if (z10) {
            int i10 = this.selfLoopCount - 1;
            this.selfLoopCount = i10;
            Graphs.checkNonNegative(i10);
        }
        N remove = this.inEdgeMap.remove(e10);
        Objects.requireNonNull(remove);
        return remove;
    }

    public N removeOutEdge(E e10) {
        N remove = this.outEdgeMap.remove(e10);
        Objects.requireNonNull(remove);
        return remove;
    }
}
