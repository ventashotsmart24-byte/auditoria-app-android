package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull
    private T nextOrNull;

    public AbstractSequentialIterator(@CheckForNull T t10) {
        this.nextOrNull = t10;
    }

    @CheckForNull
    public abstract T computeNext(T t10);

    public final boolean hasNext() {
        if (this.nextOrNull != null) {
            return true;
        }
        return false;
    }

    public final T next() {
        T t10 = this.nextOrNull;
        if (t10 != null) {
            this.nextOrNull = computeNext(t10);
            return t10;
        }
        throw new NoSuchElementException();
    }
}
