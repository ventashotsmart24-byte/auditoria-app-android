package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    public static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, d {
        final c downstream;
        boolean notSkipping;
        final Predicate<? super T> predicate;
        d upstream;

        public SkipWhileSubscriber(c cVar, Predicate<? super T> predicate2) {
            this.downstream = cVar;
            this.predicate = predicate2;
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
            if (this.notSkipping) {
                this.downstream.onNext(t10);
                return;
            }
            try {
                if (this.predicate.test(t10)) {
                    this.upstream.request(1);
                    return;
                }
                this.notSkipping = true;
                this.downstream.onNext(t10);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                this.downstream.onError(th);
            }
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

    public FlowableSkipWhile(Flowable<T> flowable, Predicate<? super T> predicate2) {
        super(flowable);
        this.predicate = predicate2;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new SkipWhileSubscriber(cVar, this.predicate));
    }
}
