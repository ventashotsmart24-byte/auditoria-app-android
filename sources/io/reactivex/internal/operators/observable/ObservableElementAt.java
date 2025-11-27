package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        long count;
        final T defaultValue;
        boolean done;
        final Observer<? super T> downstream;
        final boolean errorOnFewer;
        final long index;
        Disposable upstream;

        public ElementAtObserver(Observer<? super T> observer, long j10, T t10, boolean z10) {
            this.downstream = observer;
            this.index = j10;
            this.defaultValue = t10;
            this.errorOnFewer = z10;
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T t10 = this.defaultValue;
                if (t10 != null || !this.errorOnFewer) {
                    if (t10 != null) {
                        this.downstream.onNext(t10);
                    }
                    this.downstream.onComplete();
                    return;
                }
                this.downstream.onError(new NoSuchElementException());
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
                long j10 = this.count;
                if (j10 == this.index) {
                    this.done = true;
                    this.upstream.dispose();
                    this.downstream.onNext(t10);
                    this.downstream.onComplete();
                    return;
                }
                this.count = j10 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j10, T t10, boolean z10) {
        super(observableSource);
        this.index = j10;
        this.defaultValue = t10;
        this.errorOnFewer = z10;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ElementAtObserver(observer, this.index, this.defaultValue, this.errorOnFewer));
    }
}
