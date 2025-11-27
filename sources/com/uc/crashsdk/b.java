package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.e;
import com.uc.crashsdk.a.f;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.a.h;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import org.android.agoo.common.AgooConstants;

public class b {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static final Object G = new Object();
    private static String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static RandomAccessFile M = null;
    private static boolean N = false;
    private static final Object O = new Object();
    private static String P = null;
    private static boolean Q = false;
    private static volatile Object[] R = null;
    private static Runnable S = new e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final Object V = new Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13526a = false;

    /* renamed from: aa  reason: collision with root package name */
    private static long f13527aa = 0;
    /* access modifiers changed from: private */

    /* renamed from: ab  reason: collision with root package name */
    public static final WeakHashMap<Activity, Integer> f13528ab = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public static boolean ac = false;
    /* access modifiers changed from: private */
    public static String ad = null;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static boolean ai = false;
    private static final Object aj = new Object();
    private static PendingIntent ak = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13529b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13530c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13531d = false;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f13532e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static boolean f13533f = false;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13534g = true;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f13535h = false;

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ boolean f13536i = true;

    /* renamed from: j  reason: collision with root package name */
    private static String f13537j = null;

    /* renamed from: k  reason: collision with root package name */
    private static String f13538k = null;

    /* renamed from: l  reason: collision with root package name */
    private static String f13539l = null;

    /* renamed from: m  reason: collision with root package name */
    private static String f13540m = null;

    /* renamed from: n  reason: collision with root package name */
    private static String f13541n = null;

    /* renamed from: o  reason: collision with root package name */
    private static String f13542o = null;

    /* renamed from: p  reason: collision with root package name */
    private static String f13543p = null;

    /* renamed from: q  reason: collision with root package name */
    private static String f13544q = null;

    /* renamed from: r  reason: collision with root package name */
    private static String f13545r = null;

    /* renamed from: s  reason: collision with root package name */
    private static String f13546s = null;

    /* renamed from: t  reason: collision with root package name */
    private static String f13547t = null;

    /* renamed from: u  reason: collision with root package name */
    private static String f13548u = null;

    /* renamed from: v  reason: collision with root package name */
    private static String f13549v = null;

    /* renamed from: w  reason: collision with root package name */
    private static String f13550w = null;

    /* renamed from: x  reason: collision with root package name */
    private static boolean f13551x = false;

    /* renamed from: y  reason: collision with root package name */
    private static boolean f13552y = false;

    /* renamed from: z  reason: collision with root package name */
    private static volatile boolean f13553z = false;

    public static boolean A() {
        if (Y || !ad()) {
            return true;
        }
        return false;
    }

    public static boolean B() {
        if (!Y || f13551x) {
            return false;
        }
        return true;
    }

    public static void C() {
        f.a(2, (Runnable) new e(100));
    }

    public static void D() {
        String str;
        if (f13531d && (str = ad) != null) {
            JNIBridge.set(129, str);
        }
    }

    public static String E() {
        String str = ad;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static boolean F() {
        boolean z10;
        if (!ae) {
            if (g.a(a.f13446a) || !a.f13446a.equals(e.h())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                af = true;
                if (f13531d) {
                    JNIBridge.set(2, true);
                }
            }
            ae = true;
        }
        return af;
    }

    public static void G() {
        ag = true;
        if (f13531d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return ag;
    }

    public static int I() {
        boolean U2 = U();
        if (t()) {
            if (U2) {
                return 3;
            }
            return 6;
        } else if (s()) {
            if (U2) {
                return 2;
            }
            return 5;
        } else if (U2) {
            return 4;
        } else {
            return 1;
        }
    }

    public static int J() {
        boolean V2 = V();
        boolean W2 = W();
        boolean X2 = X();
        if (t()) {
            if (V2) {
                return 12;
            }
            if (W2) {
                return 14;
            }
            if (X2) {
                return 16;
            }
            return 98;
        } else if (!s()) {
            return 1;
        } else {
            if (V2) {
                return 11;
            }
            if (W2) {
                return 13;
            }
            if (X2) {
                return 15;
            }
            return 97;
        }
    }

    public static void K() {
        if (f13531d) {
            JNIBridge.nativeSet(27, (long) I, AgooConstants.ACK_PACK_NULL, (Object[]) null);
            JNIBridge.set(30, L);
        }
    }

    public static boolean L() {
        if (!ai) {
            synchronized (aj) {
                if (!ai) {
                    ah = ae();
                    ai = true;
                }
            }
        }
        return ah;
    }

    public static void M() {
        if (!e.F() && !L() && ak == null && g.h() >= 0) {
            try {
                Context a10 = g.a();
                Intent launchIntentForPackage = a10.getPackageManager().getLaunchIntentForPackage(a10.getPackageName());
                launchIntentForPackage.addFlags(335544320);
                ak = PendingIntent.getActivity(a10, 0, launchIntentForPackage, 0);
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    public static boolean N() {
        if (ak == null) {
            a.b("Restart intent is null!");
            return false;
        }
        try {
            a.a("crashsdk", "restarting ...");
            ((AlarmManager) g.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, ak);
            return true;
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    private static String Q() {
        if (f13537j == null) {
            f13537j = d("ss");
        }
        return f13537j;
    }

    private static String R() {
        if (f13539l == null) {
            f13539l = d("ctn");
        }
        return f13539l;
    }

    private static String S() {
        if (f13540m == null) {
            f13540m = d("cta");
        }
        return f13540m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A[Catch:{ all -> 0x0075 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void T() {
        /*
            boolean r0 = f13553z
            if (r0 != 0) goto L_0x0080
            boolean r0 = f13552y
            if (r0 == 0) goto L_0x000a
            goto L_0x0080
        L_0x000a:
            java.lang.Object r0 = G
            monitor-enter(r0)
            boolean r1 = f13553z     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x0013:
            java.lang.String r1 = com.uc.crashsdk.g.X()     // Catch:{ all -> 0x007d }
            f(r1)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = p()     // Catch:{ all -> 0x007d }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x007d }
            java.lang.String r3 = b()     // Catch:{ all -> 0x007d }
            r2.<init>(r3)     // Catch:{ all -> 0x007d }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x007d }
            java.lang.String r4 = R()     // Catch:{ all -> 0x007d }
            r3.<init>(r4)     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "f"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x007d }
            A = r4     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "b"
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x007d }
            B = r1     // Catch:{ all -> 0x007d }
            boolean r1 = r2.exists()     // Catch:{ all -> 0x007d }
            D = r1     // Catch:{ all -> 0x007d }
            boolean r1 = r3.exists()     // Catch:{ all -> 0x007d }
            E = r1     // Catch:{ all -> 0x007d }
            boolean r2 = D     // Catch:{ all -> 0x007d }
            r3 = 1
            if (r2 != 0) goto L_0x0056
            if (r1 == 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r1 = 0
            goto L_0x0057
        L_0x0056:
            r1 = 1
        L_0x0057:
            C = r1     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x006b
            boolean r1 = A     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x0063
            boolean r1 = B     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x006b
        L_0x0063:
            boolean r1 = r()     // Catch:{ all -> 0x007d }
            F = r1     // Catch:{ all -> 0x007d }
            C = r1     // Catch:{ all -> 0x007d }
        L_0x006b:
            boolean r1 = z()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0079
            Z()     // Catch:{ all -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r1 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x007d }
        L_0x0079:
            f13553z = r3     // Catch:{ all -> 0x007d }
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x007d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            throw r1
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.b.T():void");
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    private static void Y() {
        if (f13531d) {
            JNIBridge.set(26, f13551x);
        }
    }

    private static void Z() {
        if (!T) {
            T = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                g.a(th);
            }
            try {
                new File(R()).delete();
            } catch (Throwable th2) {
                g.a(th2);
            }
            try {
                if (f13531d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(S()).delete();
                }
            } catch (Throwable th3) {
                g.a(th3);
            }
        }
        Object[] ab2 = ab();
        if (ab2[0].equals(P) || R != null) {
            Q = true;
            aa();
            return;
        }
        a(ab2);
    }

    public static String a() {
        String str = H;
        if (str != null) {
            return str;
        }
        String h10 = e.h();
        if (g.a(h10)) {
            H = "LLUN";
        } else {
            int i10 = 0;
            if (h10.length() > 48) {
                h10 = h10.substring(0, 48);
                i10 = h10.length() - 48;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = h10.getBytes();
            for (int length = bytes.length - 1; length >= 0; length--) {
                byte b10 = bytes[length];
                if (b10 == 46) {
                    sb.append('0');
                } else if (b10 == 58) {
                    sb.append('1');
                } else if (b10 >= 97 && b10 <= 122) {
                    sb.append((char) ((b10 + 65) - 97));
                } else if (b10 >= 65 && b10 <= 90) {
                    sb.append((char) b10);
                } else if (b10 < 48 || b10 > 57) {
                    sb.append('2');
                } else {
                    sb.append((char) b10);
                }
            }
            if (i10 > 0) {
                sb.append(String.valueOf(i10));
            }
            H = sb.toString();
        }
        return H;
    }

    private static void aa() {
        if (!f.b(S)) {
            f.a(1, S);
            return;
        }
        Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            f.a(S);
            f.a(1, S);
        }
    }

    private static Object[] ab() {
        synchronized (V) {
            long j10 = W + 1;
            W = j10;
            if (f13551x) {
                Object[] objArr = {"e", Long.valueOf(j10)};
                return objArr;
            } else if (B()) {
                Object[] objArr2 = {m7.f.f7907a, Long.valueOf(W)};
                return objArr2;
            } else {
                Object[] objArr3 = {c8.b.f11376b, Long.valueOf(W)};
                return objArr3;
            }
        }
    }

    private static Object ac() {
        Object a10;
        Object a11 = a((Object) (Application) g.a(), (Class<?>) Application.class, "mLoadedApk");
        if (a11 != null && (a10 = a(a11, (Class<?>) null, "mActivityThread")) != null) {
            return a10;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke((Object) null, new Object[0]);
            }
        } catch (Throwable th) {
            g.a(th);
        }
        return null;
    }

    private static boolean ad() {
        String a10 = g.a(new File("/proc/self/cgroup"), 512, false);
        if (g.a(a10)) {
            return false;
        }
        if (a10.contains("/bg_non_interactive") || a10.contains("/background")) {
            return true;
        }
        return false;
    }

    private static boolean ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            g.a(th);
        }
        int myUid = Process.myUid() % 100000;
        if (myUid < 99000 || myUid > 99999) {
            return false;
        }
        return true;
    }

    public static String b() {
        if (f13538k == null) {
            f13538k = d("ctj");
        }
        return f13538k;
    }

    private static String d(String str) {
        return g.X() + a() + "." + str;
    }

    private static File[] e(String str) {
        if (f13536i || str.length() > 0) {
            File[] listFiles = new File(g.X()).listFiles();
            if (listFiles == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                if (file.getPath().endsWith(str)) {
                    arrayList.add(file);
                }
            }
            return (File[]) arrayList.toArray(new File[arrayList.size()]);
        }
        throw new AssertionError();
    }

    public static File[] f() {
        return e(".stcb");
    }

    public static String g() {
        if (f13549v == null) {
            f13549v = d("bati");
        }
        return f13549v;
    }

    public static String h() {
        if (f13550w == null) {
            f13550w = d("hdr");
        }
        return f13550w;
    }

    public static String i() {
        if (f13544q == null) {
            f13544q = g.X() + com.umeng.analytics.pro.f.R;
        }
        return f13544q;
    }

    public static String j() {
        if (f13545r == null) {
            f13545r = g.X() + "authu";
        }
        return f13545r;
    }

    public static String k() {
        if (f13546s == null) {
            f13546s = g.X() + "statu";
        }
        return f13546s;
    }

    public static String l() {
        if (f13547t == null) {
            f13547t = g.X() + "poli";
        }
        return f13547t;
    }

    public static String m() {
        if (f13548u == null) {
            f13548u = g.X() + BrowserInfo.KEY_VER;
        }
        return f13548u;
    }

    public static String n() {
        return g.X() + "bvu";
    }

    public static String o() {
        return g.X() + "fds";
    }

    public static String p() {
        return g.a(new File(Q()), 8, false);
    }

    public static boolean q() {
        return f13552y;
    }

    public static boolean r() {
        boolean z10;
        if (!J) {
            if (f13531d) {
                if (JNIBridge.cmd(15) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                K = z10;
            } else {
                K = new File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    public static boolean s() {
        T();
        return A;
    }

    public static boolean t() {
        T();
        return B;
    }

    public static boolean u() {
        return f13551x;
    }

    public static void v() {
        boolean z10;
        f(g.X());
        f13552y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {com.umeng.analytics.pro.f.R, "authu", "statu", "poli"};
        File[] listFiles = new File(g.X()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int i10 = 0;
                while (true) {
                    if (i10 >= 7) {
                        z10 = false;
                        break;
                    } else if (name.endsWith(strArr[i10])) {
                        z10 = true;
                        break;
                    } else {
                        i10++;
                    }
                }
                if (!z10) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= 4) {
                            break;
                        } else if (name.equals(strArr2[i11])) {
                            z10 = true;
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z10) {
                    a.a("crashsdk", "delete file: " + file.getPath());
                    g.a(file);
                }
            }
        }
        Z();
    }

    public static void w() {
        if (!f13551x) {
            f13551x = true;
            if (!L() && !e.u()) {
                f(g.X());
                Y();
                Z();
            }
        }
    }

    public static boolean x() {
        return f(g.X());
    }

    public static boolean y() {
        return f(g.Y());
    }

    public static boolean z() {
        if (X || !ad()) {
            return true;
        }
        return false;
    }

    public static String c() {
        if (f13541n == null) {
            f13541n = d("st");
        }
        return f13541n;
    }

    public static File[] d() {
        return e(".st");
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        a.a("crashsdk", "Crash log directory was placed by a file!", (Throwable) null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static String b(String str) {
        return "debug.crs." + str;
    }

    public static void b(boolean z10) {
        if (!e.u()) {
            if (z10 && f13551x) {
                g.P();
                f13551x = false;
                Y();
            }
            boolean z11 = e.F() || L();
            long currentTimeMillis = System.currentTimeMillis();
            if (X && !Y && z10) {
                long j10 = f13527aa;
                if (j10 != 0 && !z11 && currentTimeMillis - j10 > 1800000) {
                    f.a(1, new e(104), 1000);
                }
            }
            f13527aa = currentTimeMillis;
            Y = z10;
            if (z10) {
                X = true;
            }
            if (f13531d) {
                JNIBridge.nativeSetForeground(z10);
            }
            if (!f13551x && !z11) {
                T();
                Z();
                if (z10) {
                    a.a(false);
                    if (!Z) {
                        e.B();
                        Z = true;
                    }
                }
                if (!N) {
                    aa();
                }
                e.c(z10);
            }
        }
    }

    public static boolean c(int i10) {
        return (i10 & I) != 0;
    }

    public static String e() {
        if (f13542o == null) {
            f13542o = d("stcb");
        }
        return f13542o;
    }

    public static String a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".st");
        if (f13536i || lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            if (substring.length() <= 0) {
                return null;
            }
            return substring + ".stcb";
        }
        throw new AssertionError();
    }

    public static void a(boolean z10) {
        L = z10;
        if (f13531d) {
            JNIBridge.set(30, z10);
        }
    }

    public static void b(int i10) {
        I = i10;
        K();
    }

    private static void a(Object[] objArr) {
        R = objArr;
        synchronized (O) {
            String str = objArr[0];
            long longValue = objArr[1].longValue();
            if (longValue < U) {
                a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", new Object[]{Long.valueOf(longValue), Long.valueOf(U)}));
                return;
            }
            U = longValue;
            String Q2 = Q();
            if (f13531d) {
                RandomAccessFile randomAccessFile = M;
                if (randomAccessFile != null) {
                    g.a((Closeable) randomAccessFile);
                    M = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(Q2, str, N);
                N = false;
                if (!nativeChangeState) {
                    a.b("write state failed: " + str);
                }
            } else {
                RandomAccessFile randomAccessFile2 = M;
                if (randomAccessFile2 == null || N) {
                    if (randomAccessFile2 != null) {
                        g.a((Closeable) randomAccessFile2);
                        M = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(Q2, "rw");
                        M = randomAccessFile3;
                        randomAccessFile3.seek(0);
                        N = false;
                    } catch (Exception e10) {
                        g.a((Throwable) e10);
                    }
                }
                try {
                    M.write(str.getBytes());
                    M.seek(0);
                } catch (Exception e11) {
                    g.a((Throwable) e11);
                }
            }
            P = str;
            R = null;
        }
    }

    public static void b(Context context) {
        long j10;
        boolean z10;
        a.a("Restart APP");
        if (context != null) {
            if (f13543p == null) {
                f13543p = d("rt");
            }
            File file = new File(f13543p);
            try {
                j10 = Long.parseLong(g.d(file));
            } catch (Throwable th) {
                g.a(th);
                j10 = -1;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (g.h() < 0 || (j10 > 0 && currentTimeMillis - j10 <= ((long) g.h()))) {
                z10 = false;
            } else {
                f(g.X());
                g.a(file, String.valueOf(currentTimeMillis));
                z10 = true;
            }
            a.a("lastTime: " + j10 + ", currentTime: " + currentTimeMillis + ", needRestart: " + z10);
            if (z10) {
                try {
                    d.a(true);
                } catch (Throwable th2) {
                    g.a(th2);
                }
                N();
            }
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (!g.M()) {
                return true;
            }
            C();
            return true;
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void a(int i10) {
        Object a10;
        Activity activity;
        int i11;
        boolean z10 = false;
        boolean z11 = true;
        switch (i10) {
            case 100:
                Object ac2 = ac();
                if (ac2 != null && (a10 = a(ac2, (Class<?>) null, "mActivities")) != null) {
                    try {
                        boolean z12 = false;
                        for (Map.Entry value : ((Map) a10).entrySet()) {
                            Object value2 = value.getValue();
                            if (!(value2 == null || (activity = (Activity) a(value2, (Class<?>) null, "activity")) == null)) {
                                boolean booleanValue = ((Boolean) a(value2, (Class<?>) null, "paused")).booleanValue();
                                boolean booleanValue2 = ((Boolean) a(value2, (Class<?>) null, "stopped")).booleanValue();
                                WeakHashMap<Activity, Integer> weakHashMap = f13528ab;
                                synchronized (weakHashMap) {
                                    if (booleanValue || booleanValue2) {
                                        i11 = 2;
                                    } else {
                                        i11 = 1;
                                        z12 = true;
                                    }
                                    weakHashMap.put(activity, Integer.valueOf(i11));
                                }
                            }
                            z10 = true;
                        }
                        if (z10) {
                            b(z12);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        g.a(th);
                        return;
                    }
                } else {
                    return;
                }
            case 101:
                try {
                    if (new File(Q()).exists()) {
                        z11 = false;
                    }
                    N = z11;
                    if (z11 || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    g.a(th2);
                    return;
                }
            case 102:
                f.a(1, (Runnable) new e(103));
                return;
            case 103:
                try {
                    g.a(new File(S()));
                    return;
                } catch (Throwable th3) {
                    g.a(th3);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (F()) {
                    e.C();
                    return;
                }
                return;
            default:
                if (!f13536i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            g.a(th);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.nio.channels.FileLock} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x006e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006f, code lost:
        r1 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0072, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        com.uc.crashsdk.a.g.a((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0084, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        com.uc.crashsdk.a.g.a((java.lang.Throwable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        com.uc.crashsdk.a.g.a((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006e A[ExcHandler: all (r6v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:43:0x0069] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0030=Splitter:B:17:0x0030, B:60:0x0088=Splitter:B:60:0x0088} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.Object r4, java.lang.String r5, com.uc.crashsdk.a.e r6) {
        /*
            monitor-enter(r4)
            boolean r0 = f13531d     // Catch:{ all -> 0x00a6 }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0041
            int r0 = com.uc.crashsdk.JNIBridge.nativeOpenFile(r5)     // Catch:{ all -> 0x00a6 }
            if (r0 >= 0) goto L_0x0022
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "Can not open file: "
            r6.<init>(r0)     // Catch:{ all -> 0x00a6 }
            r6.append(r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x00a6 }
            java.lang.String r6 = "crashsdk"
            com.uc.crashsdk.a.a.a(r6, r5, r1)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)     // Catch:{ all -> 0x00a6 }
            return r2
        L_0x0022:
            r5 = 1
            boolean r5 = com.uc.crashsdk.JNIBridge.nativeLockFile(r0, r5)     // Catch:{ all -> 0x003c }
            boolean r6 = r6.a()     // Catch:{ all -> 0x0035 }
            if (r5 == 0) goto L_0x0030
            com.uc.crashsdk.JNIBridge.nativeLockFile(r0, r2)     // Catch:{ all -> 0x003c }
        L_0x0030:
            com.uc.crashsdk.JNIBridge.nativeCloseFile(r0)     // Catch:{ all -> 0x00a6 }
            goto L_0x00a0
        L_0x0035:
            r6 = move-exception
            if (r5 == 0) goto L_0x003b
            com.uc.crashsdk.JNIBridge.nativeLockFile(r0, r2)     // Catch:{ all -> 0x003c }
        L_0x003b:
            throw r6     // Catch:{ all -> 0x003c }
        L_0x003c:
            r5 = move-exception
            com.uc.crashsdk.JNIBridge.nativeCloseFile(r0)     // Catch:{ all -> 0x00a6 }
            throw r5     // Catch:{ all -> 0x00a6 }
        L_0x0041:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00a6 }
            r0.<init>(r5)     // Catch:{ all -> 0x00a6 }
            boolean r5 = r0.exists()     // Catch:{ all -> 0x00a6 }
            if (r5 != 0) goto L_0x0054
            r0.createNewFile()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r5 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x00a6 }
        L_0x0054:
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0062 }
            java.lang.String r3 = "rw"
            r5.<init>(r0, r3)     // Catch:{ Exception -> 0x0062 }
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch:{ Exception -> 0x0062 }
            goto L_0x0067
        L_0x0060:
            r5 = move-exception
            goto L_0x00a2
        L_0x0062:
            r5 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r5)     // Catch:{ Exception -> 0x0098 }
            r5 = r1
        L_0x0067:
            if (r5 == 0) goto L_0x007a
            java.nio.channels.FileLock r1 = r5.lock()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            goto L_0x007a
        L_0x006e:
            r6 = move-exception
            r1 = r5
            r5 = r6
            goto L_0x00a2
        L_0x0072:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            goto L_0x007a
        L_0x0077:
            r6 = move-exception
            r1 = r5
            goto L_0x0099
        L_0x007a:
            boolean r2 = r6.a()     // Catch:{ all -> 0x008c }
            if (r1 == 0) goto L_0x0088
            r1.release()     // Catch:{ Exception -> 0x0084, all -> 0x006e }
            goto L_0x0088
        L_0x0084:
            r6 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r6)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
        L_0x0088:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)     // Catch:{ all -> 0x00a6 }
            goto L_0x009f
        L_0x008c:
            r6 = move-exception
            if (r1 == 0) goto L_0x0097
            r1.release()     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
        L_0x0097:
            throw r6     // Catch:{ Exception -> 0x0077, all -> 0x006e }
        L_0x0098:
            r6 = move-exception
        L_0x0099:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x0060 }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a6 }
        L_0x009f:
            r6 = r2
        L_0x00a0:
            monitor-exit(r4)     // Catch:{ all -> 0x00a6 }
            return r6
        L_0x00a2:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a6 }
            throw r5     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a6 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.b.a(java.lang.Object, java.lang.String, com.uc.crashsdk.a.e):boolean");
    }
}
