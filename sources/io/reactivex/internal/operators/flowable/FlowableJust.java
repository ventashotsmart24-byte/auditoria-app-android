package io.reactivex.internal.operators.flowable;

import fb.c;
import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.ScalarSubscription;

public final class FlowableJust<T> extends Flowable<T> implements ScalarCallable<T> {
    private final T value;

    public FlowableJust(T t10) {
        this.value = t10;
    }

    public T call() {
        return this.value;
    }

    public void subscribeActual(c cVar) {
        cVar.onSubscribe(new ScalarSubscription(cVar, this.value));
    }
}
