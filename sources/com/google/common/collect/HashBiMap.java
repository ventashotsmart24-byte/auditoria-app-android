package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;
    /* access modifiers changed from: private */
    public transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;
    /* access modifiers changed from: private */
    @RetainedWith
    @CheckForNull
    @LazyInit
    public transient BiMap<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    /* access modifiers changed from: private */
    public transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    public final class EntryForKey extends AbstractMapEntry<K, V> {
        int index;
        @ParametricNullness
        final K key;

        public EntryForKey(int i10) {
            this.key = NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.keys[i10]);
            this.index = i10;
        }

        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        @ParametricNullness
        public V getValue() {
            updateIndex();
            int i10 = this.index;
            if (i10 == -1) {
                return NullnessCasts.unsafeNull();
            }
            return NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i10]);
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v10) {
            updateIndex();
            int i10 = this.index;
            if (i10 == -1) {
                HashBiMap.this.put(this.key, v10);
                return NullnessCasts.unsafeNull();
            }
            V uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i10]);
            if (Objects.equal(uncheckedCastNullableTToT, v10)) {
                return v10;
            }
            HashBiMap.this.replaceValueInEntry(this.index, v10, false);
            return uncheckedCastNullableTToT;
        }

        public void updateIndex() {
            int i10 = this.index;
            if (i10 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i10 <= hashBiMap.size && Objects.equal(hashBiMap.keys[i10], this.key)) {
                    return;
                }
            }
            this.index = HashBiMap.this.findEntryByKey(this.key);
        }
    }

    public static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        final HashBiMap<K, V> biMap;
        int index;
        @ParametricNullness
        final V value;

        public EntryForValue(HashBiMap<K, V> hashBiMap, int i10) {
            this.biMap = hashBiMap;
            this.value = NullnessCasts.uncheckedCastNullableTToT(hashBiMap.values[i10]);
            this.index = i10;
        }

        private void updateIndex() {
            int i10 = this.index;
            if (i10 != -1) {
                HashBiMap<K, V> hashBiMap = this.biMap;
                if (i10 <= hashBiMap.size && Objects.equal(this.value, hashBiMap.values[i10])) {
                    return;
                }
            }
            this.index = this.biMap.findEntryByValue(this.value);
        }

        @ParametricNullness
        public V getKey() {
            return this.value;
        }

        @ParametricNullness
        public K getValue() {
            updateIndex();
            int i10 = this.index;
            if (i10 == -1) {
                return NullnessCasts.unsafeNull();
            }
            return NullnessCasts.uncheckedCastNullableTToT(this.biMap.keys[i10]);
        }

        @ParametricNullness
        public K setValue(@ParametricNullness K k10) {
            updateIndex();
            int i10 = this.index;
            if (i10 == -1) {
                this.biMap.putInverse(this.value, k10, false);
                return NullnessCasts.unsafeNull();
            }
            K uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.biMap.keys[i10]);
            if (Objects.equal(uncheckedCastNullableTToT, k10)) {
                return k10;
            }
            this.biMap.replaceKeyInEntry(this.index, k10, false);
            return uncheckedCastNullableTToT;
        }
    }

    public final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        public EntrySet() {
            super(HashBiMap.this);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            return true;
        }

        @CanIgnoreReturnValue
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, smearedHash);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }

        public Map.Entry<K, V> forEntry(int i10) {
            return new EntryForKey(i10);
        }
    }

    public static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            BiMap unused = this.forward.inverse = this;
        }

        public void clear() {
            this.forward.clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.forward.containsValue(obj);
        }

        public boolean containsValue(@CheckForNull Object obj) {
            return this.forward.containsKey(obj);
        }

        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet2 = new InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet2;
            return inverseEntrySet2;
        }

        @CheckForNull
        @CanIgnoreReturnValue
        public K forcePut(@ParametricNullness V v10, @ParametricNullness K k10) {
            return this.forward.putInverse(v10, k10, true);
        }

        @CheckForNull
        public K get(@CheckForNull Object obj) {
            return this.forward.getInverse(obj);
        }

        public BiMap<K, V> inverse() {
            return this.forward;
        }

        public Set<V> keySet() {
            return this.forward.values();
        }

        @CheckForNull
        @CanIgnoreReturnValue
        public K put(@ParametricNullness V v10, @ParametricNullness K k10) {
            return this.forward.putInverse(v10, k10, false);
        }

        @CheckForNull
        @CanIgnoreReturnValue
        public K remove(@CheckForNull Object obj) {
            return this.forward.removeInverse(obj);
        }

        public int size() {
            return this.forward.size;
        }

        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    public static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        public InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.biMap.findEntryByValue(key);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            return true;
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByValue = this.biMap.findEntryByValue(key, smearedHash);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            this.biMap.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }

        public Map.Entry<V, K> forEntry(int i10) {
            return new EntryForValue(this.biMap, i10);
        }
    }

    public final class KeySet extends View<K, V, K> {
        public KeySet() {
            super(HashBiMap.this);
        }

        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @ParametricNullness
        public K forEntry(int i10) {
            return NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.keys[i10]);
        }

        public boolean remove(@CheckForNull Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, smearedHash);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }
    }

    public final class ValueSet extends View<K, V, V> {
        public ValueSet() {
            super(HashBiMap.this);
        }

        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @ParametricNullness
        public V forEntry(int i10) {
            return NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i10]);
        }

        public boolean remove(@CheckForNull Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, smearedHash);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }
    }

    public static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> biMap;

        public View(HashBiMap<K, V> hashBiMap) {
            this.biMap = hashBiMap;
        }

        public void clear() {
            this.biMap.clear();
        }

        @ParametricNullness
        public abstract T forEntry(int i10);

        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int expectedModCount;
                private int index;
                private int indexToRemove = -1;
                private int remaining;

                {
                    this.index = View.this.biMap.firstInInsertionOrder;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    this.expectedModCount = hashBiMap.modCount;
                    this.remaining = hashBiMap.size;
                }

                private void checkForComodification() {
                    if (View.this.biMap.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                public boolean hasNext() {
                    checkForComodification();
                    if (this.index == -2 || this.remaining <= 0) {
                        return false;
                    }
                    return true;
                }

                @ParametricNullness
                public T next() {
                    if (hasNext()) {
                        T forEntry = View.this.forEntry(this.index);
                        this.indexToRemove = this.index;
                        this.index = View.this.biMap.nextInInsertionOrder[this.index];
                        this.remaining--;
                        return forEntry;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    boolean z10;
                    checkForComodification();
                    if (this.indexToRemove != -1) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    CollectPreconditions.checkRemove(z10);
                    View.this.biMap.removeEntry(this.indexToRemove);
                    int i10 = this.index;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    if (i10 == hashBiMap.size) {
                        this.index = this.indexToRemove;
                    }
                    this.indexToRemove = -1;
                    this.expectedModCount = hashBiMap.modCount;
                }
            };
        }

        public int size() {
            return this.biMap.size;
        }
    }

    private HashBiMap(int i10) {
        init(i10);
    }

    private int bucket(int i10) {
        return i10 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private static int[] createFilledWithAbsent(int i10) {
        int[] iArr = new int[i10];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i10, int i11) {
        boolean z10;
        if (i10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        int bucket = bucket(i11);
        int[] iArr = this.hashTableKToV;
        int i12 = iArr[bucket];
        if (i12 == i10) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i10];
            iArr2[i10] = -1;
            return;
        }
        int i13 = this.nextInBucketKToV[i12];
        while (true) {
            int i14 = i12;
            i12 = i13;
            int i15 = i14;
            if (i12 == -1) {
                String valueOf = String.valueOf(this.keys[i10]);
                StringBuilder sb = new StringBuilder(valueOf.length() + 32);
                sb.append("Expected to find entry with key ");
                sb.append(valueOf);
                throw new AssertionError(sb.toString());
            } else if (i12 == i10) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i15] = iArr3[i10];
                iArr3[i10] = -1;
                return;
            } else {
                i13 = this.nextInBucketKToV[i12];
            }
        }
    }

    private void deleteFromTableVToK(int i10, int i11) {
        boolean z10;
        if (i10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        int bucket = bucket(i11);
        int[] iArr = this.hashTableVToK;
        int i12 = iArr[bucket];
        if (i12 == i10) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i10];
            iArr2[i10] = -1;
            return;
        }
        int i13 = this.nextInBucketVToK[i12];
        while (true) {
            int i14 = i12;
            i12 = i13;
            int i15 = i14;
            if (i12 == -1) {
                String valueOf = String.valueOf(this.values[i10]);
                StringBuilder sb = new StringBuilder(valueOf.length() + 34);
                sb.append("Expected to find entry with value ");
                sb.append(valueOf);
                throw new AssertionError(sb.toString());
            } else if (i12 == i10) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i15] = iArr3[i10];
                iArr3[i10] = -1;
                return;
            } else {
                i13 = this.nextInBucketVToK[i12];
            }
        }
    }

    private void ensureCapacity(int i10) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i10) {
            int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(iArr.length, i10);
            this.keys = Arrays.copyOf(this.keys, expandedCapacity);
            this.values = Arrays.copyOf(this.values, expandedCapacity);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, expandedCapacity);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, expandedCapacity);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, expandedCapacity);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, expandedCapacity);
        }
        if (this.hashTableKToV.length < i10) {
            int closedTableSize = Hashing.closedTableSize(i10, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(closedTableSize);
            this.hashTableVToK = createFilledWithAbsent(closedTableSize);
            for (int i11 = 0; i11 < this.size; i11++) {
                int bucket = bucket(Hashing.smearedHash(this.keys[i11]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i11] = iArr3[bucket];
                iArr3[bucket] = i11;
                int bucket2 = bucket(Hashing.smearedHash(this.values[i11]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i11] = iArr5[bucket2];
                iArr5[bucket2] = i11;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i10) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i10);
        Arrays.fill(copyOf, length, i10, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i10, int i11) {
        boolean z10;
        if (i10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        int bucket = bucket(i11);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i10] = iArr2[bucket];
        iArr2[bucket] = i10;
    }

    private void insertIntoTableVToK(int i10, int i11) {
        boolean z10;
        if (i10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        int bucket = bucket(i11);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i10] = iArr2[bucket];
        iArr2[bucket] = i10;
    }

    private void moveEntryToIndex(int i10, int i11) {
        int i12;
        int i13;
        if (i10 != i11) {
            int i14 = this.prevInInsertionOrder[i10];
            int i15 = this.nextInInsertionOrder[i10];
            setSucceeds(i14, i11);
            setSucceeds(i11, i15);
            K[] kArr = this.keys;
            K k10 = kArr[i10];
            V[] vArr = this.values;
            V v10 = vArr[i10];
            kArr[i11] = k10;
            vArr[i11] = v10;
            int bucket = bucket(Hashing.smearedHash(k10));
            int[] iArr = this.hashTableKToV;
            int i16 = iArr[bucket];
            if (i16 == i10) {
                iArr[bucket] = i11;
            } else {
                int i17 = this.nextInBucketKToV[i16];
                while (true) {
                    int i18 = i16;
                    i16 = i17;
                    i13 = i18;
                    if (i16 == i10) {
                        break;
                    }
                    i17 = this.nextInBucketKToV[i16];
                }
                this.nextInBucketKToV[i13] = i11;
            }
            int[] iArr2 = this.nextInBucketKToV;
            iArr2[i11] = iArr2[i10];
            iArr2[i10] = -1;
            int bucket2 = bucket(Hashing.smearedHash(v10));
            int[] iArr3 = this.hashTableVToK;
            int i19 = iArr3[bucket2];
            if (i19 == i10) {
                iArr3[bucket2] = i11;
            } else {
                int i20 = this.nextInBucketVToK[i19];
                while (true) {
                    int i21 = i19;
                    i19 = i20;
                    i12 = i21;
                    if (i19 == i10) {
                        break;
                    }
                    i20 = this.nextInBucketVToK[i19];
                }
                this.nextInBucketVToK[i12] = i11;
            }
            int[] iArr4 = this.nextInBucketVToK;
            iArr4[i11] = iArr4[i10];
            iArr4[i10] = -1;
        }
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, readCount);
    }

    /* access modifiers changed from: private */
    public void replaceKeyInEntry(int i10, @ParametricNullness K k10, boolean z10) {
        boolean z11;
        int i11;
        if (i10 != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        int smearedHash = Hashing.smearedHash(k10);
        int findEntryByKey = findEntryByKey(k10, smearedHash);
        int i12 = this.lastInInsertionOrder;
        if (findEntryByKey == -1) {
            i11 = -2;
        } else if (z10) {
            i12 = this.prevInInsertionOrder[findEntryByKey];
            i11 = this.nextInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            if (i10 == this.size) {
                i10 = findEntryByKey;
            }
        } else {
            String valueOf = String.valueOf(k10);
            StringBuilder sb = new StringBuilder(valueOf.length() + 28);
            sb.append("Key already present in map: ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i12 == i10) {
            i12 = this.prevInInsertionOrder[i10];
        } else if (i12 == this.size) {
            i12 = findEntryByKey;
        }
        if (i11 == i10) {
            findEntryByKey = this.nextInInsertionOrder[i10];
        } else if (i11 != this.size) {
            findEntryByKey = i11;
        }
        setSucceeds(this.prevInInsertionOrder[i10], this.nextInInsertionOrder[i10]);
        deleteFromTableKToV(i10, Hashing.smearedHash(this.keys[i10]));
        this.keys[i10] = k10;
        insertIntoTableKToV(i10, Hashing.smearedHash(k10));
        setSucceeds(i12, i10);
        setSucceeds(i10, findEntryByKey);
    }

    /* access modifiers changed from: private */
    public void replaceValueInEntry(int i10, @ParametricNullness V v10, boolean z10) {
        boolean z11;
        if (i10 != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        int smearedHash = Hashing.smearedHash(v10);
        int findEntryByValue = findEntryByValue(v10, smearedHash);
        if (findEntryByValue != -1) {
            if (z10) {
                removeEntryValueHashKnown(findEntryByValue, smearedHash);
                if (i10 == this.size) {
                    i10 = findEntryByValue;
                }
            } else {
                String valueOf = String.valueOf(v10);
                StringBuilder sb = new StringBuilder(valueOf.length() + 30);
                sb.append("Value already present in map: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        deleteFromTableVToK(i10, Hashing.smearedHash(this.values[i10]));
        this.values[i10] = v10;
        insertIntoTableVToK(i10, smearedHash);
    }

    private void setSucceeds(int i10, int i11) {
        if (i10 == -2) {
            this.firstInInsertionOrder = i11;
        } else {
            this.nextInInsertionOrder[i10] = i11;
        }
        if (i11 == -2) {
            this.lastInInsertionOrder = i10;
        } else {
            this.prevInInsertionOrder[i11] = i10;
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        if (findEntryByKey(obj) != -1) {
            return true;
        }
        return false;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        if (findEntryByValue(obj) != -1) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public int findEntry(@CheckForNull Object obj, int i10, int[] iArr, int[] iArr2, Object[] objArr) {
        int i11 = iArr[bucket(i10)];
        while (i11 != -1) {
            if (Objects.equal(objArr[i11], obj)) {
                return i11;
            }
            i11 = iArr2[i11];
        }
        return -1;
    }

    public int findEntryByKey(@CheckForNull Object obj) {
        return findEntryByKey(obj, Hashing.smearedHash(obj));
    }

    public int findEntryByValue(@CheckForNull Object obj) {
        return findEntryByValue(obj, Hashing.smearedHash(obj));
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V forcePut(@ParametricNullness K k10, @ParametricNullness V v10) {
        return put(k10, v10, true);
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @CheckForNull
    public K getInverse(@CheckForNull Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    public void init(int i10) {
        CollectPreconditions.checkNonnegative(i10, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i10, 1.0d);
        this.size = 0;
        this.keys = new Object[i10];
        this.values = new Object[i10];
        this.hashTableKToV = createFilledWithAbsent(closedTableSize);
        this.hashTableVToK = createFilledWithAbsent(closedTableSize);
        this.nextInBucketKToV = createFilledWithAbsent(i10);
        this.nextInBucketVToK = createFilledWithAbsent(i10);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i10);
        this.nextInInsertionOrder = createFilledWithAbsent(i10);
    }

    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse2 = new Inverse(this);
        this.inverse = inverse2;
        return inverse2;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V put(@ParametricNullness K k10, @ParametricNullness V v10) {
        return put(k10, v10, false);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public K putInverse(@ParametricNullness V v10, @ParametricNullness K k10, boolean z10) {
        int i10;
        boolean z11;
        int smearedHash = Hashing.smearedHash(v10);
        int findEntryByValue = findEntryByValue(v10, smearedHash);
        if (findEntryByValue != -1) {
            K k11 = this.keys[findEntryByValue];
            if (Objects.equal(k11, k10)) {
                return k10;
            }
            replaceKeyInEntry(findEntryByValue, k10, z10);
            return k11;
        }
        int i11 = this.lastInInsertionOrder;
        int smearedHash2 = Hashing.smearedHash(k10);
        int findEntryByKey = findEntryByKey(k10, smearedHash2);
        if (!z10) {
            if (findEntryByKey == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Key already present: %s", (Object) k10);
        } else if (findEntryByKey != -1) {
            i11 = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i12 = this.size;
        kArr[i12] = k10;
        this.values[i12] = v10;
        insertIntoTableKToV(i12, smearedHash2);
        insertIntoTableVToK(this.size, smearedHash);
        if (i11 == -2) {
            i10 = this.firstInInsertionOrder;
        } else {
            i10 = this.nextInInsertionOrder[i11];
        }
        setSucceeds(i11, this.size);
        setSucceeds(this.size, i10);
        this.size++;
        this.modCount++;
        return null;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByKey = findEntryByKey(obj, smearedHash);
        if (findEntryByKey == -1) {
            return null;
        }
        V v10 = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, smearedHash);
        return v10;
    }

    public void removeEntry(int i10) {
        removeEntryKeyHashKnown(i10, Hashing.smearedHash(this.keys[i10]));
    }

    public void removeEntryKeyHashKnown(int i10, int i11) {
        removeEntry(i10, i11, Hashing.smearedHash(this.values[i10]));
    }

    public void removeEntryValueHashKnown(int i10, int i11) {
        removeEntry(i10, Hashing.smearedHash(this.keys[i10]), i11);
    }

    @CheckForNull
    public K removeInverse(@CheckForNull Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByValue = findEntryByValue(obj, smearedHash);
        if (findEntryByValue == -1) {
            return null;
        }
        K k10 = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, smearedHash);
        return k10;
    }

    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i10) {
        return new HashBiMap<>(i10);
    }

    private void removeEntry(int i10, int i11, int i12) {
        Preconditions.checkArgument(i10 != -1);
        deleteFromTableKToV(i10, i11);
        deleteFromTableVToK(i10, i12);
        setSucceeds(this.prevInInsertionOrder[i10], this.nextInInsertionOrder[i10]);
        moveEntryToIndex(this.size - 1, i10);
        K[] kArr = this.keys;
        int i13 = this.size;
        kArr[i13 - 1] = null;
        this.values[i13 - 1] = null;
        this.size = i13 - 1;
        this.modCount++;
    }

    public int findEntryByKey(@CheckForNull Object obj, int i10) {
        return findEntry(obj, i10, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(@CheckForNull Object obj, int i10) {
        return findEntry(obj, i10, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @CheckForNull
    public V put(@ParametricNullness K k10, @ParametricNullness V v10, boolean z10) {
        int smearedHash = Hashing.smearedHash(k10);
        int findEntryByKey = findEntryByKey(k10, smearedHash);
        if (findEntryByKey != -1) {
            V v11 = this.values[findEntryByKey];
            if (Objects.equal(v11, v10)) {
                return v10;
            }
            replaceValueInEntry(findEntryByKey, v10, z10);
            return v11;
        }
        int smearedHash2 = Hashing.smearedHash(v10);
        int findEntryByValue = findEntryByValue(v10, smearedHash2);
        if (!z10) {
            Preconditions.checkArgument(findEntryByValue == -1, "Value already present: %s", (Object) v10);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i10 = this.size;
        kArr[i10] = k10;
        this.values[i10] = v10;
        insertIntoTableKToV(i10, smearedHash);
        insertIntoTableVToK(this.size, smearedHash2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet2 = new ValueSet();
        this.valueSet = valueSet2;
        return valueSet2;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
