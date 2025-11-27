package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    @VisibleForTesting
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    @CheckForNull
    @VisibleForTesting
    transient Object[] elements;
    @CheckForNull
    private transient int[] entries;
    /* access modifiers changed from: private */
    public transient int metadata;
    private transient int size;
    @CheckForNull
    private transient Object table;

    public CompactHashSet() {
        init(3);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    private Set<E> createHashFloodingResistantDelegate(int i10) {
        return new LinkedHashSet(i10, 1.0f);
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i10) {
        return new CompactHashSet<>(i10);
    }

    /* access modifiers changed from: private */
    public E element(int i10) {
        return requireElements()[i10];
    }

    private int entry(int i10) {
        return requireEntries()[i10];
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Invalid size: ");
        sb.append(readInt);
        throw new InvalidObjectException(sb.toString());
    }

    private Object[] requireElements() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private Object requireTable() {
        Object obj = this.table;
        Objects.requireNonNull(obj);
        return obj;
    }

    private void resizeMeMaybe(int i10) {
        int min;
        int length = requireEntries().length;
        if (i10 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            resizeEntries(min);
        }
    }

    @CanIgnoreReturnValue
    private int resizeTable(int i10, int i11, int i12, int i13) {
        Object createTable = CompactHashing.createTable(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            CompactHashing.tableSet(createTable, i12 & i14, i13 + 1);
        }
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        for (int i15 = 0; i15 <= i10; i15++) {
            int tableGet = CompactHashing.tableGet(requireTable, i15);
            while (tableGet != 0) {
                int i16 = tableGet - 1;
                int i17 = requireEntries[i16];
                int hashPrefix = CompactHashing.getHashPrefix(i17, i10) | i15;
                int i18 = hashPrefix & i14;
                int tableGet2 = CompactHashing.tableGet(createTable, i18);
                CompactHashing.tableSet(createTable, i18, tableGet);
                requireEntries[i16] = CompactHashing.maskCombine(hashPrefix, tableGet2, i14);
                tableGet = CompactHashing.getNext(i17, i10);
            }
        }
        this.table = createTable;
        setHashTableMask(i14);
        return i14;
    }

    private void setElement(int i10, E e10) {
        requireElements()[i10] = e10;
    }

    private void setEntry(int i10, int i11) {
        requireEntries()[i10] = i11;
    }

    private void setHashTableMask(int i10) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @CanIgnoreReturnValue
    public boolean add(@ParametricNullness E e10) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.add(e10);
        }
        int[] requireEntries = requireEntries();
        Object[] requireElements = requireElements();
        int i10 = this.size;
        int i11 = i10 + 1;
        int smearedHash = Hashing.smearedHash(e10);
        int hashTableMask = hashTableMask();
        int i12 = smearedHash & hashTableMask;
        int tableGet = CompactHashing.tableGet(requireTable(), i12);
        if (tableGet != 0) {
            int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
            int i13 = 0;
            while (true) {
                int i14 = tableGet - 1;
                int i15 = requireEntries[i14];
                if (CompactHashing.getHashPrefix(i15, hashTableMask) == hashPrefix && com.google.common.base.Objects.equal(e10, requireElements[i14])) {
                    return false;
                }
                int next = CompactHashing.getNext(i15, hashTableMask);
                i13++;
                if (next != 0) {
                    tableGet = next;
                } else if (i13 >= 9) {
                    return convertToHashFloodingResistantImplementation().add(e10);
                } else {
                    if (i11 > hashTableMask) {
                        hashTableMask = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i10);
                    } else {
                        requireEntries[i14] = CompactHashing.maskCombine(i15, i11, hashTableMask);
                    }
                }
            }
        } else if (i11 > hashTableMask) {
            hashTableMask = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i10);
        } else {
            CompactHashing.tableSet(requireTable(), i12, i11);
        }
        resizeMeMaybe(i11);
        insertEntry(i10, e10, smearedHash, hashTableMask);
        this.size = i11;
        incrementModCount();
        return true;
    }

    public int adjustAfterRemove(int i10, int i11) {
        return i10 - 1;
    }

    @CanIgnoreReturnValue
    public int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.metadata;
        int tableSize = CompactHashing.tableSize(i10);
        this.table = CompactHashing.createTable(tableSize);
        setHashTableMask(tableSize - 1);
        this.entries = new int[i10];
        this.elements = new Object[i10];
        return i10;
    }

    public void clear() {
        if (!needsAllocArrays()) {
            incrementModCount();
            Set delegateOrNull = delegateOrNull();
            if (delegateOrNull != null) {
                this.metadata = Ints.constrainToRange(size(), 3, 1073741823);
                delegateOrNull.clear();
                this.table = null;
                this.size = 0;
                return;
            }
            Arrays.fill(requireElements(), 0, this.size, (Object) null);
            CompactHashing.tableClear(requireTable());
            Arrays.fill(requireEntries(), 0, this.size, 0);
            this.size = 0;
        }
    }

    public boolean contains(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.contains(obj);
        }
        int smearedHash = Hashing.smearedHash(obj);
        int hashTableMask = hashTableMask();
        int tableGet = CompactHashing.tableGet(requireTable(), smearedHash & hashTableMask);
        if (tableGet == 0) {
            return false;
        }
        int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
        do {
            int i10 = tableGet - 1;
            int entry = entry(i10);
            if (CompactHashing.getHashPrefix(entry, hashTableMask) == hashPrefix && com.google.common.base.Objects.equal(obj, element(i10))) {
                return true;
            }
            tableGet = CompactHashing.getNext(entry, hashTableMask);
        } while (tableGet != 0);
        return false;
    }

    @CanIgnoreReturnValue
    @VisibleForTesting
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.add(element(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.elements = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    @CheckForNull
    @VisibleForTesting
    public Set<E> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public int firstEntryIndex() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public int getSuccessor(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.size) {
            return i11;
        }
        return -1;
    }

    public void incrementModCount() {
        this.metadata += 32;
    }

    public void init(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(i10, 1, 1073741823);
    }

    public void insertEntry(int i10, @ParametricNullness E e10, int i11, int i12) {
        setEntry(i10, CompactHashing.maskCombine(i11, 0, i12));
        setElement(i10, e10);
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public boolean isUsingHashFloodingResistance() {
        if (delegateOrNull() != null) {
            return true;
        }
        return false;
    }

    public Iterator<E> iterator() {
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.iterator();
        }
        return new Iterator<E>() {
            int currentIndex;
            int expectedMetadata;
            int indexToRemove = -1;

            {
                this.expectedMetadata = CompactHashSet.this.metadata;
                this.currentIndex = CompactHashSet.this.firstEntryIndex();
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.metadata != this.expectedMetadata) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                if (this.currentIndex >= 0) {
                    return true;
                }
                return false;
            }

            public void incrementExpectedModCount() {
                this.expectedMetadata += 32;
            }

            @ParametricNullness
            public E next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    int i10 = this.currentIndex;
                    this.indexToRemove = i10;
                    E access$100 = CompactHashSet.this.element(i10);
                    this.currentIndex = CompactHashSet.this.getSuccessor(this.currentIndex);
                    return access$100;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                boolean z10;
                checkForConcurrentModification();
                if (this.indexToRemove >= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                CollectPreconditions.checkRemove(z10);
                incrementExpectedModCount();
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.element(this.indexToRemove));
                this.currentIndex = CompactHashSet.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
                this.indexToRemove = -1;
            }
        };
    }

    public void moveLastEntry(int i10, int i11) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireElements = requireElements();
        int size2 = size() - 1;
        if (i10 < size2) {
            Object obj = requireElements[size2];
            requireElements[i10] = obj;
            requireElements[size2] = null;
            requireEntries[i10] = requireEntries[size2];
            requireEntries[size2] = 0;
            int smearedHash = Hashing.smearedHash(obj) & i11;
            int tableGet = CompactHashing.tableGet(requireTable, smearedHash);
            int i12 = size2 + 1;
            if (tableGet == i12) {
                CompactHashing.tableSet(requireTable, smearedHash, i10 + 1);
                return;
            }
            while (true) {
                int i13 = tableGet - 1;
                int i14 = requireEntries[i13];
                int next = CompactHashing.getNext(i14, i11);
                if (next == i12) {
                    requireEntries[i13] = CompactHashing.maskCombine(i14, i10 + 1, i11);
                    return;
                }
                tableGet = next;
            }
        } else {
            requireElements[i10] = null;
            requireEntries[i10] = 0;
        }
    }

    @VisibleForTesting
    public boolean needsAllocArrays() {
        if (this.table == null) {
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        int hashTableMask = hashTableMask();
        int remove = CompactHashing.remove(obj, (Object) null, hashTableMask, requireTable(), requireEntries(), requireElements(), (Object[]) null);
        if (remove == -1) {
            return false;
        }
        moveLastEntry(remove, hashTableMask);
        this.size--;
        incrementModCount();
        return true;
    }

    public void resizeEntries(int i10) {
        this.entries = Arrays.copyOf(requireEntries(), i10);
        this.elements = Arrays.copyOf(requireElements(), i10);
    }

    public int size() {
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.size();
        }
        return this.size;
    }

    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.toArray() : Arrays.copyOf(requireElements(), this.size);
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            Set delegateOrNull = delegateOrNull();
            if (delegateOrNull != null) {
                Set createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
                createHashFloodingResistantDelegate.addAll(delegateOrNull);
                this.table = createHashFloodingResistantDelegate;
                return;
            }
            int i10 = this.size;
            if (i10 < requireEntries().length) {
                resizeEntries(i10);
            }
            int tableSize = CompactHashing.tableSize(i10);
            int hashTableMask = hashTableMask();
            if (tableSize < hashTableMask) {
                resizeTable(hashTableMask, tableSize, 0, 0);
            }
        }
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public CompactHashSet(int i10) {
        init(i10);
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.toArray(tArr);
        }
        return ObjectArrays.toArrayImpl(requireElements(), 0, this.size, tArr);
    }
}
