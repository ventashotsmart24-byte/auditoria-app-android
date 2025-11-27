package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean nonScheduledRequests;
    final Scheduler scheduler;

    public static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, d, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final c downstream;
        final boolean nonScheduledRequests;
        final AtomicLong requested = new AtomicLong();
        b source;
        final AtomicReference<d> upstream = new AtomicReference<>();
        final Scheduler.Worker worker;

        public static final class Request implements Runnable {

            /* renamed from: n  reason: collision with root package name */
            final long f17502n;
            final d upstream;

            public Request(d dVar, long j10) {
                this.upstream = dVar;
                this.f17502n = j10;
            }

            public void run() {
                this.upstream.request(this.f17502n);
            }
        }

        public SubscribeOnSubscriber(c cVar, Scheduler.Worker worker2, b bVar, boolean z10) {
            this.downstream = cVar;
            this.worker = worker2;
            this.source = bVar;
            this.nonScheduledRequests = !z10;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar);
                }
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                d dVar = this.upstream.get();
                if (dVar != null) {
                    requestUpstream(j10, dVar);
                    return;
                }
                BackpressureHelper.add(this.requested, j10);
                d dVar2 = this.upstream.get();
                if (dVar2 != null) {
                    long andSet = this.requested.getAndSet(0);
                    if (andSet != 0) {
                        requestUpstream(andSet, dVar2);
                    }
                }
            }
        }

        public void requestUpstream(long j10, d dVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                dVar.request(j10);
            } else {
                this.worker.schedule(new Request(dVar, j10));
            }
        }

        public void run() {
            lazySet(Thread.currentThread());
            b bVar = this.source;
            this.source = null;
            bVar.subscribe(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler2, boolean z10) {
        super(flowable);
        this.scheduler = scheduler2;
        this.nonScheduledRequests = z10;
    }

    public void subscribeActual(c cVar) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(cVar, createWorker, this.source, this.nonScheduledRequests);
        cVar.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }
}
