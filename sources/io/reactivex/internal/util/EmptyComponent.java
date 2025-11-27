package io.reactivex.internal.util;

import fb.c;
import fb.d;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;

public enum EmptyComponent implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, d, Disposable {
    INSTANCE;

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public static <T> c asSubscriber() {
        return INSTANCE;
    }

    public void cancel() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public void onComplete() {
    }

    public void onError(Throwable th) {
        RxJavaPlugins.onError(th);
    }

    public void onNext(Object obj) {
    }

    public void onSubscribe(Disposable disposable) {
        disposable.dispose();
    }

    public void onSuccess(Object obj) {
    }

    public void request(long j10) {
    }

    public void onSubscribe(d dVar) {
        dVar.cancel();
    }
}
