package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import y8.k1;
import y8.o0;
import y8.p;
import y8.q;

public final class p1 extends o0 {

    /* renamed from: c  reason: collision with root package name */
    public final o0.d f20862c;

    /* renamed from: d  reason: collision with root package name */
    public o0.h f20863d;

    public class a implements o0.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o0.h f20864a;

        public a(o0.h hVar) {
            this.f20864a = hVar;
        }

        public void a(q qVar) {
            p1.this.h(this.f20864a, qVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20866a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                y8.p[] r0 = y8.p.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20866a = r0
                y8.p r1 = y8.p.IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20866a     // Catch:{ NoSuchFieldError -> 0x001d }
                y8.p r1 = y8.p.CONNECTING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20866a     // Catch:{ NoSuchFieldError -> 0x0028 }
                y8.p r1 = y8.p.READY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20866a     // Catch:{ NoSuchFieldError -> 0x0033 }
                y8.p r1 = y8.p.TRANSIENT_FAILURE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.p1.b.<clinit>():void");
        }
    }

    public static final class c extends o0.i {

        /* renamed from: a  reason: collision with root package name */
        public final o0.e f20867a;

        public c(o0.e eVar) {
            this.f20867a = (o0.e) Preconditions.checkNotNull(eVar, "result");
        }

        public o0.e a(o0.f fVar) {
            return this.f20867a;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) c.class).add("result", (Object) this.f20867a).toString();
        }
    }

    public final class d extends o0.i {

        /* renamed from: a  reason: collision with root package name */
        public final o0.h f20868a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f20869b = new AtomicBoolean(false);

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                d.this.f20868a.e();
            }
        }

        public d(o0.h hVar) {
            this.f20868a = (o0.h) Preconditions.checkNotNull(hVar, "subchannel");
        }

        public o0.e a(o0.f fVar) {
            if (this.f20869b.compareAndSet(false, true)) {
                p1.this.f20862c.d().execute(new a());
            }
            return o0.e.g();
        }
    }

    public p1(o0.d dVar) {
        this.f20862c = (o0.d) Preconditions.checkNotNull(dVar, "helper");
    }

    public boolean a(o0.g gVar) {
        List a10 = gVar.a();
        if (a10.isEmpty()) {
            k1 k1Var = k1.f20056u;
            c(k1Var.r("NameResolver returned no usable address. addrs=" + gVar.a() + ", attrs=" + gVar.b()));
            return false;
        }
        o0.h hVar = this.f20863d;
        if (hVar == null) {
            o0.h a11 = this.f20862c.a(o0.b.c().d(a10).b());
            a11.g(new a(a11));
            this.f20863d = a11;
            this.f20862c.f(p.CONNECTING, new c(o0.e.h(a11)));
            a11.e();
            return true;
        }
        hVar.h(a10);
        return true;
    }

    public void c(k1 k1Var) {
        o0.h hVar = this.f20863d;
        if (hVar != null) {
            hVar.f();
            this.f20863d = null;
        }
        this.f20862c.f(p.TRANSIENT_FAILURE, new c(o0.e.f(k1Var)));
    }

    public void e() {
        o0.h hVar = this.f20863d;
        if (hVar != null) {
            hVar.f();
        }
    }

    public final void h(o0.h hVar, q qVar) {
        o0.i iVar;
        o0.i iVar2;
        p c10 = qVar.c();
        if (c10 != p.SHUTDOWN) {
            if (qVar.c() == p.TRANSIENT_FAILURE || qVar.c() == p.IDLE) {
                this.f20862c.e();
            }
            int i10 = b.f20866a[c10.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    iVar = new c(o0.e.g());
                } else if (i10 == 3) {
                    iVar2 = new c(o0.e.h(hVar));
                } else if (i10 == 4) {
                    iVar = new c(o0.e.f(qVar.d()));
                } else {
                    throw new IllegalArgumentException("Unsupported state:" + c10);
                }
                this.f20862c.f(c10, iVar);
            }
            iVar2 = new d(hVar);
            iVar = iVar2;
            this.f20862c.f(c10, iVar);
        }
    }
}
