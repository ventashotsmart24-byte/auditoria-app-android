package androidx.work.impl.diagnostics;

import a1.k;
import a1.m;
import a1.t;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;

public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3452a = k.f("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            k.c().a(f3452a, "Requesting diagnostics", new Throwable[0]);
            try {
                t.c(context).a(m.d(DiagnosticsWorker.class));
            } catch (IllegalStateException e10) {
                k.c().b(f3452a, "WorkManager is not initialized", e10);
            }
        }
    }
}
