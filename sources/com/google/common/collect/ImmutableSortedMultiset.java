package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    @CheckForNull
    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        private final Comparator<? super E> comparator;
        private int[] counts = new int[4];
        @VisibleForTesting
        E[] elements = new Object[4];
        private boolean forceCopyElements;
        private int length;

        public Builder(Comparator<? super E> comparator2) {
            super(true);
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        private void dedupAndCoalesce(boolean z10) {
            int i10 = this.length;
            if (i10 != 0) {
                E[] copyOf = Arrays.copyOf(this.elements, i10);
                Arrays.sort(copyOf, this.comparator);
                int i11 = 1;
                for (int i12 = 1; i12 < copyOf.length; i12++) {
                    if (this.comparator.compare(copyOf[i11 - 1], copyOf[i12]) < 0) {
                        copyOf[i11] = copyOf[i12];
                        i11++;
                    }
                }
                Arrays.fill(copyOf, i11, this.length, (Object) null);
                if (z10) {
                    int i13 = i11 * 4;
                    int i14 = this.length;
                    if (i13 > i14 * 3) {
                        copyOf = Arrays.copyOf(copyOf, IntMath.saturatedAdd(i14, (i14 / 2) + 1));
                    }
                }
                int[] iArr = new int[copyOf.length];
                for (int i15 = 0; i15 < this.length; i15++) {
                    int binarySearch = Arrays.binarySearch(copyOf, 0, i11, this.elements[i15], this.comparator);
                    int i16 = this.counts[i15];
                    if (i16 >= 0) {
                        iArr[binarySearch] = iArr[binarySearch] + i16;
                    } else {
                        iArr[binarySearch] = i16 ^ -1;
                    }
                }
                this.elements = copyOf;
                this.counts = iArr;
                this.length = i11;
            }
        }

        private void dedupAndCoalesceAndDeleteEmpty() {
            dedupAndCoalesce(false);
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = this.length;
                if (i10 < i12) {
                    int[] iArr = this.counts;
                    int i13 = iArr[i10];
                    if (i13 > 0) {
                        E[] eArr = this.elements;
                        eArr[i11] = eArr[i10];
                        iArr[i11] = i13;
                        i11++;
                    }
                    i10++;
                } else {
                    Arrays.fill(this.elements, i11, i12, (Object) null);
                    Arrays.fill(this.counts, i11, this.length, 0);
                    this.length = i11;
                    return;
                }
            }
        }

        private void maintenance() {
            int i10 = this.length;
            E[] eArr = this.elements;
            if (i10 == eArr.length) {
                dedupAndCoalesce(true);
            } else if (this.forceCopyElements) {
                this.elements = Arrays.copyOf(eArr, eArr.length);
            }
            this.forceCopyElements = false;
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e10, int i10) {
            Preconditions.checkNotNull(e10);
            CollectPreconditions.checkNonnegative(i10, "occurrences");
            if (i10 == 0) {
                return this;
            }
            maintenance();
            E[] eArr = this.elements;
            int i11 = this.length;
            eArr[i11] = e10;
            this.counts[i11] = i10;
            this.length = i11 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> setCount(E e10, int i10) {
            Preconditions.checkNotNull(e10);
            CollectPreconditions.checkNonnegative(i10, "count");
            maintenance();
            E[] eArr = this.elements;
            int i11 = this.length;
            eArr[i11] = e10;
            this.counts[i11] = i10 ^ -1;
            this.length = i11 + 1;
            return this;
        }

        public ImmutableSortedMultiset<E> build() {
            dedupAndCoalesceAndDeleteEmpty();
            int i10 = this.length;
            if (i10 == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.comparator);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.comparator, i10, this.elements);
            long[] jArr = new long[(this.length + 1)];
            int i11 = 0;
            while (i11 < this.length) {
                int i12 = i11 + 1;
                jArr[i12] = jArr[i11] + ((long) this.counts[i11]);
                i11 = i12;
            }
            this.forceCopyElements = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.length);
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e10) {
            return addCopies((Object) e10, 1);
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry entry : ((Multiset) iterable).entrySet()) {
                    addCopies(entry.getElement(), entry.getCount());
                }
            } else {
                for (Object add : iterable) {
                    add((Object) add);
                }
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            for (E add : eArr) {
                add((Object) add);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            while (it.hasNext()) {
                add((Object) it.next());
            }
            return this;
        }
    }

    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public SerializedForm(SortedMultiset<E> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i10 = 0;
            for (Multiset.Entry next : sortedMultiset.entrySet()) {
                this.elements[i10] = next.getElement();
                this.counts[i10] = next.getCount();
                i10++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            Builder builder = new Builder(this.comparator);
            for (int i10 = 0; i10 < length; i10++) {
                builder.addCopies((Object) this.elements[i10], this.counts[i10]);
            }
            return builder.build();
        }
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        return copyOf(Ordering.natural(), Arrays.asList(eArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.Builder builder = new ImmutableList.Builder(collection.size());
        long[] jArr = new long[(collection.size() + 1)];
        int i10 = 0;
        for (Multiset.Entry next : collection) {
            builder.add(next.getElement());
            int i11 = i10 + 1;
            jArr[i11] = jArr[i10] + ((long) next.getCount());
            i10 = i11;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(builder.build(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e10, BoundType boundType);

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e10, BoundType boundType);

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e10) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(e10), new long[]{0, 1}, 0, 1);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            if (isEmpty()) {
                immutableSortedMultiset = emptyMultiset(Ordering.from(comparator()).reverse());
            } else {
                immutableSortedMultiset = new DescendingImmutableSortedMultiset<>(this);
            }
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    public ImmutableSortedMultiset<E> subMultiset(E e10, BoundType boundType, E e11, BoundType boundType2) {
        Preconditions.checkArgument(comparator().compare(e10, e11) <= 0, "Expected lowerBound <= upperBound but %s > %s", (Object) e10, (Object) e11);
        return tailMultiset(e10, boundType).headMultiset(e11, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e10, E e11) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e10, e11}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        Preconditions.checkNotNull(comparator);
        return new Builder(comparator).addAll((Iterator) it).build();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e10, E e11, E e12) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e10, e11, e12}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e10, E e11, E e12, E e13) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e10, e11, e12, e13}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new Builder(comparator).addAll((Iterable) iterable).build();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e10, E e11, E e12, E e13, E e14) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e10, e11, e12, e13, e14}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(eArr.length + 6);
        Collections.addAll(newArrayListWithCapacity, new Comparable[]{e10, e11, e12, e13, e14, e15});
        Collections.addAll(newArrayListWithCapacity, eArr);
        return copyOf(Ordering.natural(), newArrayListWithCapacity);
    }
}
