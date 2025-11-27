package k1;

import a1.n;
import a1.s;
import androidx.work.impl.WorkDatabase;
import b1.c;
import b1.e;
import b1.f;
import b1.j;
import j1.q;
import java.util.LinkedList;
import java.util.UUID;

public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final c f7230a = new c();

    /* renamed from: k1.a$a  reason: collision with other inner class name */
    public class C0095a extends a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f7231b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UUID f7232c;

        public C0095a(j jVar, UUID uuid) {
            this.f7231b = jVar;
            this.f7232c = uuid;
        }

        /* JADX INFO: finally extract failed */
        public void g() {
            WorkDatabase n10 = this.f7231b.n();
            n10.c();
            try {
                a(this.f7231b, this.f7232c.toString());
                n10.r();
                n10.g();
                f(this.f7231b);
            } catch (Throwable th) {
                n10.g();
                throw th;
            }
        }
    }

    public class b extends a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f7233b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7234c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f7235d;

        public b(j jVar, String str, boolean z10) {
            this.f7233b = jVar;
            this.f7234c = str;
            this.f7235d = z10;
        }

        /* JADX INFO: finally extract failed */
        public void g() {
            WorkDatabase n10 = this.f7233b.n();
            n10.c();
            try {
                for (String a10 : n10.B().f(this.f7234c)) {
                    a(this.f7233b, a10);
                }
                n10.r();
                n10.g();
                if (this.f7235d) {
                    f(this.f7233b);
                }
            } catch (Throwable th) {
                n10.g();
                throw th;
            }
        }
    }

    public static a b(UUID uuid, j jVar) {
        return new C0095a(jVar, uuid);
    }

    public static a c(String str, j jVar, boolean z10) {
        return new b(jVar, str, z10);
    }

    public void a(j jVar, String str) {
        e(jVar.n(), str);
        jVar.l().l(str);
        for (e cancel : jVar.m()) {
            cancel.cancel(str);
        }
    }

    public n d() {
        return this.f7230a;
    }

    public final void e(WorkDatabase workDatabase, String str) {
        q B = workDatabase.B();
        j1.b t10 = workDatabase.t();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            s g10 = B.g(str2);
            if (!(g10 == s.SUCCEEDED || g10 == s.FAILED)) {
                B.d(s.CANCELLED, str2);
            }
            linkedList.addAll(t10.a(str2));
        }
    }

    public void f(j jVar) {
        f.b(jVar.h(), jVar.n(), jVar.m());
    }

    public abstract void g();

    public void run() {
        try {
            g();
            this.f7230a.a(n.f125a);
        } catch (Throwable th) {
            this.f7230a.a(new n.b.a(th));
        }
    }
}
