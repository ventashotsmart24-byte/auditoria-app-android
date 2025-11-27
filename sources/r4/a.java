package r4;

import android.content.Context;
import com.ixuea.android.downloader.db.DefaultDownloadDBController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import s4.c;
import u4.c;
import x4.b;

public final class a implements c, c.a {

    /* renamed from: g  reason: collision with root package name */
    public static a f19363g;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f19364a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap f19365b;

    /* renamed from: c  reason: collision with root package name */
    public final List f19366c;

    /* renamed from: d  reason: collision with root package name */
    public final u4.a f19367d;

    /* renamed from: e  reason: collision with root package name */
    public final b f19368e;

    /* renamed from: f  reason: collision with root package name */
    public final t4.a f19369f;

    public a(Context context, t4.a aVar) {
        if (aVar == null) {
            this.f19369f = new t4.a();
        } else {
            this.f19369f = aVar;
        }
        if (this.f19369f.d() == null) {
            this.f19368e = new DefaultDownloadDBController(context, this.f19369f);
        } else {
            this.f19368e = this.f19369f.d();
        }
        if (this.f19368e.b() == null) {
            this.f19366c = new ArrayList();
        } else {
            this.f19366c = this.f19368e.b();
        }
        this.f19365b = new ConcurrentHashMap();
        this.f19368e.g();
        this.f19364a = Executors.newFixedThreadPool(this.f19369f.e());
        this.f19367d = new u4.b(this.f19368e);
    }

    public static s4.c f(Context context, t4.a aVar) {
        synchronized (a.class) {
            if (f19363g == null) {
                f19363g = new a(context, aVar);
            }
        }
        return f19363g;
    }

    public void a(y4.a aVar) {
        this.f19365b.remove(aVar.g());
        this.f19366c.remove(aVar);
        List<y4.b> e10 = aVar.e();
        if (e10 != null && e10.size() > 0) {
            for (y4.b d10 : e10) {
                this.f19368e.d(d10);
            }
        }
        h();
    }

    public void b(y4.a aVar) {
        if (!e(aVar)) {
            this.f19366c.add(aVar);
            g(aVar);
        } else if (aVar.k() == 6) {
            this.f19366c.add(aVar);
            g(aVar);
        }
    }

    public void c(y4.a aVar) {
        aVar.C(7);
        this.f19365b.remove(aVar.g());
        this.f19366c.remove(aVar);
        this.f19368e.a(aVar);
        this.f19367d.a(aVar);
    }

    public y4.a d(String str) {
        y4.a aVar;
        Iterator it = this.f19366c.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = (y4.a) it.next();
            if (aVar.g().equals(str)) {
                break;
            }
        }
        if (aVar == null) {
            return this.f19368e.c(str);
        }
        return aVar;
    }

    public final boolean e(y4.a aVar) {
        if (aVar.n() || !this.f19365b.containsKey(aVar.g())) {
            return false;
        }
        return true;
    }

    public final void g(y4.a aVar) {
        if (this.f19365b.size() >= this.f19369f.e()) {
            aVar.C(3);
            this.f19367d.a(aVar);
            return;
        }
        u4.c cVar = new u4.c(this.f19364a, this.f19367d, aVar, this.f19369f, this);
        this.f19365b.put(aVar.g(), cVar);
        aVar.s(aVar.b() + 1);
        aVar.C(1);
        this.f19367d.a(aVar);
        cVar.g();
    }

    public final void h() {
        for (y4.a aVar : this.f19366c) {
            if (aVar.k() == 3) {
                g(aVar);
                return;
            }
        }
    }
}
