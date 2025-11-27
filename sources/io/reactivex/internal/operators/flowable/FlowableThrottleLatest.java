package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableThrottleLatest<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean emitLast;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, d, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final c downstream;
        final boolean emitLast;
        long emitted;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        d upstream;
        final Scheduler.Worker worker;

        public ThrottleLatestSubscriber(c cVar, long j10, TimeUnit timeUnit, Scheduler.Worker worker2, boolean z10) {
            this.downstream = cVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = worker2;
            this.emitLast = z10;
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet((Object) null);
            }
        }

        public void drain() {
            boolean z10;
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.latest;
                AtomicLong atomicLong = this.requested;
                c cVar = this.downstream;
                int i10 = 1;
                while (!this.cancelled) {
                    boolean z11 = this.done;
                    if (!z11 || this.error == null) {
                        if (atomicReference.get() == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z11) {
                            if (z10 || !this.emitLast) {
                                atomicReference.lazySet((Object) null);
                                cVar.onComplete();
                            } else {
                                T andSet = atomicReference.getAndSet((Object) null);
                                long j10 = this.emitted;
                                if (j10 != atomicLong.get()) {
                                    this.emitted = j10 + 1;
                                    cVar.onNext(andSet);
                                    cVar.onComplete();
                                } else {
                                    cVar.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                                }
                            }
                            this.worker.dispose();
                            return;
                        }
                        if (z10) {
                            if (this.timerFired) {
                                this.timerRunning = false;
                                this.timerFired = false;
                            }
                        } else if (!this.timerRunning || this.timerFired) {
                            T andSet2 = atomicReference.getAndSet((Object) null);
                            long j11 = this.emitted;
                            if (j11 != atomicLong.get()) {
                                cVar.onNext(andSet2);
                                this.emitted = j11 + 1;
                                this.timerFired = false;
                                this.timerRunning = true;
                                this.worker.schedule(this, this.timeout, this.unit);
                            } else {
                                this.upstream.cancel();
                                cVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                                this.worker.dispose();
                                return;
                            }
                        }
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        cVar.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
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
            this.latest.set(t10);
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
            }
        }

        public void run() {
            this.timerFired = true;
            drain();
        }
    }

    public FlowableThrottleLatest(Flowable<T> flowable, long j10, TimeUnit timeUnit, Scheduler scheduler2, boolean z10) {
        super(flowable);
        this.timeout = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.emitLast = z10;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new ThrottleLatestSubscriber(cVar, this.timeout, this.unit, this.scheduler.createWorker(), this.emitLast));
    }
}
