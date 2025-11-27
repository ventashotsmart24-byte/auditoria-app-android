package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> forward;

    public DescendingImmutableSortedSet(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.forward = immutableSortedSet;
    }

    @CheckForNull
    public E ceiling(E e10) {
        return this.forward.floor(e10);
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.forward.contains(obj);
    }

    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> createDescendingSet() {
        throw new AssertionError("should never be called");
    }

    @CheckForNull
    public E floor(E e10) {
        return this.forward.ceiling(e10);
    }

    public ImmutableSortedSet<E> headSetImpl(E e10, boolean z10) {
        return this.forward.tailSet(e10, z10).descendingSet();
    }

    @CheckForNull
    public E higher(E e10) {
        return this.forward.lower(e10);
    }

    public int indexOf(@CheckForNull Object obj) {
        int indexOf = this.forward.indexOf(obj);
        if (indexOf == -1) {
            return indexOf;
        }
        return (size() - 1) - indexOf;
    }

    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    @CheckForNull
    public E lower(E e10) {
        return this.forward.higher(e10);
    }

    public int size() {
        return this.forward.size();
    }

    public ImmutableSortedSet<E> subSetImpl(E e10, boolean z10, E e11, boolean z11) {
        return this.forward.subSet(e11, z11, e10, z10).descendingSet();
    }

    public ImmutableSortedSet<E> tailSetImpl(E e10, boolean z10) {
        return this.forward.headSet(e10, z10).descendingSet();
    }

    @GwtIncompatible("NavigableSet")
    public UnmodifiableIterator<E> descendingIterator() {
        return this.forward.iterator();
    }

    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> descendingSet() {
        return this.forward;
    }

    public UnmodifiableIterator<E> iterator() {
        return this.forward.descendingIterator();
    }
}
