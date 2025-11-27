package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    private int position;
    private final int size;

    public AbstractIndexedListIterator(int i10) {
        this(i10, 0);
    }

    @ParametricNullness
    public abstract E get(int i10);

    public final boolean hasNext() {
        if (this.position < this.size) {
            return true;
        }
        return false;
    }

    public final boolean hasPrevious() {
        if (this.position > 0) {
            return true;
        }
        return false;
    }

    @ParametricNullness
    public final E next() {
        if (hasNext()) {
            int i10 = this.position;
            this.position = i10 + 1;
            return get(i10);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.position;
    }

    @ParametricNullness
    public final E previous() {
        if (hasPrevious()) {
            int i10 = this.position - 1;
            this.position = i10;
            return get(i10);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.position - 1;
    }

    public AbstractIndexedListIterator(int i10, int i11) {
        Preconditions.checkPositionIndex(i11, i10);
        this.size = i10;
        this.position = i11;
    }
}
