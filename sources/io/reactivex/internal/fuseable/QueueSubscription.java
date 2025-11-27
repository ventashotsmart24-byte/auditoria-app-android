package io.reactivex.internal.fuseable;

import fb.d;

public interface QueueSubscription<T> extends QueueFuseable<T>, d {
    /* synthetic */ void cancel();

    /* synthetic */ void request(long j10);
}
