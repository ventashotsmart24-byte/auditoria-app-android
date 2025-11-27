package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f10390a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10391b;

    public /* synthetic */ q(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f10390a = firebaseMessaging;
        this.f10391b = taskCompletionSource;
    }

    public final void run() {
        this.f10390a.lambda$deleteToken$5(this.f10391b);
    }
}
