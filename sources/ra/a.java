package ra;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ta.g;
import ta.h;
import ua.f;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static HashMap f19438c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f19439a;

    /* renamed from: b  reason: collision with root package name */
    public C0283a f19440b;

    public interface b {
        void onCreate(SQLiteDatabase sQLiteDatabase);

        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11);
    }

    /* renamed from: ra.a$a  reason: collision with other inner class name */
    public static class C0283a {

        /* renamed from: a  reason: collision with root package name */
        public Context f19441a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f19442b = "afinal.db";

        /* renamed from: c  reason: collision with root package name */
        public int f19443c = 1;

        /* renamed from: d  reason: collision with root package name */
        public boolean f19444d = true;

        /* renamed from: e  reason: collision with root package name */
        public b f19445e;

        /* renamed from: f  reason: collision with root package name */
        public String f19446f;

        public Context a() {
            return this.f19441a;
        }

        public String b() {
            return this.f19442b;
        }

        public b c() {
            return this.f19445e;
        }

        public int d() {
            return this.f19443c;
        }

        public String e() {
            return this.f19446f;
        }

        public boolean f() {
            return this.f19444d;
        }

        public void g(Context context) {
            this.f19441a = context;
        }

        public void h(String str) {
            this.f19442b = str;
        }

        public void i(b bVar) {
            this.f19445e = bVar;
        }

        public void j(int i10) {
            this.f19443c = i10;
        }

        public void k(boolean z10) {
            this.f19444d = z10;
        }
    }

    public class c extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public b f19447a;

        public c(Context context, String str, int i10, b bVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
            this.f19447a = bVar;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            b bVar = this.f19447a;
            if (bVar != null) {
                bVar.onUpgrade(sQLiteDatabase, i10, i11);
            } else {
                a.this.i();
            }
        }
    }

    public a(C0283a aVar) {
        if (aVar == null) {
            throw new va.b("daoConfig is null");
        } else if (aVar.a() != null) {
            if (aVar.e() == null || aVar.e().trim().length() <= 0) {
                this.f19439a = new c(aVar.a().getApplicationContext(), aVar.b(), aVar.d(), aVar.c()).getWritableDatabase();
            } else {
                this.f19439a = ta.c.a(new ta.b(aVar.a(), aVar.e()), aVar.b(), aVar.d(), aVar.c()).getWritableDatabase();
            }
            this.f19440b = aVar;
        } else {
            throw new va.b("android context is null");
        }
    }

    public static a b(Context context, String str, boolean z10, int i10, b bVar) {
        C0283a aVar = new C0283a();
        aVar.g(context);
        aVar.h(str);
        aVar.k(z10);
        aVar.j(i10);
        aVar.i(bVar);
        return c(aVar);
    }

    public static a c(C0283a aVar) {
        return p(aVar);
    }

    public static synchronized a p(C0283a aVar) {
        a aVar2;
        synchronized (a.class) {
            aVar2 = (a) f19438c.get(aVar.b());
            if (aVar2 == null) {
                aVar2 = new a(aVar);
                f19438c.put(aVar.b(), aVar2);
            }
        }
        return aVar2;
    }

    public final void a(Class cls) {
        if (!s(f.a(cls))) {
            String e10 = g.e(cls);
            d(e10);
            this.f19439a.execSQL(e10);
        }
    }

    public final void d(String str) {
        C0283a aVar = this.f19440b;
        if (aVar != null && aVar.f()) {
            StringBuilder sb = new StringBuilder();
            sb.append(">>>>>>  ");
            sb.append(str);
        }
    }

    public void e(Object obj) {
        a(obj.getClass());
        j(g.c(obj));
    }

    public void f(Class cls) {
        a(cls);
        String a10 = g.a(cls, (String) null);
        d(a10);
        this.f19439a.execSQL(a10);
    }

    public void g(Class cls, Object obj) {
        a(cls);
        j(g.b(cls, obj));
    }

    public void h(Class cls, String str) {
        a(cls);
        String a10 = g.a(cls, str);
        d(a10);
        this.f19439a.execSQL(a10);
    }

    public void i() {
        Cursor rawQuery = this.f19439a.rawQuery("SELECT name FROM sqlite_master WHERE type ='table' AND name != 'sqlite_sequence'", (String[]) null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                SQLiteDatabase sQLiteDatabase = this.f19439a;
                sQLiteDatabase.execSQL("DROP TABLE " + rawQuery.getString(0));
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    public final void j(h hVar) {
        if (hVar != null) {
            d(hVar.d());
            this.f19439a.execSQL(hVar.d(), hVar.b());
            return;
        }
        Log.e("FinalDb", "sava error:sqlInfo is null");
    }

    public List k(Class cls) {
        a(cls);
        return l(cls, g.h(cls));
    }

    public final List l(Class cls, String str) {
        a(cls);
        d(str);
        Cursor rawQuery = this.f19439a.rawQuery(str, (String[]) null);
        try {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(ta.a.a(rawQuery, cls, this));
            }
            rawQuery.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public List m(Class cls, String str) {
        a(cls);
        return l(cls, g.i(cls, str));
    }

    public List n(Class cls, String str, String str2) {
        a(cls);
        return l(cls, g.i(cls, str) + " ORDER BY " + str2);
    }

    public Object o(Object obj, Class cls) {
        a(cls);
        h j10 = g.j(cls, obj);
        if (j10 == null) {
            return null;
        }
        d(j10.d());
        Cursor rawQuery = this.f19439a.rawQuery(j10.d(), j10.c());
        try {
            if (rawQuery.moveToNext()) {
                Object a10 = ta.a.a(rawQuery, cls, this);
                rawQuery.close();
                return a10;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
        rawQuery.close();
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ Exception -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[Catch:{ Exception -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[Catch:{ Exception -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0092 A[Catch:{ Exception -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0010 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0056 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object q(ta.d r10, java.lang.Object r11, java.lang.Class r12, java.lang.Class... r13) {
        /*
            r9 = this;
            if (r11 == 0) goto L_0x009b
            ua.f r10 = ua.f.a(r12)     // Catch:{ Exception -> 0x0097 }
            java.util.HashMap r10 = r10.f19659f     // Catch:{ Exception -> 0x0097 }
            java.util.Collection r10 = r10.values()     // Catch:{ Exception -> 0x0097 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x0097 }
        L_0x0010:
            boolean r0 = r10.hasNext()     // Catch:{ Exception -> 0x0097 }
            if (r0 == 0) goto L_0x009b
            java.lang.Object r0 = r10.next()     // Catch:{ Exception -> 0x0097 }
            ua.c r0 = (ua.c) r0     // Catch:{ Exception -> 0x0097 }
            java.lang.Object r1 = r0.d(r11)     // Catch:{ Exception -> 0x0097 }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x0097 }
            java.lang.Class<ta.e> r2 = ta.e.class
            if (r1 != r2) goto L_0x0039
            java.lang.Object r1 = r0.d(r11)     // Catch:{ Exception -> 0x0097 }
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r0.d(r11)     // Catch:{ Exception -> 0x0097 }
            ta.e r1 = (ta.e) r1     // Catch:{ Exception -> 0x0097 }
            java.lang.Object r1 = r1.b()     // Catch:{ Exception -> 0x0097 }
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            if (r1 == 0) goto L_0x0010
            r3 = 0
            r4 = 1
            if (r13 == 0) goto L_0x0046
            int r5 = r13.length     // Catch:{ Exception -> 0x0097 }
            if (r5 != 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r5 = 0
            goto L_0x0047
        L_0x0046:
            r5 = 1
        L_0x0047:
            int r6 = r13.length     // Catch:{ Exception -> 0x0097 }
        L_0x0048:
            if (r3 >= r6) goto L_0x0056
            r7 = r13[r3]     // Catch:{ Exception -> 0x0097 }
            java.lang.Class r8 = r0.m()     // Catch:{ Exception -> 0x0097 }
            if (r8 != r7) goto L_0x0053
            goto L_0x0057
        L_0x0053:
            int r3 = r3 + 1
            goto L_0x0048
        L_0x0056:
            r4 = r5
        L_0x0057:
            if (r4 == 0) goto L_0x0010
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0097 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0097 }
            java.lang.Class r3 = r0.m()     // Catch:{ Exception -> 0x0097 }
            java.lang.Object r1 = r9.o(r1, r3)     // Catch:{ Exception -> 0x0097 }
            if (r1 == 0) goto L_0x0010
            java.lang.Object r3 = r0.d(r11)     // Catch:{ Exception -> 0x0097 }
            java.lang.Class r3 = r3.getClass()     // Catch:{ Exception -> 0x0097 }
            if (r3 != r2) goto L_0x0092
            java.lang.Object r2 = r0.d(r11)     // Catch:{ Exception -> 0x0097 }
            if (r2 != 0) goto L_0x0087
            ta.e r2 = new ta.e     // Catch:{ Exception -> 0x0097 }
            java.lang.Class r3 = r0.m()     // Catch:{ Exception -> 0x0097 }
            r2.<init>(r11, r12, r3, r9)     // Catch:{ Exception -> 0x0097 }
            r0.l(r11, r2)     // Catch:{ Exception -> 0x0097 }
        L_0x0087:
            java.lang.Object r0 = r0.d(r11)     // Catch:{ Exception -> 0x0097 }
            ta.e r0 = (ta.e) r0     // Catch:{ Exception -> 0x0097 }
            r0.c(r1)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0010
        L_0x0092:
            r0.l(r11, r1)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0010
        L_0x0097:
            r10 = move-exception
            r10.printStackTrace()
        L_0x009b:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ra.a.q(ta.d, java.lang.Object, java.lang.Class, java.lang.Class[]):java.lang.Object");
    }

    public void r(Object obj) {
        a(obj.getClass());
        j(g.d(obj));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r2 != 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (r2 == 0) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        return false;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean s(ua.f r6) {
        /*
            r5 = this;
            boolean r0 = r6.d()
            r1 = 1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            r0 = 0
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = "SELECT COUNT(*) AS c FROM sqlite_master WHERE type ='table' AND name ='"
            r3.append(r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = r6.c()     // Catch:{ Exception -> 0x004a }
            r3.append(r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = "' "
            r3.append(r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004a }
            r5.d(r3)     // Catch:{ Exception -> 0x004a }
            android.database.sqlite.SQLiteDatabase r4 = r5.f19439a     // Catch:{ Exception -> 0x004a }
            android.database.Cursor r2 = r4.rawQuery(r3, r2)     // Catch:{ Exception -> 0x004a }
            if (r2 == 0) goto L_0x0042
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0042
            int r3 = r2.getInt(r0)     // Catch:{ Exception -> 0x004a }
            if (r3 <= 0) goto L_0x0042
            r6.e(r1)     // Catch:{ Exception -> 0x004a }
            r2.close()
            return r1
        L_0x0042:
            if (r2 == 0) goto L_0x0051
        L_0x0044:
            r2.close()
            goto L_0x0051
        L_0x0048:
            r6 = move-exception
            goto L_0x0052
        L_0x004a:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0051
            goto L_0x0044
        L_0x0051:
            return r0
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            r2.close()
        L_0x0057:
            goto L_0x0059
        L_0x0058:
            throw r6
        L_0x0059:
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: ra.a.s(ua.f):boolean");
    }

    public void t(Object obj) {
        a(obj.getClass());
        j(g.l(obj));
    }

    public void u(Object obj, String str) {
        a(obj.getClass());
        j(g.m(obj, str));
    }
}
