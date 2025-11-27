package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableTake;

public final class FlowableTakePublisher<T> extends Flowable<T> {
    final long limit;
    final b source;

    public FlowableTakePublisher(b bVar, long j10) {
        this.source = bVar;
        this.limit = j10;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new FlowableTake.TakeSubscriber(cVar, this.limit));
    }
}
