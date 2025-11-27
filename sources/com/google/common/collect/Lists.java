package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Lists {

    public static class AbstractListWrapper<E> extends AbstractList<E> {
        final List<E> backingList;

        public AbstractListWrapper(List<E> list) {
            this.backingList = (List) Preconditions.checkNotNull(list);
        }

        public void add(int i10, @ParametricNullness E e10) {
            this.backingList.add(i10, e10);
        }

        public boolean addAll(int i10, Collection<? extends E> collection) {
            return this.backingList.addAll(i10, collection);
        }

        public boolean contains(@CheckForNull Object obj) {
            return this.backingList.contains(obj);
        }

        @ParametricNullness
        public E get(int i10) {
            return this.backingList.get(i10);
        }

        @ParametricNullness
        public E remove(int i10) {
            return this.backingList.remove(i10);
        }

        @ParametricNullness
        public E set(int i10, @ParametricNullness E e10) {
            return this.backingList.set(i10, e10);
        }

        public int size() {
            return this.backingList.size();
        }
    }

    public static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        public CharSequenceAsList(CharSequence charSequence) {
            this.sequence = charSequence;
        }

        public int size() {
            return this.sequence.length();
        }

        public Character get(int i10) {
            Preconditions.checkElementIndex(i10, size());
            return Character.valueOf(this.sequence.charAt(i10));
        }
    }

    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        final E first;
        final E[] rest;

        public OnePlusArrayList(@ParametricNullness E e10, E[] eArr) {
            this.first = e10;
            this.rest = (Object[]) Preconditions.checkNotNull(eArr);
        }

        @ParametricNullness
        public E get(int i10) {
            Preconditions.checkElementIndex(i10, size());
            if (i10 == 0) {
                return this.first;
            }
            return this.rest[i10 - 1];
        }

        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 1);
        }
    }

    public static class Partition<T> extends AbstractList<List<T>> {
        final List<T> list;
        final int size;

        public Partition(List<T> list2, int i10) {
            this.list = list2;
            this.size = i10;
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        public int size() {
            return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
        }

        public List<T> get(int i10) {
            Preconditions.checkElementIndex(i10, size());
            int i11 = this.size;
            int i12 = i10 * i11;
            return this.list.subList(i12, Math.min(i11 + i12, this.list.size()));
        }
    }

    public static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        public RandomAccessListWrapper(List<E> list) {
            super(list);
        }
    }

    public static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        public RandomAccessPartition(List<T> list, int i10) {
            super(list, i10);
        }
    }

    public static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        public RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    public static class ReverseList<T> extends AbstractList<T> {
        private final List<T> forwardList;

        public ReverseList(List<T> list) {
            this.forwardList = (List) Preconditions.checkNotNull(list);
        }

        private int reverseIndex(int i10) {
            int size = size();
            Preconditions.checkElementIndex(i10, size);
            return (size - 1) - i10;
        }

        /* access modifiers changed from: private */
        public int reversePosition(int i10) {
            int size = size();
            Preconditions.checkPositionIndex(i10, size);
            return size - i10;
        }

        public void add(int i10, @ParametricNullness T t10) {
            this.forwardList.add(reversePosition(i10), t10);
        }

        public void clear() {
            this.forwardList.clear();
        }

        @ParametricNullness
        public T get(int i10) {
            return this.forwardList.get(reverseIndex(i10));
        }

        public List<T> getForwardList() {
            return this.forwardList;
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i10) {
            final ListIterator<T> listIterator = this.forwardList.listIterator(reversePosition(i10));
            return new ListIterator<T>() {
                boolean canRemoveOrSet;

                public void add(@ParametricNullness T t10) {
                    listIterator.add(t10);
                    listIterator.previous();
                    this.canRemoveOrSet = false;
                }

                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                @ParametricNullness
                public T next() {
                    if (hasNext()) {
                        this.canRemoveOrSet = true;
                        return listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                public int nextIndex() {
                    return ReverseList.this.reversePosition(listIterator.nextIndex());
                }

                @ParametricNullness
                public T previous() {
                    if (hasPrevious()) {
                        this.canRemoveOrSet = true;
                        return listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                public int previousIndex() {
                    return nextIndex() - 1;
                }

                public void remove() {
                    CollectPreconditions.checkRemove(this.canRemoveOrSet);
                    listIterator.remove();
                    this.canRemoveOrSet = false;
                }

                public void set(@ParametricNullness T t10) {
                    Preconditions.checkState(this.canRemoveOrSet);
                    listIterator.set(t10);
                }
            };
        }

        @ParametricNullness
        public T remove(int i10) {
            return this.forwardList.remove(reverseIndex(i10));
        }

        public void removeRange(int i10, int i11) {
            subList(i10, i11).clear();
        }

        @ParametricNullness
        public T set(int i10, @ParametricNullness T t10) {
            return this.forwardList.set(reverseIndex(i10), t10);
        }

        public int size() {
            return this.forwardList.size();
        }

        public List<T> subList(int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11, size());
            return Lists.reverse(this.forwardList.subList(reversePosition(i11), reversePosition(i10)));
        }
    }

    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        public StringAsImmutableList(String str) {
            this.string = str;
        }

        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public boolean isPartialView() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public int size() {
            return this.string.length();
        }

        public Character get(int i10) {
            Preconditions.checkElementIndex(i10, size());
            return Character.valueOf(this.string.charAt(i10));
        }

        public ImmutableList<Character> subList(int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11, size());
            return Lists.charactersOf(this.string.substring(i10, i11));
        }
    }

    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        public TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        @ParametricNullness
        public T get(int i10) {
            return this.function.apply(this.fromList.get(i10));
        }

        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i10) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i10)) {
                public T transform(F f10) {
                    return TransformingRandomAccessList.this.function.apply(f10);
                }
            };
        }

        public T remove(int i10) {
            return this.function.apply(this.fromList.remove(i10));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        public TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        public ListIterator<T> listIterator(int i10) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i10)) {
                @ParametricNullness
                public T transform(@ParametricNullness F f10) {
                    return TransformingSequentialList.this.function.apply(f10);
                }
            };
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        final E first;
        final E[] rest;
        @ParametricNullness
        final E second;

        public TwoPlusArrayList(@ParametricNullness E e10, @ParametricNullness E e11, E[] eArr) {
            this.first = e10;
            this.second = e11;
            this.rest = (Object[]) Preconditions.checkNotNull(eArr);
        }

        @ParametricNullness
        public E get(int i10) {
            if (i10 == 0) {
                return this.first;
            }
            if (i10 == 1) {
                return this.second;
            }
            Preconditions.checkElementIndex(i10, size());
            return this.rest[i10 - 2];
        }

        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 2);
        }
    }

    private Lists() {
    }

    public static <E> boolean addAllImpl(List<E> list, int i10, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i10);
        boolean z10 = false;
        for (Object add : iterable) {
            listIterator.add(add);
            z10 = true;
        }
        return z10;
    }

    public static <E> List<E> asList(@ParametricNullness E e10, E[] eArr) {
        return new OnePlusArrayList(e10, eArr);
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        return CartesianList.create(list);
    }

    public static <T> List<T> cast(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(str));
    }

    @VisibleForTesting
    public static int computeArrayListCapacity(int i10) {
        CollectPreconditions.checkNonnegative(i10, "arraySize");
        return Ints.saturatedCast(((long) i10) + 5 + ((long) (i10 / 10)));
    }

    public static boolean equalsImpl(List<?> list, @CheckForNull Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.elementsEqual(list.iterator(), list2.iterator());
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!Objects.equal(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCodeImpl(List<?> list) {
        int i10;
        int i11 = 1;
        for (Object next : list) {
            int i12 = i11 * 31;
            if (next == null) {
                i10 = 0;
            } else {
                i10 = next.hashCode();
            }
            i11 = ((i12 + i10) ^ -1) ^ -1;
        }
        return i11;
    }

    public static int indexOfImpl(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return indexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int indexOfRandomAccess(List<?> list, @CheckForNull Object obj) {
        int size = list.size();
        int i10 = 0;
        if (obj == null) {
            while (i10 < size) {
                if (list.get(i10) == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < size) {
            if (obj.equals(list.get(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int lastIndexOfImpl(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return lastIndexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int lastIndexOfRandomAccess(List<?> list, @CheckForNull Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ListIterator<E> listIteratorImpl(List<E> list, int i10) {
        return new AbstractListWrapper(list).listIterator(i10);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int i10) {
        CollectPreconditions.checkNonnegative(i10, "initialArraySize");
        return new ArrayList<>(i10);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i10) {
        return new ArrayList<>(computeArrayListCapacity(i10));
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <T> List<List<T>> partition(List<T> list, int i10) {
        boolean z10;
        Preconditions.checkNotNull(list);
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        if (list instanceof RandomAccess) {
            return new RandomAccessPartition(list, i10);
        }
        return new Partition(list, i10);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof ReverseList) {
            return ((ReverseList) list).getForwardList();
        }
        if (list instanceof RandomAccess) {
            return new RandomAccessReverseList(list);
        }
        return new ReverseList(list);
    }

    public static <E> List<E> subListImpl(List<E> list, int i10, int i11) {
        List list2;
        if (list instanceof RandomAccess) {
            list2 = new RandomAccessListWrapper<E>(list) {
                private static final long serialVersionUID = 0;

                public ListIterator<E> listIterator(int i10) {
                    return this.backingList.listIterator(i10);
                }
            };
        } else {
            list2 = new AbstractListWrapper<E>(list) {
                private static final long serialVersionUID = 0;

                public ListIterator<E> listIterator(int i10) {
                    return this.backingList.listIterator(i10);
                }
            };
        }
        return list2.subList(i10, i11);
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        if (list instanceof RandomAccess) {
            return new TransformingRandomAccessList(list, function);
        }
        return new TransformingSequentialList(list, function);
    }

    public static <E> List<E> asList(@ParametricNullness E e10, @ParametricNullness E e11, E[] eArr) {
        return new TwoPlusArrayList(e10, e11, eArr);
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    @Beta
    public static List<Character> charactersOf(CharSequence charSequence) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    @GwtCompatible(serializable = true)
    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... eArr) {
        Preconditions.checkNotNull(eArr);
        ArrayList<E> arrayList = new ArrayList<>(computeArrayListCapacity(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> java.util.concurrent.CopyOnWriteArrayList<E> newCopyOnWriteArrayList(java.lang.Iterable<? extends E> r1) {
        /*
            boolean r0 = r1 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0007
            java.util.Collection r1 = (java.util.Collection) r1
            goto L_0x000b
        L_0x0007:
            java.util.ArrayList r1 = newArrayList(r1)
        L_0x000b:
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Lists.newCopyOnWriteArrayList(java.lang.Iterable):java.util.concurrent.CopyOnWriteArrayList");
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>((Collection) iterable);
        }
        return newArrayList(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it);
        return newArrayList;
    }
}
