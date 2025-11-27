package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableLimit<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: n  reason: collision with root package name */
    final long f17491n;

    public static final class LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, d {
        private static final long serialVersionUID = 2288246011222124525L;
        final c downstream;
        long remaining;
        d upstream;

        public LimitSubscriber(c cVar, long j10) {
            this.downstream = cVar;
            this.remaining = j10;
            lazySet(j10);
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void onComplete() {
            if (this.remaining > 0) {
                this.remaining = 0;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.remaining > 0) {
                this.remaining = 0;
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onNext(T t10) {
            long j10 = this.remaining;
            if (j10 > 0) {
                long j11 = j10 - 1;
                this.remaining = j11;
                this.downstream.onNext(t10);
                if (j11 == 0) {
                    this.upstream.cancel();
                    this.downstream.onComplete();
                }
            }
        }

        public void onSubscribe(d dVar) {
            if (!SubscriptionHelper.validate(this.upstream, dVar)) {
                return;
            }
            if (this.remaining == 0) {
                dVar.cancel();
                EmptySubscription.complete(this.downstream);
                return;
            }
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }

        public void request(long j10) {
            long j11;
            long j12;
            if (SubscriptionHelper.validate(j10)) {
                do {
                    j11 = get();
                    if (j11 != 0) {
                        if (j11 <= j10) {
                            j12 = j11;
                        } else {
                            j12 = j10;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j11, j11 - j12));
                this.upstream.request(j12);
            }
        }
    }

    public FlowableLimit(Flowable<T> flowable, long j10) {
        super(flowable);
        this.f17491n = j10;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new LimitSubscriber(cVar, this.f17491n));
    }
}
