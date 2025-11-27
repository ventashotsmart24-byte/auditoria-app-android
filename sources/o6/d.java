package o6;

import com.google.firebase.messaging.Constants;
import t9.i;

public final class d extends b {

    /* renamed from: d  reason: collision with root package name */
    public boolean f19089d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String str, String str2, boolean z10, boolean z11) {
        super(str, str2, z10);
        i.g(str, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        i.g(str2, "value");
        this.f19089d = z11;
    }
}
