package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final int f14287a = 2049;

    /* renamed from: b  reason: collision with root package name */
    public static final int f14288b = 2050;

    /* renamed from: c  reason: collision with root package name */
    private static final int f14289c = 1000;

    /* renamed from: d  reason: collision with root package name */
    private static Context f14290d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f14291e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final String f14292f = "umeng+";

    /* renamed from: g  reason: collision with root package name */
    private static final String f14293g = "ek__id";

    /* renamed from: h  reason: collision with root package name */
    private static final String f14294h = "ek_key";

    /* renamed from: i  reason: collision with root package name */
    private List<String> f14295i;

    /* renamed from: j  reason: collision with root package name */
    private List<Integer> f14296j;

    /* renamed from: k  reason: collision with root package name */
    private String f14297k;

    /* renamed from: l  reason: collision with root package name */
    private List<String> f14298l;

    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final k f14306a = new k();

        private b() {
        }
    }

    public static k a(Context context) {
        k a10 = b.f14306a;
        if (f14290d == null && context != null) {
            f14290d = context.getApplicationContext();
            a10.k();
        }
        return a10;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f14295i.clear();
            this.f14298l.clear();
            this.f14296j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f14291e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f14290d, f14293g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f14290d).getString(f14293g, (String) null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f14290d, f14293g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i10 = 0; i10 < substring.length(); i10++) {
                        char charAt = substring.charAt(i10);
                        if (!Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    f14291e = sb.toString();
                }
                if (!TextUtils.isEmpty(f14291e)) {
                    f14291e += new StringBuilder(f14291e).reverse().toString();
                    String multiProcessSP2 = UMUtils.getMultiProcessSP(f14290d, f14294h);
                    if (TextUtils.isEmpty(multiProcessSP2)) {
                        UMUtils.setMultiProcessSP(f14290d, f14294h, c(f14292f));
                    } else if (!f14292f.equals(d(multiProcessSP2))) {
                        b(true, false);
                        a(true, false);
                        h();
                        i();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.f14298l.clear();
    }

    public boolean c() {
        return this.f14298l.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (r0 == null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        if (r0 == null) goto L_0x0071;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            r0.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            com.umeng.analytics.pro.w r1 = com.umeng.analytics.pro.w.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r1 = r1.c()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            if (r2 == 0) goto L_0x0029
            r0.endTransaction()     // Catch:{ all -> 0x001f }
        L_0x001f:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            return
        L_0x0029:
            r2 = 2
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r4 = ""
            r5 = 0
            r3[r5] = r4     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r4 = "-1"
            r6 = 1
            r3[r6] = r4     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
        L_0x0036:
            if (r5 >= r2) goto L_0x0068
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            r4.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r6 = "update __et set __i=\""
            r4.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            r4.append(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r6 = "\" where "
            r4.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r6 = "__i"
            r4.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r6 = "=\""
            r4.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            r6 = r3[r5]     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            r4.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r6 = "\""
            r4.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            r0.execSQL(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            int r5 = r5 + 1
            goto L_0x0036
        L_0x0068:
            r0.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007b, all -> 0x006c }
            goto L_0x006e
        L_0x006c:
            if (r0 == 0) goto L_0x0071
        L_0x006e:
            r0.endTransaction()     // Catch:{ all -> 0x0071 }
        L_0x0071:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x0083
        L_0x007b:
            android.content.Context r1 = f14290d     // Catch:{ all -> 0x0084 }
            com.umeng.analytics.pro.j.a((android.content.Context) r1)     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0071
            goto L_0x006e
        L_0x0083:
            return
        L_0x0084:
            r1 = move-exception
            if (r0 == 0) goto L_0x008a
            r0.endTransaction()     // Catch:{ all -> 0x008a }
        L_0x008a:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x0095
        L_0x0094:
            throw r1
        L_0x0095:
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.d():void");
    }

    public boolean e() {
        return this.f14295i.isEmpty();
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0087, code lost:
        if (r2 == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a3, code lost:
        if (r2 == null) goto L_0x008c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f14298l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto L_0x000e
            return r3
        L_0x000e:
            android.content.Context r2 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0097, all -> 0x007f }
            com.umeng.analytics.pro.i r2 = com.umeng.analytics.pro.i.a(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0097, all -> 0x007f }
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0097, all -> 0x007f }
            r2.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            java.util.List<java.lang.String> r4 = r14.f14298l     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            java.lang.String r5 = "__is"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r4}     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            if (r4 == 0) goto L_0x005e
            boolean r5 = r4.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0077, all -> 0x0073 }
            if (r5 == 0) goto L_0x005e
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0077, all -> 0x0073 }
            r5.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0077, all -> 0x0073 }
            int r3 = r4.getColumnIndex(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            int r6 = r4.getColumnIndex(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            r5.put(r1, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            r5.put(r0, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            r3 = r5
            goto L_0x005e
        L_0x005c:
            goto L_0x0075
        L_0x005e:
            r2.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0077, all -> 0x0073 }
            if (r4 == 0) goto L_0x0066
            r4.close()
        L_0x0066:
            r2.endTransaction()     // Catch:{ all -> 0x0069 }
        L_0x0069:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x00a6
        L_0x0073:
            r5 = r3
        L_0x0075:
            r3 = r4
            goto L_0x0082
        L_0x0077:
            r5 = r3
        L_0x0078:
            r3 = r4
            goto L_0x0099
        L_0x007a:
            r5 = r3
            goto L_0x0082
        L_0x007d:
            r5 = r3
            goto L_0x0099
        L_0x007f:
            r2 = r3
            r5 = r2
        L_0x0082:
            if (r3 == 0) goto L_0x0087
            r3.close()
        L_0x0087:
            if (r2 == 0) goto L_0x008c
        L_0x0089:
            r2.endTransaction()     // Catch:{ all -> 0x008c }
        L_0x008c:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            r3 = r5
            goto L_0x00a6
        L_0x0097:
            r2 = r3
            r5 = r2
        L_0x0099:
            android.content.Context r0 = f14290d     // Catch:{ all -> 0x00a7 }
            com.umeng.analytics.pro.j.a((android.content.Context) r0)     // Catch:{ all -> 0x00a7 }
            if (r3 == 0) goto L_0x00a3
            r3.close()
        L_0x00a3:
            if (r2 == 0) goto L_0x008c
            goto L_0x0089
        L_0x00a6:
            return r3
        L_0x00a7:
            r0 = move-exception
            if (r3 == 0) goto L_0x00ad
            r3.close()
        L_0x00ad:
            if (r2 == 0) goto L_0x00b2
            r2.endTransaction()     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            android.content.Context r1 = f14290d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            goto L_0x00bd
        L_0x00bc:
            throw r0
        L_0x00bd:
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.f():org.json.JSONObject");
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0087, code lost:
        if (r2 == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a3, code lost:
        if (r2 == null) goto L_0x008c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f14295i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto L_0x000e
            return r3
        L_0x000e:
            android.content.Context r2 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0097, all -> 0x007f }
            com.umeng.analytics.pro.i r2 = com.umeng.analytics.pro.i.a(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0097, all -> 0x007f }
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0097, all -> 0x007f }
            r2.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            java.util.List<java.lang.String> r4 = r14.f14295i     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            java.lang.String r5 = "__sd"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r4}     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007d, all -> 0x007a }
            if (r4 == 0) goto L_0x005e
            boolean r5 = r4.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0077, all -> 0x0073 }
            if (r5 == 0) goto L_0x005e
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0077, all -> 0x0073 }
            r5.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0077, all -> 0x0073 }
            int r3 = r4.getColumnIndex(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            int r6 = r4.getColumnIndex(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            r5.put(r1, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            r5.put(r0, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, all -> 0x005c }
            r3 = r5
            goto L_0x005e
        L_0x005c:
            goto L_0x0075
        L_0x005e:
            r2.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0077, all -> 0x0073 }
            if (r4 == 0) goto L_0x0066
            r4.close()
        L_0x0066:
            r2.endTransaction()     // Catch:{ all -> 0x0069 }
        L_0x0069:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x00a6
        L_0x0073:
            r5 = r3
        L_0x0075:
            r3 = r4
            goto L_0x0082
        L_0x0077:
            r5 = r3
        L_0x0078:
            r3 = r4
            goto L_0x0099
        L_0x007a:
            r5 = r3
            goto L_0x0082
        L_0x007d:
            r5 = r3
            goto L_0x0099
        L_0x007f:
            r2 = r3
            r5 = r2
        L_0x0082:
            if (r3 == 0) goto L_0x0087
            r3.close()
        L_0x0087:
            if (r2 == 0) goto L_0x008c
        L_0x0089:
            r2.endTransaction()     // Catch:{ all -> 0x008c }
        L_0x008c:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            r3 = r5
            goto L_0x00a6
        L_0x0097:
            r2 = r3
            r5 = r2
        L_0x0099:
            android.content.Context r0 = f14290d     // Catch:{ all -> 0x00a7 }
            com.umeng.analytics.pro.j.a((android.content.Context) r0)     // Catch:{ all -> 0x00a7 }
            if (r3 == 0) goto L_0x00a3
            r3.close()
        L_0x00a3:
            if (r2 == 0) goto L_0x008c
            goto L_0x0089
        L_0x00a6:
            return r3
        L_0x00a7:
            r0 = move-exception
            if (r3 == 0) goto L_0x00ad
            r3.close()
        L_0x00ad:
            if (r2 == 0) goto L_0x00b2
            r2.endTransaction()     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            android.content.Context r1 = f14290d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            goto L_0x00bd
        L_0x00bc:
            throw r0
        L_0x00bd:
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.g():org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        if (r0 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0045, code lost:
        if (r0 == null) goto L_0x004a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            r0.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            java.util.List<java.lang.Integer> r1 = r4.f14296j     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            int r1 = r1.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            if (r1 <= 0) goto L_0x003c
            r1 = 0
        L_0x0017:
            java.util.List<java.lang.Integer> r2 = r4.f14296j     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            int r2 = r2.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            if (r1 >= r2) goto L_0x003c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            r2.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            java.util.List<java.lang.Integer> r3 = r4.f14296j     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            r0.execSQL(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x003c:
            java.util.List<java.lang.Integer> r1 = r4.f14296j     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            r1.clear()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0045 }
            goto L_0x0047
        L_0x0045:
            if (r0 == 0) goto L_0x004a
        L_0x0047:
            r0.endTransaction()     // Catch:{ all -> 0x004a }
        L_0x004a:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x005c
        L_0x0054:
            android.content.Context r1 = f14290d     // Catch:{ all -> 0x005d }
            com.umeng.analytics.pro.j.a((android.content.Context) r1)     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x004a
            goto L_0x0047
        L_0x005c:
            return
        L_0x005d:
            r1 = move-exception
            if (r0 == 0) goto L_0x0063
            r0.endTransaction()     // Catch:{ all -> 0x0063 }
        L_0x0063:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x006e
        L_0x006d:
            throw r1
        L_0x006e:
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.h():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r0 != null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (r0 == null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0026, all -> 0x0017 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0026, all -> 0x0017 }
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0026, all -> 0x0017 }
            r0.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0026, all -> 0x0017 }
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0026, all -> 0x0017 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0026, all -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            if (r0 == 0) goto L_0x001c
        L_0x0019:
            r0.endTransaction()     // Catch:{ all -> 0x001c }
        L_0x001c:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x002e
        L_0x0026:
            android.content.Context r1 = f14290d     // Catch:{ all -> 0x002f }
            com.umeng.analytics.pro.j.a((android.content.Context) r1)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x001c
            goto L_0x0019
        L_0x002e:
            return
        L_0x002f:
            r1 = move-exception
            if (r0 == 0) goto L_0x0035
            r0.endTransaction()     // Catch:{ all -> 0x0035 }
        L_0x0035:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x0040
        L_0x003f:
            throw r1
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.i():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r1 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r1 != null) goto L_0x0051;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.f14297k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0077
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x005e, all -> 0x004e }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005e, all -> 0x004e }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005e, all -> 0x004e }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r3.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            java.lang.String r4 = r5.f14297k     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r3.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r3.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r1.execSQL(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r3.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            java.lang.String r4 = r5.f14297k     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r3.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r3.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            java.lang.String r0 = r3.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r1.execSQL(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x004f }
            goto L_0x0051
        L_0x004e:
            r1 = r2
        L_0x004f:
            if (r1 == 0) goto L_0x0054
        L_0x0051:
            r1.endTransaction()     // Catch:{ all -> 0x0054 }
        L_0x0054:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x0077
        L_0x005e:
            r1 = r2
        L_0x005f:
            android.content.Context r0 = f14290d     // Catch:{ all -> 0x0067 }
            com.umeng.analytics.pro.j.a((android.content.Context) r0)     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0054
            goto L_0x0051
        L_0x0067:
            r0 = move-exception
            if (r1 == 0) goto L_0x006d
            r1.endTransaction()     // Catch:{ all -> 0x006d }
        L_0x006d:
            android.content.Context r1 = f14290d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            throw r0
        L_0x0077:
            r5.f14297k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.j():void");
    }

    private k() {
        this.f14295i = new ArrayList();
        this.f14296j = new ArrayList();
        this.f14297k = null;
        this.f14298l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        String str2;
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str3 = "";
            if (optJSONObject != null) {
                if (optJSONObject.length() > 0) {
                    str2 = c(optJSONObject.toString());
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        str3 = c(optJSONObject2.toString());
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__ii", str);
                    contentValues.put("__e", String.valueOf(longValue));
                    contentValues.put("__sp", str2);
                    contentValues.put("__pp", str3);
                    contentValues.put("__av", UMGlobalContext.getInstance(f14290d).getAppVersion());
                    contentValues.put("__vc", UMUtils.getAppVersionCode(f14290d));
                    sQLiteDatabase.insert(g.c.f14241a, (String) null, contentValues);
                }
            }
            str2 = str3;
            str3 = c(optJSONObject2.toString());
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("__ii", str);
            contentValues2.put("__e", String.valueOf(longValue));
            contentValues2.put("__sp", str2);
            contentValues2.put("__pp", str3);
            contentValues2.put("__av", UMGlobalContext.getInstance(f14290d).getAppVersion());
            contentValues2.put("__vc", UMUtils.getAppVersionCode(f14290d));
            sQLiteDatabase.insert(g.c.f14241a, (String) null, contentValues2);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(java.lang.String r20, org.json.JSONObject r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            r19 = this;
            r10 = r19
            r11 = r20
            r12 = r21
            r13 = r22
            java.lang.String r14 = "__d"
            org.json.JSONObject r9 = r12.optJSONObject(r14)     // Catch:{ all -> 0x0116 }
            if (r9 == 0) goto L_0x0054
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch:{ all -> 0x0116 }
            r0 = 0
            r3[r0] = r14     // Catch:{ all -> 0x0116 }
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[]{r20}     // Catch:{ all -> 0x0116 }
            r6 = 0
            r7 = 0
            r8 = 0
            r16 = 0
            r0 = r19
            r2 = r22
            r15 = r9
            r9 = r16
            android.database.Cursor r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0116 }
            if (r0 == 0) goto L_0x0050
            r17 = 0
        L_0x0032:
            boolean r1 = r0.moveToNext()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0045
            int r1 = r0.getColumnIndex(r14)     // Catch:{ all -> 0x004c }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x004c }
            java.lang.String r17 = r10.d(r1)     // Catch:{ all -> 0x004c }
            goto L_0x0032
        L_0x0045:
            r18 = r17
            r17 = r0
            r0 = r18
            goto L_0x0058
        L_0x004c:
            r15 = r0
            goto L_0x0118
        L_0x0050:
            r17 = r0
            r0 = 0
            goto L_0x0058
        L_0x0054:
            r15 = r9
            r0 = 0
            r17 = 0
        L_0x0058:
            java.lang.String r1 = "\""
            java.lang.String r2 = "=\""
            java.lang.String r3 = "__ii"
            java.lang.String r4 = "\" where "
            if (r15 == 0) goto L_0x00a6
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x0112 }
            r5.<init>()     // Catch:{ all -> 0x0112 }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0112 }
            if (r6 != 0) goto L_0x0072
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x0112 }
            r5.<init>(r0)     // Catch:{ all -> 0x0112 }
        L_0x0072:
            r5.put(r15)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r10.c(r0)     // Catch:{ all -> 0x0112 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0112 }
            if (r5 != 0) goto L_0x00a6
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r5.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r6 = "update  __sd set __d=\""
            r5.append(r6)     // Catch:{ all -> 0x0112 }
            r5.append(r0)     // Catch:{ all -> 0x0112 }
            r5.append(r4)     // Catch:{ all -> 0x0112 }
            r5.append(r3)     // Catch:{ all -> 0x0112 }
            r5.append(r2)     // Catch:{ all -> 0x0112 }
            r5.append(r11)     // Catch:{ all -> 0x0112 }
            r5.append(r1)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0112 }
            r13.execSQL(r0)     // Catch:{ all -> 0x0112 }
        L_0x00a6:
            java.lang.String r0 = "__c"
            org.json.JSONObject r0 = r12.optJSONObject(r0)     // Catch:{ all -> 0x0112 }
            if (r0 == 0) goto L_0x00df
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r10.c(r0)     // Catch:{ all -> 0x0112 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0112 }
            if (r5 != 0) goto L_0x00df
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r5.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r6 = "update  __sd set __c=\""
            r5.append(r6)     // Catch:{ all -> 0x0112 }
            r5.append(r0)     // Catch:{ all -> 0x0112 }
            r5.append(r4)     // Catch:{ all -> 0x0112 }
            r5.append(r3)     // Catch:{ all -> 0x0112 }
            r5.append(r2)     // Catch:{ all -> 0x0112 }
            r5.append(r11)     // Catch:{ all -> 0x0112 }
            r5.append(r1)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0112 }
            r13.execSQL(r0)     // Catch:{ all -> 0x0112 }
        L_0x00df:
            java.lang.String r0 = "__f"
            long r5 = r12.optLong(r0)     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r0.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r7 = "update  __sd set __f=\""
            r0.append(r7)     // Catch:{ all -> 0x0112 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0112 }
            r0.append(r5)     // Catch:{ all -> 0x0112 }
            r0.append(r4)     // Catch:{ all -> 0x0112 }
            r0.append(r3)     // Catch:{ all -> 0x0112 }
            r0.append(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r11)     // Catch:{ all -> 0x0112 }
            r0.append(r1)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0112 }
            r13.execSQL(r0)     // Catch:{ all -> 0x0112 }
            if (r17 == 0) goto L_0x011d
            r17.close()
            goto L_0x011d
        L_0x0112:
            r15 = r17
            goto L_0x0118
        L_0x0116:
            r15 = 0
        L_0x0118:
            if (r15 == 0) goto L_0x011d
            r15.close()
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.c(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.f14295i.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if ("-1".equals(r7) != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0094, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        if (r2 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        if (r2 != null) goto L_0x009a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a7 */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[ExcHandler: all (unused java.lang.Throwable), SYNTHETIC, Splitter:B:3:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a7, all -> 0x0098 }
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a7, all -> 0x0098 }
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a7, all -> 0x0098 }
            r3.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, all -> 0x0094 }
            r4 = 0
        L_0x0013:
            int r5 = r11.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, all -> 0x0094 }
            if (r4 >= r5) goto L_0x008d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            r6.<init>()     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r7 = r5.optString(r1)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L_0x0034
            boolean r8 = r9.equals(r7)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            if (r8 == 0) goto L_0x0043
        L_0x0034:
            com.umeng.analytics.pro.w r7 = com.umeng.analytics.pro.w.a()     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            if (r8 == 0) goto L_0x0043
            r7 = r9
        L_0x0043:
            r6.put(r1, r7)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            int r7 = r5.optInt(r0)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            r6.put(r0, r7)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r7 = "__av"
            android.content.Context r8 = f14290d     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r7 = "__vc"
            android.content.Context r8 = f14290d     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            r5.remove(r1)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            r5.remove(r0)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r5 = r10.c(r5)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            r6.put(r7, r5)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch:{ Exception -> 0x008a, all -> 0x0094 }
        L_0x008a:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x008d:
            r3.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, all -> 0x0094 }
            r3.endTransaction()     // Catch:{ all -> 0x009d }
            goto L_0x009d
        L_0x0094:
            r2 = r3
            goto L_0x0098
        L_0x0096:
            r2 = r3
            goto L_0x00a7
        L_0x0098:
            if (r2 == 0) goto L_0x009d
        L_0x009a:
            r2.endTransaction()     // Catch:{ all -> 0x009d }
        L_0x009d:
            android.content.Context r11 = f14290d
            com.umeng.analytics.pro.i r11 = com.umeng.analytics.pro.i.a(r11)
            r11.b()
            goto L_0x00af
        L_0x00a7:
            android.content.Context r11 = f14290d     // Catch:{ all -> 0x00b0 }
            com.umeng.analytics.pro.j.a((android.content.Context) r11)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x009d
            goto L_0x009a
        L_0x00af:
            return
        L_0x00b0:
            r11 = move-exception
            if (r2 == 0) goto L_0x00b6
            r2.endTransaction()     // Catch:{ all -> 0x00b6 }
        L_0x00b6:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x00c1
        L_0x00c0:
            throw r11
        L_0x00c1:
            goto L_0x00c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONArray):void");
    }

    public String d(String str) {
        try {
            if (TextUtils.isEmpty(f14291e)) {
                return str;
            }
            return new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f14291e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                new JSONObject(str);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                return str;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public JSONObject b(boolean z10) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z10);
        return jSONObject;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: android.database.sqlite.SQLiteDatabase} */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v9 android.database.sqlite.SQLiteDatabase
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.collectCodeVars(ProcessVariables.java:122)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:45)
        */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        com.umeng.analytics.pro.j.a(f14290d);
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        if (r0 != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0081, code lost:
        if (r1 != 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        com.umeng.analytics.pro.j.a(f14290d);
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        if (r0 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008f, code lost:
        if (r1 != 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009e, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009f, code lost:
        if (r0 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a1, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a4, code lost:
        if (r1 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:24:0x0077, B:31:0x0085] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0085 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0085=Splitter:B:31:0x0085, B:24:0x0077=Splitter:B:24:0x0077} */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0084, all -> 0x0076 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0084, all -> 0x0076 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0084, all -> 0x0076 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            if (r2 != 0) goto L_0x0028
            java.lang.String r3 = "__er"
            r5 = 0
            java.lang.String r6 = "__i=? "
            java.lang.String[] r7 = new java.lang.String[]{r14}     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            goto L_0x0037
        L_0x0028:
            java.lang.String r3 = "__er"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
        L_0x0037:
            r0 = r14
            if (r0 == 0) goto L_0x006d
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            r14.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
        L_0x003f:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            if (r2 == 0) goto L_0x0062
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            if (r3 != 0) goto L_0x003f
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            java.lang.String r2 = r12.d(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            r3.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            r14.put(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            goto L_0x003f
        L_0x0062:
            int r2 = r14.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            if (r2 <= 0) goto L_0x006d
            java.lang.String r2 = "error"
            r13.put(r2, r14)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
        L_0x006d:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0085, all -> 0x0077 }
            if (r0 == 0) goto L_0x0091
            r0.close()
            goto L_0x0091
        L_0x0076:
            r1 = r0
        L_0x0077:
            android.content.Context r13 = f14290d     // Catch:{ all -> 0x009e }
            com.umeng.analytics.pro.j.a((android.content.Context) r13)     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0081
            r0.close()
        L_0x0081:
            if (r1 == 0) goto L_0x0094
            goto L_0x0091
        L_0x0084:
            r1 = r0
        L_0x0085:
            android.content.Context r13 = f14290d     // Catch:{ all -> 0x009e }
            com.umeng.analytics.pro.j.a((android.content.Context) r13)     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x008f
            r0.close()
        L_0x008f:
            if (r1 == 0) goto L_0x0094
        L_0x0091:
            r1.endTransaction()     // Catch:{ all -> 0x0094 }
        L_0x0094:
            android.content.Context r13 = f14290d
            com.umeng.analytics.pro.i r13 = com.umeng.analytics.pro.i.a(r13)
            r13.b()
            return
        L_0x009e:
            r13 = move-exception
            if (r0 == 0) goto L_0x00a4
            r0.close()
        L_0x00a4:
            if (r1 == 0) goto L_0x00a9
            r1.endTransaction()     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            android.content.Context r14 = f14290d
            com.umeng.analytics.pro.i r14 = com.umeng.analytics.pro.i.a(r14)
            r14.b()
            goto L_0x00b4
        L_0x00b3:
            throw r13
        L_0x00b4:
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f14291e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f14291e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        if (r0 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        if (r0 != null) goto L_0x0058;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065, all -> 0x0056 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065, all -> 0x0056 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065, all -> 0x0056 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            r2.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            java.lang.String r5 = r4.c(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            if (r6 != 0) goto L_0x004b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            r2.put(r5, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            java.lang.String r5 = "__av"
            android.content.Context r6 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            r2.put(r5, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            java.lang.String r5 = "__vc"
            android.content.Context r6 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            r2.put(r5, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
        L_0x004b:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, all -> 0x0052 }
            r1.endTransaction()     // Catch:{ all -> 0x005b }
            goto L_0x005b
        L_0x0052:
            r0 = r1
            goto L_0x0056
        L_0x0054:
            r0 = r1
            goto L_0x0065
        L_0x0056:
            if (r0 == 0) goto L_0x005b
        L_0x0058:
            r0.endTransaction()     // Catch:{ all -> 0x005b }
        L_0x005b:
            android.content.Context r5 = f14290d
            com.umeng.analytics.pro.i r5 = com.umeng.analytics.pro.i.a(r5)
            r5.b()
            goto L_0x006d
        L_0x0065:
            android.content.Context r5 = f14290d     // Catch:{ all -> 0x006f }
            com.umeng.analytics.pro.j.a((android.content.Context) r5)     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x005b
            goto L_0x0058
        L_0x006d:
            r5 = 0
            return r5
        L_0x006f:
            r5 = move-exception
            if (r0 == 0) goto L_0x0075
            r0.endTransaction()     // Catch:{ all -> 0x0075 }
        L_0x0075:
            android.content.Context r6 = f14290d
            com.umeng.analytics.pro.i r6 = com.umeng.analytics.pro.i.a(r6)
            r6.b()
            goto L_0x0080
        L_0x007f:
            throw r5
        L_0x0080:
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d5, code lost:
        if (r1 != null) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e4, code lost:
        if (r1 != null) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x00da=Splitter:B:49:0x00da, B:42:0x00cb=Splitter:B:42:0x00cb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x00d8, all -> 0x00c9 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00d8, all -> 0x00c9 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00d8, all -> 0x00c9 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r3 = "__is"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c7, all -> 0x00c5 }
            if (r2 == 0) goto L_0x00aa
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            r3.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
        L_0x0024:
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            if (r4 == 0) goto L_0x009f
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            r4.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r5 = "__e"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r6 = "__ii"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r0 = r2.getString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.util.List<java.lang.String> r6 = r12.f14298l     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            r6.add(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r6 = "__sp"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r7 = "__pp"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r7 = r2.getString(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            if (r8 != 0) goto L_0x0070
            java.lang.String r8 = "_$sp"
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r6 = r12.d(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            r9.<init>(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            r4.put(r8, r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
        L_0x0070:
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            if (r6 != 0) goto L_0x0084
            java.lang.String r6 = "_$pp"
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r7 = r12.d(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            r8.<init>(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            r4.put(r6, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
        L_0x0084:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            if (r6 != 0) goto L_0x0024
            java.lang.String r6 = "id"
            r4.put(r6, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            java.lang.String r6 = "start_time"
            r4.put(r6, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            int r5 = r4.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            if (r5 <= 0) goto L_0x009d
            r3.put(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
        L_0x009d:
            if (r14 == 0) goto L_0x0024
        L_0x009f:
            int r14 = r3.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            if (r14 <= 0) goto L_0x00aa
            java.lang.String r14 = "sessions"
            r13.put(r14, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
        L_0x00aa:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c2, all -> 0x00bf }
            if (r2 == 0) goto L_0x00b2
            r2.close()
        L_0x00b2:
            r1.endTransaction()     // Catch:{ all -> 0x00b5 }
        L_0x00b5:
            android.content.Context r13 = f14290d
            com.umeng.analytics.pro.i r13 = com.umeng.analytics.pro.i.a(r13)
            r13.b()
            goto L_0x00f3
        L_0x00bf:
            r13 = r0
            r0 = r2
            goto L_0x00cb
        L_0x00c2:
            r13 = r0
            r0 = r2
            goto L_0x00da
        L_0x00c5:
            r13 = r0
            goto L_0x00cb
        L_0x00c7:
            r13 = r0
            goto L_0x00da
        L_0x00c9:
            r13 = r0
            r1 = r13
        L_0x00cb:
            android.content.Context r14 = f14290d     // Catch:{ all -> 0x00f4 }
            com.umeng.analytics.pro.j.a((android.content.Context) r14)     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x00d5
            r0.close()
        L_0x00d5:
            if (r1 == 0) goto L_0x00e9
            goto L_0x00e6
        L_0x00d8:
            r13 = r0
            r1 = r13
        L_0x00da:
            android.content.Context r14 = f14290d     // Catch:{ all -> 0x00f4 }
            com.umeng.analytics.pro.j.a((android.content.Context) r14)     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x00e4
            r0.close()
        L_0x00e4:
            if (r1 == 0) goto L_0x00e9
        L_0x00e6:
            r1.endTransaction()     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            android.content.Context r14 = f14290d
            com.umeng.analytics.pro.i r14 = com.umeng.analytics.pro.i.a(r14)
            r14.b()
            r0 = r13
        L_0x00f3:
            return r0
        L_0x00f4:
            r13 = move-exception
            if (r0 == 0) goto L_0x00fa
            r0.close()
        L_0x00fa:
            if (r1 == 0) goto L_0x00ff
            r1.endTransaction()     // Catch:{ all -> 0x00ff }
        L_0x00ff:
            android.content.Context r14 = f14290d
            com.umeng.analytics.pro.i r14 = com.umeng.analytics.pro.i.a(r14)
            r14.b()
            goto L_0x010a
        L_0x0109:
            throw r13
        L_0x010a:
            goto L_0x0109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0085, code lost:
        if (r2 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0087, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r2 != null) goto L_0x0087;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0094 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.k.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r2 = 0
            android.content.Context r3 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0094, all -> 0x0085 }
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0094, all -> 0x0085 }
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0094, all -> 0x0085 }
            r3.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            com.umeng.analytics.pro.k$a r4 = com.umeng.analytics.pro.k.a.BEGIN     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            if (r9 != r4) goto L_0x004f
            java.lang.Object r8 = r8.opt(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            long r8 = r8.longValue()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            r4.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            r4.put(r0, r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            java.lang.String r7 = "__av"
            android.content.Context r8 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            r4.put(r7, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            java.lang.String r7 = "__vc"
            android.content.Context r8 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            r4.put(r7, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            goto L_0x007a
        L_0x004f:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.INSTANTSESSIONBEGIN     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            if (r9 != r0) goto L_0x0057
            r6.b(r7, r8, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            goto L_0x007a
        L_0x0057:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.END     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            if (r9 != r0) goto L_0x005f
            r6.a((java.lang.String) r7, (org.json.JSONObject) r8, (android.database.sqlite.SQLiteDatabase) r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            goto L_0x007a
        L_0x005f:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.PAGE     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            if (r9 != r0) goto L_0x0069
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            goto L_0x007a
        L_0x0069:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.AUTOPAGE     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            if (r9 != r0) goto L_0x0073
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            goto L_0x007a
        L_0x0073:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.NEWSESSION     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            if (r9 != r0) goto L_0x007a
            r6.c(r7, r8, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
        L_0x007a:
            r3.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, all -> 0x0081 }
            r3.endTransaction()     // Catch:{ all -> 0x008a }
            goto L_0x008a
        L_0x0081:
            r2 = r3
            goto L_0x0085
        L_0x0083:
            r2 = r3
            goto L_0x0094
        L_0x0085:
            if (r2 == 0) goto L_0x008a
        L_0x0087:
            r2.endTransaction()     // Catch:{ all -> 0x008a }
        L_0x008a:
            android.content.Context r7 = f14290d
            com.umeng.analytics.pro.i r7 = com.umeng.analytics.pro.i.a(r7)
            r7.b()
            goto L_0x009c
        L_0x0094:
            android.content.Context r7 = f14290d     // Catch:{ all -> 0x009d }
            com.umeng.analytics.pro.j.a((android.content.Context) r7)     // Catch:{ all -> 0x009d }
            if (r2 == 0) goto L_0x008a
            goto L_0x0087
        L_0x009c:
            return r1
        L_0x009d:
            r7 = move-exception
            if (r2 == 0) goto L_0x00a3
            r2.endTransaction()     // Catch:{ all -> 0x00a3 }
        L_0x00a3:
            android.content.Context r8 = f14290d
            com.umeng.analytics.pro.i r8 = com.umeng.analytics.pro.i.a(r8)
            r8.b()
            goto L_0x00ae
        L_0x00ad:
            throw r7
        L_0x00ae:
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.k$a):boolean");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        String str2;
        try {
            long longValue = ((Long) jSONObject.opt(g.d.a.f14261g)).longValue();
            Object opt = jSONObject.opt(g.d.a.f14262h);
            long longValue2 = (opt == null || !(opt instanceof Long)) ? 0 : ((Long) opt).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str3 = "";
            if (optJSONObject != null) {
                if (optJSONObject.length() > 0) {
                    str2 = c(optJSONObject.toString());
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        str3 = c(optJSONObject2.toString());
                    }
                    sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + g.d.a.f14262h + "=\"" + longValue2 + "\", " + "__sp" + "=\"" + str2 + "\", " + "__pp" + "=\"" + str3 + "\" where " + "__ii" + "=\"" + str + "\"");
                }
            }
            str2 = str3;
            str3 = c(optJSONObject2.toString());
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + g.d.a.f14262h + "=\"" + longValue2 + "\", " + "__sp" + "=\"" + str2 + "\", " + "__pp" + "=\"" + str3 + "\" where " + "__ii" + "=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r0 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        if (r0 == null) goto L_0x0056;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0060 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            r0.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            if (r4 == 0) goto L_0x0018
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            goto L_0x004d
        L_0x0018:
            java.util.List<java.lang.String> r3 = r2.f14295i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            int r3 = r3.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            if (r3 <= 0) goto L_0x004d
            r3 = 0
        L_0x0021:
            java.util.List<java.lang.String> r4 = r2.f14295i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            int r4 = r4.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            if (r3 >= r4) goto L_0x004d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            r4.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            java.util.List<java.lang.String> r1 = r2.f14295i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            r4.append(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            r0.execSQL(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            int r3 = r3 + 1
            goto L_0x0021
        L_0x004d:
            r0.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, all -> 0x0051 }
            goto L_0x0053
        L_0x0051:
            if (r0 == 0) goto L_0x0056
        L_0x0053:
            r0.endTransaction()     // Catch:{ all -> 0x0056 }
        L_0x0056:
            android.content.Context r3 = f14290d
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)
            r3.b()
            goto L_0x0068
        L_0x0060:
            android.content.Context r3 = f14290d     // Catch:{ all -> 0x0069 }
            com.umeng.analytics.pro.j.a((android.content.Context) r3)     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0056
            goto L_0x0053
        L_0x0068:
            return
        L_0x0069:
            r3 = move-exception
            if (r0 == 0) goto L_0x006f
            r0.endTransaction()     // Catch:{ all -> 0x006f }
        L_0x006f:
            android.content.Context r4 = f14290d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            goto L_0x007a
        L_0x0079:
            throw r3
        L_0x007a:
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(boolean, boolean):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        if (r4 == 0) goto L_0x0060;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043 A[SYNTHETIC, Splitter:B:14:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048 A[Catch:{ Exception -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058 A[SYNTHETIC, Splitter:B:25:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "__f"
            r1 = 0
            r2 = 0
            android.content.Context r4 = f14290d     // Catch:{ Exception -> 0x0055, all -> 0x003f }
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)     // Catch:{ Exception -> 0x0055, all -> 0x003f }
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch:{ Exception -> 0x0055, all -> 0x003f }
            r4.beginTransaction()     // Catch:{ Exception -> 0x0056, all -> 0x003d }
            r5 = 1
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0056, all -> 0x003d }
            r5 = 0
            r8[r5] = r0     // Catch:{ Exception -> 0x0056, all -> 0x003d }
            java.lang.String r6 = "__sd"
            java.lang.String r9 = "__ii=? "
            java.lang.String[] r10 = new java.lang.String[]{r16}     // Catch:{ Exception -> 0x0056, all -> 0x003d }
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r5 = r15
            r7 = r4
            android.database.Cursor r1 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0056, all -> 0x003d }
            if (r1 == 0) goto L_0x0037
            r1.moveToFirst()     // Catch:{ Exception -> 0x0056, all -> 0x003d }
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x0056, all -> 0x003d }
            long r2 = r1.getLong(r0)     // Catch:{ Exception -> 0x0056, all -> 0x003d }
        L_0x0037:
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ Exception -> 0x0060 }
            goto L_0x005d
        L_0x003d:
            r0 = move-exception
            goto L_0x0041
        L_0x003f:
            r0 = move-exception
            r4 = r1
        L_0x0041:
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ Exception -> 0x004b }
        L_0x0046:
            if (r4 == 0) goto L_0x004b
            r4.endTransaction()     // Catch:{ Exception -> 0x004b }
        L_0x004b:
            android.content.Context r1 = f14290d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            throw r0
        L_0x0055:
            r4 = r1
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ Exception -> 0x0060 }
        L_0x005b:
            if (r4 == 0) goto L_0x0060
        L_0x005d:
            r4.endTransaction()     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (r0 == null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0031, code lost:
        if (r0 == null) goto L_0x0036;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            r0.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            if (r1 != 0) goto L_0x002d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            r1.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            r1.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            java.lang.String r4 = r1.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            r0.execSQL(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
        L_0x002d:
            r0.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0040, all -> 0x0031 }
            goto L_0x0033
        L_0x0031:
            if (r0 == 0) goto L_0x0036
        L_0x0033:
            r0.endTransaction()     // Catch:{ all -> 0x0036 }
        L_0x0036:
            android.content.Context r4 = f14290d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            goto L_0x0048
        L_0x0040:
            android.content.Context r4 = f14290d     // Catch:{ all -> 0x0049 }
            com.umeng.analytics.pro.j.a((android.content.Context) r4)     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0036
            goto L_0x0033
        L_0x0048:
            return
        L_0x0049:
            r4 = move-exception
            if (r0 == 0) goto L_0x004f
            r0.endTransaction()     // Catch:{ all -> 0x004f }
        L_0x004f:
            android.content.Context r0 = f14290d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L_0x005a
        L_0x0059:
            throw r4
        L_0x005a:
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r13v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[LOOP:0: B:19:0x004f->B:22:0x0055, LOOP_START, PHI: r13 
      PHI: (r13v4 ?) = (r13v0 ?), (r13v7 ?) binds: [B:18:0x004d, B:22:0x0055] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:19:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A[Catch:{ all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r16, org.json.JSONObject r17, android.database.sqlite.SQLiteDatabase r18, java.lang.String r19) {
        /*
            r15 = this;
            r10 = r15
            r0 = r17
            r11 = r19
            java.lang.String r12 = "=\""
            java.lang.String r1 = "__b"
            java.lang.String r2 = "__a"
            r13 = 0
            boolean r3 = r2.equals(r11)     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x0022
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x0021
            int r1 = r0.length()     // Catch:{ all -> 0x00de }
            if (r1 > 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r14 = r0
            goto L_0x0036
        L_0x0021:
            return
        L_0x0022:
            boolean r2 = r1.equals(r11)     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x0035
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x0034
            int r1 = r0.length()     // Catch:{ all -> 0x00de }
            if (r1 > 0) goto L_0x001f
        L_0x0034:
            return
        L_0x0035:
            r14 = r13
        L_0x0036:
            java.lang.String[] r3 = new java.lang.String[]{r19}     // Catch:{ all -> 0x00de }
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[]{r16}     // Catch:{ all -> 0x00de }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r0 = r15
            r2 = r18
            android.database.Cursor r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x0066
        L_0x004f:
            boolean r1 = r0.moveToNext()     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0066
            int r1 = r0.getColumnIndex(r11)     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0062 }
            java.lang.String r13 = r15.d(r1)     // Catch:{ all -> 0x0062 }
            goto L_0x004f
        L_0x0062:
            r13 = r0
            goto L_0x00df
        L_0x0066:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x0062 }
            r1.<init>()     // Catch:{ all -> 0x0062 }
            boolean r2 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0062 }
            if (r2 != 0) goto L_0x0076
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x0062 }
            r1.<init>(r13)     // Catch:{ all -> 0x0062 }
        L_0x0076:
            int r2 = r1.length()     // Catch:{ all -> 0x0062 }
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 <= r3) goto L_0x0084
            if (r0 == 0) goto L_0x0083
            r0.close()
        L_0x0083:
            return
        L_0x0084:
            r2 = 0
        L_0x0085:
            int r3 = r14.length()     // Catch:{ all -> 0x0062 }
            if (r2 >= r3) goto L_0x0097
            org.json.JSONObject r3 = r14.getJSONObject(r2)     // Catch:{ JSONException -> 0x0094 }
            if (r3 == 0) goto L_0x0094
            r1.put(r3)     // Catch:{ all -> 0x0062 }
        L_0x0094:
            int r2 = r2 + 1
            goto L_0x0085
        L_0x0097:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = r15.c(r1)     // Catch:{ all -> 0x0062 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0062 }
            if (r2 != 0) goto L_0x00d8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r2.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = "update __sd set "
            r2.append(r3)     // Catch:{ all -> 0x0062 }
            r2.append(r11)     // Catch:{ all -> 0x0062 }
            r2.append(r12)     // Catch:{ all -> 0x0062 }
            r2.append(r1)     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = "\" where "
            r2.append(r1)     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = "__ii"
            r2.append(r1)     // Catch:{ all -> 0x0062 }
            r2.append(r12)     // Catch:{ all -> 0x0062 }
            r1 = r16
            r2.append(r1)     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = "\""
            r2.append(r1)     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0062 }
            r2 = r18
            r2.execSQL(r1)     // Catch:{ all -> 0x0062 }
        L_0x00d8:
            if (r0 == 0) goto L_0x00e4
            r0.close()
            goto L_0x00e4
        L_0x00de:
        L_0x00df:
            if (r13 == 0) goto L_0x00e4
            r13.close()
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    public JSONObject a(boolean z10) {
        a();
        this.f14296j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z10) {
            a(jSONObject, z10);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String a10 = a(jSONObject, z10);
            if (!TextUtils.isEmpty(a10)) {
                b(jSONObject, a10);
                a(jSONObject, a10);
            }
        }
        return jSONObject;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: android.database.sqlite.SQLiteDatabase} */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v9 android.database.sqlite.SQLiteDatabase
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.collectCodeVars(ProcessVariables.java:122)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:45)
        */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0175, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        com.umeng.analytics.pro.j.a(f14290d);
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017a, code lost:
        if (r0 != null) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x017c, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x017f, code lost:
        if (r1 != 0) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0183, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        com.umeng.analytics.pro.j.a(f14290d);
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0188, code lost:
        if (r0 != null) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018a, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
        if (r1 != 0) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019c, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x019d, code lost:
        if (r0 != null) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x019f, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01a2, code lost:
        if (r1 != null) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:66:0x0175, B:73:0x0183] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x0175 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0183 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:73:0x0183=Splitter:B:73:0x0183, B:66:0x0175=Splitter:B:66:0x0175} */
    private void a(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0182, all -> 0x0174 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0182, all -> 0x0174 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0182, all -> 0x0174 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r2 != 0) goto L_0x0028
            java.lang.String r3 = "__et"
            r5 = 0
            java.lang.String r6 = "__i=? "
            java.lang.String[] r7 = new java.lang.String[]{r14}     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            goto L_0x0037
        L_0x0028:
            java.lang.String r3 = "__et"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
        L_0x0037:
            r0 = r14
            if (r0 == 0) goto L_0x016b
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r14.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r2.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            com.umeng.analytics.pro.w r3 = com.umeng.analytics.pro.w.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r3 = r3.b()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
        L_0x004c:
            boolean r4 = r0.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r4 == 0) goto L_0x00e9
            java.lang.String r4 = "__t"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            int r4 = r0.getInt(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r5 = "__i"
            int r5 = r0.getColumnIndex(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r6 = "__s"
            int r6 = r0.getColumnIndex(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r7 != 0) goto L_0x007e
            java.lang.String r7 = "-1"
            boolean r7 = r7.equals(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r7 == 0) goto L_0x0085
        L_0x007e:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r5 != 0) goto L_0x004c
            r5 = r3
        L_0x0085:
            r7 = 0
            int r7 = r0.getInt(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.util.List<java.lang.Integer> r8 = r12.f14296j     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r8.add(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r7 = 2049(0x801, float:2.871E-42)
            if (r4 == r7) goto L_0x00c2
            r7 = 2050(0x802, float:2.873E-42)
            if (r4 == r7) goto L_0x009c
            goto L_0x004c
        L_0x009c:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r4 != 0) goto L_0x004c
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r6 = r12.d(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r4.<init>(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            boolean r6 = r2.has(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r6 == 0) goto L_0x00b6
            org.json.JSONArray r6 = r2.optJSONArray(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            goto L_0x00bb
        L_0x00b6:
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r6.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
        L_0x00bb:
            r6.put(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r2.put(r5, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            goto L_0x004c
        L_0x00c2:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r4 != 0) goto L_0x004c
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r6 = r12.d(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r4.<init>(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            boolean r6 = r14.has(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r6 == 0) goto L_0x00dc
            org.json.JSONArray r6 = r14.optJSONArray(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            goto L_0x00e1
        L_0x00dc:
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r6.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
        L_0x00e1:
            r6.put(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r14.put(r5, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            goto L_0x004c
        L_0x00e9:
            int r3 = r14.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r3 <= 0) goto L_0x012a
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r3.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.util.Iterator r4 = r14.keys()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
        L_0x00f8:
            boolean r5 = r4.hasNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r5 == 0) goto L_0x011f
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r5.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.Object r6 = r4.next()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r7 = r14.optString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r8.<init>(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r5.put(r6, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            int r6 = r5.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r6 <= 0) goto L_0x00f8
            r3.put(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            goto L_0x00f8
        L_0x011f:
            int r14 = r3.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r14 <= 0) goto L_0x012a
            java.lang.String r14 = "ekv"
            r13.put(r14, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
        L_0x012a:
            int r14 = r2.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r14 <= 0) goto L_0x016b
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r14.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.util.Iterator r3 = r2.keys()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
        L_0x0139:
            boolean r4 = r3.hasNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r4 == 0) goto L_0x0160
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r4.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.Object r5 = r3.next()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            java.lang.String r6 = r2.optString(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r7.<init>(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            r4.put(r5, r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            int r5 = r4.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r5 <= 0) goto L_0x0139
            r14.put(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            goto L_0x0139
        L_0x0160:
            int r2 = r14.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r2 <= 0) goto L_0x016b
            java.lang.String r2 = "gkv"
            r13.put(r2, r14)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
        L_0x016b:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0183, all -> 0x0175 }
            if (r0 == 0) goto L_0x018f
            r0.close()
            goto L_0x018f
        L_0x0174:
            r1 = r0
        L_0x0175:
            android.content.Context r13 = f14290d     // Catch:{ all -> 0x019c }
            com.umeng.analytics.pro.j.a((android.content.Context) r13)     // Catch:{ all -> 0x019c }
            if (r0 == 0) goto L_0x017f
            r0.close()
        L_0x017f:
            if (r1 == 0) goto L_0x0192
            goto L_0x018f
        L_0x0182:
            r1 = r0
        L_0x0183:
            android.content.Context r13 = f14290d     // Catch:{ all -> 0x019c }
            com.umeng.analytics.pro.j.a((android.content.Context) r13)     // Catch:{ all -> 0x019c }
            if (r0 == 0) goto L_0x018d
            r0.close()
        L_0x018d:
            if (r1 == 0) goto L_0x0192
        L_0x018f:
            r1.endTransaction()     // Catch:{ all -> 0x0192 }
        L_0x0192:
            android.content.Context r13 = f14290d
            com.umeng.analytics.pro.i r13 = com.umeng.analytics.pro.i.a(r13)
            r13.b()
            return
        L_0x019c:
            r13 = move-exception
            if (r0 == 0) goto L_0x01a2
            r0.close()
        L_0x01a2:
            if (r1 == 0) goto L_0x01a7
            r1.endTransaction()     // Catch:{ all -> 0x01a7 }
        L_0x01a7:
            android.content.Context r14 = f14290d
            com.umeng.analytics.pro.i r14 = com.umeng.analytics.pro.i.a(r14)
            r14.b()
            goto L_0x01b2
        L_0x01b1:
            throw r13
        L_0x01b2:
            goto L_0x01b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x021c, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x021f, code lost:
        if (r12 != null) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x022b, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x022e, code lost:
        if (r12 != null) goto L_0x0230;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:106:0x0215, B:113:0x0224] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:106:0x0215 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x0224 */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x022b  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:113:0x0224=Splitter:B:113:0x0224, B:106:0x0215=Splitter:B:106:0x0215} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            r21 = this;
            r11 = r21
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0222, all -> 0x0213 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0222, all -> 0x0213 }
            android.database.sqlite.SQLiteDatabase r12 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0222, all -> 0x0213 }
            r12.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0211, all -> 0x020f }
            java.lang.String r2 = "__sd"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r1 = r21
            r3 = r12
            android.database.Cursor r1 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0211, all -> 0x020f }
            if (r1 == 0) goto L_0x0205
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            r2.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
        L_0x0027:
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            if (r3 == 0) goto L_0x01d8
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            r3.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            java.lang.String r5 = "__f"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            java.lang.String r5 = r1.getString(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            java.lang.String r6 = "__e"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            java.lang.String r7 = "__g"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            java.lang.String r7 = r1.getString(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            java.lang.String r8 = "__ii"
            int r8 = r1.getColumnIndex(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            java.lang.String r0 = r1.getString(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0203, all -> 0x0201 }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            if (r8 != 0) goto L_0x01c8
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            if (r8 != 0) goto L_0x01c8
            long r8 = java.lang.Long.parseLong(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            long r13 = java.lang.Long.parseLong(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            long r8 = r8 - r13
            r13 = 0
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 <= 0) goto L_0x01bf
            java.lang.String r8 = "__a"
            int r8 = r1.getColumnIndex(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r8 = r1.getString(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r9 = "__b"
            int r9 = r1.getColumnIndex(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r9 = r1.getString(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r10 = "__c"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r15 = "__d"
            int r15 = r1.getColumnIndex(r15)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r15 = r1.getString(r15)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.util.List<java.lang.String> r4 = r11.f14295i     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            r4.add(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r4 = "__sp"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r13 = "__pp"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r14 = "id"
            r3.put(r14, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r14 = "start_time"
            r3.put(r14, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r14 = "end_time"
            r3.put(r14, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            java.lang.String r14 = "header_foreground_count"
            boolean r14 = com.umeng.commonsdk.config.FieldManager.allow(r14)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d5, all -> 0x01d2 }
            r18 = r0
            java.lang.String r0 = "duration"
            if (r14 == 0) goto L_0x010f
            long r19 = java.lang.Long.parseLong(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010a, all -> 0x0105 }
            r16 = 0
            int r14 = (r19 > r16 ? 1 : (r19 == r16 ? 0 : -1))
            if (r14 > 0) goto L_0x00ec
            long r16 = java.lang.Long.parseLong(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010a, all -> 0x0105 }
            long r5 = java.lang.Long.parseLong(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010a, all -> 0x0105 }
            long r5 = r16 - r5
            r3.put(r0, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010a, all -> 0x0105 }
            r14 = r1
            r16 = r2
            goto L_0x011e
        L_0x00ec:
            r14 = r1
            r16 = r2
            long r1 = java.lang.Long.parseLong(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r3.put(r0, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            java.lang.String r0 = "duration_old"
            long r1 = java.lang.Long.parseLong(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            long r5 = java.lang.Long.parseLong(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            long r1 = r1 - r5
            r3.put(r0, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            goto L_0x011e
        L_0x0105:
            r14 = r1
        L_0x0106:
            r0 = r18
            goto L_0x0215
        L_0x010a:
            r14 = r1
        L_0x010b:
            r0 = r18
            goto L_0x0224
        L_0x010f:
            r14 = r1
            r16 = r2
            long r1 = java.lang.Long.parseLong(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            long r5 = java.lang.Long.parseLong(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            long r1 = r1 - r5
            r3.put(r0, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
        L_0x011e:
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r0 != 0) goto L_0x0132
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            java.lang.String r1 = r11.d(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r0.<init>(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            java.lang.String r1 = "pages"
            r3.put(r1, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
        L_0x0132:
            com.umeng.analytics.MobclickAgent$PageMode r0 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.analytics.MobclickAgent.PageMode.AUTO     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r0 != r1) goto L_0x013a
            r0 = 1
            goto L_0x013b
        L_0x013a:
            r0 = 0
        L_0x013b:
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r1 != 0) goto L_0x0160
            if (r0 == 0) goto L_0x0160
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            java.lang.String r1 = r11.d(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r0.<init>(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r1.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            int r2 = r0.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r2 <= 0) goto L_0x015b
            org.json.JSONArray r1 = r11.b((org.json.JSONArray) r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
        L_0x015b:
            java.lang.String r0 = "autopages"
            r3.put(r0, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
        L_0x0160:
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r0 != 0) goto L_0x0174
            java.lang.String r0 = "traffic"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            java.lang.String r2 = r11.d(r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r1.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r3.put(r0, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
        L_0x0174:
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r0 != 0) goto L_0x0188
            java.lang.String r0 = "locations"
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            java.lang.String r2 = r11.d(r15)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r1.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r3.put(r0, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
        L_0x0188:
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r0 != 0) goto L_0x019c
            java.lang.String r0 = "_$sp"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            java.lang.String r2 = r11.d(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r1.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r3.put(r0, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
        L_0x019c:
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r0 != 0) goto L_0x01b0
            java.lang.String r0 = "_$pp"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            java.lang.String r2 = r11.d(r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r1.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            r3.put(r0, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
        L_0x01b0:
            int r0 = r3.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            if (r0 <= 0) goto L_0x01bc
            r1 = r16
            r1.put(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106 }
            goto L_0x01c3
        L_0x01bc:
            r1 = r16
            goto L_0x01c3
        L_0x01bf:
            r18 = r0
            r14 = r1
            r1 = r2
        L_0x01c3:
            if (r23 == 0) goto L_0x01cc
            r0 = r18
            goto L_0x01da
        L_0x01c8:
            r18 = r0
            r14 = r1
            r1 = r2
        L_0x01cc:
            r2 = r1
            r1 = r14
            r0 = r18
            goto L_0x0027
        L_0x01d2:
            r18 = r0
            goto L_0x0201
        L_0x01d5:
            r18 = r0
            goto L_0x0203
        L_0x01d8:
            r14 = r1
            r1 = r2
        L_0x01da:
            java.util.List<java.lang.String> r2 = r11.f14295i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0224, all -> 0x0215 }
            int r2 = r2.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0224, all -> 0x0215 }
            r3 = 1
            if (r2 >= r3) goto L_0x01f3
            r14.close()
            r12.endTransaction()     // Catch:{ all -> 0x01e9 }
        L_0x01e9:
            android.content.Context r1 = f14290d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            return r0
        L_0x01f3:
            int r2 = r1.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0224, all -> 0x0215 }
            if (r2 <= 0) goto L_0x0206
            java.lang.String r2 = "sessions"
            r3 = r22
            r3.put(r2, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0224, all -> 0x0215 }
            goto L_0x0206
        L_0x0201:
            r14 = r1
            goto L_0x0215
        L_0x0203:
            r14 = r1
            goto L_0x0224
        L_0x0205:
            r14 = r1
        L_0x0206:
            r12.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0224, all -> 0x0215 }
            if (r14 == 0) goto L_0x0230
            r14.close()
            goto L_0x0230
        L_0x020f:
            r14 = r0
            goto L_0x0215
        L_0x0211:
            r14 = r0
            goto L_0x0224
        L_0x0213:
            r12 = r0
            r14 = r12
        L_0x0215:
            android.content.Context r1 = f14290d     // Catch:{ all -> 0x023d }
            com.umeng.analytics.pro.j.a((android.content.Context) r1)     // Catch:{ all -> 0x023d }
            if (r14 == 0) goto L_0x021f
            r14.close()
        L_0x021f:
            if (r12 == 0) goto L_0x0233
            goto L_0x0230
        L_0x0222:
            r12 = r0
            r14 = r12
        L_0x0224:
            android.content.Context r1 = f14290d     // Catch:{ all -> 0x023d }
            com.umeng.analytics.pro.j.a((android.content.Context) r1)     // Catch:{ all -> 0x023d }
            if (r14 == 0) goto L_0x022e
            r14.close()
        L_0x022e:
            if (r12 == 0) goto L_0x0233
        L_0x0230:
            r12.endTransaction()     // Catch:{ all -> 0x0233 }
        L_0x0233:
            android.content.Context r1 = f14290d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            return r0
        L_0x023d:
            r0 = move-exception
            if (r14 == 0) goto L_0x0243
            r14.close()
        L_0x0243:
            if (r12 == 0) goto L_0x0248
            r12.endTransaction()     // Catch:{ all -> 0x0248 }
        L_0x0248:
            android.content.Context r1 = f14290d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            goto L_0x0253
        L_0x0252:
            throw r0
        L_0x0253:
            goto L_0x0252
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        if (r0 == null) goto L_0x0069;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0057 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            r0.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            if (r7 == 0) goto L_0x0018
            if (r6 == 0) goto L_0x0053
            java.lang.String r6 = "delete from __is"
            r0.execSQL(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            goto L_0x0053
        L_0x0018:
            java.util.List<java.lang.String> r6 = r5.f14298l     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            int r6 = r6.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            r7 = 0
            if (r6 <= 0) goto L_0x004c
            r1 = 0
        L_0x0022:
            if (r7 >= r6) goto L_0x004b
            java.util.List<java.lang.String> r2 = r5.f14298l     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            if (r2 != 0) goto L_0x002f
            r1 = 1
        L_0x002f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            r3.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            java.lang.String r4 = "delete from __is where __ii=\""
            r3.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            r3.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            java.lang.String r2 = r3.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            r0.execSQL(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            int r7 = r7 + 1
            goto L_0x0022
        L_0x004b:
            r7 = r1
        L_0x004c:
            if (r7 == 0) goto L_0x0053
            java.lang.String r6 = "delete from __is where __ii is null"
            r0.execSQL(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
        L_0x0053:
            r0.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005f, all -> 0x0057 }
            goto L_0x0066
        L_0x0057:
            android.content.Context r6 = f14290d     // Catch:{ all -> 0x0073 }
            com.umeng.analytics.pro.j.a((android.content.Context) r6)     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0069
            goto L_0x0066
        L_0x005f:
            android.content.Context r6 = f14290d     // Catch:{ all -> 0x0073 }
            com.umeng.analytics.pro.j.a((android.content.Context) r6)     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0069
        L_0x0066:
            r0.endTransaction()     // Catch:{ all -> 0x0069 }
        L_0x0069:
            android.content.Context r6 = f14290d
            com.umeng.analytics.pro.i r6 = com.umeng.analytics.pro.i.a(r6)
            r6.b()
            return
        L_0x0073:
            r6 = move-exception
            if (r0 == 0) goto L_0x0079
            r0.endTransaction()     // Catch:{ all -> 0x0079 }
        L_0x0079:
            android.content.Context r7 = f14290d
            com.umeng.analytics.pro.i r7 = com.umeng.analytics.pro.i.a(r7)
            r7.b()
            goto L_0x0084
        L_0x0083:
            throw r6
        L_0x0084:
            goto L_0x0083
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(boolean, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0078, code lost:
        if (r0 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0064, code lost:
        if (r0 == null) goto L_0x0069;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = f14290d     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r0.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            if (r1 != 0) goto L_0x0060
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.append(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r0.execSQL(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.append(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r0.execSQL(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.util.List<java.lang.Integer> r1 = r3.f14296j     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.clear()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.append(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r1.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            java.lang.String r4 = r1.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            r0.execSQL(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
        L_0x0060:
            r0.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0073, all -> 0x0064 }
            goto L_0x0066
        L_0x0064:
            if (r0 == 0) goto L_0x0069
        L_0x0066:
            r0.endTransaction()     // Catch:{ all -> 0x0069 }
        L_0x0069:
            android.content.Context r4 = f14290d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            goto L_0x007b
        L_0x0073:
            android.content.Context r4 = f14290d     // Catch:{ all -> 0x007c }
            com.umeng.analytics.pro.j.a((android.content.Context) r4)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0069
            goto L_0x0066
        L_0x007b:
            return
        L_0x007c:
            r4 = move-exception
            if (r0 == 0) goto L_0x0082
            r0.endTransaction()     // Catch:{ all -> 0x0082 }
        L_0x0082:
            android.content.Context r5 = f14290d
            com.umeng.analytics.pro.i r5 = com.umeng.analytics.pro.i.a(r5)
            r5.b()
            goto L_0x008d
        L_0x008c:
            throw r4
        L_0x008d:
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(boolean, java.lang.String):void");
    }
}
