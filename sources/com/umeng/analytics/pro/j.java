package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class j {
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r2 == null) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r12, android.database.sqlite.SQLiteDatabase r13) {
        /*
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            r2 = 0
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            java.lang.String r3 = "count(*)"
            r5[r0] = r3     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            java.lang.String r3 = "table"
            r7[r0] = r3     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            java.lang.String r12 = r12.trim()     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            r7[r1] = r12     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            java.lang.String r4 = "sqlite_master"
            java.lang.String r6 = "type=? and name=?"
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r3 = r13
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            boolean r12 = r2.moveToNext()     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            if (r12 == 0) goto L_0x0033
            int r12 = r2.getInt(r0)     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            if (r12 <= 0) goto L_0x0033
            r0 = 1
        L_0x0033:
            r2.close()
            goto L_0x0042
        L_0x0037:
            r12 = move-exception
            if (r2 == 0) goto L_0x003d
            r2.close()
        L_0x003d:
            throw r12
        L_0x003e:
            if (r2 == 0) goto L_0x0042
            goto L_0x0033
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.j.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static String b(Context context) {
        File databasePath = context.getDatabasePath(g.f14213b);
        return databasePath.getParent() + File.separator;
    }

    public static String c(Context context) {
        return b(context) + g.f14212a;
    }

    public static List<String> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String next : list) {
                if (Collections.frequency(arrayList, next) < 1) {
                    arrayList.add(next);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return arrayList;
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                File databasePath = context.getDatabasePath(g.f14213b);
                if (databasePath != null && databasePath.exists()) {
                    databasePath.delete();
                }
                h.a(context).a();
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r9.isClosed() == false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r9.isClosed() == false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, java.lang.String r12) {
        /*
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            java.lang.String r7 = "LIMIT 0"
            r0 = r10
            r1 = r11
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0033, all -> 0x0026 }
            if (r9 == 0) goto L_0x001a
            int r10 = r9.getColumnIndex(r12)     // Catch:{ Exception -> 0x0033, all -> 0x0026 }
            r11 = -1
            if (r10 == r11) goto L_0x001a
            r10 = 1
            r8 = 1
        L_0x001a:
            if (r9 == 0) goto L_0x003d
            boolean r10 = r9.isClosed()
            if (r10 != 0) goto L_0x003d
        L_0x0022:
            r9.close()
            goto L_0x003d
        L_0x0026:
            r10 = move-exception
            if (r9 == 0) goto L_0x0032
            boolean r11 = r9.isClosed()
            if (r11 != 0) goto L_0x0032
            r9.close()
        L_0x0032:
            throw r10
        L_0x0033:
            if (r9 == 0) goto L_0x003d
            boolean r10 = r9.isClosed()
            if (r10 != 0) goto L_0x003d
            goto L_0x0022
        L_0x003d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.j.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + " " + str3);
    }
}
