package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.Task;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import java.util.concurrent.Executor;

public final /* synthetic */ class n0 implements MaybeOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Task f10302a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f10303b;

    public /* synthetic */ n0(Task task, Executor executor) {
        this.f10302a = task;
        this.f10303b = executor;
    }

    public final void subscribe(MaybeEmitter maybeEmitter) {
        InAppMessageStreamManager.lambda$taskToMaybe$30(this.f10302a, this.f10303b, maybeEmitter);
    }
}
