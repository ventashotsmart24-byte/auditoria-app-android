package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

public final /* synthetic */ class a implements FirebaseInAppMessagingDisplay {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInAppMessagingDisplay f10234a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f10235b;

    public /* synthetic */ a(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity) {
        this.f10234a = firebaseInAppMessagingDisplay;
        this.f10235b = activity;
    }

    public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.f10234a.lambda$bindFiamToActivity$0(this.f10235b, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }
}
