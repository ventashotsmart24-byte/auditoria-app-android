package io.reactivex.internal.subscriptions;

import fb.d;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeSubscription extends AtomicReferenceArray<d> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i10) {
        super(i10);
    }

    public void dispose() {
        d dVar;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i10 = 0; i10 < length; i10++) {
                d dVar2 = (d) get(i10);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (!(dVar2 == subscriptionHelper || (dVar = (d) getAndSet(i10, subscriptionHelper)) == subscriptionHelper || dVar == null)) {
                    dVar.cancel();
                }
            }
        }
    }

    public boolean isDisposed() {
        if (get(0) == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    public d replaceResource(int i10, d dVar) {
        d dVar2;
        do {
            dVar2 = (d) get(i10);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar == null) {
                    return null;
                }
                dVar.cancel();
                return null;
            }
        } while (!compareAndSet(i10, dVar2, dVar));
        return dVar2;
    }

    public boolean setResource(int i10, d dVar) {
        d dVar2;
        do {
            dVar2 = (d) get(i10);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!compareAndSet(i10, dVar2, dVar));
        if (dVar2 == null) {
            return true;
        }
        dVar2.cancel();
        return true;
    }
}
