package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@CanIgnoreReturnValue
abstract class WrappingExecutorService implements ExecutorService {
    private final ExecutorService delegate;

    public WrappingExecutorService(ExecutorService executorService) {
        this.delegate = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$wrapTask$0(Callable callable) {
        try {
            callable.call();
        } catch (Exception e10) {
            Throwables.throwIfUnchecked(e10);
            throw new RuntimeException(e10);
        }
    }

    private <T> ImmutableList<Callable<T>> wrapTasks(Collection<? extends Callable<T>> collection) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Callable wrapTask : collection) {
            builder.add((Object) wrapTask(wrapTask));
        }
        return builder.build();
    }

    public final boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(j10, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.delegate.execute(wrapTask(runnable));
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.delegate.invokeAll(wrapTasks(collection));
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return this.delegate.invokeAny(wrapTasks(collection));
    }

    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public final void shutdown() {
        this.delegate.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(wrapTask((Callable) Preconditions.checkNotNull(callable)));
    }

    public Runnable wrapTask(Runnable runnable) {
        return new s(wrapTask(Executors.callable(runnable, (Object) null)));
    }

    public abstract <T> Callable<T> wrapTask(Callable<T> callable);

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        return this.delegate.invokeAll(wrapTasks(collection), j10, timeUnit);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        return this.delegate.invokeAny(wrapTasks(collection), j10, timeUnit);
    }

    public final Future<?> submit(Runnable runnable) {
        return this.delegate.submit(wrapTask(runnable));
    }

    public final <T> Future<T> submit(Runnable runnable, @ParametricNullness T t10) {
        return this.delegate.submit(wrapTask(runnable), t10);
    }
}
