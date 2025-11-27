package io.reactivex.internal.operators.maybe;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeConcatArrayDelayError<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, d {
        private static final long serialVersionUID = 3520831347801429610L;
        final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);
        final SequentialDisposable disposables = new SequentialDisposable();
        final c downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        int index;
        long produced;
        final AtomicLong requested = new AtomicLong();
        final MaybeSource<? extends T>[] sources;

        public ConcatMaybeObserver(c cVar, MaybeSource<? extends T>[] maybeSourceArr) {
            this.downstream = cVar;
            this.sources = maybeSourceArr;
        }

        public void cancel() {
            this.disposables.dispose();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.current;
                c cVar = this.downstream;
                SequentialDisposable sequentialDisposable = this.disposables;
                while (!sequentialDisposable.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        boolean z10 = true;
                        if (obj != NotificationLite.COMPLETE) {
                            long j10 = this.produced;
                            if (j10 != this.requested.get()) {
                                this.produced = j10 + 1;
                                atomicReference.lazySet((Object) null);
                                cVar.onNext(obj);
                            } else {
                                z10 = false;
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (z10 && !sequentialDisposable.isDisposed()) {
                            int i10 = this.index;
                            MaybeSource<? extends T>[] maybeSourceArr = this.sources;
                            if (i10 != maybeSourceArr.length) {
                                this.index = i10 + 1;
                                maybeSourceArr[i10].subscribe(this);
                            } else if (((Throwable) this.errors.get()) != null) {
                                cVar.onError(this.errors.terminate());
                                return;
                            } else {
                                cVar.onComplete();
                                return;
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        public void onError(Throwable th) {
            this.current.lazySet(NotificationLite.COMPLETE);
            if (this.errors.addThrowable(th)) {
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.disposables.replace(disposable);
        }

        public void onSuccess(T t10) {
            this.current.lazySet(t10);
            drain();
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.add(this.requested, j10);
                drain();
            }
        }
    }

    public MaybeConcatArrayDelayError(MaybeSource<? extends T>[] maybeSourceArr) {
        this.sources = maybeSourceArr;
    }

    public void subscribeActual(c cVar) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(cVar, this.sources);
        cVar.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.drain();
    }
}
