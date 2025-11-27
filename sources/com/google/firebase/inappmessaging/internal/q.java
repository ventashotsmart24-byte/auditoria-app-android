package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10311a;

    public /* synthetic */ q(TaskCompletionSource taskCompletionSource) {
        this.f10311a = taskCompletionSource;
    }

    public final Object apply(Object obj) {
        return DisplayCallbacksImpl.lambda$maybeToTask$10(this.f10311a, (Throwable) obj);
    }
}
