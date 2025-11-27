package com.alibaba.sdk.android.httpdns.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class d extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4923a = new Object();

    public d(Context context) {
        super(context, "aliclound_httpdns.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private long a(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f4928i));
        contentValues.put("ip", gVar.f4929o);
        contentValues.put("ttl", gVar.f4930p);
        try {
            return sQLiteDatabase.insert("ip", (String) null, contentValues);
        } catch (Exception unused) {
            return 0;
        }
    }

    private long b(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f4928i));
        contentValues.put("ip", gVar.f4929o);
        contentValues.put("ttl", gVar.f4930p);
        try {
            return sQLiteDatabase.insert("ipv6", (String) null, contentValues);
        } catch (Exception unused) {
            return 0;
        }
    }

    private void c(long j10) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete("ipv6", "id = ?", new String[]{String.valueOf(j10)});
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE host (id INTEGER PRIMARY KEY,host TEXT,sp TEXT,time TEXT,extra TEXT,cache_key TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ip (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ipv6 (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
        } catch (Exception unused) {
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 != i11) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS host;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ip;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ipv6;");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } catch (Exception unused) {
            }
        }
    }

    private void c(e eVar) {
        a(eVar.id);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0093 A[Catch:{ Exception -> 0x008e, all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c A[Catch:{ Exception -> 0x008e, all -> 0x008b }] */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m3a(com.alibaba.sdk.android.httpdns.b.e r9) {
        /*
            r8 = this;
            java.lang.Object r0 = f4923a
            monitor-enter(r0)
            java.lang.String r1 = r9.f4926m     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = r9.host     // Catch:{ all -> 0x00a6 }
            r8.b((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00a6 }
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r8.getWritableDatabase()     // Catch:{ Exception -> 0x009a, all -> 0x0090 }
            r3.beginTransaction()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r4 = "host"
            java.lang.String r5 = r9.host     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r4 = "sp"
            java.lang.String r5 = r9.f4926m     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r4 = "time"
            java.lang.String r5 = r9.f4927n     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r5 = com.alibaba.sdk.android.httpdns.b.c.c(r5)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r4 = "extra"
            java.lang.String r5 = r9.f4924a     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r4 = "cache_key"
            java.lang.String r5 = r9.f4925b     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.lang.String r4 = "host"
            long r1 = r3.insert(r4, r2, r1)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r9.id = r1     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            java.util.ArrayList<com.alibaba.sdk.android.httpdns.b.g> r4 = r9.f7a     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            if (r4 == 0) goto L_0x0063
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
        L_0x004e:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            if (r5 == 0) goto L_0x0063
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            com.alibaba.sdk.android.httpdns.b.g r5 = (com.alibaba.sdk.android.httpdns.b.g) r5     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r5.f4928i = r1     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            long r6 = r8.a((android.database.sqlite.SQLiteDatabase) r3, (com.alibaba.sdk.android.httpdns.b.g) r5)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r5.id = r6     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            goto L_0x004e
        L_0x0063:
            java.util.ArrayList<com.alibaba.sdk.android.httpdns.b.g> r9 = r9.f8b     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            if (r9 == 0) goto L_0x0080
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
        L_0x006b:
            boolean r4 = r9.hasNext()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r9.next()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            com.alibaba.sdk.android.httpdns.b.g r4 = (com.alibaba.sdk.android.httpdns.b.g) r4     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r4.f4928i = r1     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            long r5 = r8.b((android.database.sqlite.SQLiteDatabase) r3, (com.alibaba.sdk.android.httpdns.b.g) r4)     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r4.id = r5     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            goto L_0x006b
        L_0x0080:
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x008e, all -> 0x008b }
            r3.endTransaction()     // Catch:{ all -> 0x00a6 }
            r3.close()     // Catch:{ all -> 0x00a6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            return r1
        L_0x008b:
            r9 = move-exception
            r2 = r3
            goto L_0x0091
        L_0x008e:
            r2 = r3
            goto L_0x009a
        L_0x0090:
            r9 = move-exception
        L_0x0091:
            if (r2 == 0) goto L_0x0099
            r2.endTransaction()     // Catch:{ all -> 0x00a6 }
            r2.close()     // Catch:{ all -> 0x00a6 }
        L_0x0099:
            throw r9     // Catch:{ all -> 0x00a6 }
        L_0x009a:
            if (r2 == 0) goto L_0x00a2
            r2.endTransaction()     // Catch:{ all -> 0x00a6 }
            r2.close()     // Catch:{ all -> 0x00a6 }
        L_0x00a2:
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            r0 = 0
            return r0
        L_0x00a6:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            goto L_0x00aa
        L_0x00a9:
            throw r9
        L_0x00aa:
            goto L_0x00a9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.m3a(com.alibaba.sdk.android.httpdns.b.e):long");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r11v2, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0092 A[SYNTHETIC, Splitter:B:17:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f A[Catch:{ Exception -> 0x00a9, all -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4 A[Catch:{ Exception -> 0x00a9, all -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab A[Catch:{ Exception -> 0x00a9, all -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0 A[Catch:{ Exception -> 0x00a9, all -> 0x0099 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.alibaba.sdk.android.httpdns.b.e> b() {
        /*
            r12 = this;
            java.lang.Object r0 = f4923a
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00b3 }
            r1.<init>()     // Catch:{ all -> 0x00b3 }
            r2 = 0
            android.database.sqlite.SQLiteDatabase r11 = r12.getReadableDatabase()     // Catch:{ Exception -> 0x00a8, all -> 0x009b }
            java.lang.String r4 = "host"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r11
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            if (r2 == 0) goto L_0x0090
            int r3 = r2.getCount()     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            if (r3 <= 0) goto L_0x0090
            r2.moveToFirst()     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
        L_0x0025:
            com.alibaba.sdk.android.httpdns.b.e r3 = new com.alibaba.sdk.android.httpdns.b.e     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.<init>()     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = "id"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            int r4 = r2.getInt(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            long r4 = (long) r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.id = r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = "host"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.host = r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = "sp"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.f4926m = r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = "time"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = com.alibaba.sdk.android.httpdns.b.c.d(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.f4927n = r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.util.List r4 = r12.a((com.alibaba.sdk.android.httpdns.b.e) r3)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.f7a = r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.util.List r4 = r12.b((com.alibaba.sdk.android.httpdns.b.e) r3)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.f8b = r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = "extra"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.f4924a = r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = "cache_key"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r3.f4925b = r4     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            r1.add(r3)     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x00a9, all -> 0x0099 }
            if (r3 != 0) goto L_0x0025
        L_0x0090:
            if (r2 == 0) goto L_0x0095
            r2.close()     // Catch:{ all -> 0x00b3 }
        L_0x0095:
            r11.close()     // Catch:{ all -> 0x00b3 }
            goto L_0x00b1
        L_0x0099:
            r1 = move-exception
            goto L_0x009d
        L_0x009b:
            r1 = move-exception
            r11 = r2
        L_0x009d:
            if (r2 == 0) goto L_0x00a2
            r2.close()     // Catch:{ all -> 0x00b3 }
        L_0x00a2:
            if (r11 == 0) goto L_0x00a7
            r11.close()     // Catch:{ all -> 0x00b3 }
        L_0x00a7:
            throw r1     // Catch:{ all -> 0x00b3 }
        L_0x00a8:
            r11 = r2
        L_0x00a9:
            if (r2 == 0) goto L_0x00ae
            r2.close()     // Catch:{ all -> 0x00b3 }
        L_0x00ae:
            if (r11 == 0) goto L_0x00b1
            goto L_0x0095
        L_0x00b1:
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            return r1
        L_0x00b3:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            goto L_0x00b7
        L_0x00b6:
            throw r1
        L_0x00b7:
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.b():java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r10v0, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v3, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008a, code lost:
        if (r10 == 0) goto L_0x008f;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.alibaba.sdk.android.httpdns.b.g> b(long r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch:{ Exception -> 0x0083, all -> 0x0076 }
            java.lang.String r3 = "ipv6"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r13 = 0
            r6[r13] = r12     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            if (r1 == 0) goto L_0x006c
            int r12 = r1.getCount()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            if (r12 <= 0) goto L_0x006c
            r1.moveToFirst()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
        L_0x002c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            int r13 = r1.getInt(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            long r2 = (long) r13     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.id = r2     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            int r13 = r1.getInt(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            long r2 = (long) r13     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.f4928i = r2     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.f4929o = r13     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.f4930p = r13     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r0.add(r12)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            boolean r12 = r1.moveToNext()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            if (r12 != 0) goto L_0x002c
        L_0x006c:
            if (r1 == 0) goto L_0x008c
            r1.close()
            goto L_0x008c
        L_0x0072:
            r12 = move-exception
            goto L_0x0078
        L_0x0074:
            goto L_0x0085
        L_0x0076:
            r12 = move-exception
            r10 = r1
        L_0x0078:
            if (r1 == 0) goto L_0x007d
            r1.close()
        L_0x007d:
            if (r10 == 0) goto L_0x0082
            r10.close()
        L_0x0082:
            throw r12
        L_0x0083:
            r10 = r1
        L_0x0085:
            if (r1 == 0) goto L_0x008a
            r1.close()
        L_0x008a:
            if (r10 == 0) goto L_0x008f
        L_0x008c:
            r10.close()
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.b(long):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.alibaba.sdk.android.httpdns.b.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.alibaba.sdk.android.httpdns.b.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: com.alibaba.sdk.android.httpdns.b.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: com.alibaba.sdk.android.httpdns.b.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: com.alibaba.sdk.android.httpdns.b.e} */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0088, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0089, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008b, code lost:
        r13 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0088 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009f A[Catch:{ Exception -> 0x0099, all -> 0x0097, all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A[Catch:{ Exception -> 0x0099, all -> 0x0097, all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ac A[Catch:{ Exception -> 0x0099, all -> 0x0097, all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b4 A[Catch:{ Exception -> 0x0099, all -> 0x0097, all -> 0x00b0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.sdk.android.httpdns.b.e a(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.Object r0 = f4923a
            monitor-enter(r0)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x00a8, all -> 0x009b }
            java.lang.String r3 = "host"
            r4 = 0
            java.lang.String r5 = "sp=? AND host=?"
            java.lang.String[] r6 = new java.lang.String[]{r12, r13}     // Catch:{ Exception -> 0x0099, all -> 0x0097 }
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0099, all -> 0x0097 }
            if (r12 == 0) goto L_0x008e
            int r13 = r12.getCount()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            if (r13 <= 0) goto L_0x008e
            r12.moveToFirst()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            com.alibaba.sdk.android.httpdns.b.e r13 = new com.alibaba.sdk.android.httpdns.b.e     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r13.<init>()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.lang.String r1 = "id"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            int r1 = r12.getInt(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r13.id = r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = "host"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r13.host = r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = "sp"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r13.f4926m = r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = "time"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = com.alibaba.sdk.android.httpdns.b.c.d(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r13.f4927n = r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.util.List r1 = r11.a((com.alibaba.sdk.android.httpdns.b.e) r13)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r13.f7a = r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.util.List r1 = r11.b((com.alibaba.sdk.android.httpdns.b.e) r13)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r13.f8b = r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = "extra"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r13.f4924a = r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = "cache_key"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r13.f4925b = r1     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r1 = r13
            goto L_0x008e
        L_0x0088:
            r13 = move-exception
            r1 = r12
            goto L_0x009d
        L_0x008b:
            r13 = r1
        L_0x008c:
            r1 = r12
            goto L_0x00aa
        L_0x008e:
            if (r12 == 0) goto L_0x0093
            r12.close()     // Catch:{ all -> 0x00b0 }
        L_0x0093:
            r10.close()     // Catch:{ all -> 0x00b0 }
            goto L_0x00b8
        L_0x0097:
            r13 = move-exception
            goto L_0x009d
        L_0x0099:
            r13 = r1
            goto L_0x00aa
        L_0x009b:
            r13 = move-exception
            r10 = r1
        L_0x009d:
            if (r1 == 0) goto L_0x00a2
            r1.close()     // Catch:{ all -> 0x00b0 }
        L_0x00a2:
            if (r10 == 0) goto L_0x00a7
            r10.close()     // Catch:{ all -> 0x00b0 }
        L_0x00a7:
            throw r13     // Catch:{ all -> 0x00b0 }
        L_0x00a8:
            r13 = r1
            r10 = r13
        L_0x00aa:
            if (r1 == 0) goto L_0x00b2
            r1.close()     // Catch:{ all -> 0x00b0 }
            goto L_0x00b2
        L_0x00b0:
            r12 = move-exception
            goto L_0x00ba
        L_0x00b2:
            if (r10 == 0) goto L_0x00b7
            r10.close()     // Catch:{ all -> 0x00b0 }
        L_0x00b7:
            r1 = r13
        L_0x00b8:
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x00ba:
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.a(java.lang.String, java.lang.String):com.alibaba.sdk.android.httpdns.b.e");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r10v0, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v3, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008a, code lost:
        if (r10 == 0) goto L_0x008f;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.alibaba.sdk.android.httpdns.b.g> a(long r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch:{ Exception -> 0x0083, all -> 0x0076 }
            java.lang.String r3 = "ip"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r13 = 0
            r6[r13] = r12     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            if (r1 == 0) goto L_0x006c
            int r12 = r1.getCount()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            if (r12 <= 0) goto L_0x006c
            r1.moveToFirst()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
        L_0x002c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            int r13 = r1.getInt(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            long r2 = (long) r13     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.id = r2     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            int r13 = r1.getInt(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            long r2 = (long) r13     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.f4928i = r2     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.f4929o = r13     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r12.f4930p = r13     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r0.add(r12)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            boolean r12 = r1.moveToNext()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            if (r12 != 0) goto L_0x002c
        L_0x006c:
            if (r1 == 0) goto L_0x008c
            r1.close()
            goto L_0x008c
        L_0x0072:
            r12 = move-exception
            goto L_0x0078
        L_0x0074:
            goto L_0x0085
        L_0x0076:
            r12 = move-exception
            r10 = r1
        L_0x0078:
            if (r1 == 0) goto L_0x007d
            r1.close()
        L_0x007d:
            if (r10 == 0) goto L_0x0082
            r10.close()
        L_0x0082:
            throw r12
        L_0x0083:
            r10 = r1
        L_0x0085:
            if (r1 == 0) goto L_0x008a
            r1.close()
        L_0x008a:
            if (r10 == 0) goto L_0x008f
        L_0x008c:
            r10.close()
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.a(long):java.util.List");
    }

    private List<g> b(e eVar) {
        return b(eVar.id);
    }

    private List<g> a(e eVar) {
        return a(eVar.id);
    }

    /* renamed from: b  reason: collision with other method in class */
    private void m2b(long j10) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete("ip", "id = ?", new String[]{String.valueOf(j10)});
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m1a(long j10) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete(Constants.KEY_HOST, "id = ?", new String[]{String.valueOf(j10)});
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    private void b(g gVar) {
        c(gVar.id);
    }

    private void a(g gVar) {
        b(gVar.id);
    }

    public void b(String str, String str2) {
        synchronized (f4923a) {
            e a10 = a(str, str2);
            if (a10 != null) {
                c(a10);
                ArrayList<g> arrayList = a10.f7a;
                if (arrayList != null) {
                    Iterator<g> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a(it.next());
                    }
                }
                ArrayList<g> arrayList2 = a10.f8b;
                if (arrayList2 != null) {
                    Iterator<g> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        b(it2.next());
                    }
                }
            }
        }
    }
}
