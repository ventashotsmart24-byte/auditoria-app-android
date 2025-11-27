package io.reactivex.disposables;

import fb.d;
import io.reactivex.annotations.NonNull;

final class SubscriptionDisposable extends ReferenceDisposable<d> {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(d dVar) {
        super(dVar);
    }

    public void onDisposed(@NonNull d dVar) {
        dVar.cancel();
    }
}
