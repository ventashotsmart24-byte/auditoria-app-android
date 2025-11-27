package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action onFinally;

    public static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final ConditionalSubscriber<? super T> downstream;
        final Action onFinally;
        QueueSubscription<T> qs;
        boolean syncFused;
        d upstream;

        public DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Action action) {
            this.downstream = conditionalSubscriber;
            this.onFinally = action;
        }

        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        public void clear() {
            this.qs.clear();
        }

        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof QueueSubscription) {
                    this.qs = (QueueSubscription) dVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        public void request(long j10) {
            this.upstream.request(j10);
        }

        public int requestFusion(int i10) {
            QueueSubscription<T> queueSubscription = this.qs;
            boolean z10 = false;
            if (queueSubscription == null || (i10 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i10);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z10 = true;
                }
                this.syncFused = z10;
            }
            return requestFusion;
        }

        public void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        public boolean tryOnNext(T t10) {
            return this.downstream.tryOnNext(t10);
        }
    }

    public static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final c downstream;
        final Action onFinally;
        QueueSubscription<T> qs;
        boolean syncFused;
        d upstream;

        public DoFinallySubscriber(c cVar, Action action) {
            this.downstream = cVar;
            this.onFinally = action;
        }

        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        public void clear() {
            this.qs.clear();
        }

        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof QueueSubscription) {
                    this.qs = (QueueSubscription) dVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        public void request(long j10) {
            this.upstream.request(j10);
        }

        public int requestFusion(int i10) {
            QueueSubscription<T> queueSubscription = this.qs;
            boolean z10 = false;
            if (queueSubscription == null || (i10 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i10);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z10 = true;
                }
                this.syncFused = z10;
            }
            return requestFusion;
        }

        public void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public FlowableDoFinally(Flowable<T> flowable, Action action) {
        super(flowable);
        this.onFinally = action;
    }

    public void subscribeActual(c cVar) {
        if (cVar instanceof ConditionalSubscriber) {
            this.source.subscribe(new DoFinallyConditionalSubscriber((ConditionalSubscriber) cVar, this.onFinally));
        } else {
            this.source.subscribe(new DoFinallySubscriber(cVar, this.onFinally));
        }
    }
}
