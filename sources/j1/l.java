package j1;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;
import q0.b;
import q0.e;
import q0.h;
import s0.c;
import t0.f;

public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    public final e f7077a;

    /* renamed from: b  reason: collision with root package name */
    public final b f7078b;

    public class a extends b {
        public a(e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        /* renamed from: i */
        public void g(f fVar, j jVar) {
            String str = jVar.f7075a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            String str2 = jVar.f7076b;
            if (str2 == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindString(2, str2);
            }
        }
    }

    public l(e eVar) {
        this.f7077a = eVar;
        this.f7078b = new a(eVar);
    }

    public void a(j jVar) {
        this.f7077a.b();
        this.f7077a.c();
        try {
            this.f7078b.h(jVar);
            this.f7077a.r();
        } finally {
            this.f7077a.g();
        }
    }

    public List b(String str) {
        h c10 = h.c("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7077a.b();
        Cursor b10 = c.b(this.f7077a, c10, false, (CancellationSignal) null);
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
}
