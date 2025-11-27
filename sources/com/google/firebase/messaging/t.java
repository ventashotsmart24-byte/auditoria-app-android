package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f10394a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10395b;

    public /* synthetic */ t(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f10394a = firebaseMessaging;
        this.f10395b = taskCompletionSource;
    }

    public final void run() {
        this.f10394a.lambda$getToken$4(this.f10395b);
    }
}
