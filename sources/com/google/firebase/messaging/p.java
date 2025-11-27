package com.google.firebase.messaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class p implements RequestDeduplicator.GetTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f10387a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10388b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f10389c;

    public /* synthetic */ p(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f10387a = firebaseMessaging;
        this.f10388b = str;
        this.f10389c = token;
    }

    public final Task start() {
        return this.f10387a.lambda$blockingGetToken$10(this.f10388b, this.f10389c);
    }
}
