package q0;

import android.database.Cursor;
import java.util.List;
import t0.c;

public class g extends c.a {

    /* renamed from: b  reason: collision with root package name */
    public a f8896b;

    /* renamed from: c  reason: collision with root package name */
    public final a f8897c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8898d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8899e;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f8900a;

        public a(int i10) {
            this.f8900a = i10;
        }

        public abstract void a(t0.b bVar);

        public abstract void b(t0.b bVar);

        public abstract void c(t0.b bVar);

        public abstract void d(t0.b bVar);

        public abstract void e(t0.b bVar);

        public abstract void f(t0.b bVar);

        public abstract b g(t0.b bVar);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f8901a;

        /* renamed from: b  reason: collision with root package name */
        public final String f8902b;

        public b(boolean z10, String str) {
            this.f8901a = z10;
            this.f8902b = str;
        }
    }

    public g(a aVar, a aVar2, String str, String str2) {
        super(aVar2.f8900a);
        this.f8896b = aVar;
        this.f8897c = aVar2;
        this.f8898d = str;
        this.f8899e = str2;
    }

    public static boolean j(t0.b bVar) {
        Cursor B = bVar.B("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (B.moveToFirst() && B.getInt(0) == 0) {
                z10 = true;
            }
            return z10;
        } finally {
            B.close();
        }
    }

    public static boolean k(t0.b bVar) {
        Cursor B = bVar.B("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z10 = false;
            if (B.moveToFirst() && B.getInt(0) != 0) {
                z10 = true;
            }
            return z10;
        } finally {
            B.close();
        }
    }

    public void b(t0.b bVar) {
        super.b(bVar);
    }

    public void d(t0.b bVar) {
        boolean j10 = j(bVar);
        this.f8897c.a(bVar);
        if (!j10) {
            b g10 = this.f8897c.g(bVar);
            if (!g10.f8901a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f8902b);
            }
        }
        l(bVar);
        this.f8897c.c(bVar);
    }

    public void e(t0.b bVar, int i10, int i11) {
        g(bVar, i10, i11);
    }

    public void f(t0.b bVar) {
        super.f(bVar);
        h(bVar);
        this.f8897c.d(bVar);
        this.f8896b = null;
    }

    public void g(t0.b bVar, int i10, int i11) {
        boolean z10;
        List<r0.a> c10;
        a aVar = this.f8896b;
        if (aVar == null || (c10 = aVar.f8849d.c(i10, i11)) == null) {
            z10 = false;
        } else {
            this.f8897c.f(bVar);
            for (r0.a a10 : c10) {
                a10.a(bVar);
            }
            b g10 = this.f8897c.g(bVar);
            if (g10.f8901a) {
                this.f8897c.e(bVar);
                l(bVar);
                z10 = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + g10.f8902b);
            }
        }
        if (!z10) {
            a aVar2 = this.f8896b;
            if (aVar2 == null || aVar2.a(i10, i11)) {
                throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.f8897c.b(bVar);
            this.f8897c.a(bVar);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void h(t0.b bVar) {
        String str;
        if (k(bVar)) {
            Cursor w10 = bVar.w(new t0.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (w10.moveToFirst()) {
                    str = w10.getString(0);
                } else {
                    str = null;
                }
                w10.close();
                if (!this.f8898d.equals(str) && !this.f8899e.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th) {
                w10.close();
                throw th;
            }
        } else {
            b g10 = this.f8897c.g(bVar);
            if (g10.f8901a) {
                this.f8897c.e(bVar);
                l(bVar);
                return;
            }
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f8902b);
        }
    }

    public final void i(t0.b bVar) {
        bVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    public final void l(t0.b bVar) {
        i(bVar);
        bVar.execSQL(f.a(this.f8898d));
    }
}
