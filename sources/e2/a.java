package e2;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import s2.d;
import t9.g;
import t9.i;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0081a f6467b = new C0081a((g) null);

    /* renamed from: c  reason: collision with root package name */
    public static a f6468c;

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f6469a = d.c();

    /* renamed from: e2.a$a  reason: collision with other inner class name */
    public static final class C0081a {
        public C0081a() {
        }

        public /* synthetic */ C0081a(g gVar) {
            this();
        }

        public final a a() {
            a b10 = b();
            i.d(b10);
            return b10;
        }

        public final a b() {
            if (a.f6468c == null) {
                a.f6468c = new a();
            }
            return a.f6468c;
        }
    }

    public final void c(f2.d dVar) {
        i.g(dVar, "request");
        this.f6469a.execute(new d.e("Big Bee Net", (Runnable) dVar, false));
    }
}
