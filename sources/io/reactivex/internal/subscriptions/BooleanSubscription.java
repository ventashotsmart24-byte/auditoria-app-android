package io.reactivex.internal.subscriptions;

import fb.d;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BooleanSubscription extends AtomicBoolean implements d {
    private static final long serialVersionUID = -8127758972444290902L;

    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    public void request(long j10) {
        SubscriptionHelper.validate(j10);
    }

    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
