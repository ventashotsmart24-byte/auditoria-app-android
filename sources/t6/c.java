package t6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.hpplay.component.protocol.push.IPushHandler;
import com.mobile.brasiltv.bean.event.StopPlayEvent;
import k7.f;
import q8.e;
import t9.i;

public final class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final String f19547a = IPushHandler.REASON;

    /* renamed from: b  reason: collision with root package name */
    public final String f19548b = "recentapps";

    /* renamed from: c  reason: collision with root package name */
    public final String f19549c = "homekey";

    /* renamed from: d  reason: collision with root package name */
    public final String f19550d = "lock";

    /* renamed from: e  reason: collision with root package name */
    public final String f19551e = "dream";

    /* renamed from: f  reason: collision with root package name */
    public final String f19552f = "assist";

    public void onReceive(Context context, Intent intent) {
        boolean z10;
        boolean z11;
        boolean z12;
        i.g(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        if (i.b(action, "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
            String stringExtra = intent.getStringExtra(this.f19547a);
            f.e("reason: " + stringExtra, new Object[0]);
            boolean z13 = true;
            if (i.b(stringExtra, this.f19549c)) {
                z10 = true;
            } else {
                z10 = i.b(stringExtra, this.f19548b);
            }
            if (z10) {
                z11 = true;
            } else {
                z11 = i.b(stringExtra, this.f19550d);
            }
            if (z11) {
                z12 = true;
            } else {
                z12 = i.b(stringExtra, this.f19551e);
            }
            if (!z12) {
                z13 = i.b(stringExtra, this.f19552f);
            }
            if (z13) {
                xa.c.c().j(new StopPlayEvent(StopPlayEvent.Reason.PRESS_HOME));
            }
        }
        if (i.b(action, "android.intent.action.SCREEN_OFF")) {
            f.e("SCREEN_OFF", new Object[0]);
            xa.c.c().j(new StopPlayEvent(StopPlayEvent.Reason.SCREEN_OFF));
            e.e("stop");
        } else if (i.b(action, "android.intent.action.SCREEN_ON")) {
            f.e("SCREEN_ON", new Object[0]);
            e.e("start");
        }
    }
}
