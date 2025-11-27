package androidx.lifecycle;

import androidx.lifecycle.d;
import i.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class h extends d {

    /* renamed from: b  reason: collision with root package name */
    public i.a f2306b;

    /* renamed from: c  reason: collision with root package name */
    public d.c f2307c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference f2308d;

    /* renamed from: e  reason: collision with root package name */
    public int f2309e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2310f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2311g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f2312h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2313i;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d.c f2314a;

        /* renamed from: b  reason: collision with root package name */
        public e f2315b;

        public a(f fVar, d.c cVar) {
            this.f2315b = j.f(fVar);
            this.f2314a = cVar;
        }

        public void a(g gVar, d.b bVar) {
            d.c b10 = bVar.b();
            this.f2314a = h.k(this.f2314a, b10);
            this.f2315b.a(gVar, bVar);
            this.f2314a = b10;
        }
    }

    public h(g gVar) {
        this(gVar, true);
    }

    public static d.c k(d.c cVar, d.c cVar2) {
        if (cVar2 == null || cVar2.compareTo(cVar) >= 0) {
            return cVar;
        }
        return cVar2;
    }

    public void a(f fVar) {
        g gVar;
        boolean z10;
        f("addObserver");
        d.c cVar = this.f2307c;
        d.c cVar2 = d.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = d.c.INITIALIZED;
        }
        a aVar = new a(fVar, cVar2);
        if (((a) this.f2306b.f(fVar, aVar)) == null && (gVar = (g) this.f2308d.get()) != null) {
            if (this.f2309e != 0 || this.f2310f) {
                z10 = true;
            } else {
                z10 = false;
            }
            d.c e10 = e(fVar);
            this.f2309e++;
            while (aVar.f2314a.compareTo(e10) < 0 && this.f2306b.contains(fVar)) {
                n(aVar.f2314a);
                d.b c10 = d.b.c(aVar.f2314a);
                if (c10 != null) {
                    aVar.a(gVar, c10);
                    m();
                    e10 = e(fVar);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f2314a);
                }
            }
            if (!z10) {
                p();
            }
            this.f2309e--;
        }
    }

    public d.c b() {
        return this.f2307c;
    }

    public void c(f fVar) {
        f("removeObserver");
        this.f2306b.g(fVar);
    }

    public final void d(g gVar) {
        Iterator descendingIterator = this.f2306b.descendingIterator();
        while (descendingIterator.hasNext() && !this.f2311g) {
            Map.Entry entry = (Map.Entry) descendingIterator.next();
            a aVar = (a) entry.getValue();
            while (aVar.f2314a.compareTo(this.f2307c) > 0 && !this.f2311g && this.f2306b.contains(entry.getKey())) {
                d.b a10 = d.b.a(aVar.f2314a);
                if (a10 != null) {
                    n(a10.b());
                    aVar.a(gVar, a10);
                    m();
                } else {
                    throw new IllegalStateException("no event down from " + aVar.f2314a);
                }
            }
        }
    }

    public final d.c e(f fVar) {
        d.c cVar;
        Map.Entry h10 = this.f2306b.h(fVar);
        d.c cVar2 = null;
        if (h10 != null) {
            cVar = ((a) h10.getValue()).f2314a;
        } else {
            cVar = null;
        }
        if (!this.f2312h.isEmpty()) {
            ArrayList arrayList = this.f2312h;
            cVar2 = (d.c) arrayList.get(arrayList.size() - 1);
        }
        return k(k(this.f2307c, cVar), cVar2);
    }

    public final void f(String str) {
        if (this.f2313i && !h.a.e().b()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    public final void g(g gVar) {
        b.d c10 = this.f2306b.c();
        while (c10.hasNext() && !this.f2311g) {
            Map.Entry entry = (Map.Entry) c10.next();
            a aVar = (a) entry.getValue();
            while (aVar.f2314a.compareTo(this.f2307c) < 0 && !this.f2311g && this.f2306b.contains(entry.getKey())) {
                n(aVar.f2314a);
                d.b c11 = d.b.c(aVar.f2314a);
                if (c11 != null) {
                    aVar.a(gVar, c11);
                    m();
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f2314a);
                }
            }
        }
    }

    public void h(d.b bVar) {
        f("handleLifecycleEvent");
        l(bVar.b());
    }

    public final boolean i() {
        if (this.f2306b.size() == 0) {
            return true;
        }
        d.c cVar = ((a) this.f2306b.a().getValue()).f2314a;
        d.c cVar2 = ((a) this.f2306b.d().getValue()).f2314a;
        if (cVar == cVar2 && this.f2307c == cVar2) {
            return true;
        }
        return false;
    }

    public void j(d.c cVar) {
        f("markState");
        o(cVar);
    }

    public final void l(d.c cVar) {
        if (this.f2307c != cVar) {
            this.f2307c = cVar;
            if (this.f2310f || this.f2309e != 0) {
                this.f2311g = true;
                return;
            }
            this.f2310f = true;
            p();
            this.f2310f = false;
        }
    }

    public final void m() {
        ArrayList arrayList = this.f2312h;
        arrayList.remove(arrayList.size() - 1);
    }

    public final void n(d.c cVar) {
        this.f2312h.add(cVar);
    }

    public void o(d.c cVar) {
        f("setCurrentState");
        l(cVar);
    }

    public final void p() {
        g gVar = (g) this.f2308d.get();
        if (gVar != null) {
            while (!i()) {
                this.f2311g = false;
                if (this.f2307c.compareTo(((a) this.f2306b.a().getValue()).f2314a) < 0) {
                    d(gVar);
                }
                Map.Entry d10 = this.f2306b.d();
                if (!this.f2311g && d10 != null && this.f2307c.compareTo(((a) d10.getValue()).f2314a) > 0) {
                    g(gVar);
                }
            }
            this.f2311g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    public h(g gVar, boolean z10) {
        this.f2306b = new i.a();
        this.f2309e = 0;
        this.f2310f = false;
        this.f2311g = false;
        this.f2312h = new ArrayList();
        this.f2308d = new WeakReference(gVar);
        this.f2307c = d.c.INITIALIZED;
        this.f2313i = z10;
    }
}
