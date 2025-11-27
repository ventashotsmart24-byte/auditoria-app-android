package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import io.reactivex.MaybeEmitter;

public final /* synthetic */ class r0 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaybeEmitter f10315a;

    public /* synthetic */ r0(MaybeEmitter maybeEmitter) {
        this.f10315a = maybeEmitter;
    }

    public final void onSuccess(Object obj) {
        InAppMessageStreamManager.lambda$taskToMaybe$28(this.f10315a, obj);
    }
}
