package androidx.lifecycle;

import androidx.lifecycle.LiveData.c;
import androidx.lifecycle.d;
import i.b;
import java.util.Map;

public abstract class LiveData {

    /* renamed from: k  reason: collision with root package name */
    public static final Object f2264k = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f2265a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public i.b f2266b = new i.b();

    /* renamed from: c  reason: collision with root package name */
    public int f2267c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2268d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f2269e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Object f2270f;

    /* renamed from: g  reason: collision with root package name */
    public int f2271g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2272h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2273i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f2274j;

    public class LifecycleBoundObserver extends c implements e {

        /* renamed from: e  reason: collision with root package name */
        public final g f2275e;

        public LifecycleBoundObserver(g gVar, m mVar) {
            super(mVar);
            this.f2275e = gVar;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [androidx.lifecycle.LiveData$LifecycleBoundObserver, androidx.lifecycle.LiveData$c] */
        public void a(g gVar, d.b bVar) {
            d.c b10 = this.f2275e.getLifecycle().b();
            if (b10 == d.c.DESTROYED) {
                LiveData.this.m(this.f2279a);
                return;
            }
            d.c cVar = null;
            while (cVar != b10) {
                b(e());
                cVar = b10;
                b10 = this.f2275e.getLifecycle().b();
            }
        }

        public void c() {
            this.f2275e.getLifecycle().c(this);
        }

        public boolean d(g gVar) {
            if (this.f2275e == gVar) {
                return true;
            }
            return false;
        }

        public boolean e() {
            return this.f2275e.getLifecycle().b().a(d.c.STARTED);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.f2265a) {
                obj = LiveData.this.f2270f;
                LiveData.this.f2270f = LiveData.f2264k;
            }
            LiveData.this.n(obj);
        }
    }

    public class b extends c {
        public b(m mVar) {
            super(mVar);
        }

        public boolean e() {
            return true;
        }
    }

    public abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final m f2279a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2280b;

        /* renamed from: c  reason: collision with root package name */
        public int f2281c = -1;

        public c(m mVar) {
            this.f2279a = mVar;
        }

        public void b(boolean z10) {
            int i10;
            if (z10 != this.f2280b) {
                this.f2280b = z10;
                LiveData liveData = LiveData.this;
                if (z10) {
                    i10 = 1;
                } else {
                    i10 = -1;
                }
                liveData.c(i10);
                if (this.f2280b) {
                    LiveData.this.e(this);
                }
            }
        }

        public void c() {
        }

        public boolean d(g gVar) {
            return false;
        }

        public abstract boolean e();
    }

    public LiveData() {
        Object obj = f2264k;
        this.f2270f = obj;
        this.f2274j = new a();
        this.f2269e = obj;
        this.f2271g = -1;
    }

    public static void b(String str) {
        if (!h.a.e().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    public void c(int i10) {
        boolean z10;
        boolean z11;
        int i11 = this.f2267c;
        this.f2267c = i10 + i11;
        if (!this.f2268d) {
            this.f2268d = true;
            while (true) {
                try {
                    int i12 = this.f2267c;
                    if (i11 != i12) {
                        if (i11 != 0 || i12 <= 0) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (i11 <= 0 || i12 != 0) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (z10) {
                            j();
                        } else if (z11) {
                            k();
                        }
                        i11 = i12;
                    } else {
                        return;
                    }
                } finally {
                    this.f2268d = false;
                }
            }
        }
    }

    public final void d(c cVar) {
        if (cVar.f2280b) {
            if (!cVar.e()) {
                cVar.b(false);
                return;
            }
            int i10 = cVar.f2281c;
            int i11 = this.f2271g;
            if (i10 < i11) {
                cVar.f2281c = i11;
                cVar.f2279a.a(this.f2269e);
            }
        }
    }

    public void e(c cVar) {
        if (this.f2272h) {
            this.f2273i = true;
            return;
        }
        this.f2272h = true;
        do {
            this.f2273i = false;
            if (cVar == null) {
                b.d c10 = this.f2266b.c();
                while (c10.hasNext()) {
                    d((c) ((Map.Entry) c10.next()).getValue());
                    if (this.f2273i) {
                        break;
                    }
                }
            } else {
                d(cVar);
                cVar = null;
            }
        } while (this.f2273i);
        this.f2272h = false;
    }

    public Object f() {
        Object obj = this.f2269e;
        if (obj != f2264k) {
            return obj;
        }
        return null;
    }

    public boolean g() {
        if (this.f2267c > 0) {
            return true;
        }
        return false;
    }

    public void h(g gVar, m mVar) {
        b("observe");
        if (gVar.getLifecycle().b() != d.c.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
            c cVar = (c) this.f2266b.f(mVar, lifecycleBoundObserver);
            if (cVar != null && !cVar.d(gVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (cVar == null) {
                gVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void i(m mVar) {
        b("observeForever");
        b bVar = new b(mVar);
        c cVar = (c) this.f2266b.f(mVar, bVar);
        if (cVar instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (cVar == null) {
            bVar.b(true);
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void l(Object obj) {
        boolean z10;
        synchronized (this.f2265a) {
            if (this.f2270f == f2264k) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f2270f = obj;
        }
        if (z10) {
            h.a.e().c(this.f2274j);
        }
    }

    public void m(m mVar) {
        b("removeObserver");
        c cVar = (c) this.f2266b.g(mVar);
        if (cVar != null) {
            cVar.c();
            cVar.b(false);
        }
    }

    public void n(Object obj) {
        b("setValue");
        this.f2271g++;
        this.f2269e = obj;
        e((c) null);
    }
}
