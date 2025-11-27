package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class p implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5864a;

    public /* synthetic */ p(Uploader uploader) {
        this.f5864a = uploader;
    }

    public final Object execute() {
        return this.f5864a.lambda$logAndUpdateState$6();
    }
}
