package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

public final /* synthetic */ class p implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10310a;

    public /* synthetic */ p(TaskCompletionSource taskCompletionSource) {
        this.f10310a = taskCompletionSource;
    }

    public final Object call() {
        return this.f10310a.setResult(null);
    }
}
