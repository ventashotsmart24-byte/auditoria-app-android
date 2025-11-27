package io.reactivex.internal.operators.single;

import fb.b;
import fb.d;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class SingleFromPublisher<T> extends Single<T> {
    final b publisher;

    public static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {
        volatile boolean disposed;
        boolean done;
        final SingleObserver<? super T> downstream;
        d upstream;
        T value;

        public ToSingleObserver(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T t10 = this.value;
                this.value = null;
                if (t10 == null) {
                    this.downstream.onError(new NoSuchElementException("The source Publisher is empty"));
                } else {
                    this.downstream.onSuccess(t10);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.value = null;
            this.downstream.onError(th);
        }

        public void onNext(T t10) {
            if (!this.done) {
                if (this.value != null) {
                    this.upstream.cancel();
                    this.done = true;
                    this.value = null;
                    this.downstream.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                    return;
                }
                this.value = t10;
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public SingleFromPublisher(b bVar) {
        this.publisher = bVar;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.publisher.subscribe(new ToSingleObserver(singleObserver));
    }
}
