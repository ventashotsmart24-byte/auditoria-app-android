package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb<T> extends Observable<T> {
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    public static final class AmbCoordinator<T> implements Disposable {
        final Observer<? super T> downstream;
        final AmbInnerObserver<T>[] observers;
        final AtomicInteger winner = new AtomicInteger();

        public AmbCoordinator(Observer<? super T> observer, int i10) {
            this.downstream = observer;
            this.observers = new AmbInnerObserver[i10];
        }

        public void dispose() {
            if (this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerObserver<T> dispose : this.observers) {
                    dispose.dispose();
                }
            }
        }

        public boolean isDisposed() {
            if (this.winner.get() == -1) {
                return true;
            }
            return false;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.observers;
            int length = ambInnerObserverArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                ambInnerObserverArr[i10] = new AmbInnerObserver<>(this, i11, this.downstream);
                i10 = i11;
            }
            this.winner.lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i12 = 0; i12 < length && this.winner.get() == 0; i12++) {
                observableSourceArr[i12].subscribe(ambInnerObserverArr[i12]);
            }
        }

        public boolean win(int i10) {
            int i11 = this.winner.get();
            int i12 = 0;
            if (i11 == 0) {
                if (!this.winner.compareAndSet(0, i10)) {
                    return false;
                }
                AmbInnerObserver<T>[] ambInnerObserverArr = this.observers;
                int length = ambInnerObserverArr.length;
                while (i12 < length) {
                    int i13 = i12 + 1;
                    if (i13 != i10) {
                        ambInnerObserverArr[i12].dispose();
                    }
                    i12 = i13;
                }
                return true;
            } else if (i11 == i10) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final Observer<? super T> downstream;
        final int index;
        final AmbCoordinator<T> parent;
        boolean won;

        public AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i10, Observer<? super T> observer) {
            this.parent = ambCoordinator;
            this.index = i10;
            this.downstream = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        public void onNext(T t10) {
            if (this.won) {
                this.downstream.onNext(t10);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onNext(t10);
            } else {
                ((Disposable) get()).dispose();
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        int i10;
        ObservableSource<? extends T>[] observableSourceArr = this.sources;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            try {
                i10 = 0;
                for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                    if (observableSource == null) {
                        EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (Observer<?>) observer);
                        return;
                    }
                    if (i10 == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i10 >> 2) + i10)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i10);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i11 = i10 + 1;
                    observableSourceArr[i10] = observableSource;
                    i10 = i11;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
                return;
            }
        } else {
            i10 = observableSourceArr.length;
        }
        if (i10 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
        } else if (i10 == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            new AmbCoordinator(observer, i10).subscribe(observableSourceArr);
        }
    }
}
