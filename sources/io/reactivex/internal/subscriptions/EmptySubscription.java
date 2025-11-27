package io.reactivex.internal.subscriptions;

import fb.c;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.QueueSubscription;

public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    public static void complete(c cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th, c cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Nullable
    public Object poll() {
        return null;
    }

    public void request(long j10) {
        SubscriptionHelper.validate(j10);
    }

    public int requestFusion(int i10) {
        return i10 & 2;
    }

    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
