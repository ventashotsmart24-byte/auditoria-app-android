package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
    final transient Comparator<? super E> comparator;
    @GwtIncompatible
    @CheckForNull
    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> comparator;

        public Builder(Comparator<? super E> comparator2) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        @CanIgnoreReturnValue
        public Builder<E> combine(ImmutableSet.Builder<E> builder) {
            super.combine(builder);
            return this;
        }

        public ImmutableSortedSet<E> build() {
            ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.comparator, this.size, this.contents);
            this.size = construct.size();
            this.forceCopy = true;
            return construct;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable) iterable);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e10) {
            super.add((Object) e10);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }
    }

    public static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator2, Object[] objArr) {
            this.comparator = comparator2;
            this.elements = objArr;
        }

        public Object readResolve() {
            return new Builder(this.comparator).add(this.elements).build();
        }
    }

    public ImmutableSortedSet(Comparator<? super E> comparator2) {
        this.comparator = comparator2;
    }

    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator2, int i10, E... eArr) {
        if (i10 == 0) {
            return emptySet(comparator2);
        }
        ObjectArrays.checkElementsNotNull(eArr, i10);
        Arrays.sort(eArr, 0, i10, comparator2);
        int i11 = 1;
        for (int i12 = 1; i12 < i10; i12++) {
            E e10 = eArr[i12];
            if (comparator2.compare(e10, eArr[i11 - 1]) != 0) {
                eArr[i11] = e10;
                i11++;
            }
        }
        Arrays.fill(eArr, i11, i10, (Object) null);
        if (i11 < eArr.length / 2) {
            eArr = Arrays.copyOf(eArr, i11);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i11), comparator2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] eArr) {
        return construct(Ordering.natural(), eArr.length, (Comparable[]) eArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator2 = SortedIterables.comparator(sortedSet);
        ImmutableList<E> copyOf = ImmutableList.copyOf(sortedSet);
        if (copyOf.isEmpty()) {
            return emptySet(comparator2);
        }
        return new RegularImmutableSortedSet(copyOf, comparator2);
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator2) {
        if (Ordering.natural().equals(comparator2)) {
            return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
        }
        return new RegularImmutableSortedSet<>(ImmutableList.of(), comparator2);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator2) {
        return new Builder<>(comparator2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Collections.reverseOrder());
    }

    @CheckForNull
    public E ceiling(E e10) {
        return Iterables.getFirst(tailSet(e10, true), null);
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @GwtIncompatible
    public abstract ImmutableSortedSet<E> createDescendingSet();

    @GwtIncompatible
    public abstract UnmodifiableIterator<E> descendingIterator();

    public E first() {
        return iterator().next();
    }

    @CheckForNull
    public E floor(E e10) {
        return Iterators.getNext(headSet(e10, true).descendingIterator(), null);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E e10, boolean z10);

    @CheckForNull
    @GwtIncompatible
    public E higher(E e10) {
        return Iterables.getFirst(tailSet(e10, false), null);
    }

    public abstract int indexOf(@CheckForNull Object obj);

    public abstract UnmodifiableIterator<E> iterator();

    public E last() {
        return descendingIterator().next();
    }

    @CheckForNull
    @GwtIncompatible
    public E lower(E e10) {
        return Iterators.getNext(headSet(e10, false).descendingIterator(), null);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableSortedSet<E> subSetImpl(E e10, boolean z10, E e11, boolean z11);

    public abstract ImmutableSortedSet<E> tailSetImpl(E e10, boolean z10);

    public int unsafeCompare(Object obj, @CheckForNull Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e10) {
        return new RegularImmutableSortedSet(ImmutableList.of(e10), Ordering.natural());
    }

    public static int unsafeCompare(Comparator<?> comparator2, Object obj, @CheckForNull Object obj2) {
        return comparator2.compare(obj, obj2);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e10, E e11) {
        return construct(Ordering.natural(), 2, e10, e11);
    }

    public ImmutableSortedSet<E> headSet(E e10) {
        return headSet(e10, false);
    }

    public ImmutableSortedSet<E> subSet(E e10, E e11) {
        return subSet(e10, true, e11, false);
    }

    public ImmutableSortedSet<E> tailSet(E e10) {
        return tailSet(e10, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf(Ordering.natural(), collection);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e10, E e11, E e12) {
        return construct(Ordering.natural(), 3, e10, e11, e12);
    }

    public ImmutableSortedSet<E> headSet(E e10, boolean z10) {
        return headSetImpl(Preconditions.checkNotNull(e10), z10);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E e10, boolean z10, E e11, boolean z11) {
        Preconditions.checkNotNull(e10);
        Preconditions.checkNotNull(e11);
        Preconditions.checkArgument(this.comparator.compare(e10, e11) <= 0);
        return subSetImpl(e10, z10, e11, z11);
    }

    public ImmutableSortedSet<E> tailSet(E e10, boolean z10) {
        return tailSetImpl(Preconditions.checkNotNull(e10), z10);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e10, E e11, E e12, E e13) {
        return construct(Ordering.natural(), 4, e10, e11, e12, e13);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e10, E e11, E e12, E e13, E e14) {
        return construct(Ordering.natural(), 5, e10, e11, e12, e13, e14);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        int length = eArr.length + 6;
        Comparable[] comparableArr = new Comparable[length];
        comparableArr[0] = e10;
        comparableArr[1] = e11;
        comparableArr[2] = e12;
        comparableArr[3] = e13;
        comparableArr[4] = e14;
        comparableArr[5] = e15;
        System.arraycopy(eArr, 0, comparableArr, 6, eArr.length);
        return construct(Ordering.natural(), length, comparableArr);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Iterator<? extends E> it) {
        return new Builder(comparator2).addAll((Iterator) it).build();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(comparator2);
        if (SortedIterables.hasSameComparator(comparator2, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] array = Iterables.toArray(iterable);
        return construct(comparator2, array.length, array);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Collection<? extends E> collection) {
        return copyOf(comparator2, collection);
    }
}
