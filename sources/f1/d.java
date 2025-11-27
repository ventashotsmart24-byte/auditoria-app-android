package f1;

import a1.k;
import android.content.Context;
import g1.b;
import g1.c;
import g1.e;
import g1.f;
import g1.g;
import g1.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m1.a;

public class d implements c.a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6538d = k.f("WorkConstraintsTracker");

    /* renamed from: a  reason: collision with root package name */
    public final c f6539a;

    /* renamed from: b  reason: collision with root package name */
    public final c[] f6540b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f6541c = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f6539a = cVar;
        this.f6540b = new c[]{new g1.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new g1.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public void a(List list) {
        synchronized (this.f6541c) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (c(str)) {
                    k.c().a(f6538d, String.format("Constraints met for %s", new Object[]{str}), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            c cVar = this.f6539a;
            if (cVar != null) {
                cVar.d(arrayList);
            }
        }
    }

    public void b(List list) {
        synchronized (this.f6541c) {
            c cVar = this.f6539a;
            if (cVar != null) {
                cVar.b(list);
            }
        }
    }

    public boolean c(String str) {
        synchronized (this.f6541c) {
            for (c cVar : this.f6540b) {
                if (cVar.d(str)) {
                    k.c().a(f6538d, String.format("Work %s constrained by %s", new Object[]{str, cVar.getClass().getSimpleName()}), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void d(Iterable iterable) {
        synchronized (this.f6541c) {
            for (c g10 : this.f6540b) {
                g10.g((c.a) null);
            }
            for (c e10 : this.f6540b) {
                e10.e(iterable);
            }
            for (c g11 : this.f6540b) {
                g11.g(this);
            }
        }
    }

    public void e() {
        synchronized (this.f6541c) {
            for (c f10 : this.f6540b) {
                f10.f();
            }
        }
    }
}
