package io.reactivex.internal.schedulers;

import h3.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask implements Callable<Void>, Disposable {
    static final FutureTask<Void> CANCELLED = new FutureTask<>(Functions.EMPTY_RUNNABLE, (Object) null);
    final ExecutorService executor;
    final AtomicReference<Future<?>> first = new AtomicReference<>();
    final AtomicReference<Future<?>> rest = new AtomicReference<>();
    Thread runner;
    final Runnable task;

    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.task = runnable;
        this.executor = executorService;
    }

    public void dispose() {
        boolean z10;
        AtomicReference<Future<?>> atomicReference = this.first;
        Future future = CANCELLED;
        Future andSet = atomicReference.getAndSet(future);
        boolean z11 = true;
        if (!(andSet == null || andSet == future)) {
            if (this.runner != Thread.currentThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            andSet.cancel(z10);
        }
        Future andSet2 = this.rest.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.runner == Thread.currentThread()) {
                z11 = false;
            }
            andSet2.cancel(z11);
        }
    }

    public boolean isDisposed() {
        if (this.first.get() == CANCELLED) {
            return true;
        }
        return false;
    }

    public void setFirst(Future<?> future) {
        Future future2;
        boolean z10;
        do {
            future2 = this.first.get();
            if (future2 == CANCELLED) {
                if (this.runner != Thread.currentThread()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                future.cancel(z10);
                return;
            }
        } while (!b.a(this.first, future2, future));
    }

    public void setRest(Future<?> future) {
        Future future2;
        boolean z10;
        do {
            future2 = this.rest.get();
            if (future2 == CANCELLED) {
                if (this.runner != Thread.currentThread()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                future.cancel(z10);
                return;
            }
        } while (!b.a(this.rest, future2, future));
    }

    public Void call() {
        this.runner = Thread.currentThread();
        try {
            this.task.run();
            setRest(this.executor.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            RxJavaPlugins.onError(th);
        }
        return null;
    }
}
