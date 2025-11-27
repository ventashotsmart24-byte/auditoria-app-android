package j4;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class a implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f7194a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f7195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EventInternal f7196c;

    public /* synthetic */ a(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.f7194a = defaultScheduler;
        this.f7195b = transportContext;
        this.f7196c = eventInternal;
    }

    public final Object execute() {
        return this.f7194a.lambda$schedule$0(this.f7195b, this.f7196c);
    }
}
