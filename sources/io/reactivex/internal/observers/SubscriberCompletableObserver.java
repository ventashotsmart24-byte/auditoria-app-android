package io.reactivex.internal.observers;

import fb.c;
import fb.d;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class SubscriberCompletableObserver<T> implements CompletableObserver, d {
    final c subscriber;
    Disposable upstream;

    public SubscriberCompletableObserver(c cVar) {
        this.subscriber = cVar;
    }

    public void cancel() {
        this.upstream.dispose();
    }

    public void onComplete() {
        this.subscriber.onComplete();
    }

    public void onError(Throwable th) {
        this.subscriber.onError(th);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.subscriber.onSubscribe(this);
        }
    }

    public void request(long j10) {
    }
}
