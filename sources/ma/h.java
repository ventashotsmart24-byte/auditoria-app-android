package ma;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import ba.s;
import ba.t;
import com.umeng.analytics.pro.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import t9.i;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f18994a;

    /* renamed from: b  reason: collision with root package name */
    public static String f18995b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f18996c = "de.robv.android.xposed.XposedHelpers";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18997d = "de.robv.android.xposed.XposedBridge";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18998e = "xposed";

    /* renamed from: f  reason: collision with root package name */
    public static final String f18999f = "/system/lib/libxposed_art.so";

    /* renamed from: g  reason: collision with root package name */
    public static final String f19000g = "/system/lib64/libxposed_art.so";

    static {
        h hVar = new h();
        f18994a = hVar;
        f18995b = hVar.getClass().getSimpleName();
    }

    public final boolean a() {
        try {
            String str = Build.MODEL;
            i.f(str, "MODEL");
            if (s.l(str, "Emulator", false, 2, (Object) null)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean b() {
        try {
            Process exec = Runtime.getRuntime().exec("ps");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            char[] cArr = new char[4096];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            bufferedReader.close();
            exec.waitFor();
            String sb2 = sb.toString();
            i.f(sb2, "output.toString()");
            if (t.o(sb2, "frida-server", false, 2, (Object) null)) {
                return true;
            }
            return false;
        } catch (IOException | Exception | InterruptedException unused) {
            return false;
        }
    }

    public final boolean c() {
        try {
            String stackTraceString = Log.getStackTraceString(new Throwable());
            i.f(stackTraceString, "getStackTraceString(Throwable())");
            return t.o(stackTraceString, "xposed", false, 2, (Object) null);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void d(Context context, String str) {
        i.g(context, f.X);
        i.g(str, "pkgName");
        l.a(m7.f.f7907a);
        try {
            b.f18991a.b();
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        } catch (Exception unused) {
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        } finally {
            System.exit(0);
            RuntimeException runtimeException = new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    public final String e(Context context) {
        i.g(context, f.X);
        try {
            String d10 = m.d(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0]);
            i.f(d10, "signStr");
            return d10;
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean f() {
        if (c() || h() || g()) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        try {
            throw new Exception("gg");
        } catch (Exception e10) {
            StackTraceElement[] stackTrace = e10.getStackTrace();
            i.f(stackTrace, "e.stackTrace");
            for (StackTraceElement className : stackTrace) {
                String className2 = className.getClassName();
                i.f(className2, "stackTraceElement.className");
                if (t.o(className2, f18997d, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean h() {
        try {
            ClassLoader.getSystemClassLoader().loadClass(f18996c).newInstance();
            try {
                ClassLoader.getSystemClassLoader().loadClass(f18997d).newInstance();
                return true;
            } catch (IllegalAccessException | InstantiationException unused) {
                return true;
            } catch (ClassNotFoundException | Exception unused2) {
                return false;
            }
        } catch (IllegalAccessException | InstantiationException unused3) {
            return true;
        } catch (ClassNotFoundException | Exception unused4) {
            return false;
        }
    }
}
