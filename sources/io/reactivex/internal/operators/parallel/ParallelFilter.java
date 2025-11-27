package io.reactivex.internal.operators.parallel;

import fb.c;
import fb.d;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ParallelFilter<T> extends ParallelFlowable<T> {
    final Predicate<? super T> predicate;
    final ParallelFlowable<T> source;

    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, d {
        boolean done;
        final Predicate<? super T> predicate;
        d upstream;

        public BaseFilterSubscriber(Predicate<? super T> predicate2) {
            this.predicate = predicate2;
        }

        public final void cancel() {
            this.upstream.cancel();
        }

        public abstract /* synthetic */ void onComplete();

        public abstract /* synthetic */ void onError(Throwable th);

        public final void onNext(T t10) {
            if (!tryOnNext(t10) && !this.done) {
                this.upstream.request(1);
            }
        }

        public final void request(long j10) {
            this.upstream.request(j10);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        final ConditionalSubscriber<? super T> downstream;

        public ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.downstream = conditionalSubscriber;
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

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
            }
        }

        public boolean tryOnNext(T t10) {
            if (!this.done) {
                try {
                    if (this.predicate.test(t10)) {
                        return this.downstream.tryOnNext(t10);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    public static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        final c downstream;

        public ParallelFilterSubscriber(c cVar, Predicate<? super T> predicate) {
            super(predicate);
            this.downstream = cVar;
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

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
            }
        }

        public boolean tryOnNext(T t10) {
            if (!this.done) {
                try {
                    if (this.predicate.test(t10)) {
                        this.downstream.onNext(t10);
                        return true;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    public ParallelFilter(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate2) {
        this.source = parallelFlowable;
        this.predicate = predicate2;
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    public void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length];
            for (int i10 = 0; i10 < length; i10++) {
                ConditionalSubscriber conditionalSubscriber = cVarArr[i10];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    cVarArr2[i10] = new ParallelFilterConditionalSubscriber(conditionalSubscriber, this.predicate);
                } else {
                    cVarArr2[i10] = new ParallelFilterSubscriber(conditionalSubscriber, this.predicate);
                }
            }
            this.source.subscribe(cVarArr2);
        }
    }
}
