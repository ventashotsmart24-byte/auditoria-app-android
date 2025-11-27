package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class c0 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RequestDeduplicator f10358a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10359b;

    public /* synthetic */ c0(RequestDeduplicator requestDeduplicator, String str) {
        this.f10358a = requestDeduplicator;
        this.f10359b = str;
    }

    public final Object then(Task task) {
        return this.f10358a.lambda$getOrStartGetTokenRequest$0(this.f10359b, task);
    }
}
