package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class j implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f10379a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10380b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f10381c;

    public /* synthetic */ j(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f10379a = firebaseMessaging;
        this.f10380b = str;
        this.f10381c = token;
    }

    public final Task then(Object obj) {
        return this.f10379a.lambda$blockingGetToken$9(this.f10380b, this.f10381c, (String) obj);
    }
}
