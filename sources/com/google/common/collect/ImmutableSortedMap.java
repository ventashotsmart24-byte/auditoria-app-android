package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final long serialVersionUID = 0;
    @CheckForNull
    private transient ImmutableSortedMap<K, V> descendingMap;
    /* access modifiers changed from: private */
    public final transient RegularImmutableSortedSet<K> keySet;
    /* access modifiers changed from: private */
    public final transient ImmutableList<V> valueList;

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;
        private transient Object[] keys;
        private transient Object[] values;

        public Builder(Comparator<? super K> comparator2) {
            this(comparator2, 4);
        }

        private void ensureCapacity(int i10) {
            Object[] objArr = this.keys;
            if (i10 > objArr.length) {
                int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArr.length, i10);
                this.keys = Arrays.copyOf(this.keys, expandedCapacity);
                this.values = Arrays.copyOf(this.values, expandedCapacity);
            }
        }

        @CanIgnoreReturnValue
        public Builder<K, V> combine(Builder<K, V> builder) {
            ensureCapacity(this.size + builder.size);
            System.arraycopy(builder.keys, 0, this.keys, this.size, builder.size);
            System.arraycopy(builder.values, 0, this.values, this.size, builder.size);
            this.size += builder.size;
            return this;
        }

        private Builder(Comparator<? super K> comparator2, int i10) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
            this.keys = new Object[i10];
            this.values = new Object[i10];
        }

        public ImmutableSortedMap<K, V> build() {
            return buildOrThrow();
        }

        @DoNotCall
        @Deprecated
        public final ImmutableSortedMap<K, V> buildKeepingLast() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        public ImmutableSortedMap<K, V> buildOrThrow() {
            int i10 = this.size;
            if (i10 == 0) {
                return ImmutableSortedMap.emptyMap(this.comparator);
            }
            if (i10 != 1) {
                Object[] copyOf = Arrays.copyOf(this.keys, i10);
                Arrays.sort(copyOf, this.comparator);
                Object[] objArr = new Object[this.size];
                for (int i11 = 0; i11 < this.size; i11++) {
                    if (i11 > 0) {
                        int i12 = i11 - 1;
                        if (this.comparator.compare(copyOf[i12], copyOf[i11]) == 0) {
                            String valueOf = String.valueOf(copyOf[i12]);
                            String valueOf2 = String.valueOf(copyOf[i11]);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
                            sb.append("keys required to be distinct but compared as equal: ");
                            sb.append(valueOf);
                            sb.append(" and ");
                            sb.append(valueOf2);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    Object obj = this.keys[i11];
                    Objects.requireNonNull(obj);
                    int binarySearch = Arrays.binarySearch(copyOf, obj, this.comparator);
                    Object obj2 = this.values[i11];
                    Objects.requireNonNull(obj2);
                    objArr[binarySearch] = obj2;
                }
                return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(copyOf), this.comparator), ImmutableList.asImmutableList(objArr));
            }
            Comparator<? super K> comparator2 = this.comparator;
            Object obj3 = this.keys[0];
            Objects.requireNonNull(obj3);
            Object obj4 = this.values[0];
            Objects.requireNonNull(obj4);
            return ImmutableSortedMap.of(comparator2, obj3, obj4);
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        @Beta
        public final Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator2) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k10, V v10) {
            ensureCapacity(this.size + 1);
            CollectPreconditions.checkEntryNotNull(k10, v10);
            Object[] objArr = this.keys;
            int i10 = this.size;
            objArr[i10] = k10;
            this.values[i10] = v10;
            this.size = i10 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll(map);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put(entry);
            return this;
        }
    }

    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        public SerializedForm(ImmutableSortedMap<K, V> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        public Builder<K, V> makeBuilder(int i10) {
            return new Builder<>(this.comparator);
        }
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, (ImmutableSortedMap) null);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, (Ordering) NATURAL_ORDER);
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z10 = false;
        if (map instanceof SortedMap) {
            Comparator comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                z10 = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                z10 = true;
            }
        }
        if (z10 && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, z10, map.entrySet());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.SortedMap<K, ? extends V>, java.util.SortedMap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> copyOfSorted(java.util.SortedMap<K, ? extends V> r3) {
        /*
            java.util.Comparator r0 = r3.comparator()
            if (r0 != 0) goto L_0x0008
            java.util.Comparator<java.lang.Comparable> r0 = NATURAL_ORDER
        L_0x0008:
            boolean r1 = r3 instanceof com.google.common.collect.ImmutableSortedMap
            if (r1 == 0) goto L_0x0016
            r1 = r3
            com.google.common.collect.ImmutableSortedMap r1 = (com.google.common.collect.ImmutableSortedMap) r1
            boolean r2 = r1.isPartialView()
            if (r2 != 0) goto L_0x0016
            return r1
        L_0x0016:
            r1 = 1
            java.util.Set r3 = r3.entrySet()
            com.google.common.collect.ImmutableSortedMap r3 = fromEntries(r0, r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSortedMap.copyOfSorted(java.util.SortedMap):com.google.common.collect.ImmutableSortedMap");
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return of();
        }
        return new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntries(Ordering.natural(), false, entryArr, entryArr.length);
    }

    private ImmutableSortedMap<K, V> getSubMap(int i10, int i11) {
        if (i10 == 0 && i11 == size()) {
            return this;
        }
        if (i10 == i11) {
            return emptyMap(comparator());
        }
        return new ImmutableSortedMap<>(this.keySet.getSubSet(i10, i11), this.valueList.subList(i10, i11));
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return NATURAL_EMPTY_MAP;
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder<>(comparator);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K k10) {
        return tailMap(k10, true).firstEntry();
    }

    @CheckForNull
    public K ceilingKey(K k10) {
        return Maps.keyOrNull(ceilingEntry(k10));
    }

    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new ImmutableMapEntrySet<K, V>() {
            public ImmutableList<Map.Entry<K, V>> createAsList() {
                return new ImmutableList<Map.Entry<K, V>>() {
                    public boolean isPartialView() {
                        return true;
                    }

                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }

                    public Map.Entry<K, V> get(int i10) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i10), ImmutableSortedMap.this.valueList.get(i10));
                    }
                };
            }

            public ImmutableMap<K, V> map() {
                return ImmutableSortedMap.this;
            }

            public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                return asList().iterator();
            }
        };
    }

    public ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    public ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().asList().get(0);
    }

    public K firstKey() {
        return keySet().first();
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(K k10) {
        return headMap(k10, true).lastEntry();
    }

    @CheckForNull
    public K floorKey(K k10) {
        return Maps.keyOrNull(floorEntry(k10));
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int indexOf = this.keySet.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.valueList.get(indexOf);
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(K k10) {
        return tailMap(k10, false).firstEntry();
    }

    @CheckForNull
    public K higherKey(K k10) {
        return Maps.keyOrNull(higherEntry(k10));
    }

    public boolean isPartialView() {
        if (this.keySet.isPartialView() || this.valueList.isPartialView()) {
            return true;
        }
        return false;
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().asList().get(size() - 1);
    }

    public K lastKey() {
        return keySet().last();
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K k10) {
        return headMap(k10, false).lastEntry();
    }

    @CheckForNull
    public K lowerKey(K k10) {
        return Maps.keyOrNull(lowerEntry(k10));
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.valueList.size();
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, @CheckForNull ImmutableSortedMap<K, V> immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z10, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Iterables.toArray(iterable, (T[]) ImmutableMap.EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator, z10, entryArr, entryArr.length);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10) {
        return of(Ordering.natural(), k10, v10);
    }

    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        if (isEmpty()) {
            return emptyMap(Ordering.from(comparator()).reverse());
        }
        return new ImmutableSortedMap<>((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this);
    }

    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return copyOfInternal(map, (Comparator) Preconditions.checkNotNull(comparator));
    }

    /* access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> comparator, K k10, V v10) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.of(k10), (Comparator) Preconditions.checkNotNull(comparator)), ImmutableList.of(v10));
    }

    public ImmutableSortedMap<K, V> headMap(K k10) {
        return headMap(k10, false);
    }

    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    public ImmutableSortedMap<K, V> subMap(K k10, K k11) {
        return subMap(k10, true, k11, false);
    }

    public ImmutableSortedMap<K, V> tailMap(K k10) {
        return tailMap(k10, true);
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) NATURAL_ORDER);
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(final Comparator<? super K> comparator, boolean z10, Map.Entry<K, V>[] entryArr, int i10) {
        if (i10 == 0) {
            return emptyMap(comparator);
        }
        if (i10 != 1) {
            Object[] objArr = new Object[i10];
            Object[] objArr2 = new Object[i10];
            if (z10) {
                for (int i11 = 0; i11 < i10; i11++) {
                    Map.Entry<K, V> entry = entryArr[i11];
                    Objects.requireNonNull(entry);
                    Map.Entry entry2 = entry;
                    Object key = entry2.getKey();
                    Object value = entry2.getValue();
                    CollectPreconditions.checkEntryNotNull(key, value);
                    objArr[i11] = key;
                    objArr2[i11] = value;
                }
            } else {
                Arrays.sort(entryArr, 0, i10, new Comparator<Map.Entry<K, V>>() {
                    public int compare(@CheckForNull Map.Entry<K, V> entry, @CheckForNull Map.Entry<K, V> entry2) {
                        Objects.requireNonNull(entry);
                        Objects.requireNonNull(entry2);
                        return comparator.compare(entry.getKey(), entry2.getKey());
                    }
                });
                Map.Entry<K, V> entry3 = entryArr[0];
                Objects.requireNonNull(entry3);
                Map.Entry entry4 = entry3;
                Object key2 = entry4.getKey();
                objArr[0] = key2;
                Object value2 = entry4.getValue();
                objArr2[0] = value2;
                CollectPreconditions.checkEntryNotNull(objArr[0], value2);
                int i12 = 1;
                while (i12 < i10) {
                    Map.Entry<K, V> entry5 = entryArr[i12 - 1];
                    Objects.requireNonNull(entry5);
                    Map.Entry entry6 = entry5;
                    Map.Entry<K, V> entry7 = entryArr[i12];
                    Objects.requireNonNull(entry7);
                    Map.Entry entry8 = entry7;
                    Object key3 = entry8.getKey();
                    Object value3 = entry8.getValue();
                    CollectPreconditions.checkEntryNotNull(key3, value3);
                    objArr[i12] = key3;
                    objArr2[i12] = value3;
                    ImmutableMap.checkNoConflict(comparator.compare(key2, key3) != 0, "key", entry6, entry8);
                    i12++;
                    key2 = key3;
                }
            }
            return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(objArr), comparator), ImmutableList.asImmutableList(objArr2));
        }
        Map.Entry<K, V> entry9 = entryArr[0];
        Objects.requireNonNull(entry9);
        Map.Entry entry10 = entry9;
        return of(comparator, entry10.getKey(), entry10.getValue());
    }

    public ImmutableSortedMap<K, V> headMap(K k10, boolean z10) {
        return getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(k10), z10));
    }

    public ImmutableSortedMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
        Preconditions.checkNotNull(k10);
        Preconditions.checkNotNull(k11);
        Preconditions.checkArgument(comparator().compare(k10, k11) <= 0, "expected fromKey <= toKey but %s > %s", (Object) k10, (Object) k11);
        return headMap(k11, z11).tailMap(k10, z10);
    }

    public ImmutableSortedMap<K, V> tailMap(K k10, boolean z10) {
        return getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(k10), z10), size());
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return fromEntries((Comparator) Preconditions.checkNotNull(comparator), false, iterable);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16), ImmutableMap.entryOf(k17, v17));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16), ImmutableMap.entryOf(k17, v17), ImmutableMap.entryOf(k18, v18));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        return fromEntries(ImmutableMap.entryOf(k10, v10), ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16), ImmutableMap.entryOf(k17, v17), ImmutableMap.entryOf(k18, v18), ImmutableMap.entryOf(k19, v19));
    }
}
