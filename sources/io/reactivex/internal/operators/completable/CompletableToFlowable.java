package io.reactivex.internal.operators.completable;

import fb.c;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;

public final class CompletableToFlowable<T> extends Flowable<T> {
    final CompletableSource source;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.source = completableSource;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new SubscriberCompletableObserver(cVar));
    }
}
