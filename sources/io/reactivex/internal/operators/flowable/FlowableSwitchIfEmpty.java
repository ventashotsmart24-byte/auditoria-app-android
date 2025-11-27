package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {
    final b other;

    public static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {
        final SubscriptionArbiter arbiter = new SubscriptionArbiter(false);
        final c downstream;
        boolean empty = true;
        final b other;

        public SwitchIfEmptySubscriber(c cVar, b bVar) {
            this.downstream = cVar;
            this.other = bVar;
        }

        public void onComplete() {
            if (this.empty) {
                this.empty = false;
                this.other.subscribe(this);
                return;
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onNext(T t10) {
            if (this.empty) {
                this.empty = false;
            }
            this.downstream.onNext(t10);
        }

        public void onSubscribe(d dVar) {
            this.arbiter.setSubscription(dVar);
        }
    }

    public FlowableSwitchIfEmpty(Flowable<T> flowable, b bVar) {
        super(flowable);
        this.other = bVar;
    }

    public void subscribeActual(c cVar) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(cVar, this.other);
        cVar.onSubscribe(switchIfEmptySubscriber.arbiter);
        this.source.subscribe(switchIfEmptySubscriber);
    }
}
