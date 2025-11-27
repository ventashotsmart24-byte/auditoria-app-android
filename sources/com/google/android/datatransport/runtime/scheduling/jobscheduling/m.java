package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class m implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5856a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5857b;

    public /* synthetic */ m(Uploader uploader, TransportContext transportContext) {
        this.f5856a = uploader;
        this.f5857b = transportContext;
    }

    public final Object execute() {
        return this.f5856a.lambda$logAndUpdateState$3(this.f5857b);
    }
}
