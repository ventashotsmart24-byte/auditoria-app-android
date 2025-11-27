package j4;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f7197a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f7198b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportScheduleCallback f7199c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EventInternal f7200d;

    public /* synthetic */ b(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.f7197a = defaultScheduler;
        this.f7198b = transportContext;
        this.f7199c = transportScheduleCallback;
        this.f7200d = eventInternal;
    }

    public final void run() {
        this.f7197a.lambda$schedule$1(this.f7198b, this.f7199c, this.f7200d);
    }
}
