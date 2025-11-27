package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class m implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f10384a;

    public /* synthetic */ m(FirebaseMessaging firebaseMessaging) {
        this.f10384a = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        this.f10384a.lambda$new$2((TopicsSubscriber) obj);
    }
}
