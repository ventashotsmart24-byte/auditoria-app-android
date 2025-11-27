package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import io.jsonwebtoken.Header;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13508a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f13509b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f13510c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private static int f13511d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, a> f13512e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f13513f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static final Object f13514g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private static final SparseArray<String> f13515h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    private static boolean f13516i = false;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f13517j = false;

    /* renamed from: k  reason: collision with root package name */
    private static final Object f13518k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private static String f13519l = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f13520a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f13521b = 0;

        /* renamed from: c  reason: collision with root package name */
        Map<String, String> f13522c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        private String f13523d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f13524e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13525f = false;

        public a(String str, boolean z10, boolean z11) {
            this.f13523d = str;
            this.f13524e = z10;
            this.f13525f = z11;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        public final void a(String str, String str2) {
            this.f13522c.put(str, str2);
        }

        public final String b(String str) {
            String a10 = a(str);
            if (a10 == null) {
                return "";
            }
            return a10;
        }

        public final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            HashMap hashMap = new HashMap();
            Map c10 = h.c(str);
            String str2 = null;
            long j10 = 0;
            int i10 = 0;
            for (String str3 : c10.keySet()) {
                String str4 = (String) c10.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.f13524e && str3.equals(f.R)) {
                    j10 = g.c(str4);
                } else if (!this.f13524e || !str3.equals("pid")) {
                    hashMap.put(str3, str4);
                } else {
                    i10 = (int) g.c(str4);
                }
            }
            String str5 = this.f13523d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.f13520a = j10;
            this.f13521b = i10;
            this.f13523d = str2;
            this.f13522c = hashMap;
            return true;
        }

        public final void a(String str, long j10) {
            long d10 = d(str) + j10;
            if (d10 <= 100) {
                j10 = 0;
                if (d10 >= 0) {
                    j10 = d10;
                }
            }
            a(str, String.valueOf(j10));
        }

        public final boolean a(a aVar) {
            if (!this.f13525f) {
                a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", new Object[]{this.f13523d}), (Throwable) null);
                return false;
            }
            for (String next : aVar.f13522c.keySet()) {
                if (next.startsWith("c_")) {
                    a(next, aVar.a(next));
                } else {
                    long d10 = aVar.d(next);
                    if (d10 == 0) {
                        a(next, aVar.a(next));
                    } else if (d10 < 100) {
                        a(next, d10);
                    }
                }
            }
            return true;
        }

        public final String a(String str) {
            return this.f13522c.get(str);
        }

        public final String a(boolean z10, boolean z11, boolean z12) {
            if (this.f13523d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z10) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.f13446a);
                h.b(sb, "rom", Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, Constants.KEY_MODEL, Build.MODEL);
                h.b(sb, com.umeng.ccg.a.f14528u, String.valueOf((long) Build.VERSION.SDK_INT));
                h.b(sb, bt.f13929w, e.e());
                h.b(sb, "hdw", e.f());
                long l10 = h.o();
                h.b(sb, "ram", String.valueOf(l10));
                h.b(sb, "aram", h.a(l10));
                h.b(sb, "cver", "3.3.2.2");
                h.b(sb, "cseq", "240515102041");
                h.b(sb, "ctag", "umeng");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, BrowserInfo.KEY_VER, g.U());
                h.b(sb, "sver", g.V());
                h.b(sb, "seq", g.W());
                h.b(sb, "grd", b.A() ? "fg" : "bg");
                h.b(sb, "os", "android");
                h.b(sb, "dn", e.q());
                String ac = g.ac();
                if (TextUtils.isEmpty(ac)) {
                    ac = e.q();
                }
                h.b(sb, "k_uid", ac);
                String ad = g.ad();
                if (!TextUtils.isEmpty(ad)) {
                    h.b(sb, "k_channel", ad);
                }
                sb.append("\n");
            }
            h.b(sb, "lt", this.f13523d);
            h.a(sb, (Map) this.f13522c);
            if (this.f13524e && !z11) {
                long j10 = this.f13520a;
                if (j10 != 0) {
                    h.b(sb, f.R, String.valueOf(j10));
                }
                if (z12) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(Process.myPid())}));
                } else {
                    int i10 = this.f13521b;
                    if (i10 != 0) {
                        h.b(sb, "pid", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(i10)}));
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    public static /* synthetic */ String a(long j10) {
        if (j10 < 524288) {
            return "512M";
        }
        return String.format(Locale.US, "%dG", new Object[]{Long.valueOf(((j10 / 1024) + 512) / 1024)});
    }

    /* access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(Operator.Operation.EQUALS);
        sb.append(str2);
        sb.append("`");
    }

    public static /* synthetic */ Map c(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] split = str2.split(Operator.Operation.EQUALS, 3);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static void d() {
        b(2, 2000);
        a(1, 70000);
    }

    public static boolean e() {
        return f13517j;
    }

    public static void f() {
        b(1, 2000);
    }

    public static void g() {
        b(3, 0);
    }

    public static void h() {
        b(4, 0);
    }

    public static void i() {
        if (g.R()) {
            f.a(1, (Runnable) new e(303));
        }
    }

    public static byte[] j() {
        return new byte[]{Ascii.DEL, 100, 110, Ascii.US};
    }

    public static void k() {
        synchronized (f13518k) {
            f13519l = null;
        }
    }

    private static String m() {
        return g.X() + "pv.wa";
    }

    private static String n() {
        return g.X() + "cdt.wa";
    }

    /* access modifiers changed from: private */
    public static long o() {
        Iterator<String> it = g.a(new File("/proc/meminfo"), 2).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e10) {
                    g.a((Throwable) e10);
                }
            }
        }
        return 0;
    }

    public static void b() {
        a(2, 0);
    }

    public static void c() {
        a(3, 0);
    }

    private static void b(int i10, long j10) {
        if (g.R()) {
            f.a(1, new e(301, new Object[]{Integer.valueOf(i10)}), j10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d2 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(java.lang.String r9, java.lang.String r10) {
        /*
            boolean r0 = com.uc.crashsdk.a.g.a((java.lang.String) r10)
            r1 = 1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            byte[] r10 = r10.getBytes()
            r0 = 16
            r2 = 8
            r3 = 0
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x003b }
            byte[] r4 = com.uc.crashsdk.a.c.a()     // Catch:{ all -> 0x003b }
            com.uc.crashsdk.a.c.a((byte[]) r0, (int) r3, (byte[]) r4)     // Catch:{ all -> 0x003b }
            byte[] r4 = j()     // Catch:{ all -> 0x003b }
            r5 = 4
            com.uc.crashsdk.a.c.a((byte[]) r0, (int) r5, (byte[]) r4)     // Catch:{ all -> 0x003b }
            byte[] r4 = com.uc.crashsdk.a.f()     // Catch:{ all -> 0x003b }
            com.uc.crashsdk.a.c.a((byte[]) r0, (int) r2, (byte[]) r4)     // Catch:{ all -> 0x003b }
            byte[] r4 = com.uc.crashsdk.a.d.d()     // Catch:{ all -> 0x003b }
            r5 = 12
            com.uc.crashsdk.a.c.a((byte[]) r0, (int) r5, (byte[]) r4)     // Catch:{ all -> 0x003b }
            byte[] r0 = com.uc.crashsdk.a.c.a((byte[]) r10, (byte[]) r0)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x003f
            r10 = r0
            r0 = 1
            goto L_0x0040
        L_0x003b:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r9 != 0) goto L_0x0044
            java.lang.String r9 = "unknown"
        L_0x0044:
            boolean r4 = com.uc.crashsdk.g.S()
            if (r4 == 0) goto L_0x004d
            java.lang.String r4 = "4ea4e41a3993"
            goto L_0x004f
        L_0x004d:
            java.lang.String r4 = "28ef1713347d"
        L_0x004f:
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r9)
            r6.append(r5)
            java.lang.String r7 = "AppChk#2014"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = com.uc.crashsdk.a.g.d((java.lang.String) r6)
            if (r6 != 0) goto L_0x0076
            r9 = 0
            goto L_0x00ba
        L_0x0076:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = com.uc.crashsdk.g.A()
            r7.append(r8)
            java.lang.String r8 = "?chk="
            r7.append(r8)
            int r8 = r6.length()
            int r8 = r8 - r2
            int r2 = r6.length()
            java.lang.String r2 = r6.substring(r8, r2)
            r7.append(r2)
            java.lang.String r2 = "&vno="
            r7.append(r2)
            r7.append(r5)
            java.lang.String r2 = "&uuid="
            r7.append(r2)
            r7.append(r9)
            java.lang.String r9 = "&app="
            r7.append(r9)
            r7.append(r4)
            if (r0 == 0) goto L_0x00b6
            java.lang.String r9 = "&enc=aes"
            r7.append(r9)
        L_0x00b6:
            java.lang.String r9 = r7.toString()
        L_0x00ba:
            if (r9 != 0) goto L_0x00bd
            return r3
        L_0x00bd:
            byte[] r9 = com.uc.crashsdk.a.c.a((java.lang.String) r9, (byte[]) r10)
            if (r9 != 0) goto L_0x00c4
            return r3
        L_0x00c4:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9)
            java.lang.String r9 = "retcode=0"
            boolean r9 = r10.contains(r9)
            if (r9 == 0) goto L_0x00d2
            return r1
        L_0x00d2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.c(java.lang.String, java.lang.String):boolean");
    }

    private static boolean d(String str) {
        boolean z10;
        File file = new File(str);
        Iterator<a> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            a next = it.next();
            String a10 = next.a("prc");
            if (!g.a(a10)) {
                Map<String, a> map = f13512e;
                a aVar = map.get(a10);
                if (aVar != null) {
                    aVar.a(next);
                } else {
                    map.put(a10, next);
                }
            }
        }
        Map<String, a> map2 = f13512e;
        StringBuilder a11 = a((Iterable<a>) map2.values(), true, false);
        if (g.ab()) {
            z10 = b(e.q(), a11.toString());
        } else {
            z10 = c(e.q(), a11.toString());
        }
        g.b(file);
        if (z10 || g.a(file, a((Iterable<a>) map2.values(), false, true).toString())) {
            map2.clear();
        }
        return true;
    }

    public static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    public static void a(String str) {
        synchronized (f13509b) {
            File file = new File(m());
            a aVar = new a(f.T, true, true);
            String c10 = g.c(file);
            if (!g.a(c10)) {
                aVar.c(c10);
            }
            aVar.a(str, 1);
            aVar.a("aujv", 1);
            g.a(file, aVar.a(false, false, false));
        }
    }

    public static boolean b(int i10, Object[] objArr) {
        switch (i10) {
            case 351:
                if (f13508a || objArr != null) {
                    String str = objArr[0];
                    int intValue = objArr[1].intValue();
                    if (intValue == 1) {
                        if (f13517j) {
                            return false;
                        }
                        f13517j = true;
                    }
                    if (!g.aa()) {
                        return false;
                    }
                    File file = new File(str);
                    ArrayList<a> a10 = a(file, "crp", 100);
                    if (intValue != 4) {
                        a aVar = new a("crp", false, false);
                        String str2 = "1";
                        if (intValue == 1) {
                            aVar.a("et", String.valueOf(b.I()));
                            aVar.a("ete", String.valueOf(b.J()));
                        } else if (intValue == 3) {
                            aVar.a("et", str2);
                            aVar.a("ete", str2);
                        } else if (intValue == 2) {
                            aVar.a("hpv", str2);
                        }
                        aVar.a("prc", e.h());
                        if (!b.F()) {
                            str2 = "0";
                        }
                        aVar.a(bd.f13843c, str2);
                        a(aVar);
                        a10.add(0, aVar);
                    }
                    if (!a10.isEmpty()) {
                        boolean c10 = c(e.q(), a((Iterable<a>) a10, true, false).toString());
                        g.b(file);
                        if (!c10) {
                            g.a(file, a((Iterable<a>) a10, false, true).toString());
                        }
                    }
                    return true;
                }
                throw new AssertionError();
            case 352:
                if (f13508a || objArr != null) {
                    return d(objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (f13508a || objArr != null) {
                    return b(objArr[0], objArr[1], objArr[2].booleanValue(), objArr[3].booleanValue());
                }
                throw new AssertionError();
            case 354:
                if (f13508a || objArr != null) {
                    File file2 = new File(objArr[0]);
                    boolean c11 = c(e.q(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                    if (c11) {
                        g.b(file2);
                    }
                    return c11;
                }
                throw new AssertionError();
            default:
                return false;
        }
    }

    public static void a() {
        a(0, b.H() ? 700000 : 70000);
    }

    private static void a(int i10, long j10) {
        if (b.F()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i10)}), j10);
        }
    }

    public static boolean a(String str, String str2) {
        String str3;
        try {
            String str4 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", Operator.Operation.MINUS);
            if (g.a(str2)) {
                str3 = "";
            } else {
                str3 = str2.replaceAll("[`=]", Operator.Operation.MINUS);
            }
            Map<String, String> map = f13510c;
            synchronized (map) {
                if (map.get(str4) == null) {
                    int i10 = f13511d;
                    if (i10 >= 20) {
                        return false;
                    }
                    f13511d = i10 + 1;
                }
                map.put(str4, str3);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void b(boolean z10) {
        if (!a(z10, "crash detail upload")) {
            String str = g.X() + "dt.wa";
            b.a(f13513f, str, new e(352, new Object[]{str}));
            String n10 = n();
            b.a(f13514g, n10, new e(354, new Object[]{n10}));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b1 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(java.lang.String r8, java.lang.String r9) {
        /*
            boolean r0 = com.uc.crashsdk.a.g.a((java.lang.String) r9)
            r1 = 1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            byte[] r9 = r9.getBytes()
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = com.uc.crashsdk.g.e()
            r0.append(r4)
            r0.append(r8)
            r0.append(r2)
            java.lang.String r4 = "AppChk#2014"
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.uc.crashsdk.a.g.d((java.lang.String) r0)
            r4 = 0
            int r5 = r0.length()     // Catch:{ all -> 0x004b }
            int r5 = r5 + -16
            int r6 = r0.length()     // Catch:{ all -> 0x004b }
            java.lang.String r5 = r0.substring(r5, r6)     // Catch:{ all -> 0x004b }
            byte[] r5 = r5.getBytes()     // Catch:{ all -> 0x004b }
            byte[] r5 = com.uc.crashsdk.a.c.a((byte[]) r9, (byte[]) r5)     // Catch:{ all -> 0x004b }
            if (r5 == 0) goto L_0x004f
            r9 = r5
            r5 = 1
            goto L_0x0050
        L_0x004b:
            r5 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r5)
        L_0x004f:
            r5 = 0
        L_0x0050:
            int r6 = r0.length()
            int r6 = r6 + -8
            int r7 = r0.length()
            java.lang.String r0 = r0.substring(r6, r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = com.uc.crashsdk.g.A()
            r6.append(r7)
            java.lang.String r7 = "/api/v1/crashtrack/upload?chk="
            r6.append(r7)
            r6.append(r0)
            java.lang.String r0 = "&vno="
            r6.append(r0)
            r6.append(r2)
            java.lang.String r0 = "&uuid="
            r6.append(r0)
            r6.append(r8)
            java.lang.String r8 = "&app="
            r6.append(r8)
            java.lang.String r8 = com.uc.crashsdk.g.e()
            r6.append(r8)
            if (r5 == 0) goto L_0x0095
            java.lang.String r8 = "&enc=aes"
            r6.append(r8)
        L_0x0095:
            java.lang.String r8 = r6.toString()
            if (r8 != 0) goto L_0x009c
            return r4
        L_0x009c:
            byte[] r8 = com.uc.crashsdk.a.c.a((java.lang.String) r8, (byte[]) r9)
            if (r8 != 0) goto L_0x00a3
            return r4
        L_0x00a3:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r8)
            java.lang.String r8 = "retcode=0"
            boolean r8 = r9.contains(r8)
            if (r8 == 0) goto L_0x00b1
            return r1
        L_0x00b1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.b(java.lang.String, java.lang.String):boolean");
    }

    private static void a(a aVar) {
        Map<String, String> map = f13510c;
        synchronized (map) {
            for (String next : map.keySet()) {
                aVar.a(next, f13510c.get(next));
            }
        }
    }

    public static void a(boolean z10) {
        a(1, z10);
    }

    public static boolean a(boolean z10, String str) {
        if (!b.f13531d || z10 || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    private static boolean b(String str, String str2, boolean z10, boolean z11) {
        a aVar;
        File file = new File(n());
        ArrayList<a> a10 = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = a10.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b(Header.TYPE))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a(Header.TYPE, str2);
            a(aVar);
            a10.add(aVar);
        }
        aVar.a("cnt", 1);
        if (z10) {
            aVar.a("lim", 1);
        }
        if (z11) {
            aVar.a("syu", 1);
        }
        return g.a(file, a((Iterable<a>) a10, false, false).toString());
    }

    private static void a(int i10, boolean z10) {
        if (!a(z10, "crash rate")) {
            String str = g.X() + "cr.wa";
            b.a(f13509b, str, new e(351, new Object[]{str, Integer.valueOf(i10)}));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
        if (r3 == false) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r9, java.lang.Object[] r10) {
        /*
            r0 = 0
            switch(r9) {
                case 301: goto L_0x00ce;
                case 302: goto L_0x000d;
                case 303: goto L_0x0009;
                default: goto L_0x0004;
            }
        L_0x0004:
            boolean r9 = f13508a
            if (r9 == 0) goto L_0x00e7
            return
        L_0x0009:
            b((boolean) r0)
            return
        L_0x000d:
            boolean r9 = f13508a
            if (r9 != 0) goto L_0x001a
            if (r10 == 0) goto L_0x0014
            goto L_0x001a
        L_0x0014:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x001a:
            java.lang.Object r9 = f13509b
            monitor-enter(r9)
            r10 = r10[r0]     // Catch:{ all -> 0x00cb }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x00cb }
            int r10 = r10.intValue()     // Catch:{ all -> 0x00cb }
            r1 = 1
            if (r10 != 0) goto L_0x002e
            boolean r2 = f13516i     // Catch:{ all -> 0x00cb }
            if (r2 != 0) goto L_0x00c9
            f13516i = r1     // Catch:{ all -> 0x00cb }
        L_0x002e:
            java.lang.String r2 = com.uc.crashsdk.a.f13447b     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = "2.0"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00cb }
            if (r2 == 0) goto L_0x0040
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            boolean r2 = com.uc.crashsdk.b.c((int) r2)     // Catch:{ all -> 0x00cb }
            if (r2 != 0) goto L_0x00c9
        L_0x0040:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = m()     // Catch:{ all -> 0x00cb }
            r2.<init>(r3)     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = com.uc.crashsdk.a.g.c((java.io.File) r2)     // Catch:{ all -> 0x00cb }
            com.uc.crashsdk.a.h$a r4 = new com.uc.crashsdk.a.h$a     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = "pv"
            r4.<init>(r5, r1, r1)     // Catch:{ all -> 0x00cb }
            boolean r5 = com.uc.crashsdk.a.g.a((java.lang.String) r3)     // Catch:{ all -> 0x00cb }
            if (r5 != 0) goto L_0x005d
            r4.c(r3)     // Catch:{ all -> 0x00cb }
        L_0x005d:
            if (r10 != 0) goto L_0x006c
            int r3 = r4.f13521b     // Catch:{ all -> 0x00cb }
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x00cb }
            if (r3 != r5) goto L_0x0069
            r3 = 1
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            if (r3 != 0) goto L_0x00c9
        L_0x006c:
            r5 = 1
            if (r10 != 0) goto L_0x007b
            java.lang.String r10 = "pv"
            r4.a((java.lang.String) r10, (long) r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r10 = "fjv"
        L_0x0077:
            r4.a((java.lang.String) r10, (long) r5)     // Catch:{ all -> 0x00cb }
            goto L_0x008b
        L_0x007b:
            if (r10 != r1) goto L_0x0080
            java.lang.String r10 = "hpv"
            goto L_0x0077
        L_0x0080:
            r3 = 2
            if (r10 != r3) goto L_0x008b
            java.lang.String r10 = "pv"
            r4.a((java.lang.String) r10, (long) r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r10 = "npv"
            goto L_0x0077
        L_0x008b:
            java.lang.String r10 = com.uc.crashsdk.e.q()     // Catch:{ all -> 0x00cb }
            long r5 = r4.f13520a     // Catch:{ all -> 0x00cb }
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x00a5
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cb }
            long r7 = r7 - r5
            r5 = 28800000(0x1b77400, double:1.42290906E-316)
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x00a5
            r10 = 0
            goto L_0x00ad
        L_0x00a5:
            java.lang.String r3 = r4.a(r1, r1, r0)     // Catch:{ all -> 0x00cb }
            boolean r10 = c(r10, r3)     // Catch:{ all -> 0x00cb }
        L_0x00ad:
            if (r10 == 0) goto L_0x00c2
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x00cb }
            r10.<init>()     // Catch:{ all -> 0x00cb }
            r4.f13522c = r10     // Catch:{ all -> 0x00cb }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cb }
            r4.f13520a = r5     // Catch:{ all -> 0x00cb }
            int r10 = android.os.Process.myPid()     // Catch:{ all -> 0x00cb }
            r4.f13521b = r10     // Catch:{ all -> 0x00cb }
        L_0x00c2:
            java.lang.String r10 = r4.a(r0, r0, r1)     // Catch:{ all -> 0x00cb }
            com.uc.crashsdk.a.g.a((java.io.File) r2, (java.lang.String) r10)     // Catch:{ all -> 0x00cb }
        L_0x00c9:
            monitor-exit(r9)     // Catch:{ all -> 0x00cb }
            return
        L_0x00cb:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00cb }
            throw r10
        L_0x00ce:
            boolean r9 = f13508a
            if (r9 != 0) goto L_0x00db
            if (r10 == 0) goto L_0x00d5
            goto L_0x00db
        L_0x00d5:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x00db:
            r9 = r10[r0]
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            a((int) r9, (boolean) r0)
            return
        L_0x00e7:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            goto L_0x00ee
        L_0x00ed:
            throw r9
        L_0x00ee:
            goto L_0x00ed
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.a(int, java.lang.Object[]):void");
    }

    public static void b(String str) {
        synchronized (f13518k) {
            f13519l = str;
            String k10 = b.k();
            b.a(k10, str + "\n");
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z10, boolean z11) {
        StringBuilder sb = new StringBuilder();
        boolean z12 = true;
        for (a next : iterable) {
            if (z12) {
                sb.append(next.a(z10, z10, z11));
                z12 = false;
            } else {
                sb.append(next.a(false, z10, z11));
            }
        }
        return sb;
    }

    public static void a(String str, int i10, int i11) {
        if (g.R()) {
            synchronized (f13513f) {
                Map<String, a> map = f13512e;
                a aVar = map.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    map.put(str, aVar);
                    a(aVar);
                }
                SparseArray<String> sparseArray = f13515h;
                synchronized (sparseArray) {
                    if (sparseArray.size() == 0) {
                        a(100, f.T);
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = sparseArray.get(i10);
                if (str2 == null) {
                    a.a("crashsdk", "map key is not set with: " + i10, (Throwable) null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i11));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z10, boolean z11) {
        if (!g.R()) {
            return false;
        }
        String n10 = n();
        return b.a(f13514g, n10, new e(353, new Object[]{str, str2, Boolean.valueOf(z10), Boolean.valueOf(z11)}));
    }

    private static void a(int i10, String str) {
        f13515h.put(i10, str);
    }

    private static ArrayList<a> a(File file, String str, int i10) {
        ArrayList<String> a10 = g.a(file, i10);
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String> it = a10.iterator();
        while (it.hasNext()) {
            a aVar = new a(str, false, false);
            if (aVar.c(it.next())) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
