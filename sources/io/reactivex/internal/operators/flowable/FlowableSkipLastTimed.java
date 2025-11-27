package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, d {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final c downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        d upstream;

        public SkipLastTimedSubscriber(c cVar, long j10, TimeUnit timeUnit, Scheduler scheduler2, int i10, boolean z10) {
            this.downstream = cVar;
            this.time = j10;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.queue = new SpscLinkedArrayQueue<>(i10);
            this.delayError = z10;
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, c cVar, boolean z12) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!z12) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        cVar.onError(th);
                        return true;
                    } else if (!z11) {
                        return false;
                    } else {
                        cVar.onComplete();
                        return true;
                    }
                } else if (!z11) {
                    return false;
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        cVar.onError(th2);
                    } else {
                        cVar.onComplete();
                    }
                    return true;
                }
            }
        }

        public void drain() {
            boolean z10;
            boolean z11;
            if (getAndIncrement() == 0) {
                c cVar = this.downstream;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                boolean z12 = this.delayError;
                TimeUnit timeUnit = this.unit;
                Scheduler scheduler2 = this.scheduler;
                long j10 = this.time;
                int i10 = 1;
                do {
                    long j11 = this.requested.get();
                    long j12 = 0;
                    while (j12 != j11) {
                        boolean z13 = this.done;
                        Long l10 = (Long) spscLinkedArrayQueue.peek();
                        if (l10 == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        long now = scheduler2.now(timeUnit);
                        if (z10 || l10.longValue() <= now - j10) {
                            z11 = z10;
                        } else {
                            z11 = true;
                        }
                        if (!checkTerminated(z13, z11, cVar, z12)) {
                            if (z11) {
                                break;
                            }
                            spscLinkedArrayQueue.poll();
                            cVar.onNext(spscLinkedArrayQueue.poll());
                            j12++;
                        } else {
                            return;
                        }
                    }
                    if (j12 != 0) {
                        BackpressureHelper.produced(this.requested, j12);
                    }
                    i10 = addAndGet(-i10);
                } while (i10 != 0);
            }
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t10) {
            this.queue.offer(Long.valueOf(this.scheduler.now(this.unit)), t10);
            drain();
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.add(this.requested, j10);
                drain();
            }
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j10, TimeUnit timeUnit, Scheduler scheduler2, int i10, boolean z10) {
        super(flowable);
        this.time = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.bufferSize = i10;
        this.delayError = z10;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new SkipLastTimedSubscriber(cVar, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
