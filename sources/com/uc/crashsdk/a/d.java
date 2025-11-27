package com.uc.crashsdk.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.common.base.Ascii;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.a;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import com.umeng.commonsdk.framework.UMModuleRegister;

public class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13477a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13478b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f13479c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static boolean f13480d = false;

    /* renamed from: e  reason: collision with root package name */
    private static String f13481e = "hsdk";

    /* renamed from: f  reason: collision with root package name */
    private static String f13482f = "alid ";

    /* renamed from: g  reason: collision with root package name */
    private static String f13483g;

    /* renamed from: h  reason: collision with root package name */
    private static final Object f13484h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private static String f13485i;

    public static void a() {
        f.a(0, new e(500), b.H() ? 900000 : 90000);
    }

    public static String b() {
        try {
            return "inv" + f13482f + "cras" + f13481e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    public static void c() {
        synchronized (f13484h) {
            f13485i = null;
        }
    }

    public static byte[] d() {
        return new byte[]{6, 0, Ascii.ETB, 8};
    }

    public static boolean e() {
        try {
            if (!e.F()) {
                if (!b.L()) {
                    a(true);
                    return f13478b;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    private static String f() {
        String str = f13485i;
        if (g.a(str)) {
            synchronized (f13484h) {
                String str2 = "https://errlog.umeng.com";
                if (g.S()) {
                    str2 = "https://errlogos.umeng.com";
                }
                str = g.a(b.j(), str2 + "/api/crashsdk/validate", true);
                f13485i = str;
            }
        }
        return str;
    }

    private static String g() {
        String str;
        byte[] bArr;
        String f10;
        byte[] a10;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, DispatchConstants.PLATFORM, g.e());
        a(sb, "pkgname", a.f13446a);
        a(sb, UMModuleRegister.PROCESS, e.h());
        a(sb, "version", a.a());
        a(sb, "cver", "3.3.2.2");
        a(sb, "ctag", "umeng");
        if (g.S()) {
            str = "true";
        } else {
            str = "false";
        }
        a(sb, "inter", str);
        a(sb, "os", "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        c.a(bArr3, 0, h.j());
        c.a(bArr3, 4, c.a());
        c.a(bArr3, 8, d());
        c.a(bArr3, 12, a.f());
        try {
            bArr = c.a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null || (f10 = f()) == null || (a10 = c.a(f10, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = c.a(a10, bArr3, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }

    public static void a(int i10) {
        if (i10 == 500) {
            synchronized (f13479c) {
                f13483g = null;
                a(!b.F());
                if (g.b(f13483g)) {
                    h.a(f13483g);
                }
            }
        } else if (!f13477a) {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(boolean r12) {
        /*
            boolean r0 = f13480d
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = r12 ^ 1
            f13480d = r0
            java.lang.String r0 = com.uc.crashsdk.a.f13447b
            java.lang.String r2 = "2.0"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x001d
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            boolean r0 = com.uc.crashsdk.b.c((int) r0)
            if (r0 == 0) goto L_0x001d
            return r1
        L_0x001d:
            boolean r0 = com.uc.crashsdk.b.A()
            if (r0 != 0) goto L_0x0024
            return r1
        L_0x0024:
            java.lang.String r0 = com.uc.crashsdk.b.n()
            java.lang.String r2 = com.uc.crashsdk.a.b.a(r0)
            boolean r3 = com.uc.crashsdk.a.g.b((java.lang.String) r2)
            r4 = 3
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = " "
            r7 = 4
            java.lang.String[] r2 = r2.split(r3, r7)
            int r3 = r2.length
            if (r3 != r4) goto L_0x004f
            r3 = r2[r1]
            r7 = r2[r6]
            long r7 = com.uc.crashsdk.a.g.c((java.lang.String) r7)
            r2 = r2[r5]
            long r9 = com.uc.crashsdk.a.g.c((java.lang.String) r2)
            int r2 = (int) r9
            goto L_0x0053
        L_0x004f:
            r3 = 0
            r7 = 0
            r2 = 0
        L_0x0053:
            f13478b = r6
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r7
            r7 = 259200000(0xf731400, double:1.280618154E-315)
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 >= 0) goto L_0x0080
            java.lang.String r7 = "o"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x006b
        L_0x0069:
            r7 = 0
            goto L_0x0081
        L_0x006b:
            java.lang.String r7 = "2"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0076
            f13478b = r1
            goto L_0x0069
        L_0x0076:
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0080
            f13478b = r1
        L_0x0080:
            r7 = 1
        L_0x0081:
            if (r7 == 0) goto L_0x0188
            if (r12 == 0) goto L_0x0087
            goto L_0x0188
        L_0x0087:
            int r12 = android.os.Process.myPid()
            if (r2 != r12) goto L_0x008e
            return r1
        L_0x008e:
            java.lang.String r12 = "per"
            f13483g = r12
            java.lang.String r12 = g()
            if (r12 == 0) goto L_0x017c
            java.lang.String r2 = "retcode="
            boolean r2 = r12.contains(r2)
            if (r2 == 0) goto L_0x017c
            java.lang.String r2 = "retcode=0"
            boolean r2 = r12.contains(r2)
            if (r2 == 0) goto L_0x00b1
            f13478b = r6
            java.lang.String r2 = "o"
            java.lang.String r3 = "aus"
            f13483g = r3
            goto L_0x00c8
        L_0x00b1:
            f13478b = r1
            java.lang.String r2 = "1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c2
            java.lang.String r2 = "2"
            java.lang.String r3 = "auf2"
            f13483g = r3
            goto L_0x00c8
        L_0x00c2:
            java.lang.String r2 = "1"
            java.lang.String r3 = "auf1"
            f13483g = r3
        L_0x00c8:
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r7 = "%s %d %d"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r2
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r4[r6] = r2
            int r2 = android.os.Process.myPid()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4[r5] = r2
            java.lang.String r2 = java.lang.String.format(r3, r7, r4)
            com.uc.crashsdk.a.b.a((java.lang.String) r0, (java.lang.String) r2)
            boolean r0 = com.uc.crashsdk.a.g.b((java.lang.String) r12)
            if (r0 == 0) goto L_0x017b
            java.lang.String r0 = "`"
            r2 = 30
            java.lang.String[] r12 = r12.split(r0, r2)
            int r0 = r12.length
            r2 = 0
        L_0x00fb:
            if (r2 >= r0) goto L_0x017b
            r3 = r12[r2]
            java.lang.String r4 = "="
            java.lang.String[] r3 = r3.split(r4, r5)
            int r4 = r3.length
            if (r4 != r5) goto L_0x0178
            r4 = r3[r1]
            java.lang.String r4 = r4.trim()
            r3 = r3[r6]
            java.lang.String r3 = r3.trim()
            boolean r7 = com.uc.crashsdk.a.g.b((java.lang.String) r3)
            if (r7 == 0) goto L_0x0124
            java.lang.String r7 = "http"
            boolean r7 = r3.startsWith(r7)
            if (r7 == 0) goto L_0x0124
            r7 = 1
            goto L_0x0125
        L_0x0124:
            r7 = 0
        L_0x0125:
            java.lang.String r8 = "logurl"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0133
            if (r7 == 0) goto L_0x0178
            com.uc.crashsdk.e.b((java.lang.String) r3)
            goto L_0x0178
        L_0x0133:
            java.lang.String r8 = "staturl"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0141
            if (r7 == 0) goto L_0x0178
            com.uc.crashsdk.a.h.b((java.lang.String) r3)
            goto L_0x0178
        L_0x0141:
            java.lang.String r8 = "policyurl"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x016d
            if (r7 == 0) goto L_0x0178
            java.lang.Object r4 = f13484h
            monitor-enter(r4)
            f13485i = r3     // Catch:{ all -> 0x016a }
            java.lang.String r7 = com.uc.crashsdk.b.j()     // Catch:{ all -> 0x016a }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x016a }
            r8.<init>()     // Catch:{ all -> 0x016a }
            r8.append(r3)     // Catch:{ all -> 0x016a }
            java.lang.String r3 = "\n"
            r8.append(r3)     // Catch:{ all -> 0x016a }
            java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x016a }
            com.uc.crashsdk.a.b.a((java.lang.String) r7, (java.lang.String) r3)     // Catch:{ all -> 0x016a }
            monitor-exit(r4)     // Catch:{ all -> 0x016a }
            goto L_0x0178
        L_0x016a:
            r12 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x016a }
            throw r12
        L_0x016d:
            java.lang.String r7 = "logpolicy"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0178
            com.uc.crashsdk.e.c((java.lang.String) r3)
        L_0x0178:
            int r2 = r2 + 1
            goto L_0x00fb
        L_0x017b:
            return r6
        L_0x017c:
            if (r12 != 0) goto L_0x0183
            java.lang.String r12 = "ner"
            f13483g = r12
            goto L_0x0187
        L_0x0183:
            java.lang.String r12 = "ser"
            f13483g = r12
        L_0x0187:
            return r1
        L_0x0188:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append(Operator.Operation.EQUALS);
        sb.append(str2);
        return sb;
    }
}
