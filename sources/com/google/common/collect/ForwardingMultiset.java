package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    @Beta
    public class StandardElementSet extends Multisets.ElementSet<E> {
        public StandardElementSet() {
        }

        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        public Multiset<E> multiset() {
            return ForwardingMultiset.this;
        }
    }

    @CanIgnoreReturnValue
    public int add(@ParametricNullness E e10, int i10) {
        return delegate().add(e10, i10);
    }

    public int count(@CheckForNull Object obj) {
        return delegate().count(obj);
    }

    public abstract Multiset<E> delegate();

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this || delegate().equals(obj)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i10) {
        return delegate().remove(obj, i10);
    }

    @CanIgnoreReturnValue
    public int setCount(@ParametricNullness E e10, int i10) {
        return delegate().setCount(e10, i10);
    }

    public boolean standardAdd(@ParametricNullness E e10) {
        add(e10, 1);
        return true;
    }

    @Beta
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.addAllImpl(this, collection);
    }

    public void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    public boolean standardContains(@CheckForNull Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    @Beta
    public int standardCount(@CheckForNull Object obj) {
        for (Multiset.Entry entry : entrySet()) {
            if (Objects.equal(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(@CheckForNull Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    public boolean standardRemove(@CheckForNull Object obj) {
        if (remove(obj, 1) > 0) {
            return true;
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    public int standardSetCount(@ParametricNullness E e10, int i10) {
        return Multisets.setCountImpl(this, e10, i10);
    }

    public int standardSize() {
        return Multisets.linearTimeSizeImpl(this);
    }

    public String standardToString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public boolean setCount(@ParametricNullness E e10, int i10, int i11) {
        return delegate().setCount(e10, i10, i11);
    }

    public boolean standardSetCount(@ParametricNullness E e10, int i10, int i11) {
        return Multisets.setCountImpl(this, e10, i10, i11);
    }
}
