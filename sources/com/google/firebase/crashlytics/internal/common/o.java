package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class o implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10213a;

    public /* synthetic */ o(TaskCompletionSource taskCompletionSource) {
        this.f10213a = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Utils.lambda$race$1(this.f10213a, task);
    }
}
