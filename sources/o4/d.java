package o4;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;

public final /* synthetic */ class d implements MetricsLoggerClient.EngagementMetricsLoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Transport f10623a;

    public /* synthetic */ d(Transport transport) {
        this.f10623a = transport;
    }

    public final void logEvent(byte[] bArr) {
        this.f10623a.send(Event.ofData(bArr));
    }
}
