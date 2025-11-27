package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class SortedMultisets {

    public static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {
        @Weak
        private final SortedMultiset<E> multiset;

        public ElementSet(SortedMultiset<E> sortedMultiset) {
            this.multiset = sortedMultiset;
        }

        public Comparator<? super E> comparator() {
            return multiset().comparator();
        }

        @ParametricNullness
        public E first() {
            return SortedMultisets.getElementOrThrow(multiset().firstEntry());
        }

        public SortedSet<E> headSet(@ParametricNullness E e10) {
            return multiset().headMultiset(e10, BoundType.OPEN).elementSet();
        }

        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        @ParametricNullness
        public E last() {
            return SortedMultisets.getElementOrThrow(multiset().lastEntry());
        }

        public SortedSet<E> subSet(@ParametricNullness E e10, @ParametricNullness E e11) {
            return multiset().subMultiset(e10, BoundType.CLOSED, e11, BoundType.OPEN).elementSet();
        }

        public SortedSet<E> tailSet(@ParametricNullness E e10) {
            return multiset().tailMultiset(e10, BoundType.CLOSED).elementSet();
        }

        public final SortedMultiset<E> multiset() {
            return this.multiset;
        }
    }

    @GwtIncompatible
    public static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        public NavigableElementSet(SortedMultiset<E> sortedMultiset) {
            super(sortedMultiset);
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e10) {
            return SortedMultisets.getElementOrNull(multiset().tailMultiset(e10, BoundType.CLOSED).firstEntry());
        }

        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<E> descendingSet() {
            return new NavigableElementSet(multiset().descendingMultiset());
        }

        @CheckForNull
        public E floor(@ParametricNullness E e10) {
            return SortedMultisets.getElementOrNull(multiset().headMultiset(e10, BoundType.CLOSED).lastEntry());
        }

        public NavigableSet<E> headSet(@ParametricNullness E e10, boolean z10) {
            return new NavigableElementSet(multiset().headMultiset(e10, BoundType.forBoolean(z10)));
        }

        @CheckForNull
        public E higher(@ParametricNullness E e10) {
            return SortedMultisets.getElementOrNull(multiset().tailMultiset(e10, BoundType.OPEN).firstEntry());
        }

        @CheckForNull
        public E lower(@ParametricNullness E e10) {
            return SortedMultisets.getElementOrNull(multiset().headMultiset(e10, BoundType.OPEN).lastEntry());
        }

        @CheckForNull
        public E pollFirst() {
            return SortedMultisets.getElementOrNull(multiset().pollFirstEntry());
        }

        @CheckForNull
        public E pollLast() {
            return SortedMultisets.getElementOrNull(multiset().pollLastEntry());
        }

        public NavigableSet<E> subSet(@ParametricNullness E e10, boolean z10, @ParametricNullness E e11, boolean z11) {
            return new NavigableElementSet(multiset().subMultiset(e10, BoundType.forBoolean(z10), e11, BoundType.forBoolean(z11)));
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e10, boolean z10) {
            return new NavigableElementSet(multiset().tailMultiset(e10, BoundType.forBoolean(z10)));
        }
    }

    private SortedMultisets() {
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public static <E> E getElementOrNull(@CheckForNull Multiset.Entry<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }

    /* access modifiers changed from: private */
    public static <E> E getElementOrThrow(@CheckForNull Multiset.Entry<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }
}
