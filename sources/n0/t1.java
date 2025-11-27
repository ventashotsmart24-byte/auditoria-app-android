package n0;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import n0.p0;
import n0.q1;

public final class t1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8143a;

    /* renamed from: b  reason: collision with root package name */
    public final c f8144b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f8145c;

    /* renamed from: d  reason: collision with root package name */
    public final PackageManager f8146d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f8147e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public boolean f8148f;

    /* renamed from: g  reason: collision with root package name */
    public final BroadcastReceiver f8149g = new a();

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f8150h = new b();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            t1.this.h();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            t1.this.h();
        }
    }

    public interface c {
        void a(p0 p0Var);

        void b(p0 p0Var);

        void d(q1 q1Var, p0.e eVar);
    }

    public t1(Context context, c cVar) {
        this.f8143a = context;
        this.f8144b = cVar;
        this.f8145c = new Handler();
        this.f8146d = context.getPackageManager();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(q1 q1Var, p0.e eVar) {
        this.f8144b.d(q1Var, eVar);
    }

    public static boolean g(List list, ServiceInfo serviceInfo) {
        if (!(serviceInfo == null || list == null || list.isEmpty())) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo2 = (ServiceInfo) it.next();
                if (serviceInfo.packageName.equals(serviceInfo2.packageName) && serviceInfo.name.equals(serviceInfo2.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int c(String str, String str2) {
        int size = this.f8147e.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((q1) this.f8147e.get(i10)).G(str, str2)) {
                return i10;
            }
        }
        return -1;
    }

    public List d() {
        return (List) this.f8146d.queryIntentServices(new Intent("android.media.MediaRoute2ProviderService"), 0).stream().map(new s1()).collect(Collectors.toList());
    }

    public void h() {
        int i10;
        if (this.f8148f) {
            List arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 30) {
                arrayList = d();
            }
            int i11 = 0;
            for (ResolveInfo resolveInfo : this.f8146d.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0)) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && (!t0.n() || !g(arrayList, serviceInfo))) {
                    int c10 = c(serviceInfo.packageName, serviceInfo.name);
                    if (c10 < 0) {
                        q1 q1Var = new q1(this.f8143a, new ComponentName(serviceInfo.packageName, serviceInfo.name));
                        q1Var.P(new r1(this, q1Var));
                        q1Var.R();
                        i10 = i11 + 1;
                        this.f8147e.add(i11, q1Var);
                        this.f8144b.a(q1Var);
                    } else if (c10 >= i11) {
                        q1 q1Var2 = (q1) this.f8147e.get(c10);
                        q1Var2.R();
                        q1Var2.O();
                        i10 = i11 + 1;
                        Collections.swap(this.f8147e, c10, i11);
                    }
                    i11 = i10;
                }
            }
            if (i11 < this.f8147e.size()) {
                for (int size = this.f8147e.size() - 1; size >= i11; size--) {
                    q1 q1Var3 = (q1) this.f8147e.get(size);
                    this.f8144b.b(q1Var3);
                    this.f8147e.remove(q1Var3);
                    q1Var3.P((q1.b) null);
                    q1Var3.S();
                }
            }
        }
    }

    public void i() {
        if (!this.f8148f) {
            this.f8148f = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
            intentFilter.addDataScheme(Constants.KEY_PACKAGE);
            this.f8143a.registerReceiver(this.f8149g, intentFilter, (String) null, this.f8145c);
            this.f8145c.post(this.f8150h);
        }
    }
}
