package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingQueue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@GwtIncompatible
@CanIgnoreReturnValue
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    public abstract BlockingQueue<E> delegate();

    public int drainTo(Collection<? super E> collection, int i10) {
        return delegate().drainTo(collection, i10);
    }

    public boolean offer(E e10, long j10, TimeUnit timeUnit) {
        return delegate().offer(e10, j10, timeUnit);
    }

    @CheckForNull
    public E poll(long j10, TimeUnit timeUnit) {
        return delegate().poll(j10, timeUnit);
    }

    public void put(E e10) {
        delegate().put(e10);
    }

    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    public E take() {
        return delegate().take();
    }

    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }
}
