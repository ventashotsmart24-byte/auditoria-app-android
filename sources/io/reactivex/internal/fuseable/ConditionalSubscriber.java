package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    /* synthetic */ void onComplete();

    /* synthetic */ void onError(Throwable th);

    /* synthetic */ void onNext(Object obj);

    boolean tryOnNext(T t10);
}
