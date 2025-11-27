package j1;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;
import q0.e;
import q0.h;
import q0.k;
import s0.c;
import t0.f;

public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    public final e f7070a;

    /* renamed from: b  reason: collision with root package name */
    public final q0.b f7071b;

    /* renamed from: c  reason: collision with root package name */
    public final k f7072c;

    public class a extends q0.b {
        public a(e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        /* renamed from: i */
        public void g(f fVar, g gVar) {
            String str = gVar.f7068a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            fVar.bindLong(2, (long) gVar.f7069b);
        }
    }

    public class b extends k {
        public b(e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public i(e eVar) {
        this.f7070a = eVar;
        this.f7071b = new a(eVar);
        this.f7072c = new b(eVar);
    }

    public void a(g gVar) {
        this.f7070a.b();
        this.f7070a.c();
        try {
            this.f7071b.h(gVar);
            this.f7070a.r();
        } finally {
            this.f7070a.g();
        }
    }

    public g b(String str) {
        h c10 = h.c("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7070a.b();
        g gVar = null;
        Cursor b10 = c.b(this.f7070a, c10, false, (CancellationSignal) null);
        try {
            int b11 = s0.b.b(b10, "work_spec_id");
            int b12 = s0.b.b(b10, "system_id");
            if (b10.moveToFirst()) {
                gVar = new g(b10.getString(b11), b10.getInt(b12));
            }
            return gVar;
        } finally {
            b10.close();
            c10.release();
        }
    }

    public List c() {
        h c10 = h.c("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f7070a.b();
        Cursor b10 = c.b(this.f7070a, c10, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(b10.getString(0));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.release();
        }
    }

    public void d(String str) {
        this.f7070a.b();
        f a10 = this.f7072c.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f7070a.c();
        try {
            a10.executeUpdateDelete();
            this.f7070a.r();
        } finally {
            this.f7070a.g();
            this.f7072c.f(a10);
        }
    }
}
