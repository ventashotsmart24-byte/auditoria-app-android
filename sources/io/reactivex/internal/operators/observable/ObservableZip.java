package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip<T, R> extends Observable<R> {
    final int bufferSize;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final Observer<? super R> downstream;
        final ZipObserver<T, R>[] observers;
        final T[] row;
        final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i10, boolean z10) {
            this.downstream = observer;
            this.zipper = function;
            this.observers = new ZipObserver[i10];
            this.row = new Object[i10];
            this.delayError = z10;
        }

        public void cancel() {
            clear();
            cancelSources();
        }

        public void cancelSources() {
            for (ZipObserver<T, R> dispose : this.observers) {
                dispose.dispose();
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, Observer<? super R> observer, boolean z12, ZipObserver<?, ?> zipObserver) {
            if (this.cancelled) {
                cancel();
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!z12) {
                    Throwable th = zipObserver.error;
                    if (th != null) {
                        this.cancelled = true;
                        cancel();
                        observer.onError(th);
                        return true;
                    } else if (!z11) {
                        return false;
                    } else {
                        this.cancelled = true;
                        cancel();
                        observer.onComplete();
                        return true;
                    }
                } else if (!z11) {
                    return false;
                } else {
                    Throwable th2 = zipObserver.error;
                    this.cancelled = true;
                    cancel();
                    if (th2 != null) {
                        observer.onError(th2);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        public void clear() {
            for (ZipObserver<T, R> zipObserver : this.observers) {
                zipObserver.queue.clear();
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                if (getAndIncrement() == 0) {
                    clear();
                }
            }
        }

        public void drain() {
            Throwable th;
            boolean z10;
            if (getAndIncrement() == 0) {
                ZipObserver<T, R>[] zipObserverArr = this.observers;
                Observer<? super R> observer = this.downstream;
                T[] tArr = this.row;
                boolean z11 = this.delayError;
                int i10 = 1;
                while (true) {
                    int i11 = 0;
                    int i12 = 0;
                    for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                        if (tArr[i12] == null) {
                            boolean z12 = zipObserver.done;
                            T poll = zipObserver.queue.poll();
                            if (poll == null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (!checkTerminated(z12, z10, observer, z11, zipObserver)) {
                                if (!z10) {
                                    tArr[i12] = poll;
                                } else {
                                    i11++;
                                }
                            } else {
                                return;
                            }
                        } else if (zipObserver.done && !z11 && (th = zipObserver.error) != null) {
                            this.cancelled = true;
                            cancel();
                            observer.onError(th);
                            return;
                        }
                        i12++;
                    }
                    if (i11 != 0) {
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        try {
                            observer.onNext(ObjectHelper.requireNonNull(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            cancel();
                            observer.onError(th2);
                            return;
                        }
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr, int i10) {
            ZipObserver<T, R>[] zipObserverArr = this.observers;
            int length = zipObserverArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                zipObserverArr[i11] = new ZipObserver<>(this, i10);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i12 = 0; i12 < length && !this.cancelled; i12++) {
                observableSourceArr[i12].subscribe(zipObserverArr[i12]);
            }
        }
    }

    public static final class ZipObserver<T, R> implements Observer<T> {
        volatile boolean done;
        Throwable error;
        final ZipCoordinator<T, R> parent;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        public ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i10) {
            this.parent = zipCoordinator;
            this.queue = new SpscLinkedArrayQueue<>(i10);
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        public void onNext(T t10) {
            this.queue.offer(t10);
            this.parent.drain();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i10, boolean z10) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i10;
        this.delayError = z10;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i10;
        ObservableSource<? extends T>[] observableSourceArr = this.sources;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            i10 = 0;
            for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                if (i10 == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i10 >> 2) + i10)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i10);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i10] = observableSource;
                i10++;
            }
        } else {
            i10 = observableSourceArr.length;
        }
        if (i10 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
        } else {
            new ZipCoordinator(observer, this.zipper, i10, this.delayError).subscribe(observableSourceArr, this.bufferSize);
        }
    }
}
