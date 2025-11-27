package com.google.android.datatransport.runtime.scheduling.jobscheduling;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f5868a;

    public /* synthetic */ s(WorkInitializer workInitializer) {
        this.f5868a = workInitializer;
    }

    public final void run() {
        this.f5868a.lambda$ensureContextsScheduled$1();
    }
}
