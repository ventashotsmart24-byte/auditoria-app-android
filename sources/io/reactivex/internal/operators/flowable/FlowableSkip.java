package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: n  reason: collision with root package name */
    final long f17501n;

    public static final class SkipSubscriber<T> implements FlowableSubscriber<T>, d {
        final c downstream;
        long remaining;
        d upstream;

        public SkipSubscriber(c cVar, long j10) {
            this.downstream = cVar;
            this.remaining = j10;
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onNext(T t10) {
            long j10 = this.remaining;
            if (j10 != 0) {
                this.remaining = j10 - 1;
            } else {
                this.downstream.onNext(t10);
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                long j10 = this.remaining;
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(j10);
            }
        }

        public void request(long j10) {
            this.upstream.request(j10);
        }
    }

    public FlowableSkip(Flowable<T> flowable, long j10) {
        super(flowable);
        this.f17501n = j10;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new SkipSubscriber(cVar, this.f17501n));
    }
}
