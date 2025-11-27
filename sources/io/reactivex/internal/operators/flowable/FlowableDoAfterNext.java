package io.reactivex.internal.operators.flowable;

import fb.c;
import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;

public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Consumer<? super T> onAfterNext;

    public static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> onAfterNext;

        public DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer) {
            super(conditionalSubscriber);
            this.onAfterNext = consumer;
        }

        public void onNext(T t10) {
            this.downstream.onNext(t10);
            if (this.sourceMode == 0) {
                try {
                    this.onAfterNext.accept(t10);
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        @Nullable
        public T poll() {
            T poll = this.qs.poll();
            if (poll != null) {
                this.onAfterNext.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i10) {
            return transitiveBoundaryFusion(i10);
        }

        public boolean tryOnNext(T t10) {
            boolean tryOnNext = this.downstream.tryOnNext(t10);
            try {
                this.onAfterNext.accept(t10);
            } catch (Throwable th) {
                fail(th);
            }
            return tryOnNext;
        }
    }

    public static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> onAfterNext;

        public DoAfterSubscriber(c cVar, Consumer<? super T> consumer) {
            super(cVar);
            this.onAfterNext = consumer;
        }

        public void onNext(T t10) {
            if (!this.done) {
                this.downstream.onNext(t10);
                if (this.sourceMode == 0) {
                    try {
                        this.onAfterNext.accept(t10);
                    } catch (Throwable th) {
                        fail(th);
                    }
                }
            }
        }

        @Nullable
        public T poll() {
            T poll = this.qs.poll();
            if (poll != null) {
                this.onAfterNext.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i10) {
            return transitiveBoundaryFusion(i10);
        }
    }

    public FlowableDoAfterNext(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.onAfterNext = consumer;
    }

    public void subscribeActual(c cVar) {
        if (cVar instanceof ConditionalSubscriber) {
            this.source.subscribe(new DoAfterConditionalSubscriber((ConditionalSubscriber) cVar, this.onAfterNext));
        } else {
            this.source.subscribe(new DoAfterSubscriber(cVar, this.onAfterNext));
        }
    }
}
