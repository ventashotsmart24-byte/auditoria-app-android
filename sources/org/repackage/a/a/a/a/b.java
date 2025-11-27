package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.repackage.a.a.a.a;

public class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f8631a;

    public b(c cVar) {
        this.f8631a = cVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f8631a.f8632a = a.C0112a.a(iBinder);
        synchronized (this.f8631a.f8635d) {
            this.f8631a.f8635d.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f8631a.f8632a = null;
    }
}
