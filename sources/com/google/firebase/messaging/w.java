package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class w implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GmsRpc f10397a;

    public /* synthetic */ w(GmsRpc gmsRpc) {
        this.f10397a = gmsRpc;
    }

    public final Object then(Task task) {
        return this.f10397a.lambda$extractResponseWhenComplete$0(task);
    }
}
