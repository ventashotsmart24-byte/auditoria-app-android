package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@ElementTypesAreNonnullByDefault
abstract class ForwardingLock implements Lock {
    public abstract Lock delegate();

    public void lock() {
        delegate().lock();
    }

    public void lockInterruptibly() {
        delegate().lockInterruptibly();
    }

    public Condition newCondition() {
        return delegate().newCondition();
    }

    public boolean tryLock() {
        return delegate().tryLock();
    }

    public void unlock() {
        delegate().unlock();
    }

    public boolean tryLock(long j10, TimeUnit timeUnit) {
        return delegate().tryLock(j10, timeUnit);
    }
}
