package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@GwtCompatible
@CanIgnoreReturnValue
@ElementTypesAreNonnullByDefault
public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {

    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {
        private final Future<V> delegate;

        public SimpleForwardingFuture(Future<V> future) {
            this.delegate = (Future) Preconditions.checkNotNull(future);
        }

        public final Future<V> delegate() {
            return this.delegate;
        }
    }

    public boolean cancel(boolean z10) {
        return delegate().cancel(z10);
    }

    public abstract Future<? extends V> delegate();

    @ParametricNullness
    public V get() {
        return delegate().get();
    }

    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    public boolean isDone() {
        return delegate().isDone();
    }

    @ParametricNullness
    public V get(long j10, TimeUnit timeUnit) {
        return delegate().get(j10, timeUnit);
    }
}
