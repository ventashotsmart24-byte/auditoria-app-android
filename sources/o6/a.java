package o6;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import t9.i;

public final class a extends b {

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f19082d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, String str2, boolean z10, ArrayList arrayList) {
        super(str, str2, z10);
        i.g(str, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        i.g(str2, "value");
        i.g(arrayList, "liveAddressList");
        this.f19082d = arrayList;
    }

    public final ArrayList e() {
        return this.f19082d;
    }
}
