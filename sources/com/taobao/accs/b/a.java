package com.taobao.accs.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.raizlabs.android.dbflow.sql.language.TriggerMethod;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.j;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f12891c;

    /* renamed from: e  reason: collision with root package name */
    private static final Lock f12892e = new ReentrantLock();

    /* renamed from: a  reason: collision with root package name */
    public int f12893a = 0;

    /* renamed from: b  reason: collision with root package name */
    LinkedList<C0192a> f12894b = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    private Context f12895d;

    /* renamed from: com.taobao.accs.b.a$a  reason: collision with other inner class name */
    public class C0192a {

        /* renamed from: a  reason: collision with root package name */
        String f12896a;

        /* renamed from: b  reason: collision with root package name */
        Object[] f12897b;

        private C0192a(String str, Object[] objArr) {
            this.f12896a = str;
            this.f12897b = objArr;
        }
    }

    private a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
        this.f12895d = context;
    }

    public static a a(Context context) {
        if (f12891c == null) {
            synchronized (a.class) {
                if (f12891c == null) {
                    f12891c = new a(context, Constants.DB_NAME, (SQLiteDatabase.CursorFactory) null, 3);
                }
            }
        }
        return f12891c;
    }

    public SQLiteDatabase getWritableDatabase() {
        if (!j.a(super.getWritableDatabase().getPath(), 102400)) {
            return null;
        }
        return super.getWritableDatabase();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            Lock lock = f12892e;
            if (lock.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
            lock.unlock();
        } catch (Throwable th) {
            f12892e.unlock();
            throw th;
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 < i11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }

    public void a(String str, String str2, String str3, boolean z10, long j10, String str4) {
        if (!a(str, str3, z10, str4)) {
            a("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z10), Long.valueOf(j10)}, true);
            return;
        }
        a("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j10), str4, str, str3, String.valueOf(z10)}, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0062, code lost:
        if (r2 != null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
        if (r2 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(java.lang.String r15, java.lang.String r16, boolean r17, java.lang.String r18) {
        /*
            r14 = this;
            monitor-enter(r14)
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r14.getWritableDatabase()     // Catch:{ Exception -> 0x006a }
            if (r3 != 0) goto L_0x000b
            monitor-exit(r14)
            return r1
        L_0x000b:
            java.lang.String r4 = "traffic"
            r0 = 7
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "_id"
            r5[r1] = r0     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "date"
            r12 = 1
            r5[r12] = r0     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "host"
            r6 = 2
            r5[r6] = r0     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "serviceid"
            r7 = 3
            r5[r7] = r0     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "bid"
            r8 = 4
            r5[r8] = r0     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "isbackground"
            r9 = 5
            r5[r9] = r0     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "size"
            r9 = 6
            r5[r9] = r0     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "date=? AND host=? AND bid=? AND isbackground=?"
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ Exception -> 0x006a }
            r8[r1] = r18     // Catch:{ Exception -> 0x006a }
            r8[r12] = r15     // Catch:{ Exception -> 0x006a }
            r8[r6] = r16     // Catch:{ Exception -> 0x006a }
            java.lang.String r6 = java.lang.String.valueOf(r17)     // Catch:{ Exception -> 0x006a }
            r8[r7] = r6     // Catch:{ Exception -> 0x006a }
            r9 = 0
            r10 = 0
            r11 = 0
            r6 = 100
            java.lang.String r13 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x006a }
            r6 = r0
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r13
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x006a }
            if (r2 == 0) goto L_0x0062
            int r0 = r2.getCount()     // Catch:{ Exception -> 0x006a }
            if (r0 <= 0) goto L_0x0062
            r2.close()     // Catch:{ all -> 0x0081 }
            monitor-exit(r14)
            return r12
        L_0x0062:
            if (r2 == 0) goto L_0x0079
        L_0x0064:
            r2.close()     // Catch:{ all -> 0x0081 }
            goto L_0x0079
        L_0x0068:
            r0 = move-exception
            goto L_0x007b
        L_0x006a:
            r0 = move-exception
            java.lang.String r3 = "DBHelper"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0068 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0068 }
            com.taobao.accs.utl.ALog.w(r3, r0, r4)     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0079
            goto L_0x0064
        L_0x0079:
            monitor-exit(r14)
            return r1
        L_0x007b:
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ all -> 0x0081 }
        L_0x0080:
            throw r0     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r0 = move-exception
            monitor-exit(r14)
            goto L_0x0085
        L_0x0084:
            throw r0
        L_0x0085:
            goto L_0x0084
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.a(java.lang.String, java.lang.String, boolean, java.lang.String):boolean");
    }

    public void a() {
        a("DELETE FROM traffic", (Object[]) null, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a9, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0112 A[SYNTHETIC, Splitter:B:50:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.taobao.accs.ut.monitor.TrafficsMonitor.a> a(boolean r21) {
        /*
            r20 = this;
            monitor-enter(r20)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x011d }
            r1.<init>()     // Catch:{ all -> 0x011d }
            r2 = 0
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r20.getWritableDatabase()     // Catch:{ Exception -> 0x0104 }
            if (r4 != 0) goto L_0x0010
            monitor-exit(r20)     // Catch:{ all -> 0x011d }
            return r2
        L_0x0010:
            r0 = 100
            r5 = 7
            r13 = 6
            r14 = 5
            r15 = 4
            r12 = 3
            r11 = 2
            r10 = 1
            if (r21 == 0) goto L_0x0066
            java.lang.String r6 = "traffic"
            java.lang.String[] r7 = new java.lang.String[r5]     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "_id"
            r7[r3] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "date"
            r7[r10] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "host"
            r7[r11] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "serviceid"
            r7[r12] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "bid"
            r7[r15] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "isbackground"
            r7[r14] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "size"
            r7[r13] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r8 = "date=?"
            java.lang.String[] r9 = new java.lang.String[r10]     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = com.taobao.accs.utl.UtilityImpl.a((long) r16)     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            r9[r3] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            r16 = 0
            r17 = 0
            r18 = 0
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r16
            r2 = 1
            r10 = r17
            r13 = 2
            r11 = r18
            r14 = 3
            r12 = r0
            android.database.Cursor r0 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            goto L_0x00a0
        L_0x0066:
            r2 = 1
            r13 = 2
            r14 = 3
            java.lang.String r6 = "traffic"
            java.lang.String[] r7 = new java.lang.String[r5]     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "_id"
            r7[r3] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "date"
            r7[r2] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "host"
            r7[r13] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "serviceid"
            r7[r14] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "bid"
            r7[r15] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "isbackground"
            r8 = 5
            r7[r8] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            java.lang.String r5 = "size"
            r8 = 6
            r7[r8] = r5     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r0
            android.database.Cursor r0 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
        L_0x00a0:
            r4 = r0
            if (r4 != 0) goto L_0x00ab
            if (r4 == 0) goto L_0x00a8
            r4.close()     // Catch:{ all -> 0x011d }
        L_0x00a8:
            monitor-exit(r20)     // Catch:{ all -> 0x011d }
            r2 = 0
            return r2
        L_0x00ab:
            boolean r0 = r4.moveToFirst()     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            if (r0 == 0) goto L_0x00f2
        L_0x00b1:
            java.lang.String r6 = r4.getString(r2)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            java.lang.String r10 = r4.getString(r13)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            java.lang.String r8 = r4.getString(r14)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            java.lang.String r7 = r4.getString(r15)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r0 = 5
            java.lang.String r5 = r4.getString(r0)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            boolean r9 = r5.booleanValue()     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r11 = 6
            long r16 = r4.getLong(r11)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            if (r7 == 0) goto L_0x00ea
            r18 = 0
            int r5 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x00ea
            com.taobao.accs.ut.monitor.TrafficsMonitor$a r12 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r5 = r12
            r0 = r12
            r19 = 6
            r11 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r1.add(r0)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            goto L_0x00ec
        L_0x00ea:
            r19 = 6
        L_0x00ec:
            boolean r0 = r4.moveToNext()     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            if (r0 != 0) goto L_0x00b1
        L_0x00f2:
            r4.close()     // Catch:{ all -> 0x011d }
            goto L_0x0115
        L_0x00f6:
            r0 = move-exception
            r2 = r4
            goto L_0x0117
        L_0x00f9:
            r0 = move-exception
            r2 = r4
            goto L_0x0105
        L_0x00fc:
            r0 = move-exception
            r2 = 0
            goto L_0x0117
        L_0x00ff:
            r0 = move-exception
            r2 = 0
            goto L_0x0105
        L_0x0102:
            r0 = move-exception
            goto L_0x0117
        L_0x0104:
            r0 = move-exception
        L_0x0105:
            java.lang.String r4 = "DBHelper"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0102 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0102 }
            com.taobao.accs.utl.ALog.w(r4, r0, r3)     // Catch:{ all -> 0x0102 }
            if (r2 == 0) goto L_0x0115
            r2.close()     // Catch:{ all -> 0x011d }
        L_0x0115:
            monitor-exit(r20)     // Catch:{ all -> 0x011d }
            return r1
        L_0x0117:
            if (r2 == 0) goto L_0x011c
            r2.close()     // Catch:{ all -> 0x011d }
        L_0x011c:
            throw r0     // Catch:{ all -> 0x011d }
        L_0x011d:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x011d }
            goto L_0x0121
        L_0x0120:
            throw r0
        L_0x0121:
            goto L_0x0120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.a(boolean):java.util.List");
    }

    private synchronized void a(String str, Object[] objArr, boolean z10) {
        this.f12894b.add(new C0192a(str, objArr));
        if (this.f12894b.size() > 5 || z10) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                while (true) {
                    try {
                        if (this.f12894b.size() > 0) {
                            C0192a removeFirst = this.f12894b.removeFirst();
                            Object[] objArr2 = removeFirst.f12897b;
                            if (objArr2 != null) {
                                writableDatabase.execSQL(removeFirst.f12896a, objArr2);
                            } else {
                                writableDatabase.execSQL(removeFirst.f12896a);
                            }
                            if (removeFirst.f12896a.contains(TriggerMethod.INSERT)) {
                                int i10 = this.f12893a + 1;
                                this.f12893a = i10;
                                if (i10 > 4000) {
                                    ALog.d("DBHelper", "db is full!", new Object[0]);
                                    onUpgrade(writableDatabase, 0, 1);
                                    this.f12893a = 0;
                                    break;
                                }
                            }
                        }
                    } catch (Exception e10) {
                        ALog.d("DBHelper", e10.toString(), new Object[0]);
                    } catch (Throwable th) {
                        writableDatabase.close();
                        throw th;
                    }
                }
                writableDatabase.close();
            } else {
                return;
            }
        }
        return;
    }
}
