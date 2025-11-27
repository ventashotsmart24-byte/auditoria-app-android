package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    @Beta
    public class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    @CheckForNull
    public E ceiling(@ParametricNullness E e10) {
        return delegate().ceiling(e10);
    }

    public abstract NavigableSet<E> delegate();

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @CheckForNull
    public E floor(@ParametricNullness E e10) {
        return delegate().floor(e10);
    }

    public NavigableSet<E> headSet(@ParametricNullness E e10, boolean z10) {
        return delegate().headSet(e10, z10);
    }

    @CheckForNull
    public E higher(@ParametricNullness E e10) {
        return delegate().higher(e10);
    }

    @CheckForNull
    public E lower(@ParametricNullness E e10) {
        return delegate().lower(e10);
    }

    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @CheckForNull
    public E standardCeiling(@ParametricNullness E e10) {
        return Iterators.getNext(tailSet(e10, true).iterator(), null);
    }

    @ParametricNullness
    public E standardFirst() {
        return iterator().next();
    }

    @CheckForNull
    public E standardFloor(@ParametricNullness E e10) {
        return Iterators.getNext(headSet(e10, true).descendingIterator(), null);
    }

    public SortedSet<E> standardHeadSet(@ParametricNullness E e10) {
        return headSet(e10, false);
    }

    @CheckForNull
    public E standardHigher(@ParametricNullness E e10) {
        return Iterators.getNext(tailSet(e10, false).iterator(), null);
    }

    @ParametricNullness
    public E standardLast() {
        return descendingIterator().next();
    }

    @CheckForNull
    public E standardLower(@ParametricNullness E e10) {
        return Iterators.getNext(headSet(e10, false).descendingIterator(), null);
    }

    @CheckForNull
    public E standardPollFirst() {
        return Iterators.pollNext(iterator());
    }

    @CheckForNull
    public E standardPollLast() {
        return Iterators.pollNext(descendingIterator());
    }

    @Beta
    public NavigableSet<E> standardSubSet(@ParametricNullness E e10, boolean z10, @ParametricNullness E e11, boolean z11) {
        return tailSet(e10, z10).headSet(e11, z11);
    }

    public SortedSet<E> standardTailSet(@ParametricNullness E e10) {
        return tailSet(e10, true);
    }

    public NavigableSet<E> subSet(@ParametricNullness E e10, boolean z10, @ParametricNullness E e11, boolean z11) {
        return delegate().subSet(e10, z10, e11, z11);
    }

    public NavigableSet<E> tailSet(@ParametricNullness E e10, boolean z10) {
        return delegate().tailSet(e10, z10);
    }

    public SortedSet<E> standardSubSet(@ParametricNullness E e10, @ParametricNullness E e11) {
        return subSet(e10, true, e11, false);
    }
}
