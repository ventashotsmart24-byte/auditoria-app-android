package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N n10);

    @CheckForNull
    @CanIgnoreReturnValue
    V putEdgeValue(EndpointPair<N> endpointPair, V v10);

    @CheckForNull
    @CanIgnoreReturnValue
    V putEdgeValue(N n10, N n11, V v10);

    @CheckForNull
    @CanIgnoreReturnValue
    V removeEdge(EndpointPair<N> endpointPair);

    @CheckForNull
    @CanIgnoreReturnValue
    V removeEdge(N n10, N n11);

    @CanIgnoreReturnValue
    boolean removeNode(N n10);
}
