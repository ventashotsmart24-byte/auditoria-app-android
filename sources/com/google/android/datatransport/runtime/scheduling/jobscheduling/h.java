package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class h implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5843a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5844b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f5845c;

    public /* synthetic */ h(Uploader uploader, TransportContext transportContext, long j10) {
        this.f5843a = uploader;
        this.f5844b = transportContext;
        this.f5845c = j10;
    }

    public final Object execute() {
        return this.f5843a.lambda$logAndUpdateState$8(this.f5844b, this.f5845c);
    }
}
