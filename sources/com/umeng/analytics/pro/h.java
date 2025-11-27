package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.g;

class h extends SQLiteOpenHelper {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Context f14279b;

    /* renamed from: a  reason: collision with root package name */
    private String f14280a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f14281a = new h(h.f14279b, j.b(h.f14279b), g.f14213b, (SQLiteDatabase.CursorFactory) null, 2);

        private a() {
        }
    }

    public static h a(Context context) {
        if (f14279b == null) {
            f14279b = context.getApplicationContext();
        }
        return a.f14281a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f14280a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f14280a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!j.a(sQLiteDatabase, g.d.f14254a, "__av")) {
            j.a(sQLiteDatabase, g.d.f14254a, "__sp", "TEXT");
            j.a(sQLiteDatabase, g.d.f14254a, "__pp", "TEXT");
            j.a(sQLiteDatabase, g.d.f14254a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.d.f14254a, "__vc", "TEXT");
        }
        if (!j.a(sQLiteDatabase, g.b.f14228a, "__av")) {
            j.a(sQLiteDatabase, g.b.f14228a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.b.f14228a, "__vc", "TEXT");
        }
        if (!j.a(sQLiteDatabase, g.a.f14217a, "__av")) {
            j.a(sQLiteDatabase, g.a.f14217a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.a.f14217a, "__vc", "TEXT");
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, g.d.f14254a);
        a(sQLiteDatabase, g.b.f14228a);
        a(sQLiteDatabase, g.a.f14217a);
        a();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.database.sqlite.SQLiteDatabase r2) {
        /*
            r1 = this;
            r2.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0019, all -> 0x0016 }
            r1.c(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0019, all -> 0x0016 }
            r1.d(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0019, all -> 0x0016 }
            r1.b(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0019, all -> 0x0016 }
            r1.a((android.database.sqlite.SQLiteDatabase) r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0019, all -> 0x0016 }
            r2.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0019, all -> 0x0016 }
        L_0x0012:
            r2.endTransaction()     // Catch:{ all -> 0x0021 }
            goto L_0x0021
        L_0x0016:
            if (r2 == 0) goto L_0x0021
            goto L_0x0012
        L_0x0019:
            android.content.Context r0 = f14279b     // Catch:{ all -> 0x0022 }
            com.umeng.analytics.pro.j.a((android.content.Context) r0)     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x0021
            goto L_0x0012
        L_0x0021:
            return
        L_0x0022:
            r0 = move-exception
            if (r2 == 0) goto L_0x0028
            r2.endTransaction()     // Catch:{ all -> 0x0028 }
        L_0x0028:
            goto L_0x002a
        L_0x0029:
            throw r0
        L_0x002a:
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:3|4|5|6|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        f(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpgrade(android.database.sqlite.SQLiteDatabase r1, int r2, int r3) {
        /*
            r0 = this;
            if (r3 <= r2) goto L_0x0010
            r3 = 1
            if (r2 != r3) goto L_0x0010
            r0.e(r1)     // Catch:{ Exception -> 0x0009 }
            goto L_0x0010
        L_0x0009:
            r0.e(r1)     // Catch:{ Exception -> 0x000d }
            goto L_0x0010
        L_0x000d:
            r0.f(r1)
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    private h(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        this(new e(context, str), str2, cursorFactory, i10);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f14280a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, TextUtils.isEmpty(str) ? g.f14213b : str, cursorFactory, i10);
        this.f14280a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!j.a(g.d.f14254a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!j.a(g.c.f14241a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!j.a(g.b.f14228a, writableDatabase)) {
                b(writableDatabase);
            }
            if (!j.a(g.a.f14217a, writableDatabase)) {
                a(writableDatabase);
            }
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f14280a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
