package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public <S extends Comparable<?>> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public <E extends Comparable<?>> E max(E e10, E e11) {
        return (Comparable) NaturalOrdering.INSTANCE.min(e10, e11);
    }

    public <E extends Comparable<?>> E min(E e10, E e11) {
        return (Comparable) NaturalOrdering.INSTANCE.max(e10, e11);
    }

    public <E extends Comparable<?>> E max(E e10, E e11, E e12, E... eArr) {
        return (Comparable) NaturalOrdering.INSTANCE.min(e10, e11, e12, eArr);
    }

    public <E extends Comparable<?>> E min(E e10, E e11, E e12, E... eArr) {
        return (Comparable) NaturalOrdering.INSTANCE.max(e10, e11, e12, eArr);
    }

    public <E extends Comparable<?>> E max(Iterator<E> it) {
        return (Comparable) NaturalOrdering.INSTANCE.min(it);
    }

    public <E extends Comparable<?>> E min(Iterator<E> it) {
        return (Comparable) NaturalOrdering.INSTANCE.max(it);
    }

    public <E extends Comparable<?>> E max(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.INSTANCE.min(iterable);
    }

    public <E extends Comparable<?>> E min(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.INSTANCE.max(iterable);
    }
}
