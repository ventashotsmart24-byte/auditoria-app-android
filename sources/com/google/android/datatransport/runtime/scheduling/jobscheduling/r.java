package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class r implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f5867a;

    public /* synthetic */ r(WorkInitializer workInitializer) {
        this.f5867a = workInitializer;
    }

    public final Object execute() {
        return this.f5867a.lambda$ensureContextsScheduled$0();
    }
}
