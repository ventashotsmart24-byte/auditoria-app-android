package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@CanIgnoreReturnValue
@ElementTypesAreNonnullByDefault
@Beta
public final class FakeTimeLimiter implements TimeLimiter {
    @ParametricNullness
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit) {
        return callWithTimeout(callable, j10, timeUnit);
    }

    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        try {
            return callable.call();
        } catch (RuntimeException e10) {
            throw new UncheckedExecutionException((Throwable) e10);
        } catch (Exception e11) {
            throw new ExecutionException(e11);
        } catch (Error e12) {
            throw new ExecutionError(e12);
        } catch (Throwable th) {
            throw new ExecutionException(th);
        }
    }

    public <T> T newProxy(T t10, Class<T> cls, long j10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t10);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        return t10;
    }

    public void runUninterruptiblyWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit) {
        runWithTimeout(runnable, j10, timeUnit);
    }

    public void runWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        try {
            runnable.run();
        } catch (RuntimeException e10) {
            throw new UncheckedExecutionException((Throwable) e10);
        } catch (Error e11) {
            throw new ExecutionError(e11);
        } catch (Throwable th) {
            throw new UncheckedExecutionException(th);
        }
    }
}
