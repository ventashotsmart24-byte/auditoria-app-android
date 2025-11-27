package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class DelayObserver<T> implements Observer<T>, Disposable {
        final long delay;
        final boolean delayError;
        final Observer<? super T> downstream;
        final TimeUnit unit;
        Disposable upstream;

        /* renamed from: w  reason: collision with root package name */
        final Scheduler.Worker f17511w;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            public void run() {
                try {
                    DelayObserver.this.downstream.onComplete();
                } finally {
                    DelayObserver.this.f17511w.dispose();
                }
            }
        }

        public final class OnError implements Runnable {
            private final Throwable throwable;

            public OnError(Throwable th) {
                this.throwable = th;
            }

            public void run() {
                try {
                    DelayObserver.this.downstream.onError(this.throwable);
                } finally {
                    DelayObserver.this.f17511w.dispose();
                }
            }
        }

        public final class OnNext implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final T f17512t;

            public OnNext(T t10) {
                this.f17512t = t10;
            }

            public void run() {
                DelayObserver.this.downstream.onNext(this.f17512t);
            }
        }

        public DelayObserver(Observer<? super T> observer, long j10, TimeUnit timeUnit, Scheduler.Worker worker, boolean z10) {
            this.downstream = observer;
            this.delay = j10;
            this.unit = timeUnit;
            this.f17511w = worker;
            this.delayError = z10;
        }

        public void dispose() {
            this.upstream.dispose();
            this.f17511w.dispose();
        }

        public boolean isDisposed() {
            return this.f17511w.isDisposed();
        }

        public void onComplete() {
            this.f17511w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            long j10;
            Scheduler.Worker worker = this.f17511w;
            OnError onError = new OnError(th);
            if (this.delayError) {
                j10 = this.delay;
            } else {
                j10 = 0;
            }
            worker.schedule(onError, j10, this.unit);
        }

        public void onNext(T t10) {
            this.f17511w.schedule(new OnNext(t10), this.delay, this.unit);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j10, TimeUnit timeUnit, Scheduler scheduler2, boolean z10) {
        super(observableSource);
        this.delay = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z10;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver;
        if (this.delayError) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.source.subscribe(new DelayObserver(serializedObserver, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
