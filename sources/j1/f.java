package j1;

import android.database.Cursor;
import android.os.CancellationSignal;
import q0.b;
import q0.e;
import q0.h;
import s0.c;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final e f7065a;

    /* renamed from: b  reason: collision with root package name */
    public final b f7066b;

    public class a extends b {
        public a(e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        /* renamed from: i */
        public void g(t0.f fVar, d dVar) {
            String str = dVar.f7063a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            Long l10 = dVar.f7064b;
            if (l10 == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindLong(2, l10.longValue());
            }
        }
    }

    public f(e eVar) {
        this.f7065a = eVar;
        this.f7066b = new a(eVar);
    }

    public void a(d dVar) {
        this.f7065a.b();
        this.f7065a.c();
        try {
            this.f7066b.h(dVar);
            this.f7065a.r();
        } finally {
            this.f7065a.g();
        }
    }

    public Long b(String str) {
        h c10 = h.c("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7065a.b();
        Long l10 = null;
        Cursor b10 = c.b(this.f7065a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                if (!b10.isNull(0)) {
                    l10 = Long.valueOf(b10.getLong(0));
                }
            }
            return l10;
        } finally {
            b10.close();
            c10.release();
        }
    }
}
