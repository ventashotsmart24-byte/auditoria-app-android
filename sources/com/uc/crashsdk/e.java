package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.common.utils.ContextPath;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.cybergarage.upnp.ssdp.SSDP;
import com.hpplay.sdk.source.common.global.Constant;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.a.f;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e implements Thread.UncaughtExceptionHandler {
    private static Map<String, Integer> A = null;
    private static String B = null;
    /* access modifiers changed from: private */
    public static int C = -1;
    /* access modifiers changed from: private */
    public static int D = -1;
    /* access modifiers changed from: private */
    public static int E = -1;
    /* access modifiers changed from: private */
    public static int F = -1;
    /* access modifiers changed from: private */
    public static int G = -1;
    /* access modifiers changed from: private */
    public static int H = -1;
    /* access modifiers changed from: private */
    public static int I = -1;
    /* access modifiers changed from: private */
    public static String J = Operator.Operation.EMPTY_PARAM;
    /* access modifiers changed from: private */
    public static boolean K = false;
    private static boolean L = false;
    /* access modifiers changed from: private */
    public static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c((byte) 0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13563a = true;

    /* renamed from: aa  reason: collision with root package name */
    private static Runnable f13564aa = new com.uc.crashsdk.a.e(407);

    /* renamed from: ab  reason: collision with root package name */
    private static final Object f13565ab = new Object();
    private static volatile boolean ac = false;
    private static Object ad = new Object();
    private static ParcelFileDescriptor ae = null;
    private static boolean af = false;
    private static boolean ag = false;

    /* renamed from: b  reason: collision with root package name */
    private static long f13566b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicBoolean f13567c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static boolean f13568d = false;

    /* renamed from: f  reason: collision with root package name */
    private static long f13569f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static long f13570g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static boolean f13571h = true;

    /* renamed from: i  reason: collision with root package name */
    private static String f13572i;

    /* renamed from: j  reason: collision with root package name */
    private static String f13573j = "";

    /* renamed from: k  reason: collision with root package name */
    private static String f13574k = null;

    /* renamed from: l  reason: collision with root package name */
    private static String f13575l = null;

    /* renamed from: m  reason: collision with root package name */
    private static String f13576m = null;

    /* renamed from: n  reason: collision with root package name */
    private static final Object f13577n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private static final ConditionVariable f13578o = new ConditionVariable();

    /* renamed from: p  reason: collision with root package name */
    private static final Object f13579p = new Object();

    /* renamed from: q  reason: collision with root package name */
    private static final Object f13580q = new Object();

    /* renamed from: r  reason: collision with root package name */
    private static final Object f13581r = new Object();

    /* renamed from: s  reason: collision with root package name */
    private static final ArrayList<String> f13582s = new ArrayList<>();

    /* renamed from: t  reason: collision with root package name */
    private static int f13583t = 0;

    /* renamed from: u  reason: collision with root package name */
    private static String f13584u = null;

    /* renamed from: v  reason: collision with root package name */
    private static boolean f13585v = false;

    /* renamed from: w  reason: collision with root package name */
    private static String f13586w = null;

    /* renamed from: x  reason: collision with root package name */
    private static String f13587x = null;

    /* renamed from: y  reason: collision with root package name */
    private static final Object f13588y = new Object();

    /* renamed from: z  reason: collision with root package name */
    private static final Object f13589z = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final List<FileInputStream> f13590e = new ArrayList();

    public static class b implements Comparator<File> {
        private b() {
        }

        public /* synthetic */ b(byte b10) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            File file = (File) obj;
            File file2 = (File) obj2;
            if (file.lastModified() > file2.lastModified()) {
                return 1;
            }
            if (file.lastModified() < file2.lastModified()) {
                return -1;
            }
            return 0;
        }
    }

    public static class c extends BroadcastReceiver {
        private c() {
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int unused = e.C = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int unused2 = e.D = intent.getIntExtra("scale", -1);
                int unused3 = e.E = intent.getIntExtra("voltage", -1);
                int unused4 = e.F = intent.getIntExtra("health", -1);
                int unused5 = e.G = intent.getIntExtra("plugged", -1);
                int unused6 = e.H = intent.getIntExtra(Constant.KEY_STATUS, -1);
                int unused7 = e.I = intent.getIntExtra("temperature", -1);
                String unused8 = e.J = intent.getStringExtra("technology");
                if (e.J() >= 2) {
                    e.K();
                    int unused9 = e.M = 0;
                }
            } else if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                boolean unused10 = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                e.K();
            } else if ("android.intent.action.ANR".equals(action)) {
                try {
                    boolean unused11 = e.d(context);
                } catch (Throwable th) {
                    g.a(th);
                }
            }
        }

        public /* synthetic */ c(byte b10) {
            this();
        }
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static void A() {
        if (g.r()) {
            f.a(0, new com.uc.crashsdk.a.e(UPnPStatus.OUT_OF_SYNC), NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
        }
    }

    public static void B() {
        if (!ac && !b.L()) {
            f.a(1, new com.uc.crashsdk.a.e(408), 1000);
        }
    }

    public static void C() {
        f.a(1, new com.uc.crashsdk.a.e(409), 7000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if ((java.lang.System.currentTimeMillis() % 3) == 0) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        if (r0 == 1) goto L_0x0011;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void D() {
        /*
            int r0 = com.uc.crashsdk.g.O()
            r1 = 4
            r2 = 3
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0013
            if (r0 == r2) goto L_0x0013
            if (r0 != r1) goto L_0x000f
            goto L_0x0013
        L_0x000f:
            if (r0 != r4) goto L_0x0043
        L_0x0011:
            r4 = 0
            goto L_0x0043
        L_0x0013:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 < r6) goto L_0x0043
            r6 = 25
            if (r5 > r6) goto L_0x0043
            if (r0 != 0) goto L_0x0021
            r5 = 0
            goto L_0x0022
        L_0x0021:
            r5 = 1
        L_0x0022:
            r6 = 0
            if (r0 != r2) goto L_0x0034
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 10
            long r8 = r8 % r10
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0033
            r5 = 1
            goto L_0x0034
        L_0x0033:
            r5 = 0
        L_0x0034:
            if (r0 != r1) goto L_0x0042
            long r0 = java.lang.System.currentTimeMillis()
            r8 = 3
            long r0 = r0 % r8
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0011
            goto L_0x0043
        L_0x0042:
            r4 = r5
        L_0x0043:
            if (r4 != 0) goto L_0x004c
            java.lang.String r0 = "crashsdk"
            java.lang.String r1 = "SIG 3 is disabled by settings"
            com.uc.crashsdk.a.a.a(r0, r1)
        L_0x004c:
            boolean r0 = com.uc.crashsdk.b.L()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 == r2) goto L_0x0068
            if (r4 == 0) goto L_0x0068
            com.uc.crashsdk.a.e r1 = new com.uc.crashsdk.a.e
            r2 = 413(0x19d, float:5.79E-43)
            r1.<init>(r2)
            r2 = 2
            com.uc.crashsdk.a.f.a((int) r2, (java.lang.Runnable) r1)
            goto L_0x0069
        L_0x0068:
            r3 = r4
        L_0x0069:
            r1 = 7
            long r4 = (long) r0
            r0 = 0
            com.uc.crashsdk.JNIBridge.nativeCmd(r1, r4, r0, r0)
            if (r3 == 0) goto L_0x0076
            r0 = 8
            com.uc.crashsdk.JNIBridge.cmd(r0)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.D():void");
    }

    public static ParcelFileDescriptor E() {
        if (!b.f13531d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            ParcelFileDescriptor parcelFileDescriptor = ae;
            if (parcelFileDescriptor != null) {
                return parcelFileDescriptor;
            }
            int cmd = (int) JNIBridge.cmd(14);
            if (cmd == -1) {
                return null;
            }
            ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(cmd);
            ae = adoptFd;
            af = true;
            return adoptFd;
        }
    }

    public static boolean F() {
        return ag;
    }

    public static void G() {
        String Y2 = g.Y();
        File file = new File(Y2);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + Y2);
                return;
            }
            int length = listFiles.length;
            int i10 = 0;
            while (i10 < length) {
                File file2 = listFiles[i10];
                if (!file2.isFile() || !file2.getName().contains("ucebu")) {
                    i10++;
                } else {
                    a(false, false);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ int J() {
        int i10 = M + 1;
        M = i10;
        return i10;
    }

    public static /* synthetic */ void K() {
        StringBuilder Y2;
        if (b.f13531d && (Y2 = Y()) != null) {
            JNIBridge.set(125, Y2.toString());
        }
        L = true;
        Z();
    }

    private void M() {
        int J2 = g.J();
        int i10 = 0;
        while (i10 < J2) {
            try {
                this.f13590e.add(new FileInputStream("/dev/null"));
                i10++;
            } catch (Exception e10) {
                g.a((Throwable) e10);
                return;
            }
        }
    }

    private void N() {
        for (FileInputStream a10 : this.f13590e) {
            g.a((Closeable) a10);
        }
        this.f13590e.clear();
    }

    /* access modifiers changed from: private */
    public static boolean O() {
        if (g.Q()) {
            return true;
        }
        return a();
    }

    private static String P() {
        return g.e() + "_";
    }

    private static String Q() {
        if (b.B()) {
            return "fg";
        }
        return "bg";
    }

    private static byte[] R() {
        byte[] bArr = null;
        int i10 = 1024;
        while (bArr == null && i10 > 0) {
            try {
                bArr = new byte[i10];
            } catch (Throwable unused) {
                i10 /= 2;
                if (i10 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String S() {
        if (!b.F() || f13568d) {
            return LogType.JAVA_TYPE;
        }
        return "ucebujava";
    }

    private static void T() {
        String str;
        BufferedReader bufferedReader;
        FileReader fileReader;
        Throwable th;
        String str2 = Operator.Operation.MINUS;
        try {
            str = Build.HARDWARE;
        } catch (Throwable th2) {
            g.a(th2);
            str = str2;
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i10 = 0;
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(SOAP.DELIM) + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(SOAP.DELIM) + 1).trim();
                        }
                        i10++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            g.a(th);
                            g.a((Closeable) fileReader);
                            g.a((Closeable) bufferedReader);
                            f13574k = str;
                            f13575l = str2;
                        } catch (Throwable th4) {
                            g.a((Closeable) fileReader);
                            g.a((Closeable) bufferedReader);
                            throw th4;
                        }
                    }
                } while (i10 < 2);
                g.a((Closeable) fileReader);
            } catch (Throwable th5) {
                Throwable th6 = th5;
                bufferedReader = null;
                th = th6;
                g.a(th);
                g.a((Closeable) fileReader);
                g.a((Closeable) bufferedReader);
                f13574k = str;
                f13575l = str2;
            }
        } catch (Throwable th7) {
            bufferedReader = null;
            th = th7;
            fileReader = null;
            g.a(th);
            g.a((Closeable) fileReader);
            g.a((Closeable) bufferedReader);
            f13574k = str;
            f13575l = str2;
        }
        g.a((Closeable) bufferedReader);
        f13574k = str;
        f13575l = str2;
    }

    private static String U() {
        return g.X() + HTTP.CONTENT_RANGE_BYTES;
    }

    private static boolean V() {
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        return false;
    }

    private static void W() {
        if (!O && !b.F() && !b.L()) {
            JNIBridge.cmd(18);
        }
    }

    private static void X() {
        f.a(3, new com.uc.crashsdk.a.e(414), 1000);
    }

    private static StringBuilder Y() {
        String str;
        String str2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(D);
            sb.append("\n");
            String str3 = " (Unknown)";
            switch (F) {
                case 1:
                    str = str3;
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append("\n");
            int i10 = G;
            if (i10 == 0) {
                str2 = " (None)";
            } else if (i10 == 1) {
                str2 = " (AC charger)";
            } else if (i10 == 2) {
                str2 = " (USB port)";
            } else if (i10 != 4) {
                str2 = " (?)";
            } else {
                str2 = " (Wireless)";
            }
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append("\n");
            int i11 = H;
            if (i11 != 1) {
                if (i11 == 2) {
                    str3 = " (Charging)";
                } else if (i11 == 3) {
                    str3 = " (Discharging)";
                } else if (i11 == 4) {
                    str3 = " (Not charging)";
                } else if (i11 != 5) {
                    str3 = " (?)";
                } else {
                    str3 = " (Full)";
                }
            }
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(K);
            sb.append("\n");
            return sb;
        } catch (Throwable th) {
            g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (b.f13530c && L && a.f13448c) {
            L = false;
            if (!f.b(P)) {
                f.a(0, P, 2000);
            }
        }
    }

    public static boolean a() {
        if (f13569f == 0) {
            f13569f = 2;
            if (h(b.b("logs")) == 1) {
                f13569f = 1;
            }
        }
        return f13569f == 1;
    }

    private static boolean aa() {
        if (!b.f13531d || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        return true;
    }

    private static void ab() {
        int i10;
        int i11;
        boolean z10;
        String Z2 = g.Z();
        File file = new File(Z2);
        if (file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new b((byte) 0));
                    int length = listFiles.length - 150;
                    if (length < 0) {
                        i10 = 0;
                    } else {
                        i10 = length;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int i12 = 0;
                    i11 = 0;
                    for (int i13 = 0; i13 < listFiles.length; i13++) {
                        File file2 = listFiles[i13];
                        if (i13 < i10) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!z10 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z10 = true;
                        }
                        if (!z10) {
                            break;
                        }
                        file2.delete();
                        i12++;
                        i11 = 0;
                        if (i11 >= 3) {
                            break;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i12 + " logs in " + Z2);
                }
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    public static long b() {
        if (f13570g == -1) {
            f13570g = h(b.b("local"));
        }
        return f13570g;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", new Object[]{P(), g.U(), g.W(), i(Build.MODEL), i(Build.VERSION.RELEASE), str});
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", new Object[]{d(), n(), Q(), str});
    }

    private static String l(String str) {
        if (!g.b(str)) {
            return "";
        }
        int indexOf = str.indexOf(0);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    private static String m(String str) {
        String a10 = com.uc.crashsdk.a.b.a(str, g.x(), g.w());
        if (!str.equals(a10)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r7.endsWith(r3) != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        if (r7.indexOf(".log", r7.lastIndexOf(95)) != r7.lastIndexOf(".log")) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean[] n(java.lang.String r7) {
        /*
            boolean r0 = com.uc.crashsdk.g.w()
            boolean r1 = com.uc.crashsdk.g.y()
            r2 = 0
            if (r0 != 0) goto L_0x000d
            if (r1 == 0) goto L_0x006d
        L_0x000d:
            java.lang.String r3 = ".tmp"
            boolean r3 = r7.endsWith(r3)
            if (r3 != 0) goto L_0x006b
            java.lang.String r3 = ".ec"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x001e
            goto L_0x006b
        L_0x001e:
            char r3 = java.io.File.separatorChar
            int r3 = r7.lastIndexOf(r3)
            if (r3 >= 0) goto L_0x0027
            r3 = 0
        L_0x0027:
            r4 = 0
        L_0x0028:
            r5 = 95
            int r3 = r7.indexOf(r5, r3)
            if (r3 < 0) goto L_0x0034
            int r4 = r4 + 1
            int r3 = r3 + 1
        L_0x0034:
            if (r3 >= 0) goto L_0x0028
            r3 = 8
            if (r4 == r3) goto L_0x003b
            goto L_0x006b
        L_0x003b:
            java.lang.String r3 = com.uc.crashsdk.g.x()
            java.lang.String r4 = ".log"
            boolean r6 = r7.endsWith(r4)
            if (r6 != 0) goto L_0x0054
            boolean r0 = com.uc.crashsdk.a.g.a((java.lang.String) r3)
            if (r0 != 0) goto L_0x006b
            boolean r7 = r7.endsWith(r3)
            if (r7 != 0) goto L_0x005a
            goto L_0x006b
        L_0x0054:
            boolean r3 = com.uc.crashsdk.a.g.a((java.lang.String) r3)
            if (r3 == 0) goto L_0x005c
        L_0x005a:
            r0 = 0
            goto L_0x006d
        L_0x005c:
            int r3 = r7.lastIndexOf(r5)
            int r3 = r7.indexOf(r4, r3)
            int r7 = r7.lastIndexOf(r4)
            if (r3 == r7) goto L_0x006d
            goto L_0x005a
        L_0x006b:
            r0 = 0
            r1 = 0
        L_0x006d:
            r7 = 2
            boolean[] r7 = new boolean[r7]
            r7[r2] = r0
            r0 = 1
            r7[r0] = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.n(java.lang.String):boolean[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        r11 = java.lang.Long.parseLong(r10.group(2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
        if ((r5 - r11) >= 86400000) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = java.lang.Integer.parseInt(r10.group(3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.uc.crashsdk.a.g.a((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        r13 = com.uc.crashsdk.g.G();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
        if (r13 < 0) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r7.replace(r10.start(), r10.end(), java.lang.String.format(java.util.Locale.US, "%s %d %d", new java.lang.Object[]{r1, java.lang.Long.valueOf(r11), java.lang.Integer.valueOf(r0 + 1)}));
        r0 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ae A[Catch:{ Exception -> 0x0071 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean o(java.lang.String r17) {
        /*
            r1 = r17
            java.lang.Object r2 = f13581r
            monitor-enter(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r0.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = com.uc.crashsdk.g.X()     // Catch:{ all -> 0x00ee }
            r0.append(r3)     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = "customlog"
            r0.append(r3)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ee }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00ee }
            r3.<init>(r0)     // Catch:{ all -> 0x00ee }
            r0 = 1024(0x400, float:1.435E-42)
            r4 = 0
            java.lang.String r0 = com.uc.crashsdk.a.g.a((java.io.File) r3, (int) r0, (boolean) r4)     // Catch:{ all -> 0x00ee }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ee }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ all -> 0x00ee }
            r7.<init>()     // Catch:{ all -> 0x00ee }
            r8 = 2
            r9 = 1
            if (r0 == 0) goto L_0x00aa
            r7.append(r0)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = "([^\\n\\r\\t\\s]+) (\\d+) (\\d+)"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ all -> 0x00ee }
            java.util.regex.Matcher r10 = r0.matcher(r7)     // Catch:{ all -> 0x00ee }
            r0 = 0
        L_0x0041:
            boolean r0 = r10.find(r0)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00aa
            java.lang.String r0 = r10.group(r9)     // Catch:{ all -> 0x00ee }
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x00ee }
            if (r0 != 0) goto L_0x0056
            int r0 = r10.end()     // Catch:{ all -> 0x00ee }
            goto L_0x0041
        L_0x0056:
            java.lang.String r0 = r10.group(r8)     // Catch:{ all -> 0x00ee }
            long r11 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x00ee }
            long r13 = r5 - r11
            r15 = 86400000(0x5265c00, double:4.2687272E-316)
            r8 = 3
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x0076
            java.lang.String r0 = r10.group(r8)     // Catch:{ Exception -> 0x0071 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0078
        L_0x0071:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x00ee }
            goto L_0x0077
        L_0x0076:
            r11 = r5
        L_0x0077:
            r0 = 0
        L_0x0078:
            int r13 = com.uc.crashsdk.g.G()     // Catch:{ all -> 0x00ee }
            if (r13 < 0) goto L_0x0082
            if (r0 < r13) goto L_0x0082
            r13 = 1
            goto L_0x0083
        L_0x0082:
            r13 = 0
        L_0x0083:
            int r0 = r0 + r9
            java.util.Locale r14 = java.util.Locale.US     // Catch:{ all -> 0x00ee }
            java.lang.String r15 = "%s %d %d"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x00ee }
            r8[r4] = r1     // Catch:{ all -> 0x00ee }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x00ee }
            r8[r9] = r11     // Catch:{ all -> 0x00ee }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00ee }
            r11 = 2
            r8[r11] = r0     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = java.lang.String.format(r14, r15, r8)     // Catch:{ all -> 0x00ee }
            int r8 = r10.start()     // Catch:{ all -> 0x00ee }
            int r10 = r10.end()     // Catch:{ all -> 0x00ee }
            r7.replace(r8, r10, r0)     // Catch:{ all -> 0x00ee }
            r0 = 1
            goto L_0x00ac
        L_0x00aa:
            r0 = 0
            r13 = 0
        L_0x00ac:
            if (r0 != 0) goto L_0x00c4
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x00ee }
            java.lang.String r8 = "%s %d 1\n"
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x00ee }
            r10[r4] = r1     // Catch:{ all -> 0x00ee }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00ee }
            r10[r9] = r1     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = java.lang.String.format(r0, r8, r10)     // Catch:{ all -> 0x00ee }
            r7.append(r0)     // Catch:{ all -> 0x00ee }
        L_0x00c4:
            r1 = 0
            java.io.FileWriter r5 = new java.io.FileWriter     // Catch:{ Exception -> 0x00e1 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x00dc, all -> 0x00d9 }
            int r1 = r0.length()     // Catch:{ Exception -> 0x00dc, all -> 0x00d9 }
            r5.write(r0, r4, r1)     // Catch:{ Exception -> 0x00dc, all -> 0x00d9 }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)     // Catch:{ all -> 0x00ee }
            goto L_0x00e8
        L_0x00d9:
            r0 = move-exception
            r1 = r5
            goto L_0x00ea
        L_0x00dc:
            r0 = move-exception
            r1 = r5
            goto L_0x00e2
        L_0x00df:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e1:
            r0 = move-exception
        L_0x00e2:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x00df }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00ee }
        L_0x00e8:
            monitor-exit(r2)     // Catch:{ all -> 0x00ee }
            return r13
        L_0x00ea:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00ee }
            throw r0     // Catch:{ all -> 0x00ee }
        L_0x00ee:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00ee }
            goto L_0x00f2
        L_0x00f1:
            throw r0
        L_0x00f2:
            goto L_0x00f1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean p(java.lang.String r14) {
        /*
            java.lang.Object r0 = f13589z
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer> r1 = A     // Catch:{ all -> 0x0108 }
            r2 = 0
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = com.uc.crashsdk.b.l()     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = "all:1"
            java.lang.String r1 = com.uc.crashsdk.a.g.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)     // Catch:{ all -> 0x0108 }
            java.util.Map r1 = q(r1)     // Catch:{ all -> 0x0108 }
            A = r1     // Catch:{ all -> 0x0108 }
        L_0x0018:
            java.util.Map<java.lang.String, java.lang.Integer> r1 = A     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = "all"
            boolean r1 = r1.containsKey(r3)     // Catch:{ all -> 0x0108 }
            r3 = 1
            if (r1 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Integer> r14 = A     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = "all"
            java.lang.Object r14 = r14.get(r1)     // Catch:{ all -> 0x0108 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0108 }
        L_0x002d:
            int r14 = r14.intValue()     // Catch:{ all -> 0x0108 }
            goto L_0x00ac
        L_0x0033:
            java.util.Map<java.lang.String, java.lang.Integer> r1 = A     // Catch:{ all -> 0x0108 }
            boolean r1 = r1.containsKey(r14)     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x0044
            java.util.Map<java.lang.String, java.lang.Integer> r1 = A     // Catch:{ all -> 0x0108 }
            java.lang.Object r14 = r1.get(r14)     // Catch:{ all -> 0x0108 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0108 }
            goto L_0x002d
        L_0x0044:
            java.lang.String r1 = "java"
            boolean r1 = r1.equals(r14)     // Catch:{ all -> 0x0108 }
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = "jni"
            boolean r1 = r1.equals(r14)     // Catch:{ all -> 0x0108 }
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = "anr"
            boolean r1 = r1.equals(r14)     // Catch:{ all -> 0x0108 }
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = "unexp"
            boolean r14 = r1.equals(r14)     // Catch:{ all -> 0x0108 }
            if (r14 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r14 = 0
            goto L_0x0068
        L_0x0067:
            r14 = 1
        L_0x0068:
            if (r14 == 0) goto L_0x007f
            java.util.Map<java.lang.String, java.lang.Integer> r1 = A     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = "crash"
            boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x007f
            java.util.Map<java.lang.String, java.lang.Integer> r14 = A     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = "crash"
            java.lang.Object r14 = r14.get(r1)     // Catch:{ all -> 0x0108 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0108 }
            goto L_0x002d
        L_0x007f:
            if (r14 != 0) goto L_0x0096
            java.util.Map<java.lang.String, java.lang.Integer> r14 = A     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = "nocrash"
            boolean r14 = r14.containsKey(r1)     // Catch:{ all -> 0x0108 }
            if (r14 == 0) goto L_0x0096
            java.util.Map<java.lang.String, java.lang.Integer> r14 = A     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = "nocrash"
            java.lang.Object r14 = r14.get(r1)     // Catch:{ all -> 0x0108 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0108 }
            goto L_0x002d
        L_0x0096:
            java.util.Map<java.lang.String, java.lang.Integer> r14 = A     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = "other"
            boolean r14 = r14.containsKey(r1)     // Catch:{ all -> 0x0108 }
            if (r14 == 0) goto L_0x00ab
            java.util.Map<java.lang.String, java.lang.Integer> r14 = A     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = "other"
            java.lang.Object r14 = r14.get(r1)     // Catch:{ all -> 0x0108 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0108 }
            goto L_0x002d
        L_0x00ab:
            r14 = 1
        L_0x00ac:
            if (r14 == 0) goto L_0x0106
            long r4 = (long) r14     // Catch:{ all -> 0x0108 }
            r6 = 1
            r8 = 0
            int r14 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r14 >= 0) goto L_0x00f1
            r10 = -2
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 != 0) goto L_0x00c0
            r4 = 7
            goto L_0x00d4
        L_0x00c0:
            r10 = -3
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 != 0) goto L_0x00c9
            r4 = 15
            goto L_0x00d4
        L_0x00c9:
            r10 = -4
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 != 0) goto L_0x00d2
            r4 = 60
            goto L_0x00d4
        L_0x00d2:
            r4 = 30
        L_0x00d4:
            long r10 = com.uc.crashsdk.a.b()     // Catch:{ all -> 0x0108 }
            int r14 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x00df
            r10 = -1
            goto L_0x00e9
        L_0x00df:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0108 }
            long r12 = r12 - r10
            r10 = 86400000(0x5265c00, double:4.2687272E-316)
            long r10 = r12 / r10
        L_0x00e9:
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 > 0) goto L_0x00ef
            r4 = r6
            goto L_0x00f1
        L_0x00ef:
            long r4 = r10 - r4
        L_0x00f1:
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 != 0) goto L_0x00f7
        L_0x00f5:
            r2 = 1
            goto L_0x0106
        L_0x00f7:
            int r14 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r14 > 0) goto L_0x00fc
            goto L_0x00f5
        L_0x00fc:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0108 }
            long r6 = r6 % r4
            int r14 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x0106
            goto L_0x00f5
        L_0x0106:
            monitor-exit(r0)     // Catch:{ all -> 0x0108 }
            return r2
        L_0x0108:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0108 }
            goto L_0x010c
        L_0x010b:
            throw r14
        L_0x010c:
            goto L_0x010b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.p(java.lang.String):boolean");
    }

    private static Map<String, Integer> q(String str) {
        HashMap hashMap = new HashMap();
        for (String split : str.split("\\|", 30)) {
            String[] split2 = split.split(SOAP.DELIM, 3);
            if (split2.length == 2) {
                String trim = split2[0].trim();
                if (!g.a(trim)) {
                    int i10 = 1;
                    try {
                        i10 = Integer.parseInt(split2[1].trim(), 10);
                    } catch (Throwable th) {
                        g.a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i10));
                }
            }
        }
        return hashMap;
    }

    private static void r(String str) {
        if (g.r()) {
            try {
                ab();
            } catch (Throwable th) {
                g.a(th);
            }
            if (str != null && !"".equals(str)) {
                try {
                    File file = new File(g.Z());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                    g.a(new File(str), file);
                } catch (Throwable th2) {
                    g.a(th2);
                }
            }
        }
    }

    private static String s(String str) {
        return String.format("$^%s^$", new Object[]{str});
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    public static boolean u() {
        if (f13567c.get() || aa()) {
            return true;
        }
        return false;
    }

    public static Throwable v() {
        return U;
    }

    public static int w() {
        if (b.I() == 5) {
            return Z;
        }
        return 100;
    }

    public static void x() {
        boolean z10;
        long p10 = (long) g.p();
        if (p10 >= 0) {
            if (b.I() == 5) {
                z10 = true;
            } else {
                z10 = false;
            }
            f.a(0, (Runnable) new com.uc.crashsdk.a.e(401));
            if (z10) {
                com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
                X = eVar;
                f.a(0, eVar, p10);
            }
        }
    }

    public static void y() {
        if (b.f13530c && a.f13448c && !f.b(f13564aa)) {
            f.a(0, f13564aa, 1000);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean z() {
        /*
            java.lang.Object r0 = Y
            monitor-enter(r0)
            java.lang.Runnable r1 = X     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0014
            boolean r2 = W     // Catch:{ all -> 0x0017 }
            if (r2 != 0) goto L_0x0014
            com.uc.crashsdk.a.f.a((java.lang.Runnable) r1)     // Catch:{ all -> 0x0017 }
            r1 = 0
            X = r1     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            r0 = 1
            return r0
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            r0 = 0
            return r0
        L_0x0017:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.z():boolean");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    public static String d() {
        String str = f13572i;
        if (str != null) {
            return str;
        }
        String j10 = j((String) null);
        f13572i = j10;
        return j10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ad A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e() {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = ","
            java.lang.String r2 = f13573j
            boolean r2 = com.uc.crashsdk.a.g.a((java.lang.String) r2)
            if (r2 != 0) goto L_0x000f
            java.lang.String r0 = f13573j
            return r0
        L_0x000f:
            r2 = 0
            r3 = 1
            r4 = 0
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x004e }
            r6 = 21
            if (r5 < r6) goto L_0x004f
            java.lang.Class<android.os.Build> r5 = android.os.Build.class
            java.lang.String r6 = "SUPPORTED_ABIS"
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch:{ all -> 0x004e }
            r5.setAccessible(r3)     // Catch:{ all -> 0x004e }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x004e }
            if (r5 == 0) goto L_0x004f
            boolean r6 = r5 instanceof java.lang.String[]     // Catch:{ all -> 0x004e }
            if (r6 == 0) goto L_0x004f
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r6.<init>()     // Catch:{ all -> 0x004e }
            int r7 = r5.length     // Catch:{ all -> 0x004e }
            r8 = 0
            r9 = 1
        L_0x0037:
            if (r8 >= r7) goto L_0x0047
            r10 = r5[r8]     // Catch:{ all -> 0x004e }
            if (r9 != 0) goto L_0x0040
            r6.append(r1)     // Catch:{ all -> 0x004e }
        L_0x0040:
            r6.append(r10)     // Catch:{ all -> 0x004e }
            int r8 = r8 + 1
            r9 = 0
            goto L_0x0037
        L_0x0047:
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x004e }
            f13573j = r5     // Catch:{ all -> 0x004e }
            goto L_0x004f
        L_0x004e:
        L_0x004f:
            java.lang.String r5 = f13573j
            boolean r5 = com.uc.crashsdk.a.g.a((java.lang.String) r5)
            if (r5 == 0) goto L_0x0098
            java.lang.String r5 = android.os.Build.CPU_ABI     // Catch:{ all -> 0x005c }
            java.lang.String r6 = android.os.Build.CPU_ABI2     // Catch:{ all -> 0x005d }
            goto L_0x005e
        L_0x005c:
            r5 = r4
        L_0x005d:
            r6 = r4
        L_0x005e:
            boolean r7 = com.uc.crashsdk.a.g.a((java.lang.String) r5)
            r7 = r7 ^ r3
            if (r7 == 0) goto L_0x0067
            f13573j = r5
        L_0x0067:
            boolean r5 = com.uc.crashsdk.a.g.a((java.lang.String) r6)
            if (r5 != 0) goto L_0x0098
            if (r7 == 0) goto L_0x0096
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = f13573j
            r5.append(r7)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            f13573j = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = f13573j
            r5.append(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            f13573j = r5
            goto L_0x0098
        L_0x0096:
            f13573j = r6
        L_0x0098:
            java.lang.String r5 = "android.os.SystemProperties"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x00d1 }
            java.lang.String r6 = "get"
            r7 = 2
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x00d1 }
            r8[r2] = r0     // Catch:{ all -> 0x00d1 }
            r8[r3] = r0     // Catch:{ all -> 0x00d1 }
            java.lang.reflect.Method r0 = r5.getDeclaredMethod(r6, r8)     // Catch:{ all -> 0x00d1 }
            if (r0 == 0) goto L_0x00cf
            r0.setAccessible(r3)     // Catch:{ all -> 0x00d1 }
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ all -> 0x00d1 }
            java.lang.String r6 = "ro.product.cpu.abi"
            r5[r2] = r6     // Catch:{ all -> 0x00d1 }
            r5[r3] = r4     // Catch:{ all -> 0x00d1 }
            java.lang.Object r5 = r0.invoke(r4, r5)     // Catch:{ all -> 0x00d1 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00d1 }
            java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch:{ all -> 0x00cd }
            java.lang.String r7 = "ro.product.cpu.abi2"
            r6[r2] = r7     // Catch:{ all -> 0x00cd }
            r6[r3] = r4     // Catch:{ all -> 0x00cd }
            java.lang.Object r0 = r0.invoke(r4, r6)     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00cd }
            goto L_0x00d7
        L_0x00cd:
            r0 = move-exception
            goto L_0x00d3
        L_0x00cf:
            r0 = r4
            goto L_0x00d8
        L_0x00d1:
            r0 = move-exception
            r5 = r4
        L_0x00d3:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
            r0 = r4
        L_0x00d7:
            r4 = r5
        L_0x00d8:
            boolean r2 = com.uc.crashsdk.a.g.a((java.lang.String) r4)     // Catch:{ all -> 0x0141 }
            if (r2 != 0) goto L_0x010c
            java.lang.String r2 = f13573j     // Catch:{ all -> 0x0141 }
            boolean r2 = r2.contains(r4)     // Catch:{ all -> 0x0141 }
            if (r2 != 0) goto L_0x010c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            r2.<init>()     // Catch:{ all -> 0x0141 }
            java.lang.String r3 = f13573j     // Catch:{ all -> 0x0141 }
            r2.append(r3)     // Catch:{ all -> 0x0141 }
            r2.append(r1)     // Catch:{ all -> 0x0141 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0141 }
            f13573j = r2     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            r2.<init>()     // Catch:{ all -> 0x0141 }
            java.lang.String r3 = f13573j     // Catch:{ all -> 0x0141 }
            r2.append(r3)     // Catch:{ all -> 0x0141 }
            r2.append(r4)     // Catch:{ all -> 0x0141 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0141 }
            f13573j = r2     // Catch:{ all -> 0x0141 }
        L_0x010c:
            boolean r2 = com.uc.crashsdk.a.g.a((java.lang.String) r0)     // Catch:{ all -> 0x0141 }
            if (r2 != 0) goto L_0x0145
            java.lang.String r2 = f13573j     // Catch:{ all -> 0x0141 }
            boolean r2 = r2.contains(r0)     // Catch:{ all -> 0x0141 }
            if (r2 != 0) goto L_0x0145
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            r2.<init>()     // Catch:{ all -> 0x0141 }
            java.lang.String r3 = f13573j     // Catch:{ all -> 0x0141 }
            r2.append(r3)     // Catch:{ all -> 0x0141 }
            r2.append(r1)     // Catch:{ all -> 0x0141 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0141 }
            f13573j = r1     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            r1.<init>()     // Catch:{ all -> 0x0141 }
            java.lang.String r2 = f13573j     // Catch:{ all -> 0x0141 }
            r1.append(r2)     // Catch:{ all -> 0x0141 }
            r1.append(r0)     // Catch:{ all -> 0x0141 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0141 }
            f13573j = r0     // Catch:{ all -> 0x0141 }
            goto L_0x0145
        L_0x0141:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0145:
            java.lang.String r0 = f13573j
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e():java.lang.String");
    }

    public static String f() {
        if (g.a(f13574k)) {
            T();
        }
        return f13574k;
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", new Class[]{String.class, Long.TYPE});
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke((Object) null, new Object[]{str, 0L})).longValue();
            }
        } catch (Throwable th) {
            g.a(th);
        }
        return 0;
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", Operator.Operation.MINUS);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static void s() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    public static void c() {
        f13572i = null;
    }

    public static boolean i() {
        return f13568d;
    }

    public static boolean b(int i10, Object[] objArr) {
        if (i10 != 451) {
            if (i10 != 452) {
                if (f13563a) {
                    return false;
                }
                throw new AssertionError();
            } else if (f13563a || objArr != null) {
                d dVar = objArr[1];
                return g.a(new File(objArr[0]), String.format(Locale.US, "%d %d %d %d", new Object[]{Long.valueOf(dVar.f13596a), Long.valueOf(dVar.f13597b), Integer.valueOf(dVar.f13598c), Integer.valueOf(dVar.f13599d)}).getBytes());
            } else {
                throw new AssertionError();
            }
        } else if (f13563a || objArr != null) {
            return a(objArr[0], objArr[1]);
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[SYNTHETIC, Splitter:B:31:0x0083] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(java.io.OutputStream r9) {
        /*
            java.lang.String r0 = "UTF-8"
            boolean r1 = com.uc.crashsdk.b.f13531d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x003d
            java.lang.String r0 = com.uc.crashsdk.b.o()
            f13571h = r2
            r1 = 17
            long r1 = com.uc.crashsdk.JNIBridge.cmd(r1, r0)
            r4 = 1
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x003a
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            byte[] r0 = com.uc.crashsdk.a.g.e(r1)     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x002d
            r9.write(r0)     // Catch:{ all -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r9)
        L_0x002d:
            r1.delete()     // Catch:{ all -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r9)
        L_0x0035:
            f13571h = r3
            a((java.io.OutputStream) r9)
        L_0x003a:
            f13571h = r3
            return
        L_0x003d:
            r1 = 0
            int r4 = com.uc.crashsdk.g.K()     // Catch:{ all -> 0x007b }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0079 }
            java.lang.String r6 = "/proc/self/fd"
            r5.<init>(r6)     // Catch:{ all -> 0x0079 }
            java.io.File[] r1 = r5.listFiles()     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x006f
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x0079 }
            java.lang.String r6 = "opened file count: %d, write limit: %d.\n"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0079 }
            int r8 = r1.length     // Catch:{ all -> 0x0079 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0079 }
            r7[r2] = r8     // Catch:{ all -> 0x0079 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0079 }
            r7[r3] = r8     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = java.lang.String.format(r5, r6, r7)     // Catch:{ all -> 0x0079 }
            byte[] r3 = r3.getBytes(r0)     // Catch:{ all -> 0x0079 }
            r9.write(r3)     // Catch:{ all -> 0x0079 }
            goto L_0x0081
        L_0x006f:
            java.lang.String r3 = "[DEBUG] listFiles failed!\n"
            byte[] r3 = r3.getBytes(r0)     // Catch:{ all -> 0x0079 }
            r9.write(r3)     // Catch:{ all -> 0x0079 }
            goto L_0x0081
        L_0x0079:
            r3 = move-exception
            goto L_0x007e
        L_0x007b:
            r3 = move-exception
            r4 = 900(0x384, float:1.261E-42)
        L_0x007e:
            a((java.lang.Throwable) r3, (java.io.OutputStream) r9)
        L_0x0081:
            if (r1 == 0) goto L_0x00c8
            int r3 = r1.length     // Catch:{ all -> 0x00c4 }
            if (r3 < r4) goto L_0x00c8
            java.lang.String r3 = "opened files:\n"
            byte[] r3 = r3.getBytes(r0)     // Catch:{ all -> 0x00c4 }
            r9.write(r3)     // Catch:{ all -> 0x00c4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
            r3.<init>()     // Catch:{ all -> 0x00c4 }
            int r4 = r1.length     // Catch:{ all -> 0x00b4 }
        L_0x0095:
            if (r2 >= r4) goto L_0x00b8
            r5 = r1[r2]     // Catch:{ all -> 0x00b4 }
            java.lang.String r6 = r5.getName()     // Catch:{ all -> 0x00b4 }
            r3.append(r6)     // Catch:{ all -> 0x00b4 }
            java.lang.String r6 = " -> "
            r3.append(r6)     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = r5.getCanonicalPath()     // Catch:{ all -> 0x00b4 }
            r3.append(r5)     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "\n"
            r3.append(r5)     // Catch:{ all -> 0x00b4 }
            int r2 = r2 + 1
            goto L_0x0095
        L_0x00b4:
            r1 = move-exception
            a((java.lang.Throwable) r1, (java.io.OutputStream) r9)     // Catch:{ all -> 0x00c4 }
        L_0x00b8:
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00c4 }
            byte[] r0 = r1.getBytes(r0)     // Catch:{ all -> 0x00c4 }
            r9.write(r0)     // Catch:{ all -> 0x00c4 }
            goto L_0x00c8
        L_0x00c4:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r9)
        L_0x00c8:
            a((java.io.OutputStream) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.c(java.io.OutputStream):void");
    }

    public static String g() {
        StringBuilder sb;
        try {
            sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            ActivityManager activityManager = (ActivityManager) g.a().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                sb.append("availMem:   ");
                sb.append(memoryInfo.availMem / 1024);
                sb.append(" kB\n");
                sb.append("threshold:  ");
                sb.append(memoryInfo.threshold / 1024);
                sb.append(" kB\n");
                sb.append("lowMemory:  ");
                sb.append(memoryInfo.lowMemory);
                sb.append("\n");
            }
        } catch (Throwable th) {
            g.a(th);
            return "";
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void d(java.io.OutputStream r12) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r2 = 0
            int r3 = com.uc.crashsdk.g.L()     // Catch:{ all -> 0x001c }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "/proc/self/task"
            r4.<init>(r5)     // Catch:{ all -> 0x001a }
            java.io.File[] r1 = r4.listFiles()     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0016
            return
        L_0x0016:
            int r4 = r1.length     // Catch:{ all -> 0x001a }
            if (r4 >= r3) goto L_0x0023
            return
        L_0x001a:
            r4 = move-exception
            goto L_0x001f
        L_0x001c:
            r4 = move-exception
            r3 = 300(0x12c, float:4.2E-43)
        L_0x001f:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r4)
            r4 = 0
        L_0x0023:
            if (r1 != 0) goto L_0x0026
            return
        L_0x0026:
            java.lang.String r5 = "threads info:\n"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ all -> 0x008e }
            r12.write(r5)     // Catch:{ all -> 0x008e }
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "threads count: %d, dump limit: %d.\n"
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x008e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x008e }
            r8[r2] = r4     // Catch:{ all -> 0x008e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x008e }
            r4 = 1
            r8[r4] = r3     // Catch:{ all -> 0x008e }
            java.lang.String r3 = java.lang.String.format(r5, r6, r8)     // Catch:{ all -> 0x008e }
            byte[] r3 = r3.getBytes(r0)     // Catch:{ all -> 0x008e }
            r12.write(r3)     // Catch:{ all -> 0x008e }
            java.lang.String r3 = " tid     name\n"
            byte[] r3 = r3.getBytes(r0)     // Catch:{ all -> 0x008e }
            r12.write(r3)     // Catch:{ all -> 0x008e }
            int r3 = r1.length     // Catch:{ all -> 0x008e }
            r5 = 0
        L_0x0059:
            if (r5 >= r3) goto L_0x0092
            r6 = r1[r5]     // Catch:{ all -> 0x008e }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x008e }
            java.lang.String r9 = r6.getPath()     // Catch:{ all -> 0x008e }
            java.lang.String r10 = "comm"
            r8.<init>(r9, r10)     // Catch:{ all -> 0x008e }
            r9 = 128(0x80, float:1.794E-43)
            java.lang.String r8 = com.uc.crashsdk.a.g.a((java.io.File) r8, (int) r9, (boolean) r2)     // Catch:{ all -> 0x008e }
            java.lang.String r8 = l(r8)     // Catch:{ all -> 0x008e }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x008e }
            java.lang.String r10 = "%5s %s\n"
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch:{ all -> 0x008e }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x008e }
            r11[r2] = r6     // Catch:{ all -> 0x008e }
            r11[r4] = r8     // Catch:{ all -> 0x008e }
            java.lang.String r6 = java.lang.String.format(r9, r10, r11)     // Catch:{ all -> 0x008e }
            byte[] r6 = r6.getBytes(r0)     // Catch:{ all -> 0x008e }
            r12.write(r6)     // Catch:{ all -> 0x008e }
            int r5 = r5 + 1
            goto L_0x0059
        L_0x008e:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r12)
        L_0x0092:
            a((java.io.OutputStream) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.d(java.io.OutputStream):void");
    }

    private static void f(OutputStream outputStream) {
        String str;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ag) {
                str = s("LASTVER");
            } else {
                str = a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", new Object[]{str}).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = f13582s;
            synchronized (arrayList) {
                if (f13584u != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", new Object[]{f13584u}).getBytes("UTF-8"));
                }
                if (f13583t > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", new Object[]{Integer.valueOf(f13583t)}).getBytes("UTF-8"));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", new Object[]{it.next()}).getBytes("UTF-8"));
                    }
                }
            }
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "dumping all threads: %s\n", new Object[]{Boolean.valueOf(f13585v)}).getBytes("UTF-8"));
            String str2 = f13586w;
            if (str2 != null) {
                outputStream.write(String.format(locale, "dumping threads: %s\n", new Object[]{str2}).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static String k() {
        String str = f13587x;
        if (g.a(str)) {
            synchronized (f13588y) {
                str = g.a(b.i(), g.z(), true);
                f13587x = str;
            }
        }
        return str;
    }

    public static void l() {
        synchronized (f13588y) {
            f13587x = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0171, code lost:
        if (com.uc.crashsdk.b.q() != false) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0177, code lost:
        if (com.uc.crashsdk.a.d.e() != false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0179, code lost:
        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0182, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0189, code lost:
        if (d(com.uc.crashsdk.export.LogType.UNEXP_TYPE) != false) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x018b, code lost:
        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0192, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0193, code lost:
        r8 = com.uc.crashsdk.JNIBridge.nativeGenerateUnexpLog((long) com.uc.crashsdk.g.p(), com.uc.crashsdk.g.q());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01a0, code lost:
        if (r8 == 0) goto L_0x01ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01a2, code lost:
        com.uc.crashsdk.f.a(11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01a9, code lost:
        if ((r8 & 4352) == 0) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01ab, code lost:
        Z = 105;
        r8 = 30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01b1, code lost:
        com.uc.crashsdk.f.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01b7, code lost:
        if ((r8 & com.uc.crashsdk.export.LogType.UNEXP_EXIT) == 0) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01b9, code lost:
        Z = 104;
        r8 = 31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01c2, code lost:
        if ((r8 & com.uc.crashsdk.export.LogType.UNEXP_RESTART) == 0) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01c4, code lost:
        Z = 106;
        r8 = 32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01cd, code lost:
        if ((r8 & 1280) == 0) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01cf, code lost:
        Z = 103;
        com.uc.crashsdk.f.a(10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x01d9, code lost:
        if ((r8 & com.uc.crashsdk.export.LogType.UNEXP_LOW_MEMORY) == 0) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01db, code lost:
        Z = 107;
        com.uc.crashsdk.f.a(29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01e3, code lost:
        Z = 102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01e7, code lost:
        a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01ea, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        X = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01ed, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x01ee, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x01f2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0111, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r7, java.lang.Object[] r8) {
        /*
            r0 = 29
            r1 = 0
            r2 = 10
            r3 = 0
            r4 = 1
            switch(r7) {
                case 401: goto L_0x01f6;
                case 402: goto L_0x0161;
                case 403: goto L_0x015d;
                case 404: goto L_0x000a;
                case 405: goto L_0x0144;
                case 406: goto L_0x011e;
                case 407: goto L_0x0115;
                case 408: goto L_0x00d9;
                case 409: goto L_0x00d5;
                case 410: goto L_0x00d1;
                case 411: goto L_0x00b8;
                case 412: goto L_0x007f;
                case 413: goto L_0x0079;
                case 414: goto L_0x0052;
                case 415: goto L_0x000f;
                case 416: goto L_0x004e;
                default: goto L_0x000a;
            }
        L_0x000a:
            boolean r7 = f13563a
            if (r7 == 0) goto L_0x0218
            return
        L_0x000f:
            boolean r7 = f13563a
            if (r7 != 0) goto L_0x001c
            if (r8 == 0) goto L_0x0016
            goto L_0x001c
        L_0x0016:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x001c:
            r7 = r8[r3]
            java.lang.Long r7 = (java.lang.Long) r7
            long r7 = r7.longValue()
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            long r1 = r0.getTimeInMillis()
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0042
            com.uc.crashsdk.a.h.g()
            r7 = 100
            com.uc.crashsdk.f.a((int) r7)
            d((boolean) r4)
            com.uc.crashsdk.f.a((boolean) r4)
            com.uc.crashsdk.a.h.b()
            goto L_0x004b
        L_0x0042:
            com.uc.crashsdk.a.h.h()
            com.uc.crashsdk.a.h.i()
            com.uc.crashsdk.a.h.c()
        L_0x004b:
            a((java.util.Calendar) r0)
        L_0x004e:
            W()
            return
        L_0x0052:
            android.content.Context r7 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x0074 }
            boolean r7 = d((android.content.Context) r7)     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x005d
            return
        L_0x005d:
            int r7 = N     // Catch:{ all -> 0x0074 }
            int r7 = r7 + r4
            N = r7     // Catch:{ all -> 0x0074 }
            if (r7 < r2) goto L_0x0070
            boolean r7 = com.uc.crashsdk.b.f13531d     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x006f
            java.lang.String r7 = "(get failed)"
            r8 = 130(0x82, float:1.82E-43)
            com.uc.crashsdk.JNIBridge.set((int) r8, (java.lang.String) r7)     // Catch:{ all -> 0x0074 }
        L_0x006f:
            return
        L_0x0070:
            X()     // Catch:{ all -> 0x0074 }
            return
        L_0x0074:
            r7 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r7)
            return
        L_0x0079:
            r7 = 8
            com.uc.crashsdk.JNIBridge.cmd(r7)
            return
        L_0x007f:
            boolean r7 = R
            if (r7 != 0) goto L_0x0097
            boolean r7 = com.uc.crashsdk.b.B()
            if (r7 == 0) goto L_0x0097
            boolean r7 = com.uc.crashsdk.g.N()
            if (r7 == 0) goto L_0x0097
            android.content.Context r7 = com.uc.crashsdk.a.g.a()
            b((android.content.Context) r7)
            return
        L_0x0097:
            boolean r7 = R
            if (r7 == 0) goto L_0x00b7
            boolean r7 = com.uc.crashsdk.b.B()
            if (r7 == 0) goto L_0x00a7
            boolean r7 = com.uc.crashsdk.g.N()
            if (r7 != 0) goto L_0x00b7
        L_0x00a7:
            android.content.Context r7 = com.uc.crashsdk.a.g.a()
            com.uc.crashsdk.e$c r8 = Q     // Catch:{ all -> 0x00b3 }
            r7.unregisterReceiver(r8)     // Catch:{ all -> 0x00b3 }
            R = r3     // Catch:{ all -> 0x00b3 }
            return
        L_0x00b3:
            r7 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r7)
        L_0x00b7:
            return
        L_0x00b8:
            boolean r7 = com.uc.crashsdk.b.f13531d
            if (r7 == 0) goto L_0x00d0
            java.lang.String r7 = "jni"
            boolean r7 = d((java.lang.String) r7)
            r8 = 28
            com.uc.crashsdk.JNIBridge.set((int) r8, (boolean) r7)
            java.lang.String r7 = "anr"
            boolean r7 = d((java.lang.String) r7)
            com.uc.crashsdk.JNIBridge.set((int) r0, (boolean) r7)
        L_0x00d0:
            return
        L_0x00d1:
            a((boolean) r3, (boolean) r4)
            return
        L_0x00d5:
            d((boolean) r3)
            return
        L_0x00d9:
            java.lang.Object r7 = f13565ab
            monitor-enter(r7)
            boolean r8 = ac     // Catch:{ all -> 0x0112 }
            if (r8 != 0) goto L_0x0110
            boolean r8 = com.uc.crashsdk.g.R()     // Catch:{ all -> 0x0112 }
            if (r8 == 0) goto L_0x0110
            boolean r8 = com.uc.crashsdk.b.z()     // Catch:{ all -> 0x0112 }
            if (r8 != 0) goto L_0x00ed
            goto L_0x0110
        L_0x00ed:
            com.uc.crashsdk.b.s()     // Catch:{ all -> 0x0112 }
            com.uc.crashsdk.a.h.f()     // Catch:{ all -> 0x0112 }
            com.uc.crashsdk.f.c()     // Catch:{ all -> 0x0112 }
            boolean r8 = com.uc.crashsdk.b.F()     // Catch:{ all -> 0x0112 }
            if (r8 == 0) goto L_0x00ff
            C()     // Catch:{ all -> 0x0112 }
        L_0x00ff:
            boolean r8 = com.uc.crashsdk.g.R()     // Catch:{ all -> 0x0112 }
            if (r8 == 0) goto L_0x010c
            java.util.Calendar r8 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x0112 }
            a((java.util.Calendar) r8)     // Catch:{ all -> 0x0112 }
        L_0x010c:
            ac = r4     // Catch:{ all -> 0x0112 }
            monitor-exit(r7)     // Catch:{ all -> 0x0112 }
            return
        L_0x0110:
            monitor-exit(r7)     // Catch:{ all -> 0x0112 }
            return
        L_0x0112:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0112 }
            throw r8
        L_0x0115:
            com.uc.crashsdk.a.d()     // Catch:{ all -> 0x0119 }
            return
        L_0x0119:
            r7 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r7)
            return
        L_0x011e:
            boolean r7 = f13563a
            if (r7 != 0) goto L_0x012b
            if (r8 == 0) goto L_0x0125
            goto L_0x012b
        L_0x0125:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x012b:
            r7 = r8[r3]
            java.lang.String r7 = (java.lang.String) r7
            r0 = r8[r4]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 2
            r8 = r8[r1]
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            a((java.lang.String) r7, (boolean) r0, (boolean) r8)
            return
        L_0x0144:
            L = r3
            java.lang.StringBuilder r7 = Y()
            java.lang.String r8 = com.uc.crashsdk.b.g()
            if (r7 == 0) goto L_0x015c
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            java.lang.String r7 = r7.toString()
            com.uc.crashsdk.a.g.a((java.io.File) r0, (java.lang.String) r7)
        L_0x015c:
            return
        L_0x015d:
            ab()
            return
        L_0x0161:
            java.lang.Object r7 = Y
            monitor-enter(r7)
            java.lang.Runnable r8 = X     // Catch:{ all -> 0x01f3 }
            if (r8 != 0) goto L_0x016a
            monitor-exit(r7)     // Catch:{ all -> 0x01f3 }
            return
        L_0x016a:
            W = r4     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)     // Catch:{ all -> 0x01f3 }
            boolean r8 = com.uc.crashsdk.b.q()
            if (r8 != 0) goto L_0x01f2
            boolean r8 = com.uc.crashsdk.a.d.e()
            if (r8 != 0) goto L_0x0183
            java.lang.String r7 = "DEBUG"
            java.lang.String r8 = com.uc.crashsdk.a.d.b()
            com.uc.crashsdk.a.a.c(r7, r8)
            return
        L_0x0183:
            java.lang.String r8 = "unexp"
            boolean r8 = d((java.lang.String) r8)
            if (r8 != 0) goto L_0x0193
            java.lang.String r7 = "DEBUG"
            java.lang.String r8 = "unexp sample miss"
            com.uc.crashsdk.a.a.d(r7, r8)
            return
        L_0x0193:
            int r8 = com.uc.crashsdk.g.p()
            long r5 = (long) r8
            int r8 = com.uc.crashsdk.g.q()
            int r8 = com.uc.crashsdk.JNIBridge.nativeGenerateUnexpLog(r5, r8)
            if (r8 == 0) goto L_0x01ea
            r3 = 11
            com.uc.crashsdk.f.a((int) r3)
            r3 = r8 & 4352(0x1100, float:6.098E-42)
            if (r3 == 0) goto L_0x01b5
            r8 = 105(0x69, float:1.47E-43)
            Z = r8
            r8 = 30
        L_0x01b1:
            com.uc.crashsdk.f.a((int) r8)
            goto L_0x01e7
        L_0x01b5:
            r3 = r8 & 8448(0x2100, float:1.1838E-41)
            if (r3 == 0) goto L_0x01c0
            r8 = 104(0x68, float:1.46E-43)
            Z = r8
            r8 = 31
            goto L_0x01b1
        L_0x01c0:
            r3 = r8 & 16640(0x4100, float:2.3318E-41)
            if (r3 == 0) goto L_0x01cb
            r8 = 106(0x6a, float:1.49E-43)
            Z = r8
            r8 = 32
            goto L_0x01b1
        L_0x01cb:
            r3 = r8 & 1280(0x500, float:1.794E-42)
            if (r3 == 0) goto L_0x01d7
            r8 = 103(0x67, float:1.44E-43)
            Z = r8
            com.uc.crashsdk.f.a((int) r2)
            goto L_0x01e7
        L_0x01d7:
            r8 = r8 & 2304(0x900, float:3.229E-42)
            if (r8 == 0) goto L_0x01e3
            r8 = 107(0x6b, float:1.5E-43)
            Z = r8
            com.uc.crashsdk.f.a((int) r0)
            goto L_0x01e7
        L_0x01e3:
            r8 = 102(0x66, float:1.43E-43)
            Z = r8
        L_0x01e7:
            a((boolean) r4)
        L_0x01ea:
            monitor-enter(r7)
            X = r1     // Catch:{ all -> 0x01ef }
            monitor-exit(r7)     // Catch:{ all -> 0x01ef }
            return
        L_0x01ef:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x01ef }
            throw r8
        L_0x01f2:
            return
        L_0x01f3:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x01f3 }
            throw r8
        L_0x01f6:
            int r7 = com.uc.crashsdk.b.I()
            r8 = 5
            if (r7 != r8) goto L_0x01ff
            r7 = 1
            goto L_0x0200
        L_0x01ff:
            r7 = 0
        L_0x0200:
            if (r7 == 0) goto L_0x0205
            r7 = 1
            goto L_0x0207
        L_0x0205:
            r7 = 0
        L_0x0207:
            com.uc.crashsdk.JNIBridge.nativeCmd(r2, r7, r1, r1)
            com.uc.crashsdk.a.f13448c = r4
            com.uc.crashsdk.a.a((boolean) r3)
            L = r4
            Z()
            y()
            return
        L_0x0218:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            goto L_0x021f
        L_0x021e:
            throw r7
        L_0x021f:
            goto L_0x021e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(int, java.lang.Object[]):void");
    }

    public static class a extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final long f13591a;

        /* renamed from: b  reason: collision with root package name */
        private final OutputStream f13592b;

        /* renamed from: c  reason: collision with root package name */
        private int f13593c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f13594d = 0;

        /* renamed from: e  reason: collision with root package name */
        private boolean f13595e = false;

        public a(long j10, OutputStream outputStream) {
            this.f13591a = j10;
            this.f13592b = outputStream;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int a(byte[] r7, int r8, int r9) {
            /*
                r6 = this;
                int r0 = r6.f13594d
                int r0 = r0 + r9
                r6.f13594d = r0
                boolean r0 = r6.f13595e
                if (r0 == 0) goto L_0x000b
                r7 = 0
                return r7
            L_0x000b:
                int r0 = com.uc.crashsdk.g.B()
                if (r0 <= 0) goto L_0x0019
                int r1 = r6.f13593c
                int r2 = r1 + r9
                if (r2 <= r0) goto L_0x0019
                int r0 = r0 - r1
                goto L_0x001a
            L_0x0019:
                r0 = r9
            L_0x001a:
                int r1 = r6.f13593c
                int r1 = r1 + r0
                r6.f13593c = r1
                long r1 = r6.f13591a
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x0030
                java.lang.String r1 = new java.lang.String
                r1.<init>(r7, r8, r0)
                r6.b(r1)
                goto L_0x0035
            L_0x0030:
                java.io.OutputStream r1 = r6.f13592b
                r1.write(r7, r8, r0)
            L_0x0035:
                if (r0 >= r9) goto L_0x003a
                r7 = 1
                r6.f13595e = r7
            L_0x003a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (b.f13531d) {
                JNIBridge.nativeClientWriteData(this.f13591a, str);
            }
        }

        public final void write(int i10) {
            if (e.f13571h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", new Object[]{Integer.valueOf(i10)}));
            }
            if (this.f13591a != 0) {
                b(String.format(Locale.US, "%c", new Object[]{Integer.valueOf(i10)}));
            } else {
                this.f13592b.write(i10);
            }
            this.f13593c++;
            this.f13594d++;
        }

        public final void write(byte[] bArr, int i10, int i11) {
            if (e.f13571h && e.O()) {
                byte[] bArr2 = new byte[i11];
                System.arraycopy(bArr, i10, bArr2, 0, i11);
                if (!(i11 == 1 && bArr2[0] == 10)) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i10, i11);
        }

        public final void a() {
            try {
                if (this.f13594d - this.f13593c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                int B = g.B();
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", new Object[]{Integer.valueOf(this.f13594d), Integer.valueOf(this.f13593c), Integer.valueOf(B), Integer.valueOf(this.f13594d - this.f13593c)}));
            } catch (Throwable th) {
                g.a(th);
            }
        }

        public final void write(byte[] bArr) {
            if (e.f13571h && e.O() && !(bArr.length == 1 && bArr[0] == 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        public final void a(String str) {
            if (e.f13571h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.f13591a != 0) {
                b(str);
            } else {
                this.f13592b.write(str.getBytes("UTF-8"));
            }
        }
    }

    public static String h() {
        String str = f13576m;
        if (str != null) {
            return str;
        }
        String a10 = a(Process.myPid());
        f13576m = a10;
        return a10;
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        long f13596a;

        /* renamed from: b  reason: collision with root package name */
        long f13597b;

        /* renamed from: c  reason: collision with root package name */
        int f13598c;

        /* renamed from: d  reason: collision with root package name */
        int f13599d;

        /* renamed from: e  reason: collision with root package name */
        boolean f13600e;

        /* renamed from: f  reason: collision with root package name */
        boolean f13601f;

        /* renamed from: g  reason: collision with root package name */
        boolean f13602g;

        private d() {
            this.f13596a = 0;
            this.f13597b = 0;
            this.f13598c = 0;
            this.f13599d = 0;
            this.f13600e = false;
            this.f13601f = false;
            this.f13602g = false;
        }

        public /* synthetic */ d(byte b10) {
            this();
        }
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static void m() {
        if (!ag) {
            f.a(1, new com.uc.crashsdk.a.e(MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER), 1000);
        }
    }

    public static void p() {
        String str;
        Throwable th;
        if (g.a(B)) {
            String str2 = null;
            try {
                File file = new File(g.X() + "unique");
                if (file.exists()) {
                    str = g.a(file, 48, false);
                    if (str != null) {
                        try {
                            if (str.length() == 36) {
                                str2 = str.replaceAll("[^0-9a-zA-Z-]", Operator.Operation.MINUS);
                            }
                        } catch (Exception e10) {
                            g.a((Throwable) e10);
                        } catch (Throwable th2) {
                            th = th2;
                            g.a(th);
                            str2 = str;
                            B = str2;
                        }
                    }
                    str2 = str;
                }
                if (g.a(str2)) {
                    b.G();
                    str2 = UUID.randomUUID().toString();
                    if (!g.a(str2)) {
                        g.a(file, str2.getBytes());
                    }
                }
            } catch (Throwable th3) {
                str = str2;
                th = th3;
                g.a(th);
                str2 = str;
                B = str2;
            }
            B = str2;
        }
    }

    public static String q() {
        return B;
    }

    public static void r() {
        O = false;
        if (!b.B()) {
            f.a(3, new com.uc.crashsdk.a.e(416), 11000);
        }
        if (!V()) {
            N = 0;
            X();
        }
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String str3;
        String str4;
        OutputStream outputStream2 = outputStream;
        try {
            outputStream2.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream2);
        }
        try {
            Locale locale = Locale.US;
            outputStream2.write(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", new Object[]{Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()}).getBytes("UTF-8"));
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (g.a(f13575l)) {
                T();
            }
            objArr[1] = f13575l;
            objArr[2] = f();
            outputStream2.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream2);
        }
        try {
            Locale locale2 = Locale.US;
            outputStream2.write(String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", new Object[]{Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)}).getBytes("UTF-8"));
            outputStream2.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(f13566b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = g.d();
            objArr2[3] = b.B() ? "fg" : "bg";
            outputStream2.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream2);
        }
        try {
            Locale locale3 = Locale.US;
            outputStream2.write(String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", new Object[]{g.U(), g.V(), g.W(), Integer.valueOf(a.c())}).getBytes("UTF-8"));
            String str5 = "0";
            String str6 = "";
            if (b.f13531d) {
                String nativeGet = JNIBridge.nativeGet(1, 0, (String) null);
                str4 = JNIBridge.nativeGet(2, 0, (String) null);
                str5 = nativeGet;
            } else {
                str4 = str6;
            }
            outputStream2.write(String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", new Object[]{"3.3.2.2", str5, "240515102041", str4, "umeng"}).getBytes("UTF-8"));
            if (str != null) {
                str6 = str;
            }
            outputStream2.write(("Report Name: " + str6.substring(str6.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream2);
        }
        try {
            if (ag) {
                str3 = s("UUID");
            } else {
                str3 = B;
            }
            outputStream2.write(String.format("UUID: %s\n", new Object[]{str3}).getBytes("UTF-8"));
            outputStream2.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream2);
        }
        try {
            String E2 = b.E();
            if (g.a(E2)) {
                E2 = "(none)";
            }
            outputStream2.write(("Activity: " + E2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream2);
        }
        a(outputStream);
        try {
            a.a(outputStream2, "UTF-8");
            if (ag) {
                f13571h = false;
                outputStream2.write(s("HEADER").getBytes("UTF-8"));
                f13571h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream2);
        }
        a(outputStream);
    }

    public static String n() {
        return a(new Date());
    }

    public static boolean d(String str) {
        if (ag) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            g.a(th);
            return true;
        }
    }

    public static void a(boolean z10) {
        File[] listFiles;
        try {
            if (b.y() && (listFiles = new File(g.Y()).listFiles()) != null) {
                int m10 = g.m();
                int n10 = g.n();
                if (listFiles.length >= Math.min(m10, n10)) {
                    int i10 = 0;
                    int i11 = 0;
                    for (File b10 : listFiles) {
                        if (b(b10)) {
                            i10++;
                        } else {
                            i11++;
                        }
                    }
                    int i12 = (!z10 || i10 < m10) ? 0 : (i10 - m10) + 1;
                    int i13 = (z10 || i11 < n10) ? 0 : (i11 - n10) + 1;
                    if (i12 != 0 || i13 != 0) {
                        Arrays.sort(listFiles, new b((byte) 0));
                        int i14 = i12;
                        int i15 = i13;
                        for (File file : listFiles) {
                            boolean b11 = b(file);
                            if (b11 && i14 > 0) {
                                com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file.getPath());
                                file.delete();
                                i14 += -1;
                            } else if (!b11 && i15 > 0) {
                                com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file.getPath());
                                file.delete();
                                i15 += -1;
                            }
                            if (i14 == 0 && i15 == 0) {
                                break;
                            }
                        }
                        f.a(16, i12 + i13);
                        if (i12 > 0) {
                            f.a(22, i12);
                        }
                        if (i13 > 0) {
                            f.a(23, i13);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    /* access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z10 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == myPid) {
                O = true;
                if (O()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (b.f13531d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z10 = true;
            }
        }
        if (!z10 && b.f13531d) {
            W();
        }
        return true;
    }

    public static void o() {
        f13566b = System.currentTimeMillis();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A[SYNTHETIC, Splitter:B:33:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b A[Catch:{ all -> 0x0096, all -> 0x00bd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e(java.io.OutputStream r11) {
        /*
            java.lang.String r0 = "UTF-8"
            boolean r1 = com.uc.crashsdk.b.f13531d
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r1 = "solib build id:\n"
            byte[] r1 = r1.getBytes(r0)     // Catch:{ all -> 0x0011 }
            r11.write(r1)     // Catch:{ all -> 0x0011 }
            goto L_0x0015
        L_0x0011:
            r1 = move-exception
            a((java.lang.Throwable) r1, (java.io.OutputStream) r11)
        L_0x0015:
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00c3 }
            r2.<init>()     // Catch:{ all -> 0x00c3 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x00c3 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = "/proc/self/maps"
            r4.<init>(r5)     // Catch:{ all -> 0x00c3 }
            r3.<init>(r4)     // Catch:{ all -> 0x00c3 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x00bf }
            r5 = 512(0x200, float:7.175E-43)
            r4.<init>(r3, r5)     // Catch:{ all -> 0x00bf }
        L_0x002e:
            java.lang.String r1 = r4.readLine()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00b9
            java.lang.String r5 = ".so"
            boolean r5 = r1.endsWith(r5)     // Catch:{ all -> 0x00bd }
            if (r5 == 0) goto L_0x002e
            r5 = 47
            int r5 = r1.indexOf(r5)     // Catch:{ all -> 0x00bd }
            r6 = -1
            if (r5 == r6) goto L_0x002e
            java.lang.String r1 = r1.substring(r5)     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = "/data/"
            boolean r5 = r1.contains(r5)     // Catch:{ all -> 0x00bd }
            r6 = 0
            r7 = 1
            if (r5 != 0) goto L_0x005e
            java.lang.String r5 = com.uc.crashsdk.a.f13446a     // Catch:{ all -> 0x00bd }
            boolean r5 = r1.contains(r5)     // Catch:{ all -> 0x00bd }
            if (r5 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r5 = 0
            goto L_0x005f
        L_0x005e:
            r5 = 1
        L_0x005f:
            if (r5 == 0) goto L_0x002e
            boolean r5 = r2.contains(r1)     // Catch:{ all -> 0x00bd }
            if (r5 != 0) goto L_0x002e
            r2.add(r1)     // Catch:{ all -> 0x00bd }
            boolean r5 = ag     // Catch:{ all -> 0x00bd }
            r8 = 2
            if (r5 == 0) goto L_0x009b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r5.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r9 = "SOBUILDID"
            java.lang.String r10 = "$^%s`%s^$"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0096 }
            r8[r6] = r9     // Catch:{ all -> 0x0096 }
            r8[r7] = r1     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = java.lang.String.format(r10, r8)     // Catch:{ all -> 0x0096 }
            r5.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "\n"
            r5.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0096 }
            byte[] r1 = r1.getBytes(r0)     // Catch:{ all -> 0x0096 }
            r11.write(r1)     // Catch:{ all -> 0x0096 }
            goto L_0x002e
        L_0x0096:
            r1 = move-exception
            a((java.lang.Throwable) r1, (java.io.OutputStream) r11)     // Catch:{ all -> 0x00bd }
            goto L_0x002e
        L_0x009b:
            r5 = 3
            r9 = 0
            java.lang.String r5 = com.uc.crashsdk.JNIBridge.nativeGet(r5, r9, r1)     // Catch:{ all -> 0x00bd }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x00bd }
            java.lang.String r10 = "%s: %s\n"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x00bd }
            r8[r6] = r1     // Catch:{ all -> 0x00bd }
            r8[r7] = r5     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = java.lang.String.format(r9, r10, r8)     // Catch:{ all -> 0x00bd }
            byte[] r1 = r1.getBytes(r0)     // Catch:{ all -> 0x00bd }
            r11.write(r1)     // Catch:{ all -> 0x00bd }
            goto L_0x002e
        L_0x00b9:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r3)
            goto L_0x00cb
        L_0x00bd:
            r0 = move-exception
            goto L_0x00c1
        L_0x00bf:
            r0 = move-exception
            r4 = r1
        L_0x00c1:
            r1 = r3
            goto L_0x00c5
        L_0x00c3:
            r0 = move-exception
            r4 = r1
        L_0x00c5:
            a((java.lang.Throwable) r0, (java.io.OutputStream) r11)     // Catch:{ all -> 0x00d2 }
            com.uc.crashsdk.a.g.a((java.io.Closeable) r1)
        L_0x00cb:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r4)
            a((java.io.OutputStream) r11)
            return
        L_0x00d2:
            r11 = move-exception
            com.uc.crashsdk.a.g.a((java.io.Closeable) r1)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r4)
            goto L_0x00db
        L_0x00da:
            throw r11
        L_0x00db:
            goto L_0x00da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e(java.io.OutputStream):void");
    }

    public static void c(String str) {
        synchronized (f13589z) {
            String l10 = b.l();
            com.uc.crashsdk.a.b.a(l10, str + "\n");
        }
    }

    public static void d(boolean z10) {
        f.d(false);
        if (z10) {
            f.a(b.c(), false);
            h.i();
            return;
        }
        f.a();
        h.i();
    }

    public static int f(boolean z10) {
        int i10;
        if (z10) {
            i10 = f.a(b.c()) ? 1 : 0;
        } else {
            i10 = f.b();
        }
        int b10 = f.b(z10);
        return b10 > i10 ? b10 : i10;
    }

    public static void c(boolean z10) {
        boolean z11 = true;
        if (!R ? !z10 || !g.N() : z10 && g.N()) {
            z11 = false;
        }
        if (z11) {
            com.uc.crashsdk.a.e eVar = S;
            if (f.b(eVar)) {
                f.a((Runnable) eVar);
            }
            f.a(0, eVar, 3000);
        }
    }

    public static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r6.contains(r9) == false) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x003b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r9, java.lang.String r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x007e }
            r1 = 26
            java.lang.String r2 = "ps"
            r3 = 0
            r4 = 1
            if (r0 < r1) goto L_0x0014
            r0 = 2
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ all -> 0x007e }
            r0[r3] = r2     // Catch:{ all -> 0x007e }
            java.lang.String r1 = "-ef"
            r0[r4] = r1     // Catch:{ all -> 0x007e }
            goto L_0x0018
        L_0x0014:
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ all -> 0x007e }
            r0[r3] = r2     // Catch:{ all -> 0x007e }
        L_0x0018:
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x007e }
            java.lang.Process r0 = r1.exec(r0)     // Catch:{ all -> 0x007e }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x007e }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x007e }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ all -> 0x007e }
            r2.<init>(r0)     // Catch:{ all -> 0x007e }
            r1.<init>(r2)     // Catch:{ all -> 0x007e }
            boolean r0 = com.uc.crashsdk.a.g.b((java.lang.String) r9)     // Catch:{ all -> 0x007e }
            boolean r2 = com.uc.crashsdk.a.g.b((java.lang.String) r10)     // Catch:{ all -> 0x007e }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x007e }
            r5.<init>()     // Catch:{ all -> 0x007e }
        L_0x003b:
            java.lang.String r6 = r1.readLine()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "UTF-8"
            if (r6 == 0) goto L_0x0079
            if (r0 == 0) goto L_0x004b
            boolean r8 = r6.contains(r9)     // Catch:{ all -> 0x007e }
            if (r8 != 0) goto L_0x0053
        L_0x004b:
            if (r2 == 0) goto L_0x0055
            boolean r8 = r6.contains(r10)     // Catch:{ all -> 0x007e }
            if (r8 == 0) goto L_0x0055
        L_0x0053:
            r8 = 1
            goto L_0x0066
        L_0x0055:
            r8 = 47
            int r8 = r6.indexOf(r8)     // Catch:{ all -> 0x007e }
            if (r8 >= 0) goto L_0x0065
            r8 = 46
            int r8 = r6.indexOf(r8)     // Catch:{ all -> 0x007e }
            if (r8 > 0) goto L_0x0053
        L_0x0065:
            r8 = 0
        L_0x0066:
            if (r8 == 0) goto L_0x003b
            byte[] r6 = r6.getBytes(r7)     // Catch:{ all -> 0x007e }
            r5.write(r6)     // Catch:{ all -> 0x007e }
            java.lang.String r6 = "\n"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ all -> 0x007e }
            r5.write(r6)     // Catch:{ all -> 0x007e }
            goto L_0x003b
        L_0x0079:
            java.lang.String r9 = r5.toString(r7)     // Catch:{ all -> 0x007e }
            return r9
        L_0x007e:
            r9 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r9)
            java.lang.String r9 = "exception exists."
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i10 = 8192;
        while (bufferedReader == null && i10 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i10);
            } catch (Throwable unused) {
                i10 /= 2;
                if (i10 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    public static boolean e(String str) {
        try {
            if (!g.b(str) || !str.startsWith(ContextPath.LIB) || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    private static String a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable unused) {
            str = null;
        }
        return g.a(str) ? file.getPath() : str;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035 A[Catch:{ all -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(android.os.StatFs r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<android.os.StatFs> r0 = android.os.StatFs.class
            r1 = 1
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x0020 }
            java.lang.reflect.Method r5 = r0.getDeclaredMethod(r5, r3)     // Catch:{ all -> 0x0020 }
            r5.setAccessible(r1)     // Catch:{ all -> 0x0020 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0020 }
            java.lang.Object r5 = r5.invoke(r4, r3)     // Catch:{ all -> 0x0020 }
            if (r5 == 0) goto L_0x0020
            boolean r3 = r5 instanceof java.lang.Long     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x0020
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0020 }
            long r4 = r5.longValue()     // Catch:{ all -> 0x0020 }
            return r4
        L_0x0020:
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x003d }
            java.lang.reflect.Method r5 = r0.getDeclaredMethod(r6, r5)     // Catch:{ all -> 0x003d }
            r5.setAccessible(r1)     // Catch:{ all -> 0x003d }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x003d }
            java.lang.Object r4 = r5.invoke(r4, r6)     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x0041
            boolean r5 = r4 instanceof java.lang.Integer     // Catch:{ all -> 0x003d }
            if (r5 == 0) goto L_0x0041
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x003d }
            int r4 = r4.intValue()     // Catch:{ all -> 0x003d }
            long r4 = (long) r4
            return r4
        L_0x003d:
            r4 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r4)
        L_0x0041:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(android.os.StatFs, java.lang.String, java.lang.String):long");
    }

    public static int e(boolean z10) {
        return f.a(z10);
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
            if (g.o() <= 0) {
                outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                a(outputStream);
                g.a((Closeable) null);
                return;
            }
            int o10 = g.o();
            bufferedReader = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.f.ax, "-b", MediaTrack.ROLE_MAIN, "-v", "threadtime", "-t", String.valueOf(o10)}).getInputStream()));
            if (bufferedReader == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                g.a((Closeable) bufferedReader);
                return;
            }
            f13571h = false;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    i10++;
                    if (i11 < o10 && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                        outputStream.write(readLine.getBytes("UTF-8"));
                        outputStream.write("\n".getBytes("UTF-8"));
                        i11++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th2) {
                        a(th2, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}).getBytes("UTF-8"));
            f13571h = true;
            g.a((Closeable) bufferedReader);
            a(outputStream);
        } catch (Throwable th3) {
            try {
                f13571h = true;
                a(th3, outputStream);
            } catch (Throwable th4) {
                g.a((Closeable) bufferedReader);
                throw th4;
            }
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", new Object[]{n()}));
        } catch (Throwable th) {
            a(th, (OutputStream) aVar);
        }
    }

    public static int a(OutputStream outputStream, String str, int i10) {
        int i11 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String a10 = com.uc.crashsdk.a.b.a(str);
            if (a10 == null) {
                a10 = "file: '" + str + "' not found or decode failed!";
            }
            int length = a10.length();
            if (length <= i10 + 32) {
                i10 = length;
            }
            if (i10 > 0) {
                try {
                    outputStream.write(a10.getBytes("UTF-8"), 0, i10);
                    outputStream.write("\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    i11 = i10;
                    a(th, outputStream);
                    i10 = i11;
                    a(outputStream);
                    return i10;
                }
            }
            if (i10 < a10.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", new Object[]{Integer.valueOf(a10.length() - i10)}).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
            a(th, outputStream);
            i10 = i11;
            a(outputStream);
            return i10;
        }
        a(outputStream);
        return i10;
    }

    public static String a(int i10) {
        try {
            String a10 = g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i10)})), 128, false);
            if (g.b(a10)) {
                return l(a10);
            }
            return "unknown";
        } catch (Throwable th) {
            g.a(th);
            return "unknown";
        }
    }

    private static void b(a aVar) {
        f13571h = false;
        try {
            aVar.write((s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (Throwable th) {
            g.a(th);
        }
        f13571h = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:228:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x037b A[SYNTHETIC, Splitter:B:234:0x037b] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0430 A[Catch:{ all -> 0x0358, all -> 0x0494 }] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x045f A[Catch:{ all -> 0x0358, all -> 0x0494 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x048d  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x04ba  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x04c1 A[Catch:{ all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x04ca A[Catch:{ all -> 0x04d2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.Throwable r23, java.lang.String r24, long r25, boolean r27) {
        /*
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r5 = "\n"
            java.lang.String r6 = "'\n"
            java.lang.String r7 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n"
            java.lang.String r8 = "UTF-8"
            r9 = 0
            r11 = 0
            boolean r0 = com.uc.crashsdk.b.L()     // Catch:{ all -> 0x04a0 }
            r12 = 1
            if (r0 != 0) goto L_0x0022
            com.uc.crashsdk.g.a()     // Catch:{ all -> 0x001f }
            a((boolean) r12)     // Catch:{ all -> 0x001f }
            goto L_0x0022
        L_0x001f:
            r0 = move-exception
            goto L_0x04a2
        L_0x0022:
            int r0 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x001f }
            r0.<init>(r2)     // Catch:{ all -> 0x001f }
            r13 = r0
            goto L_0x002e
        L_0x002d:
            r13 = r11
        L_0x002e:
            com.uc.crashsdk.e$a r14 = new com.uc.crashsdk.e$a     // Catch:{ all -> 0x049b }
            r14.<init>(r3, r13)     // Catch:{ all -> 0x049b }
            boolean r0 = com.uc.crashsdk.b.f13531d     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0041
            r0 = 126(0x7e, float:1.77E-43)
            com.uc.crashsdk.JNIBridge.set((int) r0, (java.lang.String) r2)     // Catch:{ all -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0496 }
        L_0x0041:
            java.lang.String r0 = S()     // Catch:{ all -> 0x0496 }
            b((java.io.OutputStream) r14, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0496 }
            if (r27 == 0) goto L_0x0053
            r14.flush()     // Catch:{ all -> 0x004e }
            goto L_0x0053
        L_0x004e:
            r0 = move-exception
            r15 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r15)     // Catch:{ all -> 0x0496 }
        L_0x0053:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            java.lang.String r15 = "Process Name: '"
            r0.<init>(r15)     // Catch:{ all -> 0x0090 }
            java.lang.String r15 = h()     // Catch:{ all -> 0x0090 }
            r0.append(r15)     // Catch:{ all -> 0x0090 }
            r0.append(r6)     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0090 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0090 }
            r14.write(r0)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            java.lang.String r15 = "Thread Name: '"
            r0.<init>(r15)     // Catch:{ all -> 0x0090 }
            java.lang.Thread r15 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0090 }
            java.lang.String r15 = r15.getName()     // Catch:{ all -> 0x0090 }
            r0.append(r15)     // Catch:{ all -> 0x0090 }
            r0.append(r6)     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0090 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0090 }
            r14.write(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0496 }
        L_0x0094:
            java.lang.String r0 = "Back traces starts.\n"
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x00e9 }
            r14.write((byte[]) r0)     // Catch:{ all -> 0x00e9 }
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            java.lang.String r6 = "detailMessage"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r6)     // Catch:{ all -> 0x00bc }
            r0.setAccessible(r12)     // Catch:{ all -> 0x00bc }
            java.lang.Object r6 = r0.get(r1)     // Catch:{ all -> 0x00bc }
            if (r6 == 0) goto L_0x00c0
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00bc }
            java.lang.String r15 = "\n\t"
            java.lang.String r9 = "\n->  "
            java.lang.String r6 = r6.replaceAll(r15, r9)     // Catch:{ all -> 0x00bc }
            r0.set(r1, r6)     // Catch:{ all -> 0x00bc }
            goto L_0x00c0
        L_0x00bc:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x00e9 }
        L_0x00c0:
            java.lang.String r0 = r23.getMessage()     // Catch:{ all -> 0x00e9 }
            if (r0 == 0) goto L_0x00ed
            java.lang.String r6 = r23.getLocalizedMessage()     // Catch:{ all -> 0x00e9 }
            boolean r6 = r0.equals(r6)     // Catch:{ all -> 0x00e9 }
            if (r6 != 0) goto L_0x00ed
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = "Message: "
            r6.<init>(r9)     // Catch:{ all -> 0x00e9 }
            r6.append(r0)     // Catch:{ all -> 0x00e9 }
            r6.append(r5)     // Catch:{ all -> 0x00e9 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00e9 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x00e9 }
            r14.write((byte[]) r0)     // Catch:{ all -> 0x00e9 }
            goto L_0x00ed
        L_0x00e9:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0496 }
        L_0x00ed:
            java.io.PrintStream r0 = new java.io.PrintStream     // Catch:{ all -> 0x00f6 }
            r0.<init>(r14)     // Catch:{ all -> 0x00f6 }
            r1.printStackTrace(r0)     // Catch:{ all -> 0x00f6 }
            goto L_0x00fa
        L_0x00f6:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0496 }
        L_0x00fa:
            java.lang.String r0 = "Back traces ends.\n"
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0104 }
            r14.write((byte[]) r0)     // Catch:{ all -> 0x0104 }
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0496 }
        L_0x0108:
            a((java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
            r14.flush()     // Catch:{ all -> 0x010f }
            goto L_0x0114
        L_0x010f:
            r0 = move-exception
            r1 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0496 }
        L_0x0114:
            com.uc.crashsdk.a.a((java.io.OutputStream) r14, (java.lang.String) r8, (java.lang.String) r7)     // Catch:{ all -> 0x0118 }
            goto L_0x011d
        L_0x0118:
            r0 = move-exception
            r1 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0496 }
        L_0x011d:
            if (r27 == 0) goto L_0x0128
            r14.flush()     // Catch:{ all -> 0x0123 }
            goto L_0x0128
        L_0x0123:
            r0 = move-exception
            r1 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0496 }
        L_0x0128:
            r1 = 10240(0x2800, float:1.4349E-41)
            java.lang.String r0 = "/proc/meminfo"
            java.lang.String r6 = "meminfo:\n"
            byte[] r6 = r6.getBytes(r8)     // Catch:{ all -> 0x0139 }
            r14.write(r6)     // Catch:{ all -> 0x0139 }
            b((java.io.OutputStream) r14, (java.lang.String) r0, (int) r1)     // Catch:{ all -> 0x0139 }
            goto L_0x013d
        L_0x0139:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x013d:
            r6 = 0
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x015f }
            java.lang.String r9 = "/proc/%d/status"
            java.lang.Object[] r10 = new java.lang.Object[r12]     // Catch:{ all -> 0x015f }
            int r15 = android.os.Process.myPid()     // Catch:{ all -> 0x015f }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x015f }
            r10[r6] = r15     // Catch:{ all -> 0x015f }
            java.lang.String r0 = java.lang.String.format(r0, r9, r10)     // Catch:{ all -> 0x015f }
            java.lang.String r9 = "status:\n"
            byte[] r9 = r9.getBytes(r8)     // Catch:{ all -> 0x015f }
            r14.write(r9)     // Catch:{ all -> 0x015f }
            b((java.io.OutputStream) r14, (java.lang.String) r0, (int) r1)     // Catch:{ all -> 0x015f }
            goto L_0x0163
        L_0x015f:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x0163:
            java.lang.String r0 = "memory info:\n"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0180 }
            r1.<init>()     // Catch:{ all -> 0x0180 }
            r1.append(r0)     // Catch:{ all -> 0x0180 }
            java.lang.String r0 = g()     // Catch:{ all -> 0x0180 }
            r1.append(r0)     // Catch:{ all -> 0x0180 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0180 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0180 }
            r14.write(r0)     // Catch:{ all -> 0x0180 }
            goto L_0x0184
        L_0x0180:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x0184:
            a((java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
            f((java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
            com.uc.crashsdk.a.a((java.io.OutputStream) r14, (java.lang.String) r8, (java.util.ArrayList<java.lang.String>) r11)     // Catch:{ all -> 0x018e }
            goto L_0x0193
        L_0x018e:
            r0 = move-exception
            r1 = r0
            a((java.lang.Throwable) r1, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x0193:
            boolean r0 = ag     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x01ad
            f13571h = r6     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = "JAVADUMPFILES"
            java.lang.String r0 = s(r0)     // Catch:{ all -> 0x01a7 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x01a7 }
            r14.write(r0)     // Catch:{ all -> 0x01a7 }
            goto L_0x01ab
        L_0x01a7:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x01ab:
            f13571h = r12     // Catch:{ all -> 0x0496 }
        L_0x01ad:
            r14.flush()     // Catch:{ all -> 0x01b1 }
            goto L_0x01b6
        L_0x01b1:
            r0 = move-exception
            r1 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0496 }
        L_0x01b6:
            b((java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
            r14.flush()     // Catch:{ all -> 0x01bd }
            goto L_0x01c2
        L_0x01bd:
            r0 = move-exception
            r1 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0496 }
        L_0x01c2:
            java.lang.String r0 = "battery info:\n"
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x01cc }
            r14.write(r0)     // Catch:{ all -> 0x01cc }
            goto L_0x01d0
        L_0x01cc:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x01d0:
            boolean r0 = ag     // Catch:{ all -> 0x01f8 }
            if (r0 == 0) goto L_0x01e6
            f13571h = r6     // Catch:{ all -> 0x01f8 }
            java.lang.String r0 = "BATTERYINFO"
            java.lang.String r0 = s(r0)     // Catch:{ all -> 0x01f8 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x01f8 }
            r14.write(r0)     // Catch:{ all -> 0x01f8 }
            f13571h = r12     // Catch:{ all -> 0x01f8 }
            goto L_0x01fc
        L_0x01e6:
            java.lang.StringBuilder r0 = Y()     // Catch:{ all -> 0x01f8 }
            if (r0 == 0) goto L_0x01fc
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01f8 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x01f8 }
            r14.write(r0)     // Catch:{ all -> 0x01f8 }
            goto L_0x01fc
        L_0x01f8:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x01fc:
            a((java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = "disk info:\n"
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0209 }
            r14.write(r0)     // Catch:{ all -> 0x0209 }
            goto L_0x020d
        L_0x0209:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x020d:
            boolean r0 = ag     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x022e
            f13571h = r6     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = "FSSTAT"
            java.lang.String r0 = s(r0)     // Catch:{ all -> 0x0221 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0221 }
            r14.write(r0)     // Catch:{ all -> 0x0221 }
            goto L_0x0225
        L_0x0221:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0496 }
        L_0x0225:
            f13571h = r12     // Catch:{ all -> 0x0496 }
        L_0x0227:
            r15 = r5
            r16 = r7
        L_0x022a:
            r18 = r13
            goto L_0x034b
        L_0x022e:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0342 }
            r0.<init>()     // Catch:{ all -> 0x0342 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0342 }
            java.lang.String r9 = com.uc.crashsdk.a.g.b()     // Catch:{ all -> 0x0342 }
            r1.<init>(r9)     // Catch:{ all -> 0x0342 }
            java.lang.String r1 = a((java.io.File) r1)     // Catch:{ all -> 0x0342 }
            boolean r9 = com.uc.crashsdk.a.g.a((java.lang.String) r1)     // Catch:{ all -> 0x0342 }
            if (r9 != 0) goto L_0x0227
            boolean r9 = r0.contains(r1)     // Catch:{ all -> 0x0342 }
            if (r9 != 0) goto L_0x0227
            java.lang.String r9 = "/storage/emulated"
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x0342 }
            if (r9 == 0) goto L_0x0255
            goto L_0x0227
        L_0x0255:
            r0.add(r1)     // Catch:{ all -> 0x0342 }
            android.os.StatFs r0 = new android.os.StatFs     // Catch:{ all -> 0x0227 }
            r0.<init>(r1)     // Catch:{ all -> 0x0227 }
            java.lang.String r9 = "getBlockCountLong"
            java.lang.String r10 = "getBlockCount"
            long r9 = a((android.os.StatFs) r0, (java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0342 }
            java.lang.String r15 = "getBlockSizeLong"
            java.lang.String r11 = "getBlockSize"
            r16 = r7
            long r6 = a((android.os.StatFs) r0, (java.lang.String) r15, (java.lang.String) r11)     // Catch:{ all -> 0x033f }
            r17 = 1024(0x400, double:5.06E-321)
            long r17 = r9 / r17
            long r17 = r17 * r6
            r19 = 10240(0x2800, double:5.059E-320)
            int r11 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r11 < 0) goto L_0x033c
            java.lang.String r11 = "getAvailableBlocksLong"
            java.lang.String r15 = "getAvailableBlocks"
            r18 = r13
            long r12 = a((android.os.StatFs) r0, (java.lang.String) r11, (java.lang.String) r15)     // Catch:{ all -> 0x0339 }
            java.lang.String r11 = "getFreeBlocksLong"
            java.lang.String r15 = "getFreeBlocks"
            long r2 = a((android.os.StatFs) r0, (java.lang.String) r11, (java.lang.String) r15)     // Catch:{ all -> 0x0339 }
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0331 }
            java.lang.String r4 = "%s:\n"
            r11 = 1
            java.lang.Object[] r15 = new java.lang.Object[r11]     // Catch:{ all -> 0x0331 }
            r11 = 0
            r15[r11] = r1     // Catch:{ all -> 0x0331 }
            java.lang.String r1 = java.lang.String.format(r0, r4, r15)     // Catch:{ all -> 0x0331 }
            byte[] r1 = r1.getBytes(r8)     // Catch:{ all -> 0x0331 }
            r14.write(r1)     // Catch:{ all -> 0x0331 }
            java.lang.String r1 = "  total:      %d kB\n"
            r4 = 1
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x0331 }
            double r9 = (double) r9
            r19 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r9)
            double r9 = r9 * r19
            r15 = r5
            double r4 = (double) r6
            java.lang.Double.isNaN(r4)
            double r9 = r9 * r4
            r21 = 4652218415073722368(0x4090000000000000, double:1024.0)
            double r9 = r9 / r21
            long r9 = (long) r9
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x032f }
            r10 = 0
            r11[r10] = r9     // Catch:{ all -> 0x032f }
            java.lang.String r1 = java.lang.String.format(r0, r1, r11)     // Catch:{ all -> 0x032f }
            byte[] r1 = r1.getBytes(r8)     // Catch:{ all -> 0x032f }
            r14.write(r1)     // Catch:{ all -> 0x032f }
            java.lang.String r1 = "  available:  %d kB\n"
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x032f }
            double r11 = (double) r12
            java.lang.Double.isNaN(r11)
            double r11 = r11 * r19
            java.lang.Double.isNaN(r4)
            double r11 = r11 * r4
            double r11 = r11 / r21
            long r11 = (long) r11
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x032f }
            r11 = 0
            r10[r11] = r9     // Catch:{ all -> 0x032f }
            java.lang.String r1 = java.lang.String.format(r0, r1, r10)     // Catch:{ all -> 0x032f }
            byte[] r1 = r1.getBytes(r8)     // Catch:{ all -> 0x032f }
            r14.write(r1)     // Catch:{ all -> 0x032f }
            java.lang.String r1 = "  free:       %d kB\n"
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x032f }
            double r2 = (double) r2
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r19
            java.lang.Double.isNaN(r4)
            double r2 = r2 * r4
            double r2 = r2 / r21
            long r2 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x032f }
            r3 = 0
            r10[r3] = r2     // Catch:{ all -> 0x032f }
            java.lang.String r1 = java.lang.String.format(r0, r1, r10)     // Catch:{ all -> 0x032f }
            byte[] r1 = r1.getBytes(r8)     // Catch:{ all -> 0x032f }
            r14.write(r1)     // Catch:{ all -> 0x032f }
            java.lang.String r1 = "  block size: %d B\n\n"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x032f }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x032f }
            r4 = 0
            r3[r4] = r2     // Catch:{ all -> 0x032f }
            java.lang.String r0 = java.lang.String.format(r0, r1, r3)     // Catch:{ all -> 0x032f }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x032f }
            r14.write(r0)     // Catch:{ all -> 0x032f }
            goto L_0x034b
        L_0x032f:
            r0 = move-exception
            goto L_0x0333
        L_0x0331:
            r0 = move-exception
            r15 = r5
        L_0x0333:
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0337 }
            goto L_0x034b
        L_0x0337:
            r0 = move-exception
            goto L_0x0348
        L_0x0339:
            r0 = move-exception
            r15 = r5
            goto L_0x0348
        L_0x033c:
            r15 = r5
            goto L_0x022a
        L_0x033f:
            r0 = move-exception
            r15 = r5
            goto L_0x0346
        L_0x0342:
            r0 = move-exception
            r15 = r5
            r16 = r7
        L_0x0346:
            r18 = r13
        L_0x0348:
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
        L_0x034b:
            a((java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
            java.lang.String r0 = "device status:\n"
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0358 }
            r14.write(r0)     // Catch:{ all -> 0x0358 }
            goto L_0x035c
        L_0x0358:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
        L_0x035c:
            boolean r0 = ag     // Catch:{ all -> 0x0494 }
            if (r0 == 0) goto L_0x037b
            r1 = 0
            f13571h = r1     // Catch:{ all -> 0x0375 }
            java.lang.String r0 = "DEVICESTATUS"
            java.lang.String r0 = s(r0)     // Catch:{ all -> 0x0375 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0375 }
            r14.write(r0)     // Catch:{ all -> 0x0375 }
            r1 = 1
            f13571h = r1     // Catch:{ all -> 0x0375 }
            goto L_0x0417
        L_0x0375:
            r0 = move-exception
        L_0x0376:
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
            goto L_0x0417
        L_0x037b:
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0414 }
            java.lang.String r1 = "has root: %s\n"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0414 }
            boolean r2 = com.uc.crashsdk.a.g.e()     // Catch:{ all -> 0x0414 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0414 }
            r4 = 0
            r3[r4] = r2     // Catch:{ all -> 0x0414 }
            java.lang.String r1 = java.lang.String.format(r0, r1, r3)     // Catch:{ all -> 0x0414 }
            byte[] r1 = r1.getBytes(r8)     // Catch:{ all -> 0x0414 }
            r14.write(r1)     // Catch:{ all -> 0x0414 }
            java.lang.String r1 = ""
            java.lang.String r2 = android.os.Build.TAGS     // Catch:{ all -> 0x0414 }
            if (r2 == 0) goto L_0x039f
            r1 = r2
        L_0x039f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0414 }
            r2.<init>()     // Catch:{ all -> 0x0414 }
            java.lang.String r3 = "build tags: "
            r2.append(r3)     // Catch:{ all -> 0x0414 }
            r2.append(r1)     // Catch:{ all -> 0x0414 }
            boolean r1 = com.uc.crashsdk.a.g.f()     // Catch:{ all -> 0x0414 }
            if (r1 == 0) goto L_0x03b7
            java.lang.String r1 = " (default root)"
            r2.append(r1)     // Catch:{ all -> 0x0414 }
        L_0x03b7:
            r1 = r15
            r2.append(r1)     // Catch:{ all -> 0x0414 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0414 }
            byte[] r1 = r1.getBytes(r8)     // Catch:{ all -> 0x0414 }
            r14.write(r1)     // Catch:{ all -> 0x0414 }
            java.lang.String r1 = com.uc.crashsdk.a.g.h()     // Catch:{ all -> 0x0414 }
            boolean r2 = com.uc.crashsdk.a.g.b((java.lang.String) r1)     // Catch:{ all -> 0x0414 }
            if (r2 == 0) goto L_0x0417
            java.lang.String r2 = "su binary: %s\n"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0414 }
            r3 = 0
            r4[r3] = r1     // Catch:{ all -> 0x0414 }
            java.lang.String r0 = java.lang.String.format(r0, r2, r4)     // Catch:{ all -> 0x0414 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0414 }
            r14.write(r0)     // Catch:{ all -> 0x0414 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0414 }
            r0.<init>()     // Catch:{ all -> 0x0414 }
            java.lang.String r1 = "su permission: "
            r0.append(r1)     // Catch:{ all -> 0x0414 }
            boolean r1 = com.uc.crashsdk.a.g.g()     // Catch:{ all -> 0x0414 }
            if (r1 == 0) goto L_0x03f9
            java.lang.String r1 = "valid ("
        L_0x03f5:
            r0.append(r1)     // Catch:{ all -> 0x0414 }
            goto L_0x03fc
        L_0x03f9:
            java.lang.String r1 = "invalid ("
            goto L_0x03f5
        L_0x03fc:
            java.lang.String r1 = com.uc.crashsdk.a.g.i()     // Catch:{ all -> 0x0414 }
            r0.append(r1)     // Catch:{ all -> 0x0414 }
            java.lang.String r1 = ")\n"
            r0.append(r1)     // Catch:{ all -> 0x0414 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0414 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0414 }
            r14.write(r0)     // Catch:{ all -> 0x0414 }
            goto L_0x0417
        L_0x0414:
            r0 = move-exception
            goto L_0x0376
        L_0x0417:
            a((java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
            c((java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
            d((java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
            r1 = r16
            r2 = 0
            com.uc.crashsdk.a.b(r14, r8, r1, r2)     // Catch:{ all -> 0x0427 }
            goto L_0x042c
        L_0x0427:
            r0 = move-exception
            r2 = r0
            a((java.lang.Throwable) r2, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
        L_0x042c:
            boolean r0 = ag     // Catch:{ all -> 0x0494 }
            if (r0 == 0) goto L_0x0448
            r2 = 0
            f13571h = r2     // Catch:{ all -> 0x0494 }
            java.lang.String r0 = "JAVACACHEDINFOS"
            java.lang.String r0 = s(r0)     // Catch:{ all -> 0x0441 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0441 }
            r14.write(r0)     // Catch:{ all -> 0x0441 }
            goto L_0x0445
        L_0x0441:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
        L_0x0445:
            r2 = 1
            f13571h = r2     // Catch:{ all -> 0x0494 }
        L_0x0448:
            r14.flush()     // Catch:{ all -> 0x044c }
            goto L_0x0451
        L_0x044c:
            r0 = move-exception
            r2 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0494 }
        L_0x0451:
            r2 = 0
            com.uc.crashsdk.a.a(r14, r8, r1, r2)     // Catch:{ all -> 0x0456 }
            goto L_0x045b
        L_0x0456:
            r0 = move-exception
            r1 = r0
            a((java.lang.Throwable) r1, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
        L_0x045b:
            boolean r0 = ag     // Catch:{ all -> 0x0494 }
            if (r0 == 0) goto L_0x0477
            r1 = 0
            f13571h = r1     // Catch:{ all -> 0x0494 }
            java.lang.String r0 = "JAVACALLBACKINFOS"
            java.lang.String r0 = s(r0)     // Catch:{ all -> 0x0470 }
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x0470 }
            r14.write(r0)     // Catch:{ all -> 0x0470 }
            goto L_0x0474
        L_0x0470:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r14)     // Catch:{ all -> 0x0494 }
        L_0x0474:
            r1 = 1
            f13571h = r1     // Catch:{ all -> 0x0494 }
        L_0x0477:
            r14.a()     // Catch:{ all -> 0x0494 }
            a((com.uc.crashsdk.e.a) r14)     // Catch:{ all -> 0x0494 }
            r14.flush()     // Catch:{ all -> 0x0483 }
        L_0x0480:
            r1 = 0
            goto L_0x0489
        L_0x0483:
            r0 = move-exception
            r1 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0494 }
            goto L_0x0480
        L_0x0489:
            int r0 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0490
            b((com.uc.crashsdk.e.a) r14)
        L_0x0490:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r14)
            goto L_0x04b3
        L_0x0494:
            r0 = move-exception
            goto L_0x0499
        L_0x0496:
            r0 = move-exception
            r18 = r13
        L_0x0499:
            r11 = r14
            goto L_0x04a4
        L_0x049b:
            r0 = move-exception
            r2 = r11
            r18 = r13
            goto L_0x04a4
        L_0x04a0:
            r0 = move-exception
            r2 = r11
        L_0x04a2:
            r18 = r11
        L_0x04a4:
            a((java.lang.Throwable) r0, (java.io.OutputStream) r11)     // Catch:{ all -> 0x04d7 }
            r1 = 0
            int r0 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x04b0
            b((com.uc.crashsdk.e.a) r11)
        L_0x04b0:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r11)
        L_0x04b3:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r18)
            boolean r0 = ag
            if (r0 != 0) goto L_0x04bd
            r(r24)
        L_0x04bd:
            boolean r0 = ag     // Catch:{ all -> 0x04d2 }
            if (r0 != 0) goto L_0x04ca
            java.lang.String r0 = m(r24)     // Catch:{ all -> 0x04d2 }
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x04d2 }
            goto L_0x04cc
        L_0x04ca:
            r0 = r24
        L_0x04cc:
            java.lang.String r1 = "java"
            b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x04d2 }
            goto L_0x04d6
        L_0x04d2:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x04d6:
            return r24
        L_0x04d7:
            r0 = move-exception
            r1 = r0
            r2 = 0
            int r0 = (r25 > r2 ? 1 : (r25 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x04e2
            b((com.uc.crashsdk.e.a) r11)
        L_0x04e2:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r11)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r18)
            goto L_0x04ea
        L_0x04e9:
            throw r1
        L_0x04ea:
            goto L_0x04e9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    /* JADX INFO: finally extract failed */
    public static int b(OutputStream outputStream, String str, int i10) {
        int i11;
        DataInputStream dataInputStream;
        int i12;
        DataInputStream dataInputStream2 = null;
        int i13 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] R2 = R();
                if (R2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    g.a((Closeable) null);
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i12 = 0;
                i11 = 0;
                loop0:
                while (true) {
                    boolean z10 = false;
                    while (true) {
                        try {
                            int read = dataInputStream.read(R2);
                            if (read == -1) {
                                break loop0;
                            }
                            i12 += read;
                            int i14 = i10 - i11;
                            if (read <= i14 + 32) {
                                i14 = read;
                            }
                            if (i14 > 0 && !z10) {
                                outputStream.write(R2, 0, i14);
                                i11 += i14;
                            }
                            if (!z10) {
                                if (i14 < read || i11 >= i10) {
                                    z10 = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i13 = i11;
                            dataInputStream2 = dataInputStream;
                            try {
                                a(th, outputStream);
                                g.a((Closeable) dataInputStream2);
                                i11 = i13;
                                a(outputStream);
                                return i11;
                            } catch (Throwable th2) {
                                g.a((Closeable) dataInputStream2);
                                throw th2;
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i12 = 0;
                i11 = 0;
            }
            if (i11 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i11 < i12) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", new Object[]{Integer.valueOf(i12 - i11)}).getBytes("UTF-8"));
            }
            g.a((Closeable) dataInputStream);
        } catch (Throwable th3) {
            th = th3;
            a(th, outputStream);
            g.a((Closeable) dataInputStream2);
            i11 = i13;
            a(outputStream);
            return i11;
        }
        a(outputStream);
        return i11;
    }

    public static void b(boolean z10) {
        try {
            boolean z11 = g.s() && b.F() && !f13568d;
            if (!z11) {
                z11 = g.t();
            }
            if (z11) {
                if (z10) {
                    String k10 = k();
                    if (!g.a(k10)) {
                        j();
                        a(k10, false, false);
                        return;
                    }
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    private static boolean b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf <= 0 || (indexOf = name.indexOf(46, lastIndexOf)) <= 0) {
            return false;
        }
        String substring = name.substring(lastIndexOf + 1, indexOf);
        if (LogType.JAVA_TYPE.equals(substring) || "ucebujava".equals(substring) || LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring) || LogType.ANR_TYPE.equals(substring)) {
            return true;
        }
        return false;
    }

    private static String b(String str, boolean z10, boolean z11) {
        if (z10) {
            try {
                str = m(str);
            } catch (Throwable th) {
                g.a(th);
            }
        }
        if (!z11) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            g.a(th2);
            return str;
        }
    }

    public static void b(String str, String str2, boolean z10) {
        h.a(str, str2, false, z10);
    }

    public static void b(String str) {
        synchronized (f13588y) {
            f13587x = str;
            com.uc.crashsdk.a.b.a(b.i(), str + "\n");
        }
    }

    private static void b(String str, String str2) {
        try {
            d.a(str, h(), str2);
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static void b(Context context) {
        if (g.N()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, (String) null, f.a(1));
                R = true;
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    public static void b(int i10) {
        f.a(0, new com.uc.crashsdk.a.e(Constant.TOKEN_EXPIRED), (long) (i10 * 1000));
    }

    public static String a(String str) {
        int lastIndexOf;
        int indexOf;
        int i10;
        int indexOf2;
        File file;
        byte[] e10;
        byte[] bArr;
        if (!g.y() || (lastIndexOf = str.lastIndexOf(47)) <= 0 || (indexOf = str.indexOf(95, lastIndexOf)) <= lastIndexOf || (indexOf2 = str.indexOf(95, (i10 = indexOf + 1))) <= indexOf) {
            return str;
        }
        String d10 = g.d("CrashSDK" + str.substring(lastIndexOf + 1, indexOf) + str.substring(i10, indexOf2));
        if (d10 == null || (e10 = g.e(file)) == null || e10.length <= 0) {
            return str;
        }
        try {
            bArr = com.uc.crashsdk.a.c.b(e10, d10.substring(0, 16).getBytes());
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null) {
            return str;
        }
        String str2 = str + ".ec";
        File file2 = new File(str2 + ".tmp");
        if (!g.a(file2, bArr)) {
            return str;
        }
        if (!file2.renameTo(new File(str2))) {
            file2.delete();
            return str;
        }
        (file = new File(str)).delete();
        return str2;
    }

    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                g.a(th2);
            }
        }
        g.a(th);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02b5 A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02ef A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02fc A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0347 A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0349 A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0356 A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03ad A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03c6 A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03ba A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01da A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01f3 A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01f5 A[ADDED_TO_REGION, Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0210 A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0226 A[Catch:{ all -> 0x0441, all -> 0x044e, all -> 0x044c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r30, boolean r31, boolean r32) {
        /*
            java.lang.String r0 = "crashsdk uploading logs"
            java.lang.String r1 = "crashsdk"
            com.uc.crashsdk.a.a.a(r1, r0)
            java.lang.Object r1 = f13577n
            monitor-enter(r1)
            boolean r0 = com.uc.crashsdk.a.g.b((java.lang.String) r30)     // Catch:{ all -> 0x0441 }
            if (r0 == 0) goto L_0x0432
            java.lang.String r0 = com.uc.crashsdk.g.Y()     // Catch:{ all -> 0x0441 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0441 }
            r2.<init>(r0)     // Catch:{ all -> 0x0441 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0441 }
            if (r3 != 0) goto L_0x0034
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0441 }
            java.lang.String r3 = "Folder not exist: "
            r2.<init>(r3)     // Catch:{ all -> 0x0441 }
            r2.append(r0)     // Catch:{ all -> 0x0441 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0441 }
            java.lang.String r2 = "crashsdk"
            com.uc.crashsdk.a.a.a(r2, r0)     // Catch:{ all -> 0x0441 }
            goto L_0x0439
        L_0x0034:
            java.io.File[] r2 = r2.listFiles()     // Catch:{ all -> 0x0441 }
            if (r2 != 0) goto L_0x004d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0441 }
            java.lang.String r3 = "List folder failed: "
            r2.<init>(r3)     // Catch:{ all -> 0x0441 }
            r2.append(r0)     // Catch:{ all -> 0x0441 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0441 }
            com.uc.crashsdk.a.a.b(r0)     // Catch:{ all -> 0x0441 }
            goto L_0x0439
        L_0x004d:
            int r3 = r2.length     // Catch:{ all -> 0x0441 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x005b:
            if (r5 >= r3) goto L_0x03d8
            r4 = r2[r5]     // Catch:{ all -> 0x0441 }
            boolean r0 = r4.isFile()     // Catch:{ all -> 0x0441 }
            if (r0 != 0) goto L_0x006d
            com.uc.crashsdk.a.g.a((java.io.File) r4)     // Catch:{ all -> 0x0441 }
            r18 = r2
        L_0x006a:
            r21 = r3
            goto L_0x00a7
        L_0x006d:
            java.lang.String r0 = r4.getName()     // Catch:{ all -> 0x0441 }
            r18 = r2
            java.lang.String r2 = ".tmp"
            boolean r2 = r0.endsWith(r2)     // Catch:{ all -> 0x0441 }
            r19 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x00b0
            long r21 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0441 }
            long r23 = r4.lastModified()     // Catch:{ all -> 0x0441 }
            long r21 = r21 - r23
            long r21 = r21 / r19
            r19 = 30
            int r2 = (r21 > r19 ? 1 : (r21 == r19 ? 0 : -1))
            if (r2 <= 0) goto L_0x006a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0441 }
            r21 = r3
            java.lang.String r3 = "delete legacy tmp file: "
            r2.<init>(r3)     // Catch:{ all -> 0x0441 }
            r2.append(r0)     // Catch:{ all -> 0x0441 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0441 }
            com.uc.crashsdk.a.a.b(r0)     // Catch:{ all -> 0x0441 }
            int r7 = r7 + 1
            com.uc.crashsdk.a.g.a((java.io.File) r4)     // Catch:{ all -> 0x0441 }
        L_0x00a7:
            r20 = r11
            r22 = r14
        L_0x00ab:
            r14 = 0
            r11 = r30
            goto L_0x03cc
        L_0x00b0:
            r21 = r3
            long r2 = r4.length()     // Catch:{ all -> 0x0441 }
            r22 = r14
            r23 = r15
            r14 = 0
            int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x00ca
            int r6 = r6 + 1
            com.uc.crashsdk.a.g.a((java.io.File) r4)     // Catch:{ all -> 0x0441 }
        L_0x00c5:
            r20 = r11
            r15 = r23
            goto L_0x00ab
        L_0x00ca:
            r2 = 3
            if (r31 == 0) goto L_0x0123
            long r25 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0441 }
            long r27 = r4.lastModified()     // Catch:{ all -> 0x0441 }
            long r25 = r25 - r27
            long r25 = r25 / r19
            int r0 = (r25 > r14 ? 1 : (r25 == r14 ? 0 : -1))
            if (r0 < 0) goto L_0x00f8
            r19 = 2
            int r0 = (r25 > r19 ? 1 : (r25 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e5
        L_0x00e3:
            r0 = 0
            goto L_0x00f9
        L_0x00e5:
            r19 = 5
            int r0 = (r25 > r19 ? 1 : (r25 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x00f8
            java.lang.String r0 = r4.getName()     // Catch:{ all -> 0x0441 }
            java.lang.String r14 = ".log"
            boolean r0 = r0.endsWith(r14)     // Catch:{ all -> 0x0441 }
            if (r0 == 0) goto L_0x00f8
            goto L_0x00e3
        L_0x00f8:
            r0 = 1
        L_0x00f9:
            java.util.Locale r14 = java.util.Locale.US     // Catch:{ all -> 0x0441 }
            java.lang.String r15 = "file: %s, modify interval: %d s, safe upload: %s"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0441 }
            java.lang.String r28 = r4.getName()     // Catch:{ all -> 0x0441 }
            r17 = 0
            r3[r17] = r28     // Catch:{ all -> 0x0441 }
            java.lang.Long r25 = java.lang.Long.valueOf(r25)     // Catch:{ all -> 0x0441 }
            r26 = 1
            r3[r26] = r25     // Catch:{ all -> 0x0441 }
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0441 }
            r24 = 2
            r3[r24] = r25     // Catch:{ all -> 0x0441 }
            java.lang.String r3 = java.lang.String.format(r14, r15, r3)     // Catch:{ all -> 0x0441 }
            com.uc.crashsdk.a.a.a(r3)     // Catch:{ all -> 0x0441 }
            if (r0 != 0) goto L_0x0123
            int r8 = r8 + 1
            goto L_0x00c5
        L_0x0123:
            boolean r0 = com.uc.crashsdk.g.l()     // Catch:{ all -> 0x01c0 }
            if (r0 == 0) goto L_0x01b7
            java.lang.String r0 = r4.getName()     // Catch:{ all -> 0x01c0 }
            java.lang.String r3 = "([^_]+)_([^_]+)_([^_]+)\\.crashsdk"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ all -> 0x01c0 }
            java.util.regex.Matcher r0 = r3.matcher(r0)     // Catch:{ all -> 0x01c0 }
            boolean r3 = r0.matches()     // Catch:{ all -> 0x01c0 }
            if (r3 == 0) goto L_0x01b7
            r3 = 1
            java.lang.String r14 = r0.group(r3)     // Catch:{ all -> 0x01c0 }
            r3 = 2
            java.lang.String r15 = r0.group(r3)     // Catch:{ all -> 0x01c0 }
            java.lang.String r0 = r0.group(r2)     // Catch:{ all -> 0x01c0 }
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ all -> 0x01c0 }
            java.lang.String r2 = "%s%s_%s_%s.%s"
            r26 = r8
            r8 = 5
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x01b5 }
            java.lang.String r15 = j(r15)     // Catch:{ all -> 0x01b5 }
            r17 = 0
            r8[r17] = r15     // Catch:{ all -> 0x01b5 }
            java.lang.String r15 = n()     // Catch:{ all -> 0x01b5 }
            r27 = 1
            r8[r27] = r15     // Catch:{ all -> 0x01b5 }
            java.lang.String r15 = Q()     // Catch:{ all -> 0x01b5 }
            r24 = 2
            r8[r24] = r15     // Catch:{ all -> 0x01b5 }
            r15 = 3
            r8[r15] = r14     // Catch:{ all -> 0x01b5 }
            r14 = 4
            r8[r14] = r0     // Catch:{ all -> 0x01b5 }
            java.lang.String r0 = java.lang.String.format(r3, r2, r8)     // Catch:{ all -> 0x01b5 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x01b5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            r3.<init>()     // Catch:{ all -> 0x01b5 }
            java.lang.String r8 = com.uc.crashsdk.g.Y()     // Catch:{ all -> 0x01b5 }
            r3.append(r8)     // Catch:{ all -> 0x01b5 }
            r3.append(r0)     // Catch:{ all -> 0x01b5 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01b5 }
            r2.<init>(r0)     // Catch:{ all -> 0x01b5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            java.lang.String r3 = "File "
            r0.<init>(r3)     // Catch:{ all -> 0x01b5 }
            java.lang.String r3 = r4.getPath()     // Catch:{ all -> 0x01b5 }
            r0.append(r3)     // Catch:{ all -> 0x01b5 }
            java.lang.String r3 = " matches, rename to "
            r0.append(r3)     // Catch:{ all -> 0x01b5 }
            java.lang.String r3 = r2.getPath()     // Catch:{ all -> 0x01b5 }
            r0.append(r3)     // Catch:{ all -> 0x01b5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01b5 }
            java.lang.String r3 = "crashsdk"
            com.uc.crashsdk.a.a.a(r3, r0)     // Catch:{ all -> 0x01b5 }
            r4.renameTo(r2)     // Catch:{ all -> 0x01b5 }
            goto L_0x01ba
        L_0x01b5:
            r0 = move-exception
            goto L_0x01c3
        L_0x01b7:
            r26 = r8
            r2 = r4
        L_0x01ba:
            if (r2 == r4) goto L_0x01be
            int r12 = r12 + 1
        L_0x01be:
            r4 = r2
            goto L_0x01c6
        L_0x01c0:
            r0 = move-exception
            r26 = r8
        L_0x01c3:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0441 }
        L_0x01c6:
            java.lang.String r0 = r4.getPath()     // Catch:{ all -> 0x0441 }
            boolean[] r2 = n(r0)     // Catch:{ all -> 0x0441 }
            r3 = 0
            boolean r8 = r2[r3]     // Catch:{ all -> 0x0441 }
            r14 = 1
            boolean r15 = r2[r14]     // Catch:{ all -> 0x0441 }
            java.lang.String r8 = b((java.lang.String) r0, (boolean) r8, (boolean) r15)     // Catch:{ all -> 0x0441 }
            if (r0 == r8) goto L_0x01ec
            boolean r0 = r2[r3]     // Catch:{ all -> 0x0441 }
            if (r0 == 0) goto L_0x01e0
            int r11 = r11 + 1
        L_0x01e0:
            r3 = 1
            boolean r0 = r2[r3]     // Catch:{ all -> 0x0441 }
            if (r0 == 0) goto L_0x01e7
            int r9 = r9 + 1
        L_0x01e7:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0441 }
            r4.<init>(r8)     // Catch:{ all -> 0x0441 }
        L_0x01ec:
            java.io.File r0 = com.uc.crashsdk.d.a((java.io.File) r4)     // Catch:{ all -> 0x0441 }
            r2 = 0
            if (r0 != 0) goto L_0x01f5
            r0 = r2
            goto L_0x020e
        L_0x01f5:
            if (r4 == r0) goto L_0x020e
            java.lang.String r3 = r4.getName()     // Catch:{ all -> 0x0441 }
            java.lang.String r8 = r0.getName()     // Catch:{ all -> 0x0441 }
            boolean r3 = r3.equals(r8)     // Catch:{ all -> 0x0441 }
            if (r3 != 0) goto L_0x020e
            boolean r3 = r4.exists()     // Catch:{ all -> 0x0441 }
            if (r3 == 0) goto L_0x020e
            r4.delete()     // Catch:{ all -> 0x0441 }
        L_0x020e:
            if (r0 != 0) goto L_0x0226
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0441 }
            java.lang.String r2 = "onBeforeUploadLog return null, skip upload: "
            r0.<init>(r2)     // Catch:{ all -> 0x0441 }
            java.lang.String r2 = r4.getAbsolutePath()     // Catch:{ all -> 0x0441 }
            r0.append(r2)     // Catch:{ all -> 0x0441 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0441 }
            com.uc.crashsdk.a.a.b(r0)     // Catch:{ all -> 0x0441 }
            goto L_0x023a
        L_0x0226:
            int r3 = com.uc.crashsdk.g.C()     // Catch:{ all -> 0x0441 }
            if (r3 <= 0) goto L_0x0242
            long r14 = r0.length()     // Catch:{ all -> 0x0441 }
            long r3 = (long) r3     // Catch:{ all -> 0x0441 }
            int r8 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r8 < 0) goto L_0x0242
            int r10 = r10 + 1
            com.uc.crashsdk.a.g.a((java.io.File) r0)     // Catch:{ all -> 0x0441 }
        L_0x023a:
            r20 = r11
            r15 = r23
            r8 = r26
            goto L_0x00ab
        L_0x0242:
            com.uc.crashsdk.e$d r3 = new com.uc.crashsdk.e$d     // Catch:{ all -> 0x0441 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0441 }
            r14 = 0
            r3.f13597b = r14     // Catch:{ all -> 0x0441 }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0441 }
            r3.f13596a = r14     // Catch:{ all -> 0x0441 }
            java.lang.String r4 = U()     // Catch:{ all -> 0x0441 }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0441 }
            r8.<init>(r4)     // Catch:{ all -> 0x0441 }
            boolean r8 = r8.exists()     // Catch:{ all -> 0x0441 }
            if (r8 == 0) goto L_0x0274
            com.uc.crashsdk.a.e r8 = new com.uc.crashsdk.a.e     // Catch:{ all -> 0x0441 }
            r14 = 2
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ all -> 0x0441 }
            r14 = 0
            r15[r14] = r4     // Catch:{ all -> 0x0441 }
            r14 = 1
            r15[r14] = r3     // Catch:{ all -> 0x0441 }
            r14 = 451(0x1c3, float:6.32E-43)
            r8.<init>(r14, r15)     // Catch:{ all -> 0x0441 }
            a((java.lang.String) r4, (com.uc.crashsdk.a.e) r8)     // Catch:{ all -> 0x0441 }
        L_0x0274:
            long r14 = com.uc.crashsdk.g.D()     // Catch:{ all -> 0x0441 }
            int r4 = com.uc.crashsdk.g.E()     // Catch:{ all -> 0x0441 }
            int r8 = com.uc.crashsdk.g.F()     // Catch:{ all -> 0x0441 }
            r19 = 0
            int r28 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r28 < 0) goto L_0x02ab
            r20 = r11
            r19 = r12
            long r11 = r3.f13597b     // Catch:{ all -> 0x0441 }
            long r28 = r0.length()     // Catch:{ all -> 0x0441 }
            long r11 = r11 + r28
            int r28 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r28 <= 0) goto L_0x02af
            r11 = 1
            r3.f13600e = r11     // Catch:{ all -> 0x0441 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0441 }
            java.lang.String r8 = "Reach max upload bytes: "
            r4.<init>(r8)     // Catch:{ all -> 0x0441 }
            r4.append(r14)     // Catch:{ all -> 0x0441 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0441 }
        L_0x02a7:
            com.uc.crashsdk.a.a.b(r4)     // Catch:{ all -> 0x0441 }
            goto L_0x02eb
        L_0x02ab:
            r20 = r11
            r19 = r12
        L_0x02af:
            boolean r11 = com.uc.crashsdk.g.f()     // Catch:{ all -> 0x0441 }
            if (r11 != 0) goto L_0x02eb
            boolean r11 = b((java.io.File) r0)     // Catch:{ all -> 0x0441 }
            if (r11 == 0) goto L_0x02d3
            if (r4 < 0) goto L_0x02eb
            int r8 = r3.f13598c     // Catch:{ all -> 0x0441 }
            if (r8 < r4) goto L_0x02eb
            r8 = 1
            r3.f13602g = r8     // Catch:{ all -> 0x0441 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0441 }
            java.lang.String r11 = "Reach max upload builtin log count: "
            r8.<init>(r11)     // Catch:{ all -> 0x0441 }
            r8.append(r4)     // Catch:{ all -> 0x0441 }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0441 }
            goto L_0x02a7
        L_0x02d3:
            if (r8 < 0) goto L_0x02eb
            int r4 = r3.f13599d     // Catch:{ all -> 0x0441 }
            if (r4 < r8) goto L_0x02eb
            r4 = 1
            r3.f13601f = r4     // Catch:{ all -> 0x0441 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0441 }
            java.lang.String r11 = "Reach max upload custom log count: "
            r4.<init>(r11)     // Catch:{ all -> 0x0441 }
            r4.append(r8)     // Catch:{ all -> 0x0441 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0441 }
            goto L_0x02a7
        L_0x02eb:
            boolean r4 = r3.f13600e     // Catch:{ all -> 0x0441 }
            if (r4 == 0) goto L_0x02fc
            r11 = r30
            r12 = r19
            r15 = r23
            r8 = r26
            r14 = 0
            r22 = 1
            goto L_0x03cc
        L_0x02fc:
            boolean r4 = r3.f13602g     // Catch:{ all -> 0x0441 }
            if (r4 == 0) goto L_0x030a
            r11 = r30
            r12 = r19
            r8 = r26
            r14 = 0
            r15 = 1
            goto L_0x03cc
        L_0x030a:
            boolean r4 = r3.f13601f     // Catch:{ all -> 0x0441 }
            if (r4 == 0) goto L_0x031b
            r11 = r30
            r12 = r19
            r15 = r23
            r8 = r26
            r14 = 0
            r16 = 1
            goto L_0x03cc
        L_0x031b:
            java.lang.String r4 = r0.getName()     // Catch:{ all -> 0x0441 }
            java.lang.String r8 = P()     // Catch:{ all -> 0x0441 }
            boolean r8 = r4.startsWith(r8)     // Catch:{ all -> 0x0441 }
            if (r8 == 0) goto L_0x033a
            java.lang.String r8 = "_"
            r11 = 10
            java.lang.String[] r4 = r4.split(r8, r11)     // Catch:{ all -> 0x0441 }
            int r8 = r4.length     // Catch:{ all -> 0x0441 }
            r11 = 9
            if (r8 != r11) goto L_0x033a
            r8 = 1
            r4 = r4[r8]     // Catch:{ all -> 0x0441 }
            goto L_0x033b
        L_0x033a:
            r4 = r2
        L_0x033b:
            if (r4 == 0) goto L_0x0349
            java.lang.String r8 = com.uc.crashsdk.g.U()     // Catch:{ all -> 0x0441 }
            boolean r4 = r4.equals(r8)     // Catch:{ all -> 0x0441 }
            if (r4 == 0) goto L_0x0349
            r4 = 1
            goto L_0x034a
        L_0x0349:
            r4 = 0
        L_0x034a:
            java.lang.String r8 = r0.getName()     // Catch:{ all -> 0x0441 }
            r11 = r30
            boolean r8 = com.uc.crashsdk.a.c.a((java.io.File) r0, (java.lang.String) r8, (java.lang.String) r11)     // Catch:{ all -> 0x0441 }
            if (r8 == 0) goto L_0x03ad
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0441 }
            java.lang.String r12 = "Uploaded log: "
            r8.<init>(r12)     // Catch:{ all -> 0x0441 }
            java.lang.String r12 = r0.getName()     // Catch:{ all -> 0x0441 }
            r8.append(r12)     // Catch:{ all -> 0x0441 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0441 }
            java.lang.String r12 = "crashsdk"
            com.uc.crashsdk.a.a.a(r12, r8, r2)     // Catch:{ all -> 0x0441 }
            if (r4 == 0) goto L_0x0374
            r4 = 13
            com.uc.crashsdk.f.a((int) r4)     // Catch:{ all -> 0x0441 }
        L_0x0374:
            long r12 = r3.f13597b     // Catch:{ all -> 0x0441 }
            long r14 = r0.length()     // Catch:{ all -> 0x0441 }
            long r12 = r12 + r14
            r3.f13597b = r12     // Catch:{ all -> 0x0441 }
            boolean r4 = b((java.io.File) r0)     // Catch:{ all -> 0x0441 }
            if (r4 == 0) goto L_0x038a
            int r4 = r3.f13598c     // Catch:{ all -> 0x0441 }
            r8 = 1
            int r4 = r4 + r8
            r3.f13598c = r4     // Catch:{ all -> 0x0441 }
            goto L_0x0390
        L_0x038a:
            r8 = 1
            int r4 = r3.f13599d     // Catch:{ all -> 0x0441 }
            int r4 = r4 + r8
            r3.f13599d = r4     // Catch:{ all -> 0x0441 }
        L_0x0390:
            java.lang.String r4 = U()     // Catch:{ all -> 0x0441 }
            com.uc.crashsdk.a.e r8 = new com.uc.crashsdk.a.e     // Catch:{ all -> 0x0441 }
            r12 = 2
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x0441 }
            r14 = 0
            r12[r14] = r4     // Catch:{ all -> 0x0441 }
            r13 = 1
            r12[r13] = r3     // Catch:{ all -> 0x0441 }
            r3 = 452(0x1c4, float:6.33E-43)
            r8.<init>(r3, r12)     // Catch:{ all -> 0x0441 }
            a((java.lang.String) r4, (com.uc.crashsdk.a.e) r8)     // Catch:{ all -> 0x0441 }
            r0.delete()     // Catch:{ all -> 0x0441 }
            r3 = 3
            r13 = 0
            goto L_0x03b8
        L_0x03ad:
            r14 = 0
            int r13 = r13 + 1
            if (r4 == 0) goto L_0x03b7
            r0 = 14
            com.uc.crashsdk.f.a((int) r0)     // Catch:{ all -> 0x0441 }
        L_0x03b7:
            r3 = 3
        L_0x03b8:
            if (r13 < r3) goto L_0x03c6
            java.lang.String r0 = "Upload failed 3 times continuously, abort upload!"
            java.lang.String r3 = "crashsdk"
            com.uc.crashsdk.a.a.a(r3, r0, r2)     // Catch:{ all -> 0x0441 }
            r12 = r19
            r11 = r20
            goto L_0x03de
        L_0x03c6:
            r12 = r19
            r15 = r23
            r8 = r26
        L_0x03cc:
            int r5 = r5 + 1
            r2 = r18
            r11 = r20
            r3 = r21
            r14 = r22
            goto L_0x005b
        L_0x03d8:
            r26 = r8
            r22 = r14
            r23 = r15
        L_0x03de:
            if (r7 <= 0) goto L_0x03e5
            r0 = 200(0xc8, float:2.8E-43)
            com.uc.crashsdk.f.a((int) r0, (int) r7)     // Catch:{ all -> 0x0441 }
        L_0x03e5:
            if (r6 <= 0) goto L_0x03ec
            r0 = 15
            com.uc.crashsdk.f.a((int) r0, (int) r6)     // Catch:{ all -> 0x0441 }
        L_0x03ec:
            if (r10 <= 0) goto L_0x03f3
            r0 = 17
            com.uc.crashsdk.f.a((int) r0, (int) r10)     // Catch:{ all -> 0x0441 }
        L_0x03f3:
            if (r22 == 0) goto L_0x03fa
            r0 = 19
            com.uc.crashsdk.f.a((int) r0)     // Catch:{ all -> 0x0441 }
        L_0x03fa:
            if (r23 == 0) goto L_0x0401
            r0 = 20
            com.uc.crashsdk.f.a((int) r0)     // Catch:{ all -> 0x0441 }
        L_0x0401:
            if (r16 == 0) goto L_0x0408
            r0 = 21
            com.uc.crashsdk.f.a((int) r0)     // Catch:{ all -> 0x0441 }
        L_0x0408:
            if (r22 != 0) goto L_0x040e
            if (r23 != 0) goto L_0x040e
            if (r16 == 0) goto L_0x0413
        L_0x040e:
            r0 = 18
            com.uc.crashsdk.f.a((int) r0)     // Catch:{ all -> 0x0441 }
        L_0x0413:
            if (r11 <= 0) goto L_0x041a
            r0 = 24
            com.uc.crashsdk.f.a((int) r0, (int) r11)     // Catch:{ all -> 0x0441 }
        L_0x041a:
            if (r9 <= 0) goto L_0x0421
            r0 = 201(0xc9, float:2.82E-43)
            com.uc.crashsdk.f.a((int) r0, (int) r9)     // Catch:{ all -> 0x0441 }
        L_0x0421:
            if (r12 <= 0) goto L_0x0428
            r0 = 25
            com.uc.crashsdk.f.a((int) r0, (int) r12)     // Catch:{ all -> 0x0441 }
        L_0x0428:
            if (r26 <= 0) goto L_0x0439
            r0 = 26
            r4 = r26
            com.uc.crashsdk.f.a((int) r0, (int) r4)     // Catch:{ all -> 0x0441 }
            goto L_0x0439
        L_0x0432:
            java.lang.String r0 = "upload url is empty!"
            java.lang.String r2 = "crashsdk"
            com.uc.crashsdk.a.a.a(r2, r0)     // Catch:{ all -> 0x0441 }
        L_0x0439:
            if (r32 == 0) goto L_0x044a
            android.os.ConditionVariable r0 = f13578o     // Catch:{ all -> 0x044c }
        L_0x043d:
            r0.open()     // Catch:{ all -> 0x044c }
            goto L_0x044a
        L_0x0441:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x044e }
            if (r32 == 0) goto L_0x044a
            android.os.ConditionVariable r0 = f13578o     // Catch:{ all -> 0x044c }
            goto L_0x043d
        L_0x044a:
            monitor-exit(r1)     // Catch:{ all -> 0x044c }
            return
        L_0x044c:
            r0 = move-exception
            goto L_0x0458
        L_0x044e:
            r0 = move-exception
            r2 = r0
            if (r32 == 0) goto L_0x0457
            android.os.ConditionVariable r0 = f13578o     // Catch:{ all -> 0x044c }
            r0.open()     // Catch:{ all -> 0x044c }
        L_0x0457:
            throw r2     // Catch:{ all -> 0x044c }
        L_0x0458:
            monitor-exit(r1)     // Catch:{ all -> 0x044c }
            goto L_0x045b
        L_0x045a:
            throw r0
        L_0x045b:
            goto L_0x045a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    public static boolean a(boolean z10, boolean z11) {
        if (!f13568d) {
            if (b.f13531d) {
                JNIBridge.set(1, true);
            }
            f13568d = true;
        }
        try {
            String k10 = k();
            if (g.a(k10)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            if (f.a(z10 ? 1 : 0, (Runnable) new com.uc.crashsdk.a.e(406, new Object[]{k10, Boolean.valueOf(z11), Boolean.valueOf(z10)})) && z10) {
                ConditionVariable conditionVariable = f13578o;
                conditionVariable.close();
                if (!conditionVariable.block(3000)) {
                    com.uc.crashsdk.a.a.a("crashsdk", "timeout to wait for uploading");
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.nio.channels.FileLock} */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0057, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0058, code lost:
        r1 = null;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        com.uc.crashsdk.a.g.a((java.lang.Throwable) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0060, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0061, code lost:
        r5 = r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0018] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r5, com.uc.crashsdk.a.e r6) {
        /*
            java.lang.Object r0 = f13579p
            monitor-enter(r0)
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0066 }
            r1.<init>(r5)     // Catch:{ all -> 0x0066 }
            boolean r5 = r1.exists()     // Catch:{ all -> 0x0066 }
            if (r5 != 0) goto L_0x0016
            r1.createNewFile()     // Catch:{ Exception -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            r5 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0066 }
        L_0x0016:
            r5 = 0
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            java.lang.String r4 = "rw"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            java.nio.channels.FileChannel r1 = r3.getChannel()     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            r6 = move-exception
            goto L_0x0062
        L_0x0026:
            r1 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ Exception -> 0x0057, all -> 0x0024 }
            r1 = r5
        L_0x002b:
            if (r1 == 0) goto L_0x0039
            java.nio.channels.FileLock r5 = r1.lock()     // Catch:{ Exception -> 0x0032 }
            goto L_0x0039
        L_0x0032:
            r3 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)     // Catch:{ Exception -> 0x0037 }
            goto L_0x0039
        L_0x0037:
            r5 = move-exception
            goto L_0x005a
        L_0x0039:
            boolean r2 = r6.a()     // Catch:{ all -> 0x004b }
            if (r5 == 0) goto L_0x0047
            r5.release()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r5 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r5)     // Catch:{ Exception -> 0x0037 }
        L_0x0047:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0066 }
            goto L_0x005e
        L_0x004b:
            r6 = move-exception
            if (r5 == 0) goto L_0x0056
            r5.release()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r5 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r5)     // Catch:{ Exception -> 0x0037 }
        L_0x0056:
            throw r6     // Catch:{ Exception -> 0x0037 }
        L_0x0057:
            r6 = move-exception
            r1 = r5
            r5 = r6
        L_0x005a:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0060 }
            goto L_0x0047
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            return r2
        L_0x0060:
            r6 = move-exception
            r5 = r1
        L_0x0062:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r5)     // Catch:{ all -> 0x0066 }
            throw r6     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            goto L_0x006a
        L_0x0069:
            throw r5
        L_0x006a:
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, com.uc.crashsdk.a.e):boolean");
    }

    private static boolean a(String str, d dVar) {
        String a10 = g.a(new File(str), 64, false);
        if (a10 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a10);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    dVar.f13597b = Long.parseLong(matcher.group(2));
                    dVar.f13598c = Integer.parseInt(matcher.group(3));
                    dVar.f13599d = Integer.parseInt(matcher.group(4));
                    dVar.f13596a = parseLong;
                }
            }
        } catch (Throwable th) {
            g.a(th);
        }
        return true;
    }

    public static boolean a(StringBuffer stringBuffer, String str, long j10, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j11;
        boolean z10;
        boolean a10;
        String str3 = str;
        if (f13567c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str3);
            return false;
        }
        boolean z11 = ag || b.L();
        if (!z11 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        } else if (!d(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str3);
            return false;
        } else if (aa()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str3);
            return false;
        } else if (stringBuffer == null || str3 == null) {
            return false;
        } else {
            String str4 = g.Y() + k(str);
            boolean z12 = (j10 & 32) != 0;
            if (z11) {
                long nativeClientCreateConnection = b.f13531d ? JNIBridge.nativeClientCreateConnection(str4, "custom", str3, z12 ? 1 : 0) : 0;
                if (nativeClientCreateConnection == 0) {
                    com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str3);
                    return false;
                }
                j11 = nativeClientCreateConnection;
            } else if (a(h(), str3, z12)) {
                return false;
            } else {
                g.a();
                a(false);
                j11 = 0;
            }
            synchronized (f13580q) {
                z10 = z12;
                a10 = a(str4, j11, stringBuffer, str, j10, arrayList, arrayList2, arrayList3, str2);
            }
            if (a10 && !z11) {
                b(h(), str3, z10);
            }
            if (j11 != 0) {
                JNIBridge.nativeClientCloseConnection(j11);
            }
            if (!a10) {
                return false;
            }
            if (!z11) {
                r(str4);
            }
            if (!z11) {
                str4 = a(m(str4));
            }
            b(str4, str3);
            if (!z10 || z11) {
                return true;
            }
            try {
                a(true, false);
                return true;
            } catch (Throwable th) {
                g.a(th);
                return true;
            }
        }
    }

    public static boolean a(String str, String str2, boolean z10) {
        if (!o(str2)) {
            return false;
        }
        h.a(str, str2, true, z10);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", new Object[]{str2}));
        return true;
    }

    private static void a(a aVar, String str, long j10) {
        String str2;
        String str3 = null;
        if (b.f13531d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                g.a(th);
            }
            str2 = JNIBridge.nativeDumpThreads(str, j10);
            if (ag || str2 == null || str2.length() >= 512 || !str2.startsWith(Operator.Operation.DIVISION) || str2.indexOf(10) >= 0) {
                str3 = str2;
            } else {
                if (!new File(str2).exists()) {
                    str3 = "Can not found " + str2;
                }
                String str4 = str3;
                str3 = str2;
                str2 = str4;
            }
        } else {
            str2 = "Native not initialized, skip dump!";
        }
        if (str2 != null) {
            try {
                aVar.write(str2.getBytes("UTF-8"));
                aVar.write("\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str3 != null && !ag) {
            b((OutputStream) aVar, str3, (int) LogType.ANR);
            File file = new File(str3);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            g.a(th3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r17, long r18, java.lang.StringBuffer r20, java.lang.String r21, long r22, java.util.ArrayList<java.lang.String> r24, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.lang.String r27) {
        /*
            r1 = r17
            r2 = r18
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = 0
            r10 = 0
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x001e
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x001a }
            r0.<init>(r1)     // Catch:{ all -> 0x001a }
            r11 = r0
            goto L_0x001f
        L_0x001a:
            r0 = move-exception
            r11 = r10
            r12 = r11
            goto L_0x003d
        L_0x001e:
            r11 = r10
        L_0x001f:
            com.uc.crashsdk.e$a r12 = new com.uc.crashsdk.e$a     // Catch:{ all -> 0x003b }
            r12.<init>(r2, r11)     // Catch:{ all -> 0x003b }
            java.util.ArrayList<java.lang.String> r13 = f13582s     // Catch:{ all -> 0x0039 }
            monitor-enter(r13)     // Catch:{ all -> 0x0039 }
            f13584u = r1     // Catch:{ all -> 0x0036 }
            boolean r0 = com.uc.crashsdk.b.f13531d     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = f13584u     // Catch:{ all -> 0x0036 }
            r14 = 126(0x7e, float:1.77E-43)
            com.uc.crashsdk.JNIBridge.set((int) r14, (java.lang.String) r0)     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r13)     // Catch:{ all -> 0x0036 }
            goto L_0x0040
        L_0x0036:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0036 }
            throw r0     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r0 = move-exception
            goto L_0x003d
        L_0x003b:
            r0 = move-exception
            r12 = r10
        L_0x003d:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0040:
            r13 = 0
            if (r12 != 0) goto L_0x004a
            com.uc.crashsdk.a.g.a((java.io.Closeable) r12)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r11)
            return r13
        L_0x004a:
            r14 = 1
            long r14 = r22 & r14
            r16 = 1
            int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x005d
            r14 = r21
            b((java.io.OutputStream) r12, (java.lang.String) r1, (java.lang.String) r14)     // Catch:{ all -> 0x005a }
            goto L_0x005d
        L_0x005a:
            r0 = move-exception
            goto L_0x013d
        L_0x005d:
            java.lang.String r0 = r20.toString()     // Catch:{ all -> 0x0077 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0077 }
            r12.write((byte[]) r0)     // Catch:{ all -> 0x0077 }
            java.lang.String r0 = "\n"
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch:{ all -> 0x0077 }
            r12.write((byte[]) r0)     // Catch:{ all -> 0x0077 }
            r12.flush()     // Catch:{ all -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
        L_0x007b:
            a((java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
            r0 = 4
            long r0 = r22 & r0
            int r14 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r14 == 0) goto L_0x0092
            b((java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
            r12.flush()     // Catch:{ all -> 0x008d }
            goto L_0x0092
        L_0x008d:
            r0 = move-exception
            r1 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x005a }
        L_0x0092:
            if (r4 == 0) goto L_0x009f
            int r0 = r24.size()     // Catch:{ all -> 0x005a }
            if (r0 <= 0) goto L_0x009f
            java.lang.String r0 = "UTF-8"
            com.uc.crashsdk.a.a((java.io.OutputStream) r12, (java.lang.String) r0, (java.util.ArrayList<java.lang.String>) r4)     // Catch:{ all -> 0x005a }
        L_0x009f:
            if (r5 == 0) goto L_0x00ae
            int r0 = r25.size()     // Catch:{ all -> 0x005a }
            if (r0 <= 0) goto L_0x00ae
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n"
            com.uc.crashsdk.a.a(r12, r0, r1, r5)     // Catch:{ all -> 0x005a }
        L_0x00ae:
            if (r6 == 0) goto L_0x00bd
            int r0 = r26.size()     // Catch:{ all -> 0x005a }
            if (r0 <= 0) goto L_0x00bd
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n"
            com.uc.crashsdk.a.b(r12, r0, r1, r6)     // Catch:{ all -> 0x005a }
        L_0x00bd:
            if (r7 == 0) goto L_0x00e9
            r12.flush()     // Catch:{ all -> 0x00c3 }
            goto L_0x00c8
        L_0x00c3:
            r0 = move-exception
            r1 = r0
            a((java.lang.Throwable) r1, (java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
        L_0x00c8:
            java.lang.String r0 = "threads dump:\n"
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch:{ all -> 0x00d4 }
            r12.write((byte[]) r0)     // Catch:{ all -> 0x00d4 }
            goto L_0x00d8
        L_0x00d4:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
        L_0x00d8:
            f13571h = r13     // Catch:{ all -> 0x005a }
            f13586w = r7     // Catch:{ all -> 0x005a }
            a((com.uc.crashsdk.e.a) r12, (java.lang.String) r7, (long) r2)     // Catch:{ all -> 0x00e0 }
            goto L_0x00e5
        L_0x00e0:
            r0 = move-exception
            r1 = r0
            a((java.lang.Throwable) r1, (java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
        L_0x00e5:
            f13586w = r10     // Catch:{ all -> 0x005a }
            f13571h = r16     // Catch:{ all -> 0x005a }
        L_0x00e9:
            r0 = 8
            long r0 = r22 & r0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x011c
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x011c
            r12.flush()     // Catch:{ all -> 0x00f9 }
            goto L_0x00fe
        L_0x00f9:
            r0 = move-exception
            r1 = r0
            a((java.lang.Throwable) r1, (java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
        L_0x00fe:
            java.lang.String r0 = "all threads dump:\n"
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch:{ all -> 0x010a }
            r12.write((byte[]) r0)     // Catch:{ all -> 0x010a }
            goto L_0x010e
        L_0x010a:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
        L_0x010e:
            f13585v = r16     // Catch:{ all -> 0x005a }
            java.lang.String r0 = "all"
            a((com.uc.crashsdk.e.a) r12, (java.lang.String) r0, (long) r8)     // Catch:{ all -> 0x0116 }
            goto L_0x011a
        L_0x0116:
            r0 = move-exception
            a((java.lang.Throwable) r0, (java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
        L_0x011a:
            f13585v = r13     // Catch:{ all -> 0x005a }
        L_0x011c:
            r0 = 16
            long r0 = r22 & r0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0127
            e((java.io.OutputStream) r12)     // Catch:{ all -> 0x005a }
        L_0x0127:
            r0 = 2
            long r0 = r22 & r0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0135
            r12.a()     // Catch:{ all -> 0x005a }
            a((com.uc.crashsdk.e.a) r12)     // Catch:{ all -> 0x005a }
        L_0x0135:
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0140
            b((com.uc.crashsdk.e.a) r12)     // Catch:{ all -> 0x005a }
            goto L_0x0140
        L_0x013d:
            a((java.lang.Throwable) r0, (java.io.OutputStream) r12)     // Catch:{ all -> 0x0183 }
        L_0x0140:
            com.uc.crashsdk.a.g.a((java.io.Closeable) r12)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r11)
            java.util.ArrayList<java.lang.String> r1 = f13582s     // Catch:{ all -> 0x017e }
            monitor-enter(r1)     // Catch:{ all -> 0x017e }
            int r0 = f13583t     // Catch:{ all -> 0x017b }
            int r0 = r0 + 1
            f13583t = r0     // Catch:{ all -> 0x017b }
            java.lang.String r0 = f13584u     // Catch:{ all -> 0x017b }
            if (r0 == 0) goto L_0x016d
            r1.add(r0)     // Catch:{ all -> 0x017b }
            int r0 = r1.size()     // Catch:{ all -> 0x017b }
            r2 = 3
            if (r0 <= r2) goto L_0x0160
            r1.remove(r13)     // Catch:{ all -> 0x017b }
        L_0x0160:
            boolean r0 = com.uc.crashsdk.b.f13531d     // Catch:{ all -> 0x017b }
            if (r0 == 0) goto L_0x016b
            java.lang.String r0 = f13584u     // Catch:{ all -> 0x017b }
            r2 = 127(0x7f, float:1.78E-43)
            com.uc.crashsdk.JNIBridge.set((int) r2, (java.lang.String) r0)     // Catch:{ all -> 0x017b }
        L_0x016b:
            f13584u = r10     // Catch:{ all -> 0x017b }
        L_0x016d:
            boolean r0 = com.uc.crashsdk.b.f13531d     // Catch:{ all -> 0x017b }
            if (r0 == 0) goto L_0x0179
            int r0 = f13583t     // Catch:{ all -> 0x017b }
            long r2 = (long) r0     // Catch:{ all -> 0x017b }
            r0 = 25
            com.uc.crashsdk.JNIBridge.set((int) r0, (long) r2)     // Catch:{ all -> 0x017b }
        L_0x0179:
            monitor-exit(r1)     // Catch:{ all -> 0x017b }
            goto L_0x0182
        L_0x017b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x017b }
            throw r0     // Catch:{ all -> 0x017e }
        L_0x017e:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0182:
            return r16
        L_0x0183:
            r0 = move-exception
            r1 = r0
            com.uc.crashsdk.a.g.a((java.io.Closeable) r12)
            com.uc.crashsdk.a.g.a((java.io.Closeable) r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", new Object[]{Integer.valueOf(date.getYear() + SSDP.PORT), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds())});
    }

    public static void a(OutputStream outputStream, String str, String str2, int i10, boolean z10, boolean z11) {
        int i11 = 0;
        f13571h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i10);
            objArr[3] = Integer.valueOf(z10 ? 1 : 0);
            if (z11) {
                i11 = 1;
            }
            objArr[4] = Integer.valueOf(i11);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            g.a(th);
        }
        f13571h = true;
        a(outputStream);
    }

    public static void a(OutputStream outputStream, String str, String str2) {
        f13571h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", new Object[]{str, str2}).getBytes("UTF-8"));
        } catch (Throwable th) {
            g.a(th);
        }
        f13571h = true;
    }

    public static void a(Context context) {
        try {
            if (V()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), (String) null, f.a(3));
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:373:0x04b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:?, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x055c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:433:0x057a, code lost:
        com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + r2);
        a(r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:446:?, code lost:
        a(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:447:0x05a7, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x05a9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:449:0x05aa, code lost:
        r3 = r0;
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:450:0x05ad, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x05ae, code lost:
        r3 = r0;
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:452:0x05b0, code lost:
        com.uc.crashsdk.a.g.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:464:0x05cf, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:480:0x060b, code lost:
        android.os.Process.killProcess(android.os.Process.myPid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:553:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:555:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:266:0x034c, B:371:0x04b0] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0205 A[SYNTHETIC, Splitter:B:148:0x0205] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0269 A[Catch:{ all -> 0x0292 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x02ea A[Catch:{ all -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0390 A[Catch:{ all -> 0x03b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x0415 A[Catch:{ all -> 0x043e }] */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0488 A[Catch:{ all -> 0x04b4, all -> 0x055c }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x04e4 A[SYNTHETIC, Splitter:B:384:0x04e4] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0518 A[Catch:{ all -> 0x0541 }] */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x057a A[Catch:{ all -> 0x0613, all -> 0x0635, all -> 0x0632, all -> 0x0647, all -> 0x067f }] */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x059b A[SYNTHETIC, Splitter:B:440:0x059b] */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x05cf A[Catch:{ all -> 0x05f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x060b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008e A[Catch:{ all -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:534:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:537:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:540:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:543:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:546:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:549:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:552:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:555:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0115 A[Catch:{ all -> 0x013e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Thread r20, java.lang.Throwable r21, boolean r22) {
        /*
            r19 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "original exception is: "
            java.lang.String r4 = "crashsdk"
            java.lang.String r5 = "Call java default handler: "
            java.lang.String r6 = "DEBUG"
            boolean r0 = ag
            r7 = 1
            r8 = 0
            if (r0 == 0) goto L_0x0016
            boolean r0 = com.uc.crashsdk.b.f13531d
            if (r0 != 0) goto L_0x001c
        L_0x0016:
            boolean r0 = com.uc.crashsdk.b.L()
            if (r0 == 0) goto L_0x001e
        L_0x001c:
            r9 = 1
            goto L_0x001f
        L_0x001e:
            r9 = 0
        L_0x001f:
            java.util.concurrent.atomic.AtomicBoolean r0 = f13567c     // Catch:{ all -> 0x0560 }
            boolean r0 = r0.getAndSet(r7)     // Catch:{ all -> 0x0560 }
            r12 = 4
            if (r0 == 0) goto L_0x00d1
            int r0 = android.os.Process.myPid()     // Catch:{ all -> 0x0560 }
            if (r0 <= 0) goto L_0x00d1
            java.lang.String r0 = "another thread is generating java report!"
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x0560 }
            java.lang.String r0 = "current thread exception is:"
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x0560 }
            a((java.lang.Throwable) r21)     // Catch:{ all -> 0x0560 }
            boolean r0 = com.uc.crashsdk.g.j()     // Catch:{ all -> 0x0560 }
            if (r0 == 0) goto L_0x005b
            r13 = 0
        L_0x0042:
            boolean r0 = V     // Catch:{ all -> 0x0560 }
            if (r0 != 0) goto L_0x0054
            r14 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r14)     // Catch:{ all -> 0x004c }
            goto L_0x0051
        L_0x004c:
            r0 = move-exception
            r14 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r14)     // Catch:{ all -> 0x0560 }
        L_0x0051:
            int r13 = r13 + r7
            if (r13 < r12) goto L_0x0042
        L_0x0054:
            int r0 = android.os.Process.myPid()     // Catch:{ all -> 0x0560 }
            android.os.Process.killProcess(r0)     // Catch:{ all -> 0x0560 }
        L_0x005b:
            if (r22 == 0) goto L_0x0073
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0073
            if (r9 != 0) goto L_0x0073
            a((boolean) r7, (boolean) r8)     // Catch:{ all -> 0x006a }
            r3 = 1
            goto L_0x0074
        L_0x006a:
            r0 = move-exception
            r3 = 1
            goto L_0x006f
        L_0x006d:
            r0 = move-exception
            r3 = 0
        L_0x006f:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            if (r3 != 0) goto L_0x007b
            if (r9 != 0) goto L_0x007b
            b((boolean) r8)
        L_0x007b:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x007f }
            goto L_0x0084
        L_0x007f:
            r0 = move-exception
            r3 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
        L_0x0084:
            boolean r0 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x00b7 }
            boolean r3 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x00b7 }
            if (r3 != 0) goto L_0x008f
            r0 = 1
        L_0x008f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r3.<init>(r5)     // Catch:{ all -> 0x00b7 }
            r3.append(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b7 }
            com.uc.crashsdk.a.a.a(r4, r3)     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00a7
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00a7
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x00b7 }
        L_0x00a7:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00bb
            if (r9 != 0) goto L_0x00bb
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x00b7 }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x00bb:
            V = r7
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x00d0
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x00d0
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x00d0:
            return
        L_0x00d1:
            U = r2     // Catch:{ all -> 0x0560 }
            if (r9 != 0) goto L_0x0158
            boolean r0 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x0560 }
            if (r0 != 0) goto L_0x0158
            java.lang.String r0 = com.uc.crashsdk.a.d.b()     // Catch:{ all -> 0x0560 }
            com.uc.crashsdk.a.a.c(r6, r0)     // Catch:{ all -> 0x0560 }
            if (r22 == 0) goto L_0x00fa
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x00fa
            if (r9 != 0) goto L_0x00fa
            a((boolean) r7, (boolean) r8)     // Catch:{ all -> 0x00f1 }
            r3 = 1
            goto L_0x00fb
        L_0x00f1:
            r0 = move-exception
            r3 = 1
            goto L_0x00f6
        L_0x00f4:
            r0 = move-exception
            r3 = 0
        L_0x00f6:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
            goto L_0x00fb
        L_0x00fa:
            r3 = 0
        L_0x00fb:
            if (r3 != 0) goto L_0x0102
            if (r9 != 0) goto L_0x0102
            b((boolean) r8)
        L_0x0102:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x0106 }
            goto L_0x010b
        L_0x0106:
            r0 = move-exception
            r3 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
        L_0x010b:
            boolean r0 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x013e }
            boolean r3 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x013e }
            if (r3 != 0) goto L_0x0116
            r0 = 1
        L_0x0116:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            r3.<init>(r5)     // Catch:{ all -> 0x013e }
            r3.append(r0)     // Catch:{ all -> 0x013e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x013e }
            com.uc.crashsdk.a.a.a(r4, r3)     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x012e
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x012e
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x013e }
        L_0x012e:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x0142
            if (r9 != 0) goto L_0x0142
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x013e }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x013e }
            goto L_0x0142
        L_0x013e:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0142:
            V = r7
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x0157
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x0157
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x0157:
            return
        L_0x0158:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0560 }
            java.lang.String r13 = "encryptLog: "
            r0.<init>(r13)     // Catch:{ all -> 0x0560 }
            boolean r13 = com.uc.crashsdk.g.y()     // Catch:{ all -> 0x0560 }
            r0.append(r13)     // Catch:{ all -> 0x0560 }
            java.lang.String r13 = ", zipCrashLog: "
            r0.append(r13)     // Catch:{ all -> 0x0560 }
            boolean r13 = com.uc.crashsdk.g.y()     // Catch:{ all -> 0x0560 }
            r0.append(r13)     // Catch:{ all -> 0x0560 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0560 }
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x0560 }
            java.lang.RuntimeException r0 = com.uc.crashsdk.g.f13612a     // Catch:{ all -> 0x0560 }
            if (r0 == 0) goto L_0x0187
            java.lang.String r0 = "the set zip log to false stack is:"
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x0560 }
            java.lang.RuntimeException r0 = com.uc.crashsdk.g.f13612a     // Catch:{ all -> 0x0560 }
            r0.printStackTrace()     // Catch:{ all -> 0x0560 }
        L_0x0187:
            java.lang.RuntimeException r0 = com.uc.crashsdk.g.f13613b     // Catch:{ all -> 0x0560 }
            if (r0 == 0) goto L_0x0195
            java.lang.String r0 = "the set encrypt to true stack is:"
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x0560 }
            java.lang.RuntimeException r0 = com.uc.crashsdk.g.f13613b     // Catch:{ all -> 0x0560 }
            r0.printStackTrace()     // Catch:{ all -> 0x0560 }
        L_0x0195:
            java.lang.String r0 = "begin to generate java report"
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x0560 }
            r19.N()     // Catch:{ all -> 0x019e }
            goto L_0x01a3
        L_0x019e:
            r0 = move-exception
            r13 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r13)     // Catch:{ all -> 0x0560 }
        L_0x01a3:
            boolean r14 = com.uc.crashsdk.g.u()     // Catch:{ all -> 0x01d5 }
            java.lang.String r0 = com.uc.crashsdk.g.g()     // Catch:{ all -> 0x01d3 }
            if (r0 == 0) goto L_0x01b5
            java.lang.String r15 = ""
            boolean r15 = r0.equals(r15)     // Catch:{ all -> 0x01d3 }
            if (r15 == 0) goto L_0x01bd
        L_0x01b5:
            java.lang.String r0 = S()     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = k(r0)     // Catch:{ all -> 0x01d3 }
        L_0x01bd:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d3 }
            r15.<init>()     // Catch:{ all -> 0x01d3 }
            java.lang.String r10 = com.uc.crashsdk.g.Y()     // Catch:{ all -> 0x01d3 }
            r15.append(r10)     // Catch:{ all -> 0x01d3 }
            r15.append(r0)     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = r15.toString()     // Catch:{ all -> 0x01d3 }
            r10 = r0
            r11 = 0
            goto L_0x01ff
        L_0x01d3:
            r0 = move-exception
            goto L_0x01d7
        L_0x01d5:
            r0 = move-exception
            r14 = 0
        L_0x01d7:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0560 }
            java.lang.String r11 = "get java log name failed: "
            r10.<init>(r11)     // Catch:{ all -> 0x0560 }
            r10.append(r0)     // Catch:{ all -> 0x0560 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0560 }
            com.uc.crashsdk.a.a.d(r6, r10)     // Catch:{ all -> 0x0560 }
            a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0560 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0560 }
            r0.<init>(r3)     // Catch:{ all -> 0x0560 }
            r0.append(r2)     // Catch:{ all -> 0x0560 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0560 }
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x0560 }
            a((java.lang.Throwable) r21)     // Catch:{ all -> 0x0560 }
            r10 = 0
            r11 = 1
        L_0x01ff:
            java.lang.String r15 = "omit java crash"
            java.lang.String r13 = "java"
            if (r9 != 0) goto L_0x0331
            com.uc.crashsdk.g.a()     // Catch:{ all -> 0x021c }
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x0217 }
            if (r0 == 0) goto L_0x0213
            r0 = 3
            com.uc.crashsdk.f.a((int) r0)     // Catch:{ all -> 0x0217 }
            goto L_0x0220
        L_0x0213:
            com.uc.crashsdk.f.a((int) r12)     // Catch:{ all -> 0x0217 }
            goto L_0x0220
        L_0x0217:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x021c }
            goto L_0x0220
        L_0x021c:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x055e }
        L_0x0220:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x022d }
            java.lang.String r12 = com.uc.crashsdk.b.b()     // Catch:{ all -> 0x022d }
            r0.<init>(r12)     // Catch:{ all -> 0x022d }
            r0.createNewFile()     // Catch:{ all -> 0x022d }
            goto L_0x0231
        L_0x022d:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x055e }
        L_0x0231:
            if (r14 == 0) goto L_0x02ac
            com.uc.crashsdk.a.a.d(r6, r15)     // Catch:{ all -> 0x055e }
            if (r22 == 0) goto L_0x024e
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x0248 }
            if (r0 == 0) goto L_0x024e
            if (r9 != 0) goto L_0x024e
            a((boolean) r7, (boolean) r8)     // Catch:{ all -> 0x0245 }
            r3 = 1
            goto L_0x024f
        L_0x0245:
            r0 = move-exception
            r3 = 1
            goto L_0x024a
        L_0x0248:
            r0 = move-exception
            r3 = 0
        L_0x024a:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
            goto L_0x024f
        L_0x024e:
            r3 = 0
        L_0x024f:
            if (r3 != 0) goto L_0x0256
            if (r9 != 0) goto L_0x0256
            b((boolean) r8)
        L_0x0256:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x025a }
            goto L_0x025f
        L_0x025a:
            r0 = move-exception
            r3 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
        L_0x025f:
            boolean r0 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x0292 }
            boolean r3 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x0292 }
            if (r3 != 0) goto L_0x026a
            r0 = 1
        L_0x026a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0292 }
            r3.<init>(r5)     // Catch:{ all -> 0x0292 }
            r3.append(r0)     // Catch:{ all -> 0x0292 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0292 }
            com.uc.crashsdk.a.a.a(r4, r3)     // Catch:{ all -> 0x0292 }
            if (r0 == 0) goto L_0x0282
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x0292 }
            if (r0 == 0) goto L_0x0282
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x0292 }
        L_0x0282:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x0292 }
            if (r0 == 0) goto L_0x0296
            if (r9 != 0) goto L_0x0296
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x0292 }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x0292 }
            goto L_0x0296
        L_0x0292:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0296:
            V = r7
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x02ab
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x02ab
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x02ab:
            return
        L_0x02ac:
            boolean r0 = d((java.lang.String) r13)     // Catch:{ all -> 0x055e }
            if (r0 != 0) goto L_0x032d
            java.lang.String r0 = "java log sample miss"
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x055e }
            if (r22 == 0) goto L_0x02cf
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x02c9 }
            if (r0 == 0) goto L_0x02cf
            if (r9 != 0) goto L_0x02cf
            a((boolean) r7, (boolean) r8)     // Catch:{ all -> 0x02c6 }
            r3 = 1
            goto L_0x02d0
        L_0x02c6:
            r0 = move-exception
            r3 = 1
            goto L_0x02cb
        L_0x02c9:
            r0 = move-exception
            r3 = 0
        L_0x02cb:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
            goto L_0x02d0
        L_0x02cf:
            r3 = 0
        L_0x02d0:
            if (r3 != 0) goto L_0x02d7
            if (r9 != 0) goto L_0x02d7
            b((boolean) r8)
        L_0x02d7:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x02db }
            goto L_0x02e0
        L_0x02db:
            r0 = move-exception
            r3 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
        L_0x02e0:
            boolean r0 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x0313 }
            boolean r3 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x0313 }
            if (r3 != 0) goto L_0x02eb
            r0 = 1
        L_0x02eb:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0313 }
            r3.<init>(r5)     // Catch:{ all -> 0x0313 }
            r3.append(r0)     // Catch:{ all -> 0x0313 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0313 }
            com.uc.crashsdk.a.a.a(r4, r3)     // Catch:{ all -> 0x0313 }
            if (r0 == 0) goto L_0x0303
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x0313 }
            if (r0 == 0) goto L_0x0303
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x0313 }
        L_0x0303:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x0313 }
            if (r0 == 0) goto L_0x0317
            if (r9 != 0) goto L_0x0317
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x0313 }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x0313 }
            goto L_0x0317
        L_0x0313:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0317:
            V = r7
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x032c
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x032c
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x032c:
            return
        L_0x032d:
            r12 = 0
            goto L_0x0458
        L_0x0331:
            if (r14 == 0) goto L_0x0338
            java.lang.String r10 = "omit"
            com.uc.crashsdk.a.a.d(r6, r15)     // Catch:{ all -> 0x055e }
        L_0x0338:
            boolean r0 = com.uc.crashsdk.b.f13531d     // Catch:{ all -> 0x055e }
            if (r0 == 0) goto L_0x0342
            r12 = 0
            long r12 = com.uc.crashsdk.JNIBridge.nativeClientCreateConnection(r10, r13, r12, r8)     // Catch:{ all -> 0x055e }
            goto L_0x0344
        L_0x0342:
            r12 = 0
        L_0x0344:
            r15 = 0
            int r0 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r0 != 0) goto L_0x03d3
            java.lang.String r0 = "skip java crash:"
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x055c }
            a((java.lang.Throwable) r21)     // Catch:{ all -> 0x055c }
            int r0 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x035d
            boolean r0 = com.uc.crashsdk.b.f13531d
            if (r0 == 0) goto L_0x035d
            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(r12)
        L_0x035d:
            if (r22 == 0) goto L_0x0375
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x036f }
            if (r0 == 0) goto L_0x0375
            if (r9 != 0) goto L_0x0375
            a((boolean) r7, (boolean) r8)     // Catch:{ all -> 0x036c }
            r3 = 1
            goto L_0x0376
        L_0x036c:
            r0 = move-exception
            r3 = 1
            goto L_0x0371
        L_0x036f:
            r0 = move-exception
            r3 = 0
        L_0x0371:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
            goto L_0x0376
        L_0x0375:
            r3 = 0
        L_0x0376:
            if (r3 != 0) goto L_0x037d
            if (r9 != 0) goto L_0x037d
            b((boolean) r8)
        L_0x037d:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x0381 }
            goto L_0x0386
        L_0x0381:
            r0 = move-exception
            r3 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
        L_0x0386:
            boolean r0 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x03b9 }
            boolean r3 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x03b9 }
            if (r3 != 0) goto L_0x0391
            r0 = 1
        L_0x0391:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b9 }
            r3.<init>(r5)     // Catch:{ all -> 0x03b9 }
            r3.append(r0)     // Catch:{ all -> 0x03b9 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03b9 }
            com.uc.crashsdk.a.a.a(r4, r3)     // Catch:{ all -> 0x03b9 }
            if (r0 == 0) goto L_0x03a9
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x03b9 }
            if (r0 == 0) goto L_0x03a9
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x03b9 }
        L_0x03a9:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x03b9 }
            if (r0 == 0) goto L_0x03bd
            if (r9 != 0) goto L_0x03bd
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x03b9 }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x03b9 }
            goto L_0x03bd
        L_0x03b9:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x03bd:
            V = r7
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x03d2
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x03d2
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x03d2:
            return
        L_0x03d3:
            if (r14 == 0) goto L_0x0458
            r10 = 0
            int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x03e2
            boolean r0 = com.uc.crashsdk.b.f13531d
            if (r0 == 0) goto L_0x03e2
            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(r12)
        L_0x03e2:
            if (r22 == 0) goto L_0x03fa
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x03f4 }
            if (r0 == 0) goto L_0x03fa
            if (r9 != 0) goto L_0x03fa
            a((boolean) r7, (boolean) r8)     // Catch:{ all -> 0x03f1 }
            r3 = 1
            goto L_0x03fb
        L_0x03f1:
            r0 = move-exception
            r3 = 1
            goto L_0x03f6
        L_0x03f4:
            r0 = move-exception
            r3 = 0
        L_0x03f6:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
            goto L_0x03fb
        L_0x03fa:
            r3 = 0
        L_0x03fb:
            if (r3 != 0) goto L_0x0402
            if (r9 != 0) goto L_0x0402
            b((boolean) r8)
        L_0x0402:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x0406 }
            goto L_0x040b
        L_0x0406:
            r0 = move-exception
            r3 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
        L_0x040b:
            boolean r0 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x043e }
            boolean r3 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x043e }
            if (r3 != 0) goto L_0x0416
            r0 = 1
        L_0x0416:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x043e }
            r3.<init>(r5)     // Catch:{ all -> 0x043e }
            r3.append(r0)     // Catch:{ all -> 0x043e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x043e }
            com.uc.crashsdk.a.a.a(r4, r3)     // Catch:{ all -> 0x043e }
            if (r0 == 0) goto L_0x042e
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x043e }
            if (r0 == 0) goto L_0x042e
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x043e }
        L_0x042e:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x043e }
            if (r0 == 0) goto L_0x0442
            if (r9 != 0) goto L_0x0442
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x043e }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x043e }
            goto L_0x0442
        L_0x043e:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0442:
            V = r7
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x0457
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x0457
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x0457:
            return
        L_0x0458:
            boolean r0 = r2 instanceof java.lang.OutOfMemoryError     // Catch:{ all -> 0x055c }
            a(r2, r10, r12, r0)     // Catch:{ all -> 0x055c }
            java.lang.String r14 = "generate java report finished"
            com.uc.crashsdk.a.a.d(r6, r14)     // Catch:{ all -> 0x055c }
            boolean r14 = com.uc.crashsdk.b.L()     // Catch:{ all -> 0x055c }
            if (r14 != 0) goto L_0x04d5
            if (r0 == 0) goto L_0x04d5
            boolean r0 = com.uc.crashsdk.g.k()     // Catch:{ all -> 0x055c }
            if (r0 == 0) goto L_0x04d5
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x055c }
            r0.<init>(r10)     // Catch:{ all -> 0x055c }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x055c }
            java.lang.String r10 = com.uc.crashsdk.g.Z()     // Catch:{ all -> 0x055c }
            java.io.File r14 = new java.io.File     // Catch:{ all -> 0x055c }
            r14.<init>(r10)     // Catch:{ all -> 0x055c }
            boolean r15 = r14.exists()     // Catch:{ all -> 0x055c }
            if (r15 != 0) goto L_0x048b
            r14.mkdirs()     // Catch:{ all -> 0x055c }
        L_0x048b:
            java.util.Locale r14 = java.util.Locale.US     // Catch:{ all -> 0x055c }
            java.lang.String r15 = "%s%s.hprof"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x055c }
            r7[r8] = r10     // Catch:{ all -> 0x055c }
            r10 = 1
            r7[r10] = r0     // Catch:{ all -> 0x055c }
            java.lang.String r0 = java.lang.String.format(r14, r15, r7)     // Catch:{ all -> 0x055c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x055c }
            java.lang.String r10 = "begin dump hprof: "
            r7.<init>(r10)     // Catch:{ all -> 0x055c }
            r7.append(r0)     // Catch:{ all -> 0x055c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x055c }
            com.uc.crashsdk.a.a.d(r6, r7)     // Catch:{ all -> 0x055c }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x055c }
            android.os.Debug.dumpHprofData(r0)     // Catch:{ all -> 0x04b4 }
            goto L_0x04b9
        L_0x04b4:
            r0 = move-exception
            r7 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r7)     // Catch:{ all -> 0x055c }
        L_0x04b9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x055c }
            java.lang.String r7 = "end dump hprof, use "
            r0.<init>(r7)     // Catch:{ all -> 0x055c }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x055c }
            long r14 = r17 - r14
            r0.append(r14)     // Catch:{ all -> 0x055c }
            java.lang.String r7 = " ms"
            r0.append(r7)     // Catch:{ all -> 0x055c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x055c }
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x055c }
        L_0x04d5:
            r6 = 0
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x04e2
            boolean r0 = com.uc.crashsdk.b.f13531d
            if (r0 == 0) goto L_0x04e2
            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(r12)
        L_0x04e2:
            if (r22 == 0) goto L_0x04fd
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x04f6 }
            if (r0 == 0) goto L_0x04fd
            if (r9 != 0) goto L_0x04fd
            r3 = 1
            a((boolean) r3, (boolean) r8)     // Catch:{ all -> 0x04f2 }
            r0 = 1
            goto L_0x04fe
        L_0x04f2:
            r0 = move-exception
            r3 = r0
            r0 = 1
            goto L_0x04f9
        L_0x04f6:
            r0 = move-exception
            r3 = r0
            r0 = 0
        L_0x04f9:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
            goto L_0x04fe
        L_0x04fd:
            r0 = 0
        L_0x04fe:
            if (r0 != 0) goto L_0x0505
            if (r9 != 0) goto L_0x0505
            b((boolean) r8)
        L_0x0505:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x0509 }
            goto L_0x050e
        L_0x0509:
            r0 = move-exception
            r3 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
        L_0x050e:
            boolean r0 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x0541 }
            boolean r3 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x0541 }
            if (r3 != 0) goto L_0x0519
            r0 = 1
        L_0x0519:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0541 }
            r3.<init>(r5)     // Catch:{ all -> 0x0541 }
            r3.append(r0)     // Catch:{ all -> 0x0541 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0541 }
            com.uc.crashsdk.a.a.a(r4, r3)     // Catch:{ all -> 0x0541 }
            if (r0 == 0) goto L_0x0531
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x0541 }
            if (r0 == 0) goto L_0x0531
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x0541 }
        L_0x0531:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x0541 }
            if (r0 == 0) goto L_0x0545
            if (r9 != 0) goto L_0x0545
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x0541 }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x0541 }
            goto L_0x0545
        L_0x0541:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0545:
            r1 = 1
            V = r1
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x055b
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x055b
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x055b:
            return
        L_0x055c:
            r0 = move-exception
            goto L_0x0564
        L_0x055e:
            r0 = move-exception
            goto L_0x0562
        L_0x0560:
            r0 = move-exception
            r11 = 0
        L_0x0562:
            r12 = 0
        L_0x0564:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0613 }
            java.lang.String r10 = "exception occurs while java log: "
            r7.<init>(r10)     // Catch:{ all -> 0x0613 }
            r7.append(r0)     // Catch:{ all -> 0x0613 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0613 }
            com.uc.crashsdk.a.a.d(r6, r7)     // Catch:{ all -> 0x0613 }
            a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0613 }
            if (r11 != 0) goto L_0x058c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0613 }
            r0.<init>(r3)     // Catch:{ all -> 0x0613 }
            r0.append(r2)     // Catch:{ all -> 0x0613 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0613 }
            com.uc.crashsdk.a.a.d(r6, r0)     // Catch:{ all -> 0x0613 }
            a((java.lang.Throwable) r21)     // Catch:{ all -> 0x0613 }
        L_0x058c:
            r6 = 0
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0599
            boolean r0 = com.uc.crashsdk.b.f13531d
            if (r0 == 0) goto L_0x0599
            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(r12)
        L_0x0599:
            if (r22 == 0) goto L_0x05b4
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x05ad }
            if (r0 == 0) goto L_0x05b4
            if (r9 != 0) goto L_0x05b4
            r3 = 1
            a((boolean) r3, (boolean) r8)     // Catch:{ all -> 0x05a9 }
            r0 = 1
            goto L_0x05b5
        L_0x05a9:
            r0 = move-exception
            r3 = r0
            r0 = 1
            goto L_0x05b0
        L_0x05ad:
            r0 = move-exception
            r3 = r0
            r0 = 0
        L_0x05b0:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
            goto L_0x05b5
        L_0x05b4:
            r0 = 0
        L_0x05b5:
            if (r0 != 0) goto L_0x05bc
            if (r9 != 0) goto L_0x05bc
            b((boolean) r8)
        L_0x05bc:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x05c0 }
            goto L_0x05c5
        L_0x05c0:
            r0 = move-exception
            r3 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r3)
        L_0x05c5:
            boolean r0 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x05f8 }
            boolean r3 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x05f8 }
            if (r3 != 0) goto L_0x05d0
            r0 = 1
        L_0x05d0:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x05f8 }
            r3.<init>(r5)     // Catch:{ all -> 0x05f8 }
            r3.append(r0)     // Catch:{ all -> 0x05f8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x05f8 }
            com.uc.crashsdk.a.a.a(r4, r3)     // Catch:{ all -> 0x05f8 }
            if (r0 == 0) goto L_0x05e8
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x05f8 }
            if (r0 == 0) goto L_0x05e8
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x05f8 }
        L_0x05e8:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x05f8 }
            if (r0 == 0) goto L_0x05fc
            if (r9 != 0) goto L_0x05fc
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x05f8 }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x05f8 }
            goto L_0x05fc
        L_0x05f8:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x05fc:
            r1 = 1
            V = r1
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x0612
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x0612
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x0612:
            return
        L_0x0613:
            r0 = move-exception
            r3 = r0
            r6 = 0
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0622
            boolean r0 = com.uc.crashsdk.b.f13531d
            if (r0 == 0) goto L_0x0622
            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(r12)
        L_0x0622:
            if (r22 == 0) goto L_0x063b
            boolean r0 = com.uc.crashsdk.g.s()     // Catch:{ all -> 0x0635 }
            if (r0 == 0) goto L_0x063b
            if (r9 != 0) goto L_0x063b
            r6 = 1
            a((boolean) r6, (boolean) r8)     // Catch:{ all -> 0x0632 }
            r10 = 1
            goto L_0x063c
        L_0x0632:
            r0 = move-exception
            r10 = 1
            goto L_0x0637
        L_0x0635:
            r0 = move-exception
            r10 = 0
        L_0x0637:
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
            goto L_0x063c
        L_0x063b:
            r10 = 0
        L_0x063c:
            if (r10 != 0) goto L_0x0643
            if (r9 != 0) goto L_0x0643
            b((boolean) r8)
        L_0x0643:
            com.uc.crashsdk.f.c((boolean) r8)     // Catch:{ all -> 0x0647 }
            goto L_0x064c
        L_0x0647:
            r0 = move-exception
            r6 = r0
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r6)
        L_0x064c:
            boolean r10 = com.uc.crashsdk.g.i()     // Catch:{ all -> 0x067f }
            boolean r0 = com.uc.crashsdk.a.d.e()     // Catch:{ all -> 0x067f }
            if (r0 != 0) goto L_0x0657
            r10 = 1
        L_0x0657:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x067f }
            r0.<init>(r5)     // Catch:{ all -> 0x067f }
            r0.append(r10)     // Catch:{ all -> 0x067f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x067f }
            com.uc.crashsdk.a.a.a(r4, r0)     // Catch:{ all -> 0x067f }
            if (r10 == 0) goto L_0x066f
            java.lang.Thread$UncaughtExceptionHandler r0 = T     // Catch:{ all -> 0x067f }
            if (r0 == 0) goto L_0x066f
            r0.uncaughtException(r1, r2)     // Catch:{ all -> 0x067f }
        L_0x066f:
            boolean r0 = com.uc.crashsdk.b.B()     // Catch:{ all -> 0x067f }
            if (r0 == 0) goto L_0x0683
            if (r9 != 0) goto L_0x0683
            android.content.Context r0 = com.uc.crashsdk.a.g.a()     // Catch:{ all -> 0x067f }
            com.uc.crashsdk.b.b((android.content.Context) r0)     // Catch:{ all -> 0x067f }
            goto L_0x0683
        L_0x067f:
            r0 = move-exception
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)
        L_0x0683:
            r1 = 1
            V = r1
            int r0 = android.os.Process.myPid()
            if (r0 <= 0) goto L_0x0699
            boolean r0 = com.uc.crashsdk.g.j()
            if (r0 == 0) goto L_0x0699
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
        L_0x0699:
            goto L_0x069b
        L_0x069a:
            throw r3
        L_0x069b:
            goto L_0x069a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    private static void a(Calendar calendar) {
        if (g.T()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j10 = timeInMillis2 - timeInMillis;
            long j11 = 3600000;
            if (j10 <= 3600000) {
                j11 = 1000 + j10;
            }
            f.a(0, new com.uc.crashsdk.a.e(415, new Object[]{Long.valueOf(timeInMillis2)}), j11);
        }
    }

    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z10 = str == null;
            int i11 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i11++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z10 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z10 = true;
                    i11 = 0;
                }
            }
            i10 = i11;
        }
        if (i10 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (af) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        } else if (!b.f13531d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        } else {
            if (ae != null) {
                com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
            }
            ae = parcelFileDescriptor;
            int fd = parcelFileDescriptor.getFd();
            int nativeCmd = (int) JNIBridge.nativeCmd(13, (long) fd, (String) null, (Object[]) null);
            ag = nativeCmd != -1;
            if (fd == -1 || nativeCmd != -1) {
                return true;
            }
            return false;
        }
    }
}
