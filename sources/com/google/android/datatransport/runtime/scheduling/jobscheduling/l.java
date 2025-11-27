package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class l implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5854a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5855b;

    public /* synthetic */ l(Uploader uploader, TransportContext transportContext) {
        this.f5854a = uploader;
        this.f5855b = transportContext;
    }

    public final Object execute() {
        return this.f5854a.lambda$logAndUpdateState$2(this.f5855b);
    }
}
