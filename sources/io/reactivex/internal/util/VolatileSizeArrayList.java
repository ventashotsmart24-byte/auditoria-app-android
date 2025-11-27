package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList<>();
    }

    public boolean add(T t10) {
        boolean add = this.list.add(t10);
        lazySet(this.list.size());
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(collection);
        lazySet(this.list.size());
        return addAll;
    }

    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.list.equals(((VolatileSizeArrayList) obj).list);
        }
        return this.list.equals(obj);
    }

    public T get(int i10) {
        return this.list.get(i10);
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public boolean isEmpty() {
        if (get() == 0) {
            return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    public boolean remove(Object obj) {
        boolean remove = this.list.remove(obj);
        lazySet(this.list.size());
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.list.removeAll(collection);
        lazySet(this.list.size());
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.list.retainAll(collection);
        lazySet(this.list.size());
        return retainAll;
    }

    public T set(int i10, T t10) {
        return this.list.set(i10, t10);
    }

    public int size() {
        return get();
    }

    public List<T> subList(int i10, int i11) {
        return this.list.subList(i10, i11);
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public String toString() {
        return this.list.toString();
    }

    public ListIterator<T> listIterator(int i10) {
        return this.list.listIterator(i10);
    }

    public <E> E[] toArray(E[] eArr) {
        return this.list.toArray(eArr);
    }

    public VolatileSizeArrayList(int i10) {
        this.list = new ArrayList<>(i10);
    }

    public void add(int i10, T t10) {
        this.list.add(i10, t10);
        lazySet(this.list.size());
    }

    public boolean addAll(int i10, Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(i10, collection);
        lazySet(this.list.size());
        return addAll;
    }

    public T remove(int i10) {
        T remove = this.list.remove(i10);
        lazySet(this.list.size());
        return remove;
    }
}
