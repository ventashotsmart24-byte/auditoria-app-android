package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
interface NetworkConnections<N, E> {
    void addInEdge(E e10, N n10, boolean z10);

    void addOutEdge(E e10, N n10);

    N adjacentNode(E e10);

    Set<N> adjacentNodes();

    Set<E> edgesConnecting(N n10);

    Set<E> inEdges();

    Set<E> incidentEdges();

    Set<E> outEdges();

    Set<N> predecessors();

    @CheckForNull
    @CanIgnoreReturnValue
    N removeInEdge(E e10, boolean z10);

    @CanIgnoreReturnValue
    N removeOutEdge(E e10);

    Set<N> successors();
}
