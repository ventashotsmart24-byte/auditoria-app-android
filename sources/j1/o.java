package j1;

import androidx.appcompat.app.m;
import q0.e;
import q0.k;
import t0.f;

public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    public final e f7080a;

    /* renamed from: b  reason: collision with root package name */
    public final q0.b f7081b;

    /* renamed from: c  reason: collision with root package name */
    public final k f7082c;

    /* renamed from: d  reason: collision with root package name */
    public final k f7083d;

    public class a extends q0.b {
        public a(e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        public /* bridge */ /* synthetic */ void g(f fVar, Object obj) {
            m.a(obj);
            i(fVar, (m) null);
        }

        public void i(f fVar, m mVar) {
            throw null;
        }
    }

    public class b extends k {
        public b(e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    public class c extends k {
        public c(e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(e eVar) {
        this.f7080a = eVar;
        this.f7081b = new a(eVar);
        this.f7082c = new b(eVar);
        this.f7083d = new c(eVar);
    }

    public void a(String str) {
        this.f7080a.b();
        f a10 = this.f7082c.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f7080a.c();
        try {
            a10.executeUpdateDelete();
            this.f7080a.r();
        } finally {
            this.f7080a.g();
            this.f7082c.f(a10);
        }
    }

    public void b() {
        this.f7080a.b();
        f a10 = this.f7083d.a();
        this.f7080a.c();
        try {
            a10.executeUpdateDelete();
            this.f7080a.r();
        } finally {
            this.f7080a.g();
            this.f7083d.f(a10);
        }
    }
}
