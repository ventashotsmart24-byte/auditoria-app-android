package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    /* access modifiers changed from: protected */
    public volatile boolean cancelled;
    protected volatile boolean done;
    protected final Observer<? super V> downstream;
    protected Throwable error;
    /* access modifiers changed from: protected */
    public final SimplePlainQueue<U> queue;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.downstream = observer;
        this.queue = simplePlainQueue;
    }

    public void accept(Observer<? super V> observer, U u10) {
    }

    public final boolean cancelled() {
        return this.cancelled;
    }

    public final boolean done() {
        return this.done;
    }

    public final boolean enter() {
        if (this.wip.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        if (this.wip.get() != 0 || !this.wip.compareAndSet(0, 1)) {
            return false;
        }
        return true;
    }

    public final void fastPathEmit(U u10, boolean z10, Disposable disposable) {
        Observer<? super V> observer = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() != 0 || !this.wip.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u10);
            if (!enter()) {
                return;
            }
        } else {
            accept(observer, u10);
            if (leave(-1) == 0) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z10, disposable, this);
    }

    public final void fastPathOrderedEmit(U u10, boolean z10, Disposable disposable) {
        Observer<? super V> observer = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() != 0 || !this.wip.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u10);
            if (!enter()) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            accept(observer, u10);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u10);
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z10, disposable, this);
    }

    public final int leave(int i10) {
        return this.wip.addAndGet(i10);
    }
}
