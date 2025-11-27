package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f10139a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f10140b;

    public /* synthetic */ a(FirebaseApp firebaseApp, Context context) {
        this.f10139a = firebaseApp;
        this.f10140b = context;
    }

    public final Object get() {
        return this.f10139a.lambda$new$0(this.f10140b);
    }
}
