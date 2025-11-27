package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());
    private static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    private final transient long[] cumulativeCounts;
    @VisibleForTesting
    final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int i10) {
        long[] jArr = this.cumulativeCounts;
        int i11 = this.offset;
        return (int) (jArr[(i11 + i10) + 1] - jArr[i11 + i10]);
    }

    public int count(@CheckForNull Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return getCount(indexOf);
        }
        return 0;
    }

    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    public Multiset.Entry<E> getEntry(int i10) {
        return Multisets.immutableEntry(this.elementSet.asList().get(i10), getCount(i10));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i11, this.length);
        if (i10 == i11) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        if (i10 == 0 && i11 == this.length) {
            return this;
        }
        return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i10, i11), this.cumulativeCounts, this.offset + i10, i11 - i10);
    }

    public boolean isPartialView() {
        if (this.offset > 0 || this.length < this.cumulativeCounts.length - 1) {
            return true;
        }
        return false;
    }

    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.length - 1);
    }

    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i10 = this.offset;
        return Ints.saturatedCast(jArr[this.length + i10] - jArr[i10]);
    }

    public ImmutableSortedMultiset<E> headMultiset(E e10, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e10, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    public ImmutableSortedMultiset<E> tailMultiset(E e10, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e10, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }

    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i10, int i11) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i10;
        this.length = i11;
    }
}
