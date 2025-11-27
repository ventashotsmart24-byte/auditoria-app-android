package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

@ElementTypesAreNonnullByDefault
abstract class ForwardingCondition implements Condition {
    public void await() {
        delegate().await();
    }

    public long awaitNanos(long j10) {
        return delegate().awaitNanos(j10);
    }

    public void awaitUninterruptibly() {
        delegate().awaitUninterruptibly();
    }

    public boolean awaitUntil(Date date) {
        return delegate().awaitUntil(date);
    }

    public abstract Condition delegate();

    public void signal() {
        delegate().signal();
    }

    public void signalAll() {
        delegate().signalAll();
    }

    public boolean await(long j10, TimeUnit timeUnit) {
        return delegate().await(j10, timeUnit);
    }
}
