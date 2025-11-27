package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzqt implements Iterator<Object> {
    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
