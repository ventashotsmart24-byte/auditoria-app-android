package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class e0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f10365a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f10366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f10367c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Metadata f10368d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GmsRpc f10369e;

    public /* synthetic */ e0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        this.f10365a = context;
        this.f10366b = scheduledExecutorService;
        this.f10367c = firebaseMessaging;
        this.f10368d = metadata;
        this.f10369e = gmsRpc;
    }

    public final Object call() {
        return TopicsSubscriber.lambda$createInstance$0(this.f10365a, this.f10366b, this.f10367c, this.f10368d, this.f10369e);
    }
}
