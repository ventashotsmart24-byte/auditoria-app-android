package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class k implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5851a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5852b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5853c;

    public /* synthetic */ k(Uploader uploader, TransportContext transportContext, int i10) {
        this.f5851a = uploader;
        this.f5852b = transportContext;
        this.f5853c = i10;
    }

    public final Object execute() {
        return this.f5851a.lambda$upload$0(this.f5852b, this.f5853c);
    }
}
