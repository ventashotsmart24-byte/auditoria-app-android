package com.uc.crashsdk;

import android.util.SparseArray;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.e;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.CrashStatKey;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13607a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f13608b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<String> f13609c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f13610d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static boolean f13611e = false;

    public static void a(int i10) {
        a(i10, 1);
    }

    private static boolean b(int i10, int i11) {
        try {
            b.x();
        } catch (Throwable th) {
            g.a(th);
        }
        try {
            String c10 = c(i10);
            if (c10 == null) {
                a.a("crashsdk", "Stat type not exists: " + i10, (Throwable) null);
                return false;
            }
            File file = new File(b.c());
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuffer a10 = a(file);
            if (g.a(a10)) {
                if (a10 == null) {
                    a10 = new StringBuffer();
                }
                a10.append("[");
                a10.append(e.h());
                a10.append("]\n");
            }
            a(a10, c10, a(a10, c10) + i11);
            return a(file, a10);
        } catch (Throwable th2) {
            g.a(th2);
            return false;
        }
    }

    private static boolean c(String str) {
        if (g.a(str) || !new File(str).exists()) {
            return false;
        }
        return a(str, new e(755, new Object[]{str}));
    }

    private static boolean d(String str) {
        if (f13607a || str != null) {
            File file = new File(str);
            StringBuffer a10 = a(file);
            if (g.a(a10)) {
                return false;
            }
            String a11 = a(a10);
            StringBuffer stringBuffer = null;
            if (a11 == null || a11.length() <= 0) {
                a.a("crashsdk", "notifyStatsDetailImpl: process name is invalid", (Throwable) null);
                return false;
            }
            SparseArray<String> e10 = e();
            boolean P = g.P();
            if (P) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("notifyStatsDetailImpl: processName: ");
                stringBuffer.append(a11 + "\n");
            }
            int i10 = 0;
            boolean z10 = false;
            while (i10 < e10.size()) {
                try {
                    int keyAt = e10.keyAt(i10);
                    String str2 = e10.get(keyAt);
                    int a12 = a(a10, str2);
                    if (a12 > 0) {
                        if (P) {
                            stringBuffer.append("name: ");
                            stringBuffer.append(str2);
                            stringBuffer.append(", key: ");
                            stringBuffer.append(keyAt);
                            stringBuffer.append(", count: ");
                            stringBuffer.append(a12);
                            stringBuffer.append("\n");
                        }
                        d.a(a11, keyAt, a12);
                        a(a10, str2, 0);
                        z10 = true;
                    }
                    i10++;
                } finally {
                    if (z10) {
                        a(file, a10);
                    }
                }
            }
            if (P) {
                a.a(stringBuffer.toString());
            }
            if (z10) {
                d.a(a11, (int) CrashStatKey.STATS_REPORT_FINISHED, 0);
            }
            return z10;
        }
        throw new AssertionError();
    }

    private static boolean e(String str) {
        if (g.a(str) || !new File(str).exists()) {
            return false;
        }
        return a(str, new e(756, new Object[]{str}));
    }

    private static void f() {
        SparseArray<String> sparseArray = f13609c;
        synchronized (sparseArray) {
            if (sparseArray.size() == 0) {
                sparseArray.put(100, "start_pv");
                sparseArray.put(102, "start_hpv");
                sparseArray.put(1, "all_all");
                sparseArray.put(2, "all_fg");
                sparseArray.put(101, "all_bg");
                sparseArray.put(3, "java_fg");
                sparseArray.put(4, "java_bg");
                sparseArray.put(7, "native_fg");
                sparseArray.put(8, "native_bg");
                sparseArray.put(27, "native_anr_fg");
                sparseArray.put(28, "native_anr_bg");
                sparseArray.put(9, "native_ok");
                sparseArray.put(10, "unexp_anr");
                sparseArray.put(29, "unexp_lowmem");
                sparseArray.put(30, "unexp_killed");
                sparseArray.put(31, "unexp_exit");
                sparseArray.put(32, "unexp_restart");
                sparseArray.put(11, "unexp_fg");
                sparseArray.put(12, "unexp_bg");
                sparseArray.put(40, "anr_fg");
                sparseArray.put(41, "anr_bg");
                sparseArray.put(42, "anr_cr_fg");
                sparseArray.put(43, "anr_cr_bg");
                sparseArray.put(13, "log_up_succ");
                sparseArray.put(14, "log_up_fail");
                sparseArray.put(15, "log_empty");
                sparseArray.put(200, "log_tmp");
                sparseArray.put(16, "log_abd_all");
                sparseArray.put(22, "log_abd_builtin");
                sparseArray.put(23, "log_abd_custom");
                sparseArray.put(17, "log_large");
                sparseArray.put(18, "log_up_all");
                sparseArray.put(19, "log_up_bytes");
                sparseArray.put(20, "log_up_crash");
                sparseArray.put(21, "log_up_custom");
                sparseArray.put(24, "log_zipped");
                sparseArray.put(201, "log_enced");
                sparseArray.put(25, "log_renamed");
                sparseArray.put(26, "log_safe_skip");
            }
        }
    }

    public static void a(int i10, int i11) {
        if (i11 == 0) {
            a.b("Add stat for type " + i10 + " with count 0!");
            return;
        }
        a(b.c(), new e(751, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    private static String c(int i10) {
        String str;
        f();
        SparseArray<String> sparseArray = f13609c;
        synchronized (sparseArray) {
            str = sparseArray.get(i10);
        }
        return str;
    }

    private static SparseArray<String> e() {
        SparseArray<String> clone;
        f();
        SparseArray<String> sparseArray = f13609c;
        synchronized (sparseArray) {
            clone = sparseArray.clone();
        }
        return clone;
    }

    private static StringBuffer a(File file) {
        FileReader fileReader = null;
        if (!file.exists()) {
            return null;
        }
        char[] d10 = d();
        if (d10 == null) {
            a.a("crashsdk", "readCrashStatData alloc buffer failed!", (Throwable) null);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                int read = fileReader2.read(d10);
                if (read > 0) {
                    stringBuffer.append(d10, 0, read);
                }
                g.a((Closeable) fileReader2);
            } catch (Exception e10) {
                e = e10;
                fileReader = fileReader2;
                try {
                    g.a((Throwable) e);
                    g.a((Closeable) fileReader);
                    return stringBuffer;
                } catch (Throwable th) {
                    th = th;
                    g.a((Closeable) fileReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileReader = fileReader2;
                g.a((Closeable) fileReader);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            g.a((Throwable) e);
            g.a((Closeable) fileReader);
            return stringBuffer;
        }
        return stringBuffer;
    }

    public static void c(boolean z10) {
        if (g.R() && !b.L()) {
            e.j();
            if (!h.e()) {
                h.a(z10);
            }
            if (b.F()) {
                d(z10);
                a(b.c(), z10);
                h.b(z10);
            }
        }
    }

    private static String a(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        int indexOf = stringBuffer.indexOf("[");
        if (indexOf < 0) {
            a.a("crashsdk", "getProcessName: Can not found process name start!", (Throwable) null);
            return null;
        }
        int i10 = indexOf + 1;
        int indexOf2 = stringBuffer.indexOf("]", i10);
        if (indexOf2 < 0) {
            a.a("crashsdk", "getProcessName: Can not found process name end!", (Throwable) null);
            return null;
        }
        String substring = stringBuffer.substring(i10, indexOf2);
        if (substring.length() > 0) {
            return substring;
        }
        a.a("crashsdk", "getProcessName: process name is empty", (Throwable) null);
        return null;
    }

    private static boolean b(String str) {
        File file = new File(str);
        StringBuffer a10 = a(file);
        if (g.a(a10)) {
            return false;
        }
        String a11 = a(a10);
        StringBuffer stringBuffer = null;
        if (a11 == null || a11.length() <= 0) {
            a.a("crashsdk", "reportCrashStatImpl: process name is invalid", (Throwable) null);
            return false;
        }
        SparseArray<String> e10 = e();
        HashMap hashMap = new HashMap();
        boolean P = g.P();
        if (P) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("reportCrashStatImpl: processName: ");
            stringBuffer.append(a11 + "\n");
        }
        int i10 = 0;
        boolean z10 = false;
        while (i10 < e10.size()) {
            try {
                int keyAt = e10.keyAt(i10);
                String str2 = e10.get(keyAt);
                int a12 = a(a10, str2);
                if (a12 > 0) {
                    if (P) {
                        stringBuffer.append("name: ");
                        stringBuffer.append(str2);
                        stringBuffer.append(", key: ");
                        stringBuffer.append(keyAt);
                        stringBuffer.append(", count: ");
                        stringBuffer.append(a12);
                        stringBuffer.append("\n");
                    }
                    h.a(a11, keyAt, a12);
                    hashMap.put(str2, Integer.valueOf(a12));
                    a(a10, str2, 0);
                    z10 = true;
                }
                i10++;
            } finally {
                if (z10) {
                    a(file, a10);
                    if (hashMap.size() > 0) {
                        a(a11, (HashMap<String, Integer>) hashMap, b.a(str));
                    }
                }
            }
        }
        if (P) {
            a.a(stringBuffer.toString());
        }
        return true;
    }

    public static void c() {
        com.uc.crashsdk.a.f.a(1, new e(700), 3000);
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        int indexOf2 = stringBuffer.indexOf(Operator.Operation.EQUALS, indexOf + str.length());
        if (indexOf2 < 0) {
            a.b(str + " line not contain '='!");
            return 0;
        }
        int i10 = indexOf2 + 1;
        int indexOf3 = stringBuffer.indexOf("\n", i10);
        if (indexOf3 < 0) {
            indexOf3 = stringBuffer.length();
        }
        try {
            int parseInt = Integer.parseInt(stringBuffer.substring(i10, indexOf3));
            if (parseInt < 0) {
                return 0;
            }
            return parseInt;
        } catch (NumberFormatException e10) {
            g.a((Throwable) e10);
            return 0;
        }
    }

    private static char[] d() {
        char[] cArr = null;
        int i10 = 1024;
        while (cArr == null && i10 > 0) {
            try {
                cArr = new char[i10];
            } catch (Throwable unused) {
                i10 /= 2;
                if (i10 < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(boolean r2) {
        /*
            boolean r0 = f13611e
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = f13610d
            monitor-enter(r0)
            boolean r1 = f13611e     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x000e:
            java.lang.String r1 = "crash detail"
            boolean r2 = com.uc.crashsdk.a.h.a((boolean) r2, (java.lang.String) r1)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0018
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x0018:
            boolean r2 = com.uc.crashsdk.b.s()     // Catch:{ all -> 0x0056 }
            r1 = 1
            if (r2 == 0) goto L_0x0030
            r2 = 2
            a((int) r2, (int) r1)     // Catch:{ all -> 0x0056 }
            boolean r2 = com.uc.crashsdk.b.r()     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x002e
            r2 = 42
            a((int) r2, (int) r1)     // Catch:{ all -> 0x0056 }
        L_0x002e:
            r2 = 1
            goto L_0x0048
        L_0x0030:
            boolean r2 = com.uc.crashsdk.b.t()     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0047
            r2 = 101(0x65, float:1.42E-43)
            a((int) r2, (int) r1)     // Catch:{ all -> 0x0056 }
            boolean r2 = com.uc.crashsdk.b.r()     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x002e
            r2 = 43
            a((int) r2, (int) r1)     // Catch:{ all -> 0x0056 }
            goto L_0x002e
        L_0x0047:
            r2 = 0
        L_0x0048:
            if (r2 == 0) goto L_0x004d
            a((int) r1, (int) r1)     // Catch:{ all -> 0x0056 }
        L_0x004d:
            r2 = 100
            a((int) r2, (int) r1)     // Catch:{ all -> 0x0056 }
            f13611e = r1     // Catch:{ all -> 0x0056 }
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x0056:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            goto L_0x005a
        L_0x0059:
            throw r2
        L_0x005a:
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.d(boolean):void");
    }

    private static void a(StringBuffer stringBuffer, String str, int i10) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf >= 0) {
            int indexOf2 = stringBuffer.indexOf("\n", indexOf);
            if (indexOf2 < 0) {
                indexOf2 = stringBuffer.length();
            }
            stringBuffer.replace(indexOf, indexOf2, str + Operator.Operation.EQUALS + String.valueOf(i10));
        } else if (i10 > 0) {
            stringBuffer.append(str);
            stringBuffer.append(Operator.Operation.EQUALS);
            stringBuffer.append(i10);
            stringBuffer.append("\n");
        }
    }

    private static boolean a(File file, StringBuffer stringBuffer) {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                String stringBuffer2 = stringBuffer.toString();
                fileWriter2.write(stringBuffer2, 0, stringBuffer2.length());
                g.a((Closeable) fileWriter2);
                return true;
            } catch (Exception e10) {
                e = e10;
                fileWriter = fileWriter2;
                try {
                    g.a((Throwable) e);
                    g.a((Closeable) fileWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    g.a((Closeable) fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter = fileWriter2;
                g.a((Closeable) fileWriter);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            g.a((Throwable) e);
            g.a((Closeable) fileWriter);
            return false;
        }
    }

    private static void a(String str, HashMap<String, Integer> hashMap, String str2) {
        if (hashMap.size() > 0) {
            if (g.a(str)) {
                a.a("crashsdk", "cacheReportedStatsForCallback: processName is null", (Throwable) null);
            } else if (g.a(str2)) {
                a.a("crashsdk", "cacheReportedStatsForCallback: callbackCacheFilePathName is null", (Throwable) null);
            } else {
                a(str2, new e(754, new Object[]{str, hashMap, str2}));
            }
        }
    }

    public static int a(boolean z10) {
        if (!z10) {
            File[] f10 = b.f();
            if (f10 == null) {
                return 0;
            }
            int i10 = 0;
            for (File absolutePath : f10) {
                if (c(absolutePath.getAbsolutePath())) {
                    i10++;
                }
            }
            return i10;
        } else if (c(b.e())) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void b(String str, HashMap<String, Integer> hashMap, String str2) {
        File file;
        try {
            b.x();
        } catch (Throwable th) {
            g.a(th);
        }
        try {
            file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th2) {
            g.a(th2);
            return;
        }
        StringBuffer a10 = a(file);
        if (g.a(a10)) {
            if (a10 == null) {
                a10 = new StringBuffer();
            }
            a10.append("[");
            a10.append(str);
            a10.append("]\n");
        }
        boolean z10 = false;
        for (Map.Entry next : hashMap.entrySet()) {
            int intValue = ((Integer) next.getValue()).intValue();
            if (intValue > 0) {
                String str3 = (String) next.getKey();
                a(a10, str3, intValue + a(a10, str3));
                z10 = true;
            }
        }
        if (z10) {
            a(file, a10);
        }
    }

    private static boolean a(String str, e eVar) {
        return b.a(f13608b, str, eVar);
    }

    public static boolean a(String str, boolean z10) {
        if (h.a(z10, "crash detail report")) {
            return false;
        }
        return a(str, new e(752, new Object[]{str}));
    }

    public static int a() {
        File[] d10 = b.d();
        if (d10 == null) {
            return 0;
        }
        int i10 = 0;
        for (File absolutePath : d10) {
            if (a(absolutePath.getAbsolutePath(), false)) {
                i10++;
            }
        }
        return i10;
    }

    public static boolean a(String str) {
        return a(str, new e(753, new Object[]{str}));
    }

    public static boolean a(int i10, Object[] objArr) {
        switch (i10) {
            case 751:
                if (f13607a || objArr != null) {
                    return b(objArr[0].intValue(), objArr[1].intValue());
                }
                throw new AssertionError();
            case 752:
                if (f13607a || objArr != null) {
                    return b(objArr[0]);
                }
                throw new AssertionError();
            case 753:
                if (f13607a || objArr != null) {
                    File file = new File(objArr[0]);
                    if (!file.exists()) {
                        return false;
                    }
                    file.delete();
                    return true;
                }
                throw new AssertionError();
            case 754:
                if (f13607a || objArr != null) {
                    b(objArr[0], objArr[1], objArr[2]);
                    return true;
                }
                throw new AssertionError();
            case 755:
                if (f13607a || objArr != null) {
                    return d(objArr[0]);
                }
                throw new AssertionError();
            case 756:
                if (f13607a || objArr != null) {
                    File file2 = new File(objArr[0]);
                    if (!file2.exists()) {
                        return false;
                    }
                    file2.delete();
                    return true;
                }
                throw new AssertionError();
            default:
                return false;
        }
    }

    public static int b(boolean z10) {
        if (!z10) {
            File[] f10 = b.f();
            if (f10 == null) {
                return 0;
            }
            int i10 = 0;
            for (File absolutePath : f10) {
                if (e(absolutePath.getAbsolutePath())) {
                    i10++;
                }
            }
            return i10;
        } else if (e(b.e())) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int b() {
        File[] d10 = b.d();
        if (d10 == null) {
            return 0;
        }
        int i10 = 0;
        for (File absolutePath : d10) {
            if (a(absolutePath.getAbsolutePath())) {
                i10++;
            }
        }
        return i10;
    }

    public static void b(int i10) {
        if (i10 == 700) {
            d(false);
        }
    }
}
