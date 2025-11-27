package io.reactivex.internal.operators.flowable;

import fb.c;
import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;

public final class FlowableNever extends Flowable<Object> {
    public static final Flowable<Object> INSTANCE = new FlowableNever();

    private FlowableNever() {
    }

    public void subscribeActual(c cVar) {
        cVar.onSubscribe(EmptySubscription.INSTANCE);
    }
}
