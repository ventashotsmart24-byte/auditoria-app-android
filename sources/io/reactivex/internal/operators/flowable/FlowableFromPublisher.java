package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import io.reactivex.Flowable;

public final class FlowableFromPublisher<T> extends Flowable<T> {
    final b publisher;

    public FlowableFromPublisher(b bVar) {
        this.publisher = bVar;
    }

    public void subscribeActual(c cVar) {
        this.publisher.subscribe(cVar);
    }
}
