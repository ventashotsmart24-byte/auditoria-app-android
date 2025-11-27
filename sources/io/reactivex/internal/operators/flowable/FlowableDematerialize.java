package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableDematerialize<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> selector;

    public static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, d {
        boolean done;
        final c downstream;
        final Function<? super T, ? extends Notification<R>> selector;
        d upstream;

        public DematerializeSubscriber(c cVar, Function<? super T, ? extends Notification<R>> function) {
            this.downstream = cVar;
            this.selector = function;
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onNext(T t10) {
            if (!this.done) {
                try {
                    Notification notification = (Notification) ObjectHelper.requireNonNull(this.selector.apply(t10), "The selector returned a null Notification");
                    if (notification.isOnError()) {
                        this.upstream.cancel();
                        onError(notification.getError());
                    } else if (notification.isOnComplete()) {
                        this.upstream.cancel();
                        onComplete();
                    } else {
                        this.downstream.onNext(notification.getValue());
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
                }
            } else if (t10 instanceof Notification) {
                Notification notification2 = (Notification) t10;
                if (notification2.isOnError()) {
                    RxJavaPlugins.onError(notification2.getError());
                }
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

    public FlowableDematerialize(Flowable<T> flowable, Function<? super T, ? extends Notification<R>> function) {
        super(flowable);
        this.selector = function;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new DematerializeSubscriber(cVar, this.selector));
    }
}
