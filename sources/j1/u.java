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

public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    public final e f7130a;

    /* renamed from: b  reason: collision with root package name */
    public final b f7131b;

    public class a extends b {
        public a(e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        /* renamed from: i */
        public void g(f fVar, s sVar) {
            String str = sVar.f7128a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            String str2 = sVar.f7129b;
            if (str2 == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindString(2, str2);
            }
        }
    }

    public u(e eVar) {
        this.f7130a = eVar;
        this.f7131b = new a(eVar);
    }

    public List a(String str) {
        h c10 = h.c("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7130a.b();
        Cursor b10 = c.b(this.f7130a, c10, false, (CancellationSignal) null);
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

    public void b(s sVar) {
        this.f7130a.b();
        this.f7130a.c();
        try {
            this.f7131b.h(sVar);
            this.f7130a.r();
        } finally {
            this.f7130a.g();
        }
    }
}
