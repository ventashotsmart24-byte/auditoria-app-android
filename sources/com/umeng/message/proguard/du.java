package com.umeng.message.proguard;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public final class du {

    /* renamed from: a  reason: collision with root package name */
    private final String f15884a;

    public du(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + "_";
        }
        this.f15884a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (r0 == null) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            android.content.Context r1 = com.umeng.message.proguard.de.a()     // Catch:{ Exception -> 0x0053 }
            boolean r2 = com.umeng.message.proguard.dy.a(r1)     // Catch:{ Exception -> 0x0053 }
            if (r2 == 0) goto L_0x0014
            com.umeng.message.proguard.ds r1 = com.umeng.message.proguard.ds.a()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r8 = r1.b(r8, r9)     // Catch:{ Exception -> 0x0053 }
            return r8
        L_0x0014:
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch:{ Exception -> 0x0053 }
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch:{ Exception -> 0x0053 }
            android.net.Uri r3 = com.umeng.message.proguard.cy.a(r1)     // Catch:{ Exception -> 0x0053 }
            r4 = 0
            r6 = 0
            r7 = 0
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r6
            r6 = r7
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0053 }
            if (r0 != 0) goto L_0x003c
            com.umeng.message.proguard.ds r1 = com.umeng.message.proguard.ds.a()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r8 = r1.b(r8, r9)     // Catch:{ Exception -> 0x0053 }
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ all -> 0x003b }
        L_0x003b:
            return r8
        L_0x003c:
            boolean r8 = r0.moveToFirst()     // Catch:{ Exception -> 0x0053 }
            if (r8 == 0) goto L_0x004d
            java.lang.String r8 = "v"
            int r8 = r0.getColumnIndex(r8)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r8 = r0.getString(r8)     // Catch:{ Exception -> 0x0053 }
            r9 = r8
        L_0x004d:
            r0.close()     // Catch:{ all -> 0x005a }
            goto L_0x005a
        L_0x0051:
            r8 = move-exception
            goto L_0x005b
        L_0x0053:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x005a
            goto L_0x004d
        L_0x005a:
            return r9
        L_0x005b:
            if (r0 == 0) goto L_0x0060
            r0.close()     // Catch:{ all -> 0x0060 }
        L_0x0060:
            goto L_0x0062
        L_0x0061:
            throw r8
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.du.d(java.lang.String, java.lang.String):java.lang.String");
    }

    public final String a(String str) {
        return this.f15884a + str;
    }

    public final int b(String str) {
        try {
            return Integer.parseInt(d(a(str), "0"));
        } catch (Exception unused) {
            return 0;
        }
    }

    public final boolean c(String str) {
        try {
            return Boolean.parseBoolean(d(a(str), "false"));
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(String str, int i10) {
        c(a(str), String.valueOf(i10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.umeng.message.proguard.ds.a().a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.lang.String r3, java.lang.String r4) {
        /*
            android.content.Context r0 = com.umeng.message.proguard.de.a()     // Catch:{ all -> 0x0035 }
            boolean r1 = com.umeng.message.proguard.dy.a(r0)     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0012
            com.umeng.message.proguard.ds r0 = com.umeng.message.proguard.ds.a()     // Catch:{ all -> 0x0035 }
            r0.a(r3, r4)     // Catch:{ all -> 0x0035 }
            return
        L_0x0012:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ all -> 0x0035 }
            r1.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = "k"
            r1.put(r2, r3)     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = "v"
            r1.put(r2, r4)     // Catch:{ all -> 0x0035 }
            android.content.ContentResolver r2 = r0.getContentResolver()     // Catch:{ all -> 0x002d }
            android.net.Uri r0 = com.umeng.message.proguard.cy.a(r0)     // Catch:{ all -> 0x002d }
            r2.insert(r0, r1)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            com.umeng.message.proguard.ds r0 = com.umeng.message.proguard.ds.a()     // Catch:{ all -> 0x0035 }
            r0.a(r3, r4)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r3 = move-exception
            r3.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.du.c(java.lang.String, java.lang.String):void");
    }

    public final void a(String str, long j10) {
        c(a(str), String.valueOf(j10));
    }

    public final long b(String str, long j10) {
        try {
            return Long.parseLong(d(a(str), String.valueOf(j10)));
        } catch (Exception unused) {
            return j10;
        }
    }

    public final void a(String str, String str2) {
        c(a(str), String.valueOf(str2));
    }

    public final void a(String str, boolean z10) {
        c(a(str), String.valueOf(z10));
    }

    public final String b(String str, String str2) {
        return d(a(str), String.valueOf(str2));
    }

    public final Set<String> a(String str, Set<String> set) {
        try {
            String d10 = d(a(str), "");
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = new JSONArray(d10);
            int length = jSONArray.length();
            if (length > 0) {
                for (int i10 = 0; i10 < length; i10++) {
                    hashSet.add(jSONArray.optString(i10));
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return set;
        }
    }
}
