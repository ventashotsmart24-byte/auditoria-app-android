package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    public int degree(N n10) {
        int i10;
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((Object) n10).size(), successors((Object) n10).size());
        }
        Set adjacentNodes = adjacentNodes(n10);
        if (!allowsSelfLoops() || !adjacentNodes.contains(n10)) {
            i10 = 0;
        } else {
            i10 = 1;
        }
        return IntMath.saturatedAdd(adjacentNodes.size(), i10);
    }

    public long edgeCount() {
        boolean z10;
        long j10 = 0;
        for (Object degree : nodes()) {
            j10 += (long) degree(degree);
        }
        if ((1 & j10) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        return j10 >>> 1;
    }

    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() {
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!AbstractBaseGraph.this.isOrderingCompatible(endpointPair) || !AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) || !AbstractBaseGraph.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }

            public boolean remove(@CheckForNull Object obj) {
                throw new UnsupportedOperationException();
            }

            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }
        };
    }

    public boolean hasEdgeConnecting(N n10, N n11) {
        Preconditions.checkNotNull(n10);
        Preconditions.checkNotNull(n11);
        return nodes().contains(n10) && successors((Object) n10).contains(n11);
    }

    public int inDegree(N n10) {
        if (isDirected()) {
            return predecessors((Object) n10).size();
        }
        return degree(n10);
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    public Set<EndpointPair<N>> incidentEdges(N n10) {
        Preconditions.checkNotNull(n10);
        Preconditions.checkArgument(nodes().contains(n10), "Node %s is not an element of this graph.", (Object) n10);
        return new IncidentEdgeSet<N>(this, this, n10) {
            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair lambda$iterator$0(Object obj) {
                return EndpointPair.ordered(obj, this.node);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair lambda$iterator$1(Object obj) {
                return EndpointPair.ordered(this.node, obj);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair lambda$iterator$2(Object obj) {
                return EndpointPair.unordered(this.node, obj);
            }

            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                if (this.graph.isDirected()) {
                    return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors((Object) this.node).iterator(), new a(this)), Iterators.transform(Sets.difference(this.graph.successors((Object) this.node), ImmutableSet.of(this.node)).iterator(), new b(this))));
                }
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new c(this)));
            }
        };
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        if (endpointPair.isOrdered() || !isDirected()) {
            return true;
        }
        return false;
    }

    public int outDegree(N n10) {
        if (isDirected()) {
            return successors((Object) n10).size();
        }
        return degree(n10);
    }

    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors(obj);
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        N nodeV = endpointPair.nodeV();
        if (!nodes().contains(nodeU) || !successors((Object) nodeU).contains(nodeV)) {
            return false;
        }
        return true;
    }
}
