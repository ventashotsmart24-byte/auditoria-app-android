package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10296a;

    public /* synthetic */ m(TaskCompletionSource taskCompletionSource) {
        this.f10296a = taskCompletionSource;
    }

    public final void accept(Object obj) {
        this.f10296a.setResult(obj);
    }
}
