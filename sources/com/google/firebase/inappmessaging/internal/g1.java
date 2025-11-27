package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Function;

public final /* synthetic */ class g1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f10272a;

    public /* synthetic */ g1(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f10272a = inAppMessageStreamManager;
    }

    public final Object apply(Object obj) {
        return this.f10272a.lambda$createFirebaseInAppMessageStream$21((String) obj);
    }
}
