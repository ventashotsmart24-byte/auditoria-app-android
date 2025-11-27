package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient ObjectCountHashMap<E> backingMap;
    transient long size;

    public abstract class Itr<T> implements Iterator<T> {
        int entryIndex;
        int expectedModCount;
        int toRemove = -1;

        public Itr() {
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.entryIndex >= 0) {
                return true;
            }
            return false;
        }

        @ParametricNullness
        public T next() {
            if (hasNext()) {
                T result = result(this.entryIndex);
                int i10 = this.entryIndex;
                this.toRemove = i10;
                this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(i10);
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z10;
            checkForConcurrentModification();
            if (this.toRemove != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            CollectPreconditions.checkRemove(z10);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        @ParametricNullness
        public abstract T result(int i10);
    }

    public AbstractMapBasedMultiset(int i10) {
        this.backingMap = newBackingMap(i10);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        this.backingMap = newBackingMap(3);
        Serialization.populateMultiset(this, objectInputStream, readCount);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @CanIgnoreReturnValue
    public final int add(@ParametricNullness E e10, int i10) {
        boolean z10;
        if (i10 == 0) {
            return count(e10);
        }
        boolean z11 = true;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "occurrences cannot be negative: %s", i10);
        int indexOf = this.backingMap.indexOf(e10);
        if (indexOf == -1) {
            this.backingMap.put(e10, i10);
            this.size += (long) i10;
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        long j10 = (long) i10;
        long j11 = ((long) value) + j10;
        if (j11 > TTL.MAX_VALUE) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "too many occurrences: %s", j11);
        this.backingMap.setValue(indexOf, (int) j11);
        this.size += j10;
        return value;
    }

    public void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int firstIndex = this.backingMap.firstIndex();
        while (firstIndex >= 0) {
            multiset.add(this.backingMap.getKey(firstIndex), this.backingMap.getValue(firstIndex));
            firstIndex = this.backingMap.nextIndex(firstIndex);
        }
    }

    public final void clear() {
        this.backingMap.clear();
        this.size = 0;
    }

    public final int count(@CheckForNull Object obj) {
        return this.backingMap.get(obj);
    }

    public final int distinctElements() {
        return this.backingMap.size();
    }

    public final Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() {
            @ParametricNullness
            public E result(int i10) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(i10);
            }
        };
    }

    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() {
            public Multiset.Entry<E> result(int i10) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(i10);
            }
        };
    }

    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    public abstract ObjectCountHashMap<E> newBackingMap(int i10);

    @CanIgnoreReturnValue
    public final int remove(@CheckForNull Object obj, int i10) {
        boolean z10;
        if (i10 == 0) {
            return count(obj);
        }
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "occurrences cannot be negative: %s", i10);
        int indexOf = this.backingMap.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        if (value > i10) {
            this.backingMap.setValue(indexOf, value - i10);
        } else {
            this.backingMap.removeEntry(indexOf);
            i10 = value;
        }
        this.size -= (long) i10;
        return value;
    }

    @CanIgnoreReturnValue
    public final int setCount(@ParametricNullness E e10, int i10) {
        CollectPreconditions.checkNonnegative(i10, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int remove = i10 == 0 ? objectCountHashMap.remove(e10) : objectCountHashMap.put(e10, i10);
        this.size += (long) (i10 - remove);
        return remove;
    }

    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    public final boolean setCount(@ParametricNullness E e10, int i10, int i11) {
        CollectPreconditions.checkNonnegative(i10, "oldCount");
        CollectPreconditions.checkNonnegative(i11, "newCount");
        int indexOf = this.backingMap.indexOf(e10);
        if (indexOf == -1) {
            if (i10 != 0) {
                return false;
            }
            if (i11 > 0) {
                this.backingMap.put(e10, i11);
                this.size += (long) i11;
            }
            return true;
        } else if (this.backingMap.getValue(indexOf) != i10) {
            return false;
        } else {
            if (i11 == 0) {
                this.backingMap.removeEntry(indexOf);
                this.size -= (long) i10;
            } else {
                this.backingMap.setValue(indexOf, i11);
                this.size += (long) (i11 - i10);
            }
            return true;
        }
    }
}
