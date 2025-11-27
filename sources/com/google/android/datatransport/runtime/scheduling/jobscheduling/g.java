package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class g implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClientHealthMetricsStore f5842a;

    public /* synthetic */ g(ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f5842a = clientHealthMetricsStore;
    }

    public final Object execute() {
        return this.f5842a.loadClientMetrics();
    }
}
