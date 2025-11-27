package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class d implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f10230a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10231b;

    public /* synthetic */ d(Context context, String str) {
        this.f10230a = context;
        this.f10231b = str;
    }

    public final Object get() {
        return DefaultHeartBeatController.lambda$new$2(this.f10230a, this.f10231b);
    }
}
