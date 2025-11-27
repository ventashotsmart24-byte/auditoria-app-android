package c1;

import a1.k;
import a1.s;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.a;
import b1.e;
import b1.j;
import f1.c;
import f1.d;
import j1.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b implements e, c, b1.b {

    /* renamed from: i  reason: collision with root package name */
    public static final String f4581i = k.f("GreedyScheduler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f4582a;

    /* renamed from: b  reason: collision with root package name */
    public final j f4583b;

    /* renamed from: c  reason: collision with root package name */
    public final d f4584c;

    /* renamed from: d  reason: collision with root package name */
    public final Set f4585d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public a f4586e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4587f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f4588g;

    /* renamed from: h  reason: collision with root package name */
    public Boolean f4589h;

    public b(Context context, a aVar, m1.a aVar2, j jVar) {
        this.f4582a = context;
        this.f4583b = jVar;
        this.f4584c = new d(context, aVar2, this);
        this.f4586e = new a(this, aVar.k());
        this.f4588g = new Object();
    }

    public boolean a() {
        return false;
    }

    public void b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c().a(f4581i, String.format("Constraints not met: Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
            this.f4583b.w(str);
        }
    }

    public void c(String str, boolean z10) {
        h(str);
    }

    public void cancel(String str) {
        if (this.f4589h == null) {
            f();
        }
        if (!this.f4589h.booleanValue()) {
            k.c().d(f4581i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        g();
        k.c().a(f4581i, String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        a aVar = this.f4586e;
        if (aVar != null) {
            aVar.b(str);
        }
        this.f4583b.w(str);
    }

    public void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c().a(f4581i, String.format("Constraints met: Scheduling work ID %s", new Object[]{str}), new Throwable[0]);
            this.f4583b.t(str);
        }
    }

    public void e(p... pVarArr) {
        if (this.f4589h == null) {
            f();
        }
        if (!this.f4589h.booleanValue()) {
            k.c().d(f4581i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        g();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long a10 = pVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.f7090b == s.ENQUEUED) {
                if (currentTimeMillis < a10) {
                    a aVar = this.f4586e;
                    if (aVar != null) {
                        aVar.a(pVar);
                    }
                } else if (pVar.b()) {
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 23 && pVar.f7098j.h()) {
                        k.c().a(f4581i, String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{pVar}), new Throwable[0]);
                    } else if (i10 < 24 || !pVar.f7098j.e()) {
                        hashSet.add(pVar);
                        hashSet2.add(pVar.f7089a);
                    } else {
                        k.c().a(f4581i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{pVar}), new Throwable[0]);
                    }
                } else {
                    k.c().a(f4581i, String.format("Starting work for %s", new Object[]{pVar.f7089a}), new Throwable[0]);
                    this.f4583b.t(pVar.f7089a);
                }
            }
        }
        synchronized (this.f4588g) {
            if (!hashSet.isEmpty()) {
                k.c().a(f4581i, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", hashSet2)}), new Throwable[0]);
                this.f4585d.addAll(hashSet);
                this.f4584c.d(this.f4585d);
            }
        }
    }

    public final void f() {
        this.f4589h = Boolean.valueOf(k1.j.b(this.f4582a, this.f4583b.h()));
    }

    public final void g() {
        if (!this.f4587f) {
            this.f4583b.l().d(this);
            this.f4587f = true;
        }
    }

    public final void h(String str) {
        synchronized (this.f4588g) {
            Iterator it = this.f4585d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p pVar = (p) it.next();
                if (pVar.f7089a.equals(str)) {
                    k.c().a(f4581i, String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                    this.f4585d.remove(pVar);
                    this.f4584c.d(this.f4585d);
                    break;
                }
            }
        }
    }
}
