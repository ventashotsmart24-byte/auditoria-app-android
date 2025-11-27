package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class o implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5862a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f5863b;

    public /* synthetic */ o(Uploader uploader, Iterable iterable) {
        this.f5862a = uploader;
        this.f5863b = iterable;
    }

    public final Object execute() {
        return this.f5862a.lambda$logAndUpdateState$5(this.f5863b);
    }
}
