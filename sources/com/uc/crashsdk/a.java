package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.uc.crashsdk.a.b;
import com.uc.crashsdk.a.e;
import com.uc.crashsdk.a.f;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

public class a {
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    private static Runnable F = new e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    /* renamed from: a  reason: collision with root package name */
    public static String f13446a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f13447b = "";

    /* renamed from: c  reason: collision with root package name */
    static boolean f13448c = false;

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f13449d = true;

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, String> f13450e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private static final List<String> f13451f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private static String f13452g = "";

    /* renamed from: h  reason: collision with root package name */
    private static String f13453h = null;

    /* renamed from: i  reason: collision with root package name */
    private static int f13454i = -1;

    /* renamed from: j  reason: collision with root package name */
    private static long f13455j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static final HashMap<String, Object[]> f13456k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private static final List<String> f13457l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private static int f13458m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static int f13459n = 0;

    /* renamed from: o  reason: collision with root package name */
    private static int f13460o = 0;

    /* renamed from: p  reason: collision with root package name */
    private static int f13461p = 0;

    /* renamed from: q  reason: collision with root package name */
    private static final HashMap<String, Object[]> f13462q = new HashMap<>();

    /* renamed from: r  reason: collision with root package name */
    private static final List<String> f13463r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private static int f13464s = 0;

    /* renamed from: t  reason: collision with root package name */
    private static int f13465t = 0;

    /* renamed from: u  reason: collision with root package name */
    private static int f13466u = 0;

    /* renamed from: v  reason: collision with root package name */
    private static int f13467v = 0;

    /* renamed from: w  reason: collision with root package name */
    private static int f13468w = 0;

    /* renamed from: x  reason: collision with root package name */
    private static int f13469x = 0;

    /* renamed from: y  reason: collision with root package name */
    private static final SparseArray<Object[]> f13470y = new SparseArray<>();

    /* renamed from: z  reason: collision with root package name */
    private static final List<Integer> f13471z = new ArrayList();

    public static String a() {
        String str = f13453h;
        if (str != null) {
            return str;
        }
        return o() ? f13453h : "";
    }

    public static long b() {
        return f13455j;
    }

    public static int c() {
        if (f13454i == -1) {
            o();
        }
        return f13454i;
    }

    public static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (f13450e) {
            for (String next : f13451f) {
                String str = f13450e.get(next);
                sb.append(next);
                sb.append(": ");
                if (str != null) {
                    sb.append(str);
                }
                sb.append("\n");
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", new Object[]{e.n()}));
        b.a(b.h(), sb.toString());
    }

    public static void e() {
        if (f13449d || b.f13531d) {
            synchronized (f13450e) {
                for (String next : f13451f) {
                    JNIBridge.nativeAddHeaderInfo(next, f13450e.get(next));
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static byte[] f() {
        return new byte[]{Ascii.CAN, 99, 121, 60};
    }

    public static void g() {
        if (f13449d || b.f13531d) {
            synchronized (f13456k) {
                for (String next : f13457l) {
                    Object[] objArr = f13456k.get(next);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if ((1048833 & intValue) != 0) {
                        JNIBridge.nativeAddDumpFile(next, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), intValue, ((Boolean) objArr[4]).booleanValue());
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (f13456k) {
            boolean z10 = true;
            for (String next : f13457l) {
                if (LogType.isForJava(((Integer) f13456k.get(next)[0]).intValue())) {
                    if (!z10) {
                        sb.append("`");
                    }
                    sb.append(next);
                    z10 = false;
                }
            }
        }
        return sb.toString();
    }

    public static void i() {
        if (f13449d || b.f13531d) {
            synchronized (f13462q) {
                for (String next : f13463r) {
                    Object[] objArr = f13462q.get(next);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if ((1048833 & intValue) != 0) {
                        JNIBridge.nativeAddCallbackInfo(next, intValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static String j() {
        String sb;
        synchronized (f13462q) {
            StringBuilder sb2 = new StringBuilder();
            List<String> list = f13463r;
            synchronized (list) {
                boolean z10 = true;
                for (String next : list) {
                    if (LogType.isForJava(((Integer) f13462q.get(next)[0]).intValue())) {
                        if (!z10) {
                            sb2.append("`");
                        }
                        sb2.append(next);
                        z10 = false;
                    }
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static void k() {
        if (f13449d || b.f13531d) {
            synchronized (A) {
                for (String next : B) {
                    Object[] objArr = A.get(next);
                    int intValue = ((Integer) objArr[0]).intValue();
                    int intValue2 = ((Integer) objArr[1]).intValue();
                    List list = (List) objArr[2];
                    if ((1048577 & intValue2) != 0 && JNIBridge.nativeCreateCachedInfo(next, intValue, intValue2) != 0) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!JNIBridge.nativeAddCachedInfo(next, (String) it.next())) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z10 = true;
            for (String next : B) {
                if (LogType.isForJava(((Integer) A.get(next)[1]).intValue())) {
                    if (!z10) {
                        sb.append("`");
                    }
                    sb.append(next);
                    z10 = false;
                }
            }
        }
        return sb.toString();
    }

    public static String m() {
        if (!G) {
            String a10 = b.a(b.m());
            f13452g = a10;
            G = true;
            if (a10 == null) {
                f13452g = "";
            }
        }
        return f13452g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            f.a(0, (Runnable) new e(202));
        } else if (b.f13531d) {
            JNIBridge.set(128, f13452g);
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = g.a().getPackageManager().getPackageInfo(f13446a, 0);
            f13453h = packageInfo.versionName;
            f13455j = packageInfo.lastUpdateTime;
            f13454i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            g.b(th);
            return false;
        }
    }

    private static void p() {
        if (I || !e.a()) {
            return;
        }
        if (b.f13531d || !b.f13534g) {
            String format = String.format(Locale.US, "%s/%s/%s", new Object[]{g.U(), g.V(), g.W()});
            com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
            com.uc.crashsdk.a.a.b("crashsdk", "Version: " + format);
            com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
            I = true;
        }
    }

    private static StringBuilder b(String str, boolean z10) {
        String str2;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = f13462q.get(str);
            if (objArr == null) {
                str2 = "Unknown callback: " + str;
            } else {
                Callable callable = (Callable) objArr[1];
                if (callable != null) {
                    str2 = (String) callable.call();
                } else {
                    str2 = d.a(str, z10);
                }
            }
            if (str2 != null) {
                sb.append(str2);
            }
        } catch (Throwable th) {
            g.a(th);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th2) {
            g.a(th2);
        }
        return sb;
    }

    public static void a(String str, String str2) {
        Map<String, String> map = f13450e;
        synchronized (map) {
            if (!map.containsKey(str)) {
                f13451f.add(str);
            }
            map.put(str, str2);
            if (b.f13531d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.y();
        }
    }

    public static ArrayList<String> c(String str) {
        if (g.a(str)) {
            return null;
        }
        String[] split = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (!g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void a(OutputStream outputStream, String str) {
        synchronized (f13450e) {
            for (String next : f13451f) {
                try {
                    StringBuilder sb = new StringBuilder(11);
                    sb.append(next);
                    sb.append(": ");
                    String str2 = f13450e.get(next);
                    if (str2 != null) {
                        sb.append(str2);
                    }
                    sb.append("\n");
                    outputStream.write(sb.toString().getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
            }
        }
    }

    public static int b(String str, String str2) {
        int i10;
        int i11 = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            if (objArr != null) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= intValue) {
                    list.remove(0);
                }
                list.add(str2);
                if (LogType.isForJava(intValue2)) {
                    i11 = LogType.addType(0, 16);
                }
                if (!b.f13531d) {
                    if (LogType.isForNative(intValue2)) {
                        i11 = LogType.addType(i11, 1);
                    }
                    if (LogType.isForANR(intValue2)) {
                        i11 = LogType.addType(i11, LogType.ANR);
                    }
                }
                i10 = i11;
                i11 = intValue2;
            } else {
                i10 = 0;
            }
            if (b.f13531d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(i11)) {
                    i10 = LogType.addType(i10, 1);
                }
                if (LogType.isForANR(i11)) {
                    i10 = LogType.addType(i10, LogType.ANR);
                }
            }
        }
        return i10;
    }

    public static int a(String str, String str2, boolean z10, boolean z11, int i10, boolean z12) {
        int i11;
        int i12;
        boolean z13;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", (Throwable) null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = f13456k;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i12 = ((Integer) hashMap.get(str)[0]).intValue();
                i11 = LogType.addType(i12, i10);
            } else {
                i11 = i10;
                i12 = 0;
            }
            if (LogType.isForJava(i11) && !LogType.isForJava(i12)) {
                int i13 = f13458m;
                if (i13 >= 10) {
                    i11 = LogType.removeType(i11, 16);
                } else {
                    f13458m = i13 + 1;
                }
            }
            if (LogType.isForNative(i11) && !LogType.isForNative(i12)) {
                int i14 = f13459n;
                if (i14 >= 10) {
                    i11 = LogType.removeType(i11, 1);
                } else {
                    f13459n = i14 + 1;
                }
            }
            if (LogType.isForUnexp(i11) && !LogType.isForUnexp(i12)) {
                int i15 = f13460o;
                if (i15 >= 10) {
                    i11 = LogType.removeType(i11, 256);
                } else {
                    f13460o = i15 + 1;
                }
            }
            if (LogType.isForANR(i11) && !LogType.isForANR(i12)) {
                int i16 = f13461p;
                if (i16 >= 10) {
                    i11 = LogType.removeType(i11, LogType.ANR);
                } else {
                    f13461p = i16 + 1;
                }
            }
            if ((1048849 & i11) == 0) {
                z13 = false;
            } else {
                if (i12 == 0) {
                    f13457l.add(str);
                }
                z13 = true;
            }
            if (!z13) {
                return i11;
            }
            if (b.f13531d && (1048833 & i10) != 0) {
                int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z10, z11, i10, z12);
                if (!LogType.isForNative(nativeAddDumpFile)) {
                    i11 = LogType.removeType(i11, 1);
                }
                if (!LogType.isForUnexp(nativeAddDumpFile)) {
                    i11 = LogType.removeType(i11, 256);
                }
                if (!LogType.isForANR(nativeAddDumpFile)) {
                    i11 = LogType.removeType(i11, LogType.ANR);
                }
            }
            hashMap.put(str, new Object[]{Integer.valueOf(i11), str2, Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12)});
            return i11;
        }
    }

    public static void b(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        synchronized (A) {
            for (String next : B) {
                Object[] objArr = A.get(next);
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List<String> list = (List) objArr[2];
                if (arrayList == null) {
                    if (!LogType.isForJava(intValue2)) {
                    }
                } else if (!a((List<String>) arrayList, next)) {
                    continue;
                }
                try {
                    outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", new Object[]{next, Integer.valueOf(list.size()), Integer.valueOf(intValue)}).getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
                try {
                    for (String bytes : list) {
                        outputStream.write(bytes.getBytes(str));
                        outputStream.write("\n".getBytes(str));
                    }
                } catch (Throwable th2) {
                    e.a(th2, outputStream);
                }
                try {
                    outputStream.write("\n".getBytes(str));
                    outputStream.write(str2.getBytes(str));
                } catch (Throwable th3) {
                    e.a(th3, outputStream);
                }
            }
            if (arrayList != null && e.F()) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next2 = it.next();
                    if (!a(B, next2)) {
                        e.a(outputStream, "CUSTOMCACHEDINFO", next2);
                    }
                }
            }
        }
        return;
    }

    public static void a(OutputStream outputStream, String str, ArrayList<String> arrayList) {
        int i10;
        OutputStream outputStream2 = outputStream;
        ArrayList<String> arrayList2 = arrayList;
        boolean z10 = arrayList2 == null;
        boolean F2 = e.F();
        synchronized (f13456k) {
            int i11 = 0;
            for (String next : f13457l) {
                try {
                    Object[] objArr = f13456k.get(next);
                    if (arrayList2 == null) {
                        if (!LogType.isForJava(((Integer) objArr[0]).intValue())) {
                        }
                    } else if (!a((List<String>) arrayList2, next)) {
                    }
                    if (((Boolean) objArr[3]).booleanValue()) {
                        try {
                            outputStream2.write((next + "\n").getBytes(str));
                        } catch (Throwable th) {
                            th = th;
                        }
                    } else {
                        String str2 = str;
                    }
                    int i12 = i11 > 153600 ? 153600 : i11;
                    try {
                        int min = Math.min(20480, 153600 - i12);
                        boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                        String str3 = (String) objArr[1];
                        boolean booleanValue2 = ((Boolean) objArr[4]).booleanValue();
                        if (!F2 || str3.startsWith("/proc/")) {
                            if (booleanValue) {
                                i10 = e.a(outputStream2, str3, min);
                            } else {
                                i10 = e.b(outputStream2, str3, min);
                            }
                            i12 += i10;
                        } else {
                            e.a(outputStream, "FILE", str3, min, booleanValue, booleanValue2);
                        }
                        i11 = i12;
                        if (booleanValue2 && z10 && !F2) {
                            File file = new File(str3);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i11 = i12;
                        e.a(th, outputStream2);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    String str4 = str;
                    e.a(th, outputStream2);
                }
            }
            if (arrayList2 != null && F2) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next2 = it.next();
                    if (!a(f13457l, next2)) {
                        e.a(outputStream2, "CUSTOMDUMPFILE", next2);
                    }
                }
            }
        }
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            int intValue = ((Integer) objArr[0]).intValue();
            List<String> list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", new Object[]{str, Integer.valueOf(list.size()), Integer.valueOf(intValue)}));
            for (String append : list) {
                sb.append(append);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String a(String str) {
        HashMap<String, Object[]> hashMap = f13456k;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            if (objArr == null) {
                return null;
            }
            int i10 = 1;
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = (String) objArr[1];
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(booleanValue ? 1 : 0);
            if (!booleanValue2) {
                i10 = 0;
            }
            objArr2[3] = Integer.valueOf(i10);
            String format = String.format(locale, "%s%s%d%d", objArr2);
            return format;
        }
    }

    private static boolean a(List<String> list, String str) {
        if (g.a(str)) {
            return false;
        }
        for (String equals : list) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r16, int r17, java.util.concurrent.Callable<java.lang.String> r18, long r19, int r21) {
        /*
            r0 = r16
            r1 = r17
            r2 = r19
            r4 = 0
            if (r0 != 0) goto L_0x000a
            return r4
        L_0x000a:
            java.util.HashMap<java.lang.String, java.lang.Object[]> r5 = f13462q
            monitor-enter(r5)
            boolean r6 = r5.containsKey(r0)     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x0029
            java.lang.Object r6 = r5.get(r0)     // Catch:{ all -> 0x015a }
            java.lang.Object[] r6 = (java.lang.Object[]) r6     // Catch:{ all -> 0x015a }
            r6 = r6[r4]     // Catch:{ all -> 0x015a }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x015a }
            int r6 = r6.intValue()     // Catch:{ all -> 0x015a }
            int r7 = com.uc.crashsdk.export.LogType.addType(r6, r1)     // Catch:{ all -> 0x015a }
            if (r6 != r7) goto L_0x002b
            monitor-exit(r5)     // Catch:{ all -> 0x015a }
            return r6
        L_0x0029:
            r7 = r1
            r6 = 0
        L_0x002b:
            boolean r8 = com.uc.crashsdk.export.LogType.isForJava(r7)     // Catch:{ all -> 0x015a }
            r9 = 0
            r11 = 6
            r12 = 1
            if (r8 == 0) goto L_0x0063
            boolean r8 = com.uc.crashsdk.export.LogType.isForJava(r6)     // Catch:{ all -> 0x015a }
            if (r8 != 0) goto L_0x0063
            int r8 = f13464s     // Catch:{ all -> 0x015a }
            r13 = 8
            if (r8 < r13) goto L_0x0043
        L_0x0041:
            r8 = 1
            goto L_0x005b
        L_0x0043:
            int r13 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r13 == 0) goto L_0x0050
            int r13 = f13468w     // Catch:{ all -> 0x015a }
            if (r13 < r11) goto L_0x004c
            goto L_0x0041
        L_0x004c:
            int r13 = r13 + r12
            f13468w = r13     // Catch:{ all -> 0x015a }
            goto L_0x0057
        L_0x0050:
            int r13 = f13468w     // Catch:{ all -> 0x015a }
            int r13 = r8 - r13
            if (r13 < r11) goto L_0x0057
            goto L_0x0041
        L_0x0057:
            int r8 = r8 + r12
            f13464s = r8     // Catch:{ all -> 0x015a }
            r8 = 0
        L_0x005b:
            if (r8 == 0) goto L_0x0063
            r8 = 16
            int r7 = com.uc.crashsdk.export.LogType.removeType(r7, r8)     // Catch:{ all -> 0x015a }
        L_0x0063:
            boolean r8 = com.uc.crashsdk.export.LogType.isForNative(r7)     // Catch:{ all -> 0x015a }
            r13 = 4
            if (r8 == 0) goto L_0x009f
            boolean r8 = com.uc.crashsdk.export.LogType.isForNative(r6)     // Catch:{ all -> 0x015a }
            if (r8 != 0) goto L_0x009f
            int r8 = f13465t     // Catch:{ all -> 0x015a }
            if (r8 < r11) goto L_0x0078
        L_0x0074:
            r8 = 1
            r9 = 0
        L_0x0076:
            r10 = 0
            goto L_0x0098
        L_0x0078:
            int r14 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x008b
            int r9 = f13469x     // Catch:{ all -> 0x015a }
            if (r9 < r13) goto L_0x0081
            goto L_0x0074
        L_0x0081:
            int r9 = r9 + r12
            f13469x = r9     // Catch:{ all -> 0x015a }
            int r8 = r8 + r12
            f13465t = r8     // Catch:{ all -> 0x015a }
            r8 = 0
            r9 = 1
            r10 = 1
            goto L_0x0098
        L_0x008b:
            int r9 = f13469x     // Catch:{ all -> 0x015a }
            int r9 = r8 - r9
            if (r9 < r13) goto L_0x0092
            goto L_0x0074
        L_0x0092:
            int r8 = r8 + r12
            f13465t = r8     // Catch:{ all -> 0x015a }
            r8 = 0
            r9 = 1
            goto L_0x0076
        L_0x0098:
            if (r8 == 0) goto L_0x00a1
            int r7 = com.uc.crashsdk.export.LogType.removeType(r7, r12)     // Catch:{ all -> 0x015a }
            goto L_0x00a1
        L_0x009f:
            r9 = 0
            r10 = 0
        L_0x00a1:
            boolean r8 = com.uc.crashsdk.export.LogType.isForANR(r7)     // Catch:{ all -> 0x015a }
            r14 = 1048576(0x100000, float:1.469368E-39)
            if (r8 == 0) goto L_0x00bd
            boolean r8 = com.uc.crashsdk.export.LogType.isForANR(r6)     // Catch:{ all -> 0x015a }
            if (r8 != 0) goto L_0x00bd
            int r8 = f13467v     // Catch:{ all -> 0x015a }
            if (r8 < r11) goto L_0x00b8
            int r7 = com.uc.crashsdk.export.LogType.removeType(r7, r14)     // Catch:{ all -> 0x015a }
            goto L_0x00bd
        L_0x00b8:
            int r8 = r8 + r12
            f13467v = r8     // Catch:{ all -> 0x015a }
            r8 = 1
            goto L_0x00be
        L_0x00bd:
            r8 = 0
        L_0x00be:
            boolean r15 = com.uc.crashsdk.export.LogType.isForUnexp(r7)     // Catch:{ all -> 0x015a }
            r4 = 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L_0x00da
            boolean r15 = com.uc.crashsdk.export.LogType.isForUnexp(r6)     // Catch:{ all -> 0x015a }
            if (r15 != 0) goto L_0x00da
            int r15 = f13466u     // Catch:{ all -> 0x015a }
            if (r15 < r11) goto L_0x00d5
            int r7 = com.uc.crashsdk.export.LogType.removeType(r7, r4)     // Catch:{ all -> 0x015a }
            goto L_0x00da
        L_0x00d5:
            int r15 = r15 + r12
            f13466u = r15     // Catch:{ all -> 0x015a }
            r11 = 1
            goto L_0x00db
        L_0x00da:
            r11 = 0
        L_0x00db:
            r15 = 1048849(0x100111, float:1.46975E-39)
            r15 = r15 & r7
            if (r15 != 0) goto L_0x00e3
            r6 = 0
            goto L_0x00eb
        L_0x00e3:
            if (r6 != 0) goto L_0x00ea
            java.util.List<java.lang.String> r6 = f13463r     // Catch:{ all -> 0x015a }
            r6.add(r0)     // Catch:{ all -> 0x015a }
        L_0x00ea:
            r6 = 1
        L_0x00eb:
            if (r6 != 0) goto L_0x00ef
            monitor-exit(r5)     // Catch:{ all -> 0x015a }
            return r7
        L_0x00ef:
            boolean r6 = com.uc.crashsdk.b.f13531d     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x013a
            r6 = 1048833(0x100101, float:1.469728E-39)
            r6 = r6 & r1
            if (r6 == 0) goto L_0x013a
            r6 = r21
            int r1 = com.uc.crashsdk.JNIBridge.nativeAddCallbackInfo(r0, r1, r2, r6)     // Catch:{ all -> 0x015a }
            boolean r15 = com.uc.crashsdk.export.LogType.isForNative(r1)     // Catch:{ all -> 0x015a }
            if (r15 != 0) goto L_0x0117
            int r7 = com.uc.crashsdk.export.LogType.removeType(r7, r12)     // Catch:{ all -> 0x015a }
            if (r9 == 0) goto L_0x0110
            int r9 = f13465t     // Catch:{ all -> 0x015a }
            int r9 = r9 - r12
            f13465t = r9     // Catch:{ all -> 0x015a }
        L_0x0110:
            if (r10 == 0) goto L_0x0117
            int r9 = f13469x     // Catch:{ all -> 0x015a }
            int r9 = r9 - r12
            f13469x = r9     // Catch:{ all -> 0x015a }
        L_0x0117:
            boolean r9 = com.uc.crashsdk.export.LogType.isForANR(r1)     // Catch:{ all -> 0x015a }
            if (r9 != 0) goto L_0x0128
            int r7 = com.uc.crashsdk.export.LogType.removeType(r7, r14)     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x0128
            int r8 = f13467v     // Catch:{ all -> 0x015a }
            int r8 = r8 - r12
            f13467v = r8     // Catch:{ all -> 0x015a }
        L_0x0128:
            boolean r1 = com.uc.crashsdk.export.LogType.isForUnexp(r1)     // Catch:{ all -> 0x015a }
            if (r1 != 0) goto L_0x013c
            int r7 = com.uc.crashsdk.export.LogType.removeType(r7, r4)     // Catch:{ all -> 0x015a }
            if (r11 == 0) goto L_0x013c
            int r1 = f13466u     // Catch:{ all -> 0x015a }
            int r1 = r1 - r12
            f13466u = r1     // Catch:{ all -> 0x015a }
            goto L_0x013c
        L_0x013a:
            r6 = r21
        L_0x013c:
            java.lang.Object[] r1 = new java.lang.Object[r13]     // Catch:{ all -> 0x015a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x015a }
            r8 = 0
            r1[r8] = r4     // Catch:{ all -> 0x015a }
            r1[r12] = r18     // Catch:{ all -> 0x015a }
            java.lang.Long r2 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x015a }
            r3 = 2
            r1[r3] = r2     // Catch:{ all -> 0x015a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r21)     // Catch:{ all -> 0x015a }
            r3 = 3
            r1[r3] = r2     // Catch:{ all -> 0x015a }
            r5.put(r0, r1)     // Catch:{ all -> 0x015a }
            monitor-exit(r5)     // Catch:{ all -> 0x015a }
            return r7
        L_0x015a:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x015a }
            goto L_0x015e
        L_0x015d:
            throw r0
        L_0x015e:
            goto L_0x015d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long, int):int");
    }

    public static void a(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        String str3;
        synchronized (f13462q) {
            for (String next : f13463r) {
                try {
                    Object[] objArr = f13462q.get(next);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if (arrayList == null) {
                        if (!LogType.isForJava(intValue)) {
                        }
                    } else if (!a((List<String>) arrayList, next)) {
                    }
                    outputStream.write((next + "\n").getBytes(str));
                    long longValue = ((Long) objArr[2]).longValue();
                    if (longValue != 0) {
                        str3 = JNIBridge.nativeGetCallbackInfo(next, longValue, ((Integer) objArr[3]).intValue(), false);
                    } else {
                        str3 = b(next, false).toString();
                    }
                    if (str3 == null || str3.length() <= 0) {
                        outputStream.write("(data is null)\n".getBytes(str));
                    } else {
                        outputStream.write(str3.getBytes(str));
                    }
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
                try {
                    outputStream.write("\n".getBytes(str));
                    outputStream.write(str2.getBytes(str));
                } catch (Throwable th2) {
                    e.a(th2, outputStream);
                }
            }
            if (arrayList != null && e.F()) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next2 = it.next();
                    if (!a(f13463r, next2)) {
                        e.a(outputStream, "CUSTOMCALLBACKINFO", next2);
                    }
                }
            }
        }
        return;
    }

    public static String a(String str, boolean z10) {
        String str2;
        HashMap<String, Object[]> hashMap = f13462q;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            long longValue = ((Long) objArr[2]).longValue();
            if (longValue != 0) {
                str2 = JNIBridge.nativeGetCallbackInfo(str, longValue, ((Integer) objArr[3]).intValue(), z10);
            } else {
                str2 = b(str, z10).toString();
            }
        }
        return str2;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        SparseArray<Object[]> sparseArray = f13470y;
        synchronized (sparseArray) {
            int id = (int) thread.getId();
            if (sparseArray.get(id) == null) {
                f13471z.add(Integer.valueOf(id));
            }
            sparseArray.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ca A[Catch:{ all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d8 A[Catch:{ all -> 0x0100 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.OutputStream r13, java.lang.String r14, java.lang.String r15) {
        /*
            android.util.SparseArray<java.lang.Object[]> r0 = f13470y
            monitor-enter(r0)
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x011e }
            java.util.List<java.lang.Integer> r2 = f13471z     // Catch:{ all -> 0x011e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x011e }
        L_0x000d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x011e }
            if (r3 == 0) goto L_0x011c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x011e }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x011e }
            int r3 = r3.intValue()     // Catch:{ all -> 0x011e }
            r4 = 0
            r5 = 1
            r6 = 0
            android.util.SparseArray<java.lang.Object[]> r7 = f13470y     // Catch:{ all -> 0x0064 }
            java.lang.Object r7 = r7.get(r3)     // Catch:{ all -> 0x0064 }
            java.lang.Object[] r7 = (java.lang.Object[]) r7     // Catch:{ all -> 0x0064 }
            if (r7 != 0) goto L_0x002b
            goto L_0x000d
        L_0x002b:
            r8 = r7[r6]     // Catch:{ all -> 0x0064 }
            java.lang.ref.WeakReference r8 = (java.lang.ref.WeakReference) r8     // Catch:{ all -> 0x0064 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0064 }
            java.lang.Thread r8 = (java.lang.Thread) r8     // Catch:{ all -> 0x0064 }
            r7 = r7[r5]     // Catch:{ all -> 0x005f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x005f }
            if (r8 != 0) goto L_0x005c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            java.lang.String r9 = "Thread ("
            r4.<init>(r9)     // Catch:{ all -> 0x005a }
            r4.append(r7)     // Catch:{ all -> 0x005a }
            java.lang.String r9 = ", "
            r4.append(r9)     // Catch:{ all -> 0x005a }
            r4.append(r3)     // Catch:{ all -> 0x005a }
            java.lang.String r9 = ") has exited!"
            r4.append(r9)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005a }
            com.uc.crashsdk.a.a.b(r4)     // Catch:{ all -> 0x005a }
            goto L_0x000d
        L_0x005a:
            r4 = move-exception
            goto L_0x0068
        L_0x005c:
            if (r1 == r8) goto L_0x000d
            goto L_0x006b
        L_0x005f:
            r7 = move-exception
            r12 = r7
            r7 = r4
            r4 = r12
            goto L_0x0068
        L_0x0064:
            r7 = move-exception
            r8 = r4
            r4 = r7
            r7 = r8
        L_0x0068:
            com.uc.crashsdk.e.a((java.lang.Throwable) r4, (java.io.OutputStream) r13)     // Catch:{ all -> 0x011e }
        L_0x006b:
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ all -> 0x00bf }
            java.lang.String r9 = "Thread Name: '%s'\n"
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ all -> 0x00bf }
            r10[r6] = r7     // Catch:{ all -> 0x00bf }
            java.lang.String r7 = java.lang.String.format(r4, r9, r10)     // Catch:{ all -> 0x00bf }
            byte[] r7 = r7.getBytes(r14)     // Catch:{ all -> 0x00bf }
            r13.write(r7)     // Catch:{ all -> 0x00bf }
            boolean r7 = r8.isDaemon()     // Catch:{ all -> 0x00bf }
            if (r7 == 0) goto L_0x0087
            java.lang.String r7 = " daemon"
            goto L_0x0089
        L_0x0087:
            java.lang.String r7 = ""
        L_0x0089:
            java.lang.String r9 = "\"%s\"%s prio=%d tid=%d %s\n"
            r10 = 5
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x00bf }
            java.lang.String r11 = r8.getName()     // Catch:{ all -> 0x00bf }
            r10[r6] = r11     // Catch:{ all -> 0x00bf }
            r10[r5] = r7     // Catch:{ all -> 0x00bf }
            int r7 = r8.getPriority()     // Catch:{ all -> 0x00bf }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00bf }
            r11 = 2
            r10[r11] = r7     // Catch:{ all -> 0x00bf }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00bf }
            r7 = 3
            r10[r7] = r3     // Catch:{ all -> 0x00bf }
            java.lang.Thread$State r3 = r8.getState()     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00bf }
            r7 = 4
            r10[r7] = r3     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = java.lang.String.format(r4, r9, r10)     // Catch:{ all -> 0x00bf }
            byte[] r3 = r3.getBytes(r14)     // Catch:{ all -> 0x00bf }
            r13.write(r3)     // Catch:{ all -> 0x00bf }
            goto L_0x00c3
        L_0x00bf:
            r3 = move-exception
            com.uc.crashsdk.e.a((java.lang.Throwable) r3, (java.io.OutputStream) r13)     // Catch:{ all -> 0x011e }
        L_0x00c3:
            java.lang.StackTraceElement[] r3 = r8.getStackTrace()     // Catch:{ all -> 0x0100 }
            int r4 = r3.length     // Catch:{ all -> 0x0100 }
            if (r4 != 0) goto L_0x00d3
            java.lang.String r4 = "  (no stack frames)"
            byte[] r4 = r4.getBytes(r14)     // Catch:{ all -> 0x0100 }
            r13.write(r4)     // Catch:{ all -> 0x0100 }
        L_0x00d3:
            int r4 = r3.length     // Catch:{ all -> 0x0100 }
            r7 = 0
            r8 = 1
        L_0x00d6:
            if (r7 >= r4) goto L_0x0104
            r9 = r3[r7]     // Catch:{ all -> 0x0100 }
            if (r8 != 0) goto L_0x00e5
            java.lang.String r8 = "\n"
            byte[] r8 = r8.getBytes(r14)     // Catch:{ all -> 0x0100 }
            r13.write(r8)     // Catch:{ all -> 0x0100 }
        L_0x00e5:
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x0100 }
            java.lang.String r10 = "  at %s"
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ all -> 0x0100 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0100 }
            r11[r6] = r9     // Catch:{ all -> 0x0100 }
            java.lang.String r8 = java.lang.String.format(r8, r10, r11)     // Catch:{ all -> 0x0100 }
            byte[] r8 = r8.getBytes(r14)     // Catch:{ all -> 0x0100 }
            r13.write(r8)     // Catch:{ all -> 0x0100 }
            int r7 = r7 + 1
            r8 = 0
            goto L_0x00d6
        L_0x0100:
            r3 = move-exception
            com.uc.crashsdk.e.a((java.lang.Throwable) r3, (java.io.OutputStream) r13)     // Catch:{ all -> 0x011e }
        L_0x0104:
            java.lang.String r3 = "\n"
            byte[] r3 = r3.getBytes(r14)     // Catch:{ all -> 0x0116 }
            r13.write(r3)     // Catch:{ all -> 0x0116 }
            byte[] r3 = r15.getBytes(r14)     // Catch:{ all -> 0x0116 }
            r13.write(r3)     // Catch:{ all -> 0x0116 }
            goto L_0x000d
        L_0x0116:
            r3 = move-exception
            com.uc.crashsdk.e.a((java.lang.Throwable) r3, (java.io.OutputStream) r13)     // Catch:{ all -> 0x011e }
            goto L_0x000d
        L_0x011c:
            monitor-exit(r0)     // Catch:{ all -> 0x011e }
            return
        L_0x011e:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011e }
            goto L_0x0122
        L_0x0121:
            throw r13
        L_0x0122:
            goto L_0x0121
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    public static int a(String str, int i10, int i11) {
        int i12;
        int i13;
        boolean z10;
        if (str == null || i10 <= 0) {
            return 0;
        }
        if (i10 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", (Throwable) null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i13 = ((Integer) hashMap.get(str)[1]).intValue();
                i12 = LogType.addType(i13, i11);
            } else {
                i12 = i11;
                i13 = 0;
            }
            if (LogType.isForJava(i12) && !LogType.isForJava(i13)) {
                int i14 = C;
                if (i14 >= 8) {
                    i12 = LogType.removeType(i12, 16);
                } else {
                    C = i14 + 1;
                }
            }
            if (LogType.isForNative(i12) && !LogType.isForNative(i13)) {
                int i15 = D;
                if (i15 >= 8) {
                    i12 = LogType.removeType(i12, 1);
                } else {
                    D = i15 + 1;
                }
            }
            if (LogType.isForANR(i12) && !LogType.isForANR(i13)) {
                int i16 = E;
                if (i16 >= 8) {
                    i12 = LogType.removeType(i12, LogType.ANR);
                } else {
                    E = i16 + 1;
                }
            }
            if ((1048849 & i12) == 0) {
                z10 = false;
            } else {
                if (i13 == 0) {
                    B.add(str);
                }
                z10 = true;
            }
            if (!z10) {
                return i12;
            }
            if (b.f13531d && (i11 & 1048577) != 0) {
                int nativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i10, i12);
                if (!LogType.isForNative(nativeCreateCachedInfo)) {
                    i12 = LogType.removeType(i12, 1);
                }
                if (!LogType.isForANR(nativeCreateCachedInfo)) {
                    i12 = LogType.removeType(i12, LogType.ANR);
                }
            }
            hashMap.put(str, new Object[]{Integer.valueOf(i10), Integer.valueOf(i12), new ArrayList()});
            return i12;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r5, java.lang.String r6) {
        /*
            boolean r0 = com.uc.crashsdk.a.g.a((java.lang.String) r6)
            if (r0 == 0) goto L_0x000e
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            java.lang.String r6 = r6.getName()
        L_0x000e:
            boolean r0 = com.uc.crashsdk.export.LogType.isForNative(r5)
            if (r0 != 0) goto L_0x001a
            boolean r0 = com.uc.crashsdk.export.LogType.isForANR(r5)
            if (r0 == 0) goto L_0x0040
        L_0x001a:
            boolean r0 = com.uc.crashsdk.b.f13531d
            r1 = 0
            if (r0 == 0) goto L_0x0039
            android.util.SparseArray<java.lang.Object[]> r0 = f13470y
            monitor-enter(r0)
            r2 = 4
            long r3 = (long) r5
            com.uc.crashsdk.JNIBridge.nativeCmd(r2, r3, r6, r1)     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            boolean r0 = com.uc.crashsdk.export.LogType.isForNative(r5)
            boolean r1 = com.uc.crashsdk.export.LogType.isForANR(r5)
            if (r1 == 0) goto L_0x0041
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 | r1
            goto L_0x0041
        L_0x0036:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r5
        L_0x0039:
            java.lang.String r0 = "crashsdk so has not loaded!"
            java.lang.String r2 = "crashsdk"
            com.uc.crashsdk.a.a.a(r2, r0, r1)
        L_0x0040:
            r0 = 0
        L_0x0041:
            boolean r5 = com.uc.crashsdk.export.LogType.isForJava(r5)
            if (r5 == 0) goto L_0x0050
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            a((java.lang.String) r6, (java.lang.Thread) r5)
            r0 = r0 | 16
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(int, java.lang.String):int");
    }

    public static boolean a(boolean z10) {
        int i10;
        if (!b.f13530c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        } else if (e.F() || b.L()) {
            return false;
        } else {
            if (z10) {
                f.a(F);
                i10 = 0;
            } else if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            } else if (g.H() <= 0) {
                return false;
            } else {
                if (f.b(F)) {
                    return true;
                }
                i10 = g.H() * 1000;
            }
            f.a(0, F, (long) i10);
            return true;
        }
    }

    public static void a(int i10) {
        if (i10 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long currentTimeMillis = System.currentTimeMillis();
            if (b.f13531d && f13448c) {
                JNIBridge.nativeCmd(11, (long) g.H(), String.valueOf(g.I()), (Object[]) null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            a(false);
        } else if (i10 == 202) {
            p();
            Locale locale = Locale.US;
            String format = String.format(locale, "%s/%s/%s", new Object[]{g.U(), g.V(), g.W()});
            f13452g = m();
            if (b.f13531d) {
                JNIBridge.set(128, f13452g);
            }
            boolean z10 = !format.equals(f13452g);
            if (z10) {
                b.a(b.m(), format);
            }
            if (z10 && g.v()) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(locale, "Is new version ('%s' -> '%s'), deleting old stats data!", new Object[]{f13452g, format}));
                b.v();
            }
        } else if (!f13449d) {
            throw new AssertionError();
        }
    }
}
