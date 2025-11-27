package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class DelaySubscriber<T> implements FlowableSubscriber<T>, d {
        final long delay;
        final boolean delayError;
        final c downstream;
        final TimeUnit unit;
        d upstream;

        /* renamed from: w  reason: collision with root package name */
        final Scheduler.Worker f17487w;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            public void run() {
                try {
                    DelaySubscriber.this.downstream.onComplete();
                } finally {
                    DelaySubscriber.this.f17487w.dispose();
                }
            }
        }

        public final class OnError implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final Throwable f17488t;

            public OnError(Throwable th) {
                this.f17488t = th;
            }

            public void run() {
                try {
                    DelaySubscriber.this.downstream.onError(this.f17488t);
                } finally {
                    DelaySubscriber.this.f17487w.dispose();
                }
            }
        }

        public final class OnNext implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final T f17489t;

            public OnNext(T t10) {
                this.f17489t = t10;
            }

            public void run() {
                DelaySubscriber.this.downstream.onNext(this.f17489t);
            }
        }

        public DelaySubscriber(c cVar, long j10, TimeUnit timeUnit, Scheduler.Worker worker, boolean z10) {
            this.downstream = cVar;
            this.delay = j10;
            this.unit = timeUnit;
            this.f17487w = worker;
            this.delayError = z10;
        }

        public void cancel() {
            this.upstream.cancel();
            this.f17487w.dispose();
        }

        public void onComplete() {
            this.f17487w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            long j10;
            Scheduler.Worker worker = this.f17487w;
            OnError onError = new OnError(th);
            if (this.delayError) {
                j10 = this.delay;
            } else {
                j10 = 0;
            }
            worker.schedule(onError, j10, this.unit);
        }

        public void onNext(T t10) {
            this.f17487w.schedule(new OnNext(t10), this.delay, this.unit);
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j10) {
            this.upstream.request(j10);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j10, TimeUnit timeUnit, Scheduler scheduler2, boolean z10) {
        super(flowable);
        this.delay = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z10;
    }

    public void subscribeActual(c cVar) {
        SerializedSubscriber serializedSubscriber;
        if (this.delayError) {
            serializedSubscriber = cVar;
        } else {
            serializedSubscriber = new SerializedSubscriber(cVar);
        }
        this.source.subscribe(new DelaySubscriber(serializedSubscriber, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
