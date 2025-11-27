package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Deprecated
public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {
    public abstract BlockingDeque<E> delegate();

    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }

    public boolean offer(E e10, long j10, TimeUnit timeUnit) {
        return delegate().offer(e10, j10, timeUnit);
    }

    public boolean offerFirst(E e10, long j10, TimeUnit timeUnit) {
        return delegate().offerFirst(e10, j10, timeUnit);
    }

    public boolean offerLast(E e10, long j10, TimeUnit timeUnit) {
        return delegate().offerLast(e10, j10, timeUnit);
    }

    @CheckForNull
    public E poll(long j10, TimeUnit timeUnit) {
        return delegate().poll(j10, timeUnit);
    }

    @CheckForNull
    public E pollFirst(long j10, TimeUnit timeUnit) {
        return delegate().pollFirst(j10, timeUnit);
    }

    @CheckForNull
    public E pollLast(long j10, TimeUnit timeUnit) {
        return delegate().pollLast(j10, timeUnit);
    }

    public void put(E e10) {
        delegate().put(e10);
    }

    public void putFirst(E e10) {
        delegate().putFirst(e10);
    }

    public void putLast(E e10) {
        delegate().putLast(e10);
    }

    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    public E take() {
        return delegate().take();
    }

    public E takeFirst() {
        return delegate().takeFirst();
    }

    public E takeLast() {
        return delegate().takeLast();
    }

    public int drainTo(Collection<? super E> collection, int i10) {
        return delegate().drainTo(collection, i10);
    }
}
