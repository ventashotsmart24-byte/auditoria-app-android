package io.reactivex.processors;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final AtomicReference<c> downstream;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested;
    final BasicIntQueueSubscription<T> wip;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        public void cancel() {
            if (!UnicastProcessor.this.cancelled) {
                UnicastProcessor.this.cancelled = true;
                UnicastProcessor.this.doTerminate();
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (!unicastProcessor.enableOperatorFusion && unicastProcessor.wip.getAndIncrement() == 0) {
                    UnicastProcessor.this.queue.clear();
                    UnicastProcessor.this.downstream.lazySet((Object) null);
                }
            }
        }

        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        @Nullable
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, j10);
                UnicastProcessor.this.drain();
            }
        }

        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.enableOperatorFusion = true;
            return 2;
        }
    }

    public UnicastProcessor(int i10) {
        this(i10, (Runnable) null, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(Flowable.bufferSize());
    }

    public boolean checkTerminated(boolean z10, boolean z11, boolean z12, c cVar, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.cancelled) {
            spscLinkedArrayQueue.clear();
            this.downstream.lazySet((Object) null);
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (z10 && this.error != null) {
                spscLinkedArrayQueue.clear();
                this.downstream.lazySet((Object) null);
                cVar.onError(this.error);
                return true;
            } else if (!z12) {
                return false;
            } else {
                Throwable th = this.error;
                this.downstream.lazySet((Object) null);
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
        }
    }

    public void doTerminate() {
        Runnable andSet = this.onTerminate.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            c cVar = this.downstream.get();
            int i10 = 1;
            while (cVar == null) {
                i10 = this.wip.addAndGet(-i10);
                if (i10 != 0) {
                    cVar = this.downstream.get();
                } else {
                    return;
                }
            }
            if (this.enableOperatorFusion) {
                drainFused(cVar);
            } else {
                drainRegular(cVar);
            }
        }
    }

    public void drainFused(c cVar) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i10 = 1;
        boolean z10 = !this.delayError;
        while (!this.cancelled) {
            boolean z11 = this.done;
            if (!z10 || !z11 || this.error == null) {
                cVar.onNext((Object) null);
                if (z11) {
                    this.downstream.lazySet((Object) null);
                    Throwable th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                } else {
                    i10 = this.wip.addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            } else {
                spscLinkedArrayQueue.clear();
                this.downstream.lazySet((Object) null);
                cVar.onError(this.error);
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.downstream.lazySet((Object) null);
    }

    public void drainRegular(c cVar) {
        long j10;
        boolean z10;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean z11 = !this.delayError;
        int i10 = 1;
        do {
            long j11 = this.requested.get();
            long j12 = 0;
            while (true) {
                if (j11 == j12) {
                    j10 = j12;
                    break;
                }
                boolean z12 = this.done;
                T poll = spscLinkedArrayQueue.poll();
                if (poll == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                j10 = j12;
                if (!checkTerminated(z11, z12, z10, cVar, spscLinkedArrayQueue)) {
                    if (z10) {
                        break;
                    }
                    cVar.onNext(poll);
                    j12 = 1 + j10;
                } else {
                    return;
                }
            }
            c cVar2 = cVar;
            if (j11 == j10) {
                if (checkTerminated(z11, this.done, spscLinkedArrayQueue.isEmpty(), cVar, spscLinkedArrayQueue)) {
                    return;
                }
            }
            if (!(j10 == 0 || j11 == Long.MAX_VALUE)) {
                this.requested.addAndGet(-j10);
            }
            i10 = this.wip.addAndGet(-i10);
        } while (i10 != 0);
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    public boolean hasComplete() {
        if (!this.done || this.error != null) {
            return false;
        }
        return true;
    }

    public boolean hasSubscribers() {
        if (this.downstream.get() != null) {
            return true;
        }
        return false;
    }

    public boolean hasThrowable() {
        if (!this.done || this.error == null) {
            return false;
        }
        return true;
    }

    public void onComplete() {
        if (!this.done && !this.cancelled) {
            this.done = true;
            doTerminate();
            drain();
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done || this.cancelled) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.error = th;
        this.done = true;
        doTerminate();
        drain();
    }

    public void onNext(T t10) {
        ObjectHelper.requireNonNull(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.cancelled) {
            this.queue.offer(t10);
            drain();
        }
    }

    public void onSubscribe(d dVar) {
        if (this.done || this.cancelled) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(c cVar) {
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.onSubscribe(this.wip);
        this.downstream.set(cVar);
        if (this.cancelled) {
            this.downstream.lazySet((Object) null);
        } else {
            drain();
        }
    }

    public UnicastProcessor(int i10, Runnable runnable) {
        this(i10, runnable, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i10) {
        return new UnicastProcessor<>(i10);
    }

    public UnicastProcessor(int i10, Runnable runnable, boolean z10) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i10, "capacityHint"));
        this.onTerminate = new AtomicReference<>(runnable);
        this.delayError = z10;
        this.downstream = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(boolean z10) {
        return new UnicastProcessor<>(Flowable.bufferSize(), (Runnable) null, z10);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i10, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i10, runnable);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i10, Runnable runnable, boolean z10) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i10, runnable, z10);
    }
}
