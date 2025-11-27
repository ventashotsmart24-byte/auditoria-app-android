package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class n implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5858a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f5859b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5860c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f5861d;

    public /* synthetic */ n(Uploader uploader, Iterable iterable, TransportContext transportContext, long j10) {
        this.f5858a = uploader;
        this.f5859b = iterable;
        this.f5860c = transportContext;
        this.f5861d = j10;
    }

    public final Object execute() {
        return this.f5858a.lambda$logAndUpdateState$4(this.f5859b, this.f5860c, this.f5861d);
    }
}
