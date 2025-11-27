package androidx.work.impl.foreground;

import a1.e;
import a1.k;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import b1.j;
import f1.c;
import f1.d;
import j1.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class a implements c, b1.b {

    /* renamed from: k  reason: collision with root package name */
    public static final String f3468k = k.f("SystemFgDispatcher");

    /* renamed from: a  reason: collision with root package name */
    public Context f3469a;

    /* renamed from: b  reason: collision with root package name */
    public j f3470b;

    /* renamed from: c  reason: collision with root package name */
    public final m1.a f3471c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3472d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public String f3473e;

    /* renamed from: f  reason: collision with root package name */
    public final Map f3474f;

    /* renamed from: g  reason: collision with root package name */
    public final Map f3475g;

    /* renamed from: h  reason: collision with root package name */
    public final Set f3476h;

    /* renamed from: i  reason: collision with root package name */
    public final d f3477i;

    /* renamed from: j  reason: collision with root package name */
    public b f3478j;

    /* renamed from: androidx.work.impl.foreground.a$a  reason: collision with other inner class name */
    public class C0059a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkDatabase f3479a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3480b;

        public C0059a(WorkDatabase workDatabase, String str) {
            this.f3479a = workDatabase;
            this.f3480b = str;
        }

        public void run() {
            p h10 = this.f3479a.B().h(this.f3480b);
            if (h10 != null && h10.b()) {
                synchronized (a.this.f3472d) {
                    a.this.f3475g.put(this.f3480b, h10);
                    a.this.f3476h.add(h10);
                    a aVar = a.this;
                    aVar.f3477i.d(aVar.f3476h);
                }
            }
        }
    }

    public interface b {
        void a(int i10, Notification notification);

        void c(int i10, int i11, Notification notification);

        void d(int i10);

        void stop();
    }

    public a(Context context) {
        this.f3469a = context;
        j j10 = j.j(context);
        this.f3470b = j10;
        m1.a o10 = j10.o();
        this.f3471c = o10;
        this.f3473e = null;
        this.f3474f = new LinkedHashMap();
        this.f3476h = new HashSet();
        this.f3475g = new HashMap();
        this.f3477i = new d(this.f3469a, o10, this);
        this.f3470b.l().d(this);
    }

    public static Intent a(Context context, String str, e eVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent e(Context context, String str, e eVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    public void b(List list) {
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                k.c().a(f3468k, String.format("Constraints unmet for WorkSpec %s", new Object[]{str}), new Throwable[0]);
                this.f3470b.v(str);
            }
        }
    }

    public void c(String str, boolean z10) {
        boolean z11;
        Map.Entry entry;
        synchronized (this.f3472d) {
            p pVar = (p) this.f3475g.remove(str);
            if (pVar != null) {
                z11 = this.f3476h.remove(pVar);
            } else {
                z11 = false;
            }
            if (z11) {
                this.f3477i.d(this.f3476h);
            }
        }
        e eVar = (e) this.f3474f.remove(str);
        if (str.equals(this.f3473e) && this.f3474f.size() > 0) {
            Iterator it = this.f3474f.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.f3473e = (String) entry.getKey();
            if (this.f3478j != null) {
                e eVar2 = (e) entry.getValue();
                this.f3478j.c(eVar2.c(), eVar2.a(), eVar2.b());
                this.f3478j.d(eVar2.c());
            }
        }
        b bVar = this.f3478j;
        if (eVar != null && bVar != null) {
            k.c().a(f3468k, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(eVar.c()), str, Integer.valueOf(eVar.a())}), new Throwable[0]);
            bVar.d(eVar.c());
        }
    }

    public void d(List list) {
    }

    public final void g(Intent intent) {
        k.c().d(f3468k, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.f3470b.e(UUID.fromString(stringExtra));
        }
    }

    public final void h(Intent intent) {
        int i10 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        k.c().a(f3468k, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (notification != null && this.f3478j != null) {
            this.f3474f.put(stringExtra, new e(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f3473e)) {
                this.f3473e = stringExtra;
                this.f3478j.c(intExtra, intExtra2, notification);
                return;
            }
            this.f3478j.a(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry value : this.f3474f.entrySet()) {
                    i10 |= ((e) value.getValue()).a();
                }
                e eVar = (e) this.f3474f.get(this.f3473e);
                if (eVar != null) {
                    this.f3478j.c(eVar.c(), i10, eVar.b());
                }
            }
        }
    }

    public final void i(Intent intent) {
        k.c().d(f3468k, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        this.f3471c.b(new C0059a(this.f3470b.n(), stringExtra));
    }

    public void j(Intent intent) {
        k.c().d(f3468k, "Stopping foreground service", new Throwable[0]);
        b bVar = this.f3478j;
        if (bVar != null) {
            bVar.stop();
        }
    }

    public void k() {
        this.f3478j = null;
        synchronized (this.f3472d) {
            this.f3477i.e();
        }
        this.f3470b.l().i(this);
    }

    public void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
            h(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            h(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            g(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            j(intent);
        }
    }

    public void m(b bVar) {
        if (this.f3478j != null) {
            k.c().b(f3468k, "A callback already exists.", new Throwable[0]);
        } else {
            this.f3478j = bVar;
        }
    }
}
