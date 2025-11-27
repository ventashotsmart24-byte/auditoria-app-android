package j1;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;
import q0.b;
import q0.e;
import q0.h;
import t0.f;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final e f7060a;

    /* renamed from: b  reason: collision with root package name */
    public final b f7061b;

    public class a extends b {
        public a(e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        /* renamed from: i */
        public void g(f fVar, a aVar) {
            String str = aVar.f7058a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            String str2 = aVar.f7059b;
            if (str2 == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindString(2, str2);
            }
        }
    }

    public c(e eVar) {
        this.f7060a = eVar;
        this.f7061b = new a(eVar);
    }

    public List a(String str) {
        h c10 = h.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7060a.b();
        Cursor b10 = s0.c.b(this.f7060a, c10, false, (CancellationSignal) null);
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

    public boolean b(String str) {
        boolean z10 = true;
        h c10 = h.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7060a.b();
        boolean z11 = false;
        Cursor b10 = s0.c.b(this.f7060a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                if (b10.getInt(0) == 0) {
                    z10 = false;
                }
                z11 = z10;
            }
            return z11;
        } finally {
            b10.close();
            c10.release();
        }
    }

    public void c(a aVar) {
        this.f7060a.b();
        this.f7060a.c();
        try {
            this.f7061b.h(aVar);
            this.f7060a.r();
        } finally {
            this.f7060a.g();
        }
    }

    public boolean d(String str) {
        boolean z10 = true;
        h c10 = h.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7060a.b();
        boolean z11 = false;
        Cursor b10 = s0.c.b(this.f7060a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                if (b10.getInt(0) == 0) {
                    z10 = false;
                }
                z11 = z10;
            }
            return z11;
        } finally {
            b10.close();
            c10.release();
        }
    }
}
