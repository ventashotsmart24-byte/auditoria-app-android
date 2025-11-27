package androidx.work.impl;

import android.content.Context;
import androidx.work.impl.a;
import b1.h;
import j1.k;
import j1.n;
import j1.q;
import j1.t;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import q0.e;
import t0.c;
import u0.d;

public abstract class WorkDatabase extends e {

    /* renamed from: l  reason: collision with root package name */
    public static final long f3385l = TimeUnit.DAYS.toMillis(1);

    public class a implements c.C0123c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3386a;

        public a(Context context) {
            this.f3386a = context;
        }

        public c a(c.b bVar) {
            c.b.a a10 = c.b.a(this.f3386a);
            a10.c(bVar.f9343b).b(bVar.f9344c).d(true);
            return new d().a(a10.a());
        }
    }

    public class b extends e.b {
        public void c(t0.b bVar) {
            super.c(bVar);
            bVar.beginTransaction();
            try {
                bVar.execSQL(WorkDatabase.w());
                bVar.setTransactionSuccessful();
            } finally {
                bVar.endTransaction();
            }
        }
    }

    public static WorkDatabase s(Context context, Executor executor, boolean z10) {
        e.a aVar;
        Class<WorkDatabase> cls = WorkDatabase.class;
        if (z10) {
            aVar = q0.d.c(context, cls).c();
        } else {
            aVar = q0.d.a(context, cls, h.d());
            aVar.f(new a(context));
        }
        return (WorkDatabase) aVar.g(executor).a(u()).b(a.f3395a).b(new a.h(context, 2, 3)).b(a.f3396b).b(a.f3397c).b(new a.h(context, 5, 6)).b(a.f3398d).b(a.f3399e).b(a.f3400f).b(new a.i(context)).b(new a.h(context, 10, 11)).b(a.f3401g).e().d();
    }

    public static e.b u() {
        return new b();
    }

    public static long v() {
        return System.currentTimeMillis() - f3385l;
    }

    public static String w() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + v() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract n A();

    public abstract q B();

    public abstract t C();

    public abstract j1.b t();

    public abstract j1.e x();

    public abstract j1.h y();

    public abstract k z();
}
