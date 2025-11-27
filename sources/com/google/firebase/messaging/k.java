package com.google.firebase.messaging;

import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

public final /* synthetic */ class k implements FirebaseInstanceIdInternal.NewTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f10382a;

    public /* synthetic */ k(FirebaseMessaging firebaseMessaging) {
        this.f10382a = firebaseMessaging;
    }

    public final void onNewToken(String str) {
        this.f10382a.lambda$new$0(str);
    }
}
