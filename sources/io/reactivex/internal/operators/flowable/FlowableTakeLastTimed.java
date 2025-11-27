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

public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, d {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
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

        public TakeLastTimedSubscriber(c cVar, long j10, long j11, TimeUnit timeUnit, Scheduler scheduler2, int i10, boolean z10) {
            this.downstream = cVar;
            this.count = j10;
            this.time = j11;
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

        public boolean checkTerminated(boolean z10, c cVar, boolean z11) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z11) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    cVar.onError(th);
                    return true;
                } else if (!z10) {
                    return false;
                } else {
                    cVar.onComplete();
                    return true;
                }
            } else if (!z10) {
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

        public void drain() {
            boolean z10;
            if (getAndIncrement() == 0) {
                c cVar = this.downstream;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                boolean z11 = this.delayError;
                int i10 = 1;
                do {
                    if (this.done) {
                        if (!checkTerminated(spscLinkedArrayQueue.isEmpty(), cVar, z11)) {
                            long j10 = this.requested.get();
                            long j11 = 0;
                            while (true) {
                                if (spscLinkedArrayQueue.peek() == null) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (!checkTerminated(z10, cVar, z11)) {
                                    if (j10 != j11) {
                                        spscLinkedArrayQueue.poll();
                                        cVar.onNext(spscLinkedArrayQueue.poll());
                                        j11++;
                                    } else if (j11 != 0) {
                                        BackpressureHelper.produced(this.requested, j11);
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    i10 = addAndGet(-i10);
                } while (i10 != 0);
            }
        }

        public void onComplete() {
            trim(this.scheduler.now(this.unit), this.queue);
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            if (this.delayError) {
                trim(this.scheduler.now(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t10) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            long now = this.scheduler.now(this.unit);
            spscLinkedArrayQueue.offer(Long.valueOf(now), t10);
            trim(now, spscLinkedArrayQueue);
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

        public void trim(long j10, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
            boolean z10;
            long j11 = this.time;
            long j12 = this.count;
            if (j12 == Long.MAX_VALUE) {
                z10 = true;
            } else {
                z10 = false;
            }
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() < j10 - j11 || (!z10 && ((long) (spscLinkedArrayQueue.size() >> 1)) > j12)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }
    }

    public FlowableTakeLastTimed(Flowable<T> flowable, long j10, long j11, TimeUnit timeUnit, Scheduler scheduler2, int i10, boolean z10) {
        super(flowable);
        this.count = j10;
        this.time = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.bufferSize = i10;
        this.delayError = z10;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new TakeLastTimedSubscriber(cVar, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
