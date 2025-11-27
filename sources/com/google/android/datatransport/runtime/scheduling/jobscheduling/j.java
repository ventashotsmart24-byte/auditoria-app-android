package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class j implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventStore f5850a;

    public /* synthetic */ j(EventStore eventStore) {
        this.f5850a = eventStore;
    }

    public final Object execute() {
        return Integer.valueOf(this.f5850a.cleanUp());
    }
}
