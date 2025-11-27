package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

public class bv extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f13973b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static bv f13974c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String f13975d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* renamed from: e  reason: collision with root package name */
    private static final String f13976e = "DROP TABLE IF EXISTS stf";

    /* renamed from: f  reason: collision with root package name */
    private static final String f13977f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* renamed from: a  reason: collision with root package name */
    private final Context f13978a;

    private bv(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
        this.f13978a = context;
    }

    public static final int a() {
        return 1;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f13975d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r2 = this;
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0014
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)"
            r0.execSQL(r1)     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r0.close()     // Catch:{ all -> 0x0014 }
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bv.d():void");
    }

    public boolean c() {
        if (!b(bx.f13987c)) {
            return true;
        }
        return false;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public static bv a(Context context) {
        bv bvVar;
        synchronized (f13973b) {
            if (f13974c == null) {
                f13974c = new bv(context, bx.f13986b, (SQLiteDatabase.CursorFactory) null, 1);
            }
            bvVar = f13974c;
        }
        return bvVar;
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && writableDatabase.isOpen()) {
                writableDatabase.close();
            }
        } catch (Throwable unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f13976e);
            sQLiteDatabase.execSQL(f13975d);
        } catch (SQLException unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.database.Cursor} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch:{ all -> 0x0038 }
            if (r10 == 0) goto L_0x001e
            boolean r1 = r10.isOpen()     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x001e
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r1 = r10
            r2 = r12
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x001c }
            r0 = r12
            goto L_0x001e
        L_0x001c:
            goto L_0x003a
        L_0x001e:
            if (r0 == 0) goto L_0x0030
            int r12 = r0.getCount()     // Catch:{ all -> 0x001c }
            if (r12 <= 0) goto L_0x0030
            r0.close()
            if (r10 == 0) goto L_0x002e
            r10.close()
        L_0x002e:
            r12 = 1
            return r12
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()
        L_0x0035:
            if (r10 == 0) goto L_0x0044
            goto L_0x0041
        L_0x0038:
            r10 = r0
        L_0x003a:
            if (r0 == 0) goto L_0x003f
            r0.close()
        L_0x003f:
            if (r10 == 0) goto L_0x0044
        L_0x0041:
            r10.close()
        L_0x0044:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bv.b(java.lang.String):boolean");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r3, android.content.ContentValues r4) {
        /*
            r2 = this;
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0023
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0023
            r0.beginTransaction()     // Catch:{ all -> 0x001d }
            r1 = 0
            r0.insert(r3, r1, r4)     // Catch:{ all -> 0x001d }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x001d }
            java.lang.String r3 = "MobclickRT"
            java.lang.String r4 = "--->>> [有状态]插入二级缓存数据记录 成功。"
            com.umeng.commonsdk.debug.UMRTLog.e(r3, r4)     // Catch:{ all -> 0x001d }
        L_0x001d:
            r0.endTransaction()     // Catch:{ all -> 0x0023 }
            r0.close()     // Catch:{ all -> 0x0023 }
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bv.a(java.lang.String, android.content.ContentValues):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r3, java.lang.String r4, java.lang.String[] r5) {
        /*
            r2 = this;
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001b
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x001b
            r0.beginTransaction()     // Catch:{ all -> 0x0015 }
            r0.delete(r3, r4, r5)     // Catch:{ all -> 0x0015 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0015 }
        L_0x0015:
            r0.endTransaction()     // Catch:{ all -> 0x001b }
            r0.close()     // Catch:{ all -> 0x001b }
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bv.a(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.umeng.analytics.pro.bw a(java.lang.String r19) {
        /*
            r18 = this;
            r10 = r18
            r0 = 6
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "_uuid"
            r12 = 0
            r3[r12] = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "_tp"
            r13 = 1
            r3[r13] = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "_hd"
            r14 = 2
            r3[r14] = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "_bd"
            r15 = 3
            r3[r15] = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "_re1"
            r9 = 4
            r3[r9] = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "_re2"
            r8 = 5
            r3[r8] = r0     // Catch:{ all -> 0x008b }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = 0
            java.lang.String r16 = "1"
            r1 = r18
            r2 = r19
            r11 = 5
            r8 = r0
            r0 = 4
            r9 = r16
            android.database.Cursor r1 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0084
            boolean r2 = r1.moveToFirst()     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x0084
            com.umeng.analytics.pro.bw r2 = new com.umeng.analytics.pro.bw     // Catch:{ all -> 0x0082 }
            r2.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r1.getString(r12)     // Catch:{ all -> 0x007e }
            r2.f13979a = r3     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r1.getString(r13)     // Catch:{ all -> 0x007e }
            r2.f13980b = r3     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r1.getString(r14)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r1.getString(r15)     // Catch:{ all -> 0x007e }
            android.content.Context r5 = r10.f13978a     // Catch:{ all -> 0x007e }
            com.umeng.analytics.pro.k r5 = com.umeng.analytics.pro.k.a((android.content.Context) r5)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r5.d(r3)     // Catch:{ all -> 0x007e }
            r2.f13981c = r3     // Catch:{ all -> 0x007e }
            android.content.Context r3 = r10.f13978a     // Catch:{ all -> 0x007e }
            com.umeng.analytics.pro.k r3 = com.umeng.analytics.pro.k.a((android.content.Context) r3)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r3.d(r4)     // Catch:{ all -> 0x007e }
            r2.f13982d = r3     // Catch:{ all -> 0x007e }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x007e }
            r2.f13983e = r0     // Catch:{ all -> 0x007e }
            java.lang.String r0 = r1.getString(r11)     // Catch:{ all -> 0x007e }
            r2.f13984f = r0     // Catch:{ all -> 0x007e }
            r11 = r2
            goto L_0x0085
        L_0x007e:
            r11 = r1
            r17 = r2
            goto L_0x008e
        L_0x0082:
            r11 = r1
            goto L_0x008c
        L_0x0084:
            r11 = 0
        L_0x0085:
            if (r1 == 0) goto L_0x0098
            r1.close()
            goto L_0x0098
        L_0x008b:
            r11 = 0
        L_0x008c:
            r17 = 0
        L_0x008e:
            r18.d()     // Catch:{ all -> 0x0099 }
            if (r11 == 0) goto L_0x0096
            r11.close()
        L_0x0096:
            r11 = r17
        L_0x0098:
            return r11
        L_0x0099:
            r0 = move-exception
            r1 = r0
            if (r11 == 0) goto L_0x00a0
            r11.close()
        L_0x00a0:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bv.a(java.lang.String):com.umeng.analytics.pro.bw");
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }
}
