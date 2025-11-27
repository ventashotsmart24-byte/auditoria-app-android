package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Map;

public final /* synthetic */ class q implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f5865a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f5866b;

    public /* synthetic */ q(Uploader uploader, Map map) {
        this.f5865a = uploader;
        this.f5866b = map;
    }

    public final Object execute() {
        return this.f5865a.lambda$logAndUpdateState$7(this.f5866b);
    }
}
