package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f10227a;

    public /* synthetic */ a(DefaultHeartBeatController defaultHeartBeatController) {
        this.f10227a = defaultHeartBeatController;
    }

    public final Object call() {
        return this.f10227a.lambda$getHeartBeatsHeader$1();
    }
}
