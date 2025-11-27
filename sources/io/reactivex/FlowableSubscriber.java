package io.reactivex;

import fb.c;
import fb.d;
import io.reactivex.annotations.NonNull;

public interface FlowableSubscriber<T> extends c {
    /* synthetic */ void onComplete();

    /* synthetic */ void onError(Throwable th);

    /* synthetic */ void onNext(Object obj);

    void onSubscribe(@NonNull d dVar);
}
