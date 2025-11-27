package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    public void add(int i10, @ParametricNullness E e10) {
        delegate().add(i10, e10);
    }

    @CanIgnoreReturnValue
    public boolean addAll(int i10, Collection<? extends E> collection) {
        return delegate().addAll(i10, collection);
    }

    public abstract List<E> delegate();

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this || delegate().equals(obj)) {
            return true;
        }
        return false;
    }

    @ParametricNullness
    public E get(int i10) {
        return delegate().get(i10);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    public int indexOf(@CheckForNull Object obj) {
        return delegate().indexOf(obj);
    }

    public int lastIndexOf(@CheckForNull Object obj) {
        return delegate().lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E remove(int i10) {
        return delegate().remove(i10);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E set(int i10, @ParametricNullness E e10) {
        return delegate().set(i10, e10);
    }

    public boolean standardAdd(@ParametricNullness E e10) {
        add(size(), e10);
        return true;
    }

    public boolean standardAddAll(int i10, Iterable<? extends E> iterable) {
        return Lists.addAllImpl(this, i10, iterable);
    }

    @Beta
    public boolean standardEquals(@CheckForNull Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    @Beta
    public int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }

    public int standardIndexOf(@CheckForNull Object obj) {
        return Lists.indexOfImpl(this, obj);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    public int standardLastIndexOf(@CheckForNull Object obj) {
        return Lists.lastIndexOfImpl(this, obj);
    }

    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Beta
    public List<E> standardSubList(int i10, int i11) {
        return Lists.subListImpl(this, i10, i11);
    }

    public List<E> subList(int i10, int i11) {
        return delegate().subList(i10, i11);
    }

    public ListIterator<E> listIterator(int i10) {
        return delegate().listIterator(i10);
    }

    @Beta
    public ListIterator<E> standardListIterator(int i10) {
        return Lists.listIteratorImpl(this, i10);
    }
}
