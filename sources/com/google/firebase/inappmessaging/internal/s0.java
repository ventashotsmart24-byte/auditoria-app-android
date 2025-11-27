package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnFailureListener;
import io.reactivex.MaybeEmitter;

public final /* synthetic */ class s0 implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaybeEmitter f10320a;

    public /* synthetic */ s0(MaybeEmitter maybeEmitter) {
        this.f10320a = maybeEmitter;
    }

    public final void onFailure(Exception exc) {
        InAppMessageStreamManager.lambda$taskToMaybe$29(this.f10320a, exc);
    }
}
